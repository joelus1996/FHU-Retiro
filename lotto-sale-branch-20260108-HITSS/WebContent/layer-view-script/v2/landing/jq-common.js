$(document).ready(function() {
    if ( document.querySelector('.inversionistas') ) {
        /**
         * date range
         */
        $('#date-range-both').dateRangePicker({
            language: 'es',
            format: 'YYYY/MM/DD',
            inline: true,
            batchMode: true,
            stickyMonths: true,
            showTopbar: false,
            container: '#date-range-both',
            separator : ' to ',
            getValue: function() {
                if ($('#date-range-1').val() && $('#date-range-2').val() )
                    return $('#date-range-2').val() + ' to ' + $('#date-range-1').val();
                else
                    return '';
            },
            setValue: function(s,s1,s2) {
                $('#date-range-1').val(s1);
                $('#date-range-2').val(s2);
            }
        });


        /**
         * form submit
         */
        $('#facts-of-importance').on('submit', function( e ) {
            e.preventDefault(); e.stopPropagation();

            if ( $('#date-range-1').val() && $('#date-range-2').val() ) {
                if ( $(this).find('input').hasClass('is-empty') ) {
                    $(this).find('input').removeClass('is-empty');
                }

                var htmlMarkup = '<div class="il-r-table-row"><div class="il-r-table-col">FECHA</div><div class="il-r-table-col">TIPO DE HECHO DE IMPORTANCIA</div><div class="il-r-table-col">descargar</div></div>';
                var formData = {
                    startDate: $('#date-range-1').val(),
                    endDate: $('#date-range-2').val()
                };

                $.ajax('https://jsonplaceholder.typicode.com/posts', {
                    data: { action: 'some_backend_func', formData: formData }
                }).then(
                    function success( res ) {
                        res.forEach(function( value, key ) {
                            if ( key <= 15 ) {
                                htmlMarkup += '<div class="il-r-table-row">';
                                htmlMarkup += '<div class="il-r-table-col"><span>'+value.id+'</span></div>';
                                htmlMarkup += '<div class="il-r-table-col"><span>'+value.title+'</span></div>';
                                htmlMarkup += '<div class="il-r-table-col"><a href="#" download><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.89 15.48" width="16.89" height="15.48"><polygon points="4.22 6.33 8.44 11.26 12.66 6.33 9.15 6.33 9.15 0 7.74 0 7.74 6.33 4.22 6.33" fill="#959595"/><path d="M15.48,14.07H1.41V9.85H0v4.93a.7.7,0,0,0,.7.7H16.18a.7.7,0,0,0,.7-.7V9.85H15.48Z" fill="#959595"/></svg></a></div>';
                                htmlMarkup += '</div>';

                                if ( key < 15 ) {
                                    $('[data-search-result-content="facts-of-importance"]').html( htmlMarkup );
                                }
                            }
                        });
                    },
                    function fail( data, status ) {
                        console.log('Something went wrong.');
                    }
                );
            } else {
                $(this).find('input').addClass('is-empty');
            }
        });
    }
});
