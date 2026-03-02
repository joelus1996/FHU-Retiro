$(document).ready(function () {
	redirectTeapuesto()
});

function redirectTeapuesto(){
	$.ajax({
        type: 'post',
        url: 'tav2-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}