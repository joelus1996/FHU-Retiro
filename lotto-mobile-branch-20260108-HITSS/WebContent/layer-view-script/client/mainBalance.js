let isLoading = false;

function debounce(func, wait) {
	let timeout;
	return function (...args) {
		clearTimeout(timeout);
		timeout = setTimeout(() => func.apply(this, args), wait);
	};
}

const loadBalanceDataDebounced = debounce(loadBalanceData, 300);

function ajustarAltoMovementsList() {
  const headerHeight = $('#movements-total-balance-main-page').outerHeight(true);
  const formHeight = $('.form_filter_movimientos').outerHeight(true);
  const filterHeight = $('#movements-filter-count').outerHeight(true);
  const paginationHeight = $('#pagination-items-hispayment').outerHeight(true);
  const windowHeight = $(window).height();
 
  const espacioDisponible = windowHeight - (headerHeight + formHeight + filterHeight + paginationHeight);

  $('#items-hispayment').css('max-height', `${espacioDisponible}px`);
  $('#items-hispayment').css('height', `${espacioDisponible}px`);
}

function ajustarAltoMovementsListEmpty(){
  const headerHeight = $('#movements-total-balance-main-page').outerHeight(true);
  const formHeight = $('.form_filter_movimientos').outerHeight(true);
  const windowHeight = $(window).height();
 
  const espacioDisponible = windowHeight - (headerHeight + formHeight);

  $('#items-hispayment').css('height', `${espacioDisponible}px`);	
  $('#items-hispayment').css('max-height', '');

}


/**************************************
 * Función principal para renderizar los ítems
 **************************************/
function renderItems(data) {
	const $container = $("#items-hispayment").empty();
	const limit = $('#row-limit').val();
	$container.attr('data-show-items', limit);

	if (!data.data.balances || data.data.balances.length === 0) {
		$container.html("<div class='empty-movements'><div class='empty-movements-text'><p>No tienes movimientos</p></div>" +
			"<p class='empty-movements-instructions'>" +
			"* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en \"Mis Jugadas\". </p> </div>");
		$(".pagination").hide();
		$("#movements-filter-count").hide();
		ajustarAltoMovementsListEmpty();
		return;
	}

	$("#movements-filter-count").show();

	data.data.balances.forEach(item => {
		const isPrize = item.clientCarrier === 'PRIZE';
		const amountText = item.amount.toLocaleString('es-PE', { minimumFractionDigits: 2 });
		const colorClass = isPrize ? "movements-green" : "movements-orange";
		
		const description = item.description.length > 28
	    ? item.description.substring(0, 23) + '...'
	    : item.description;

		const html = `
	      <div class="movements-item item">
	        <div class="movements-left">
	          <div class="movements-description">${description}</div>
	          <div class="movements-date">${item.date}</div>
	        </div>
	        <div class="movements-amount ${colorClass}">S/ ${amountText}</div>
	      </div>
	    `;

		$container.append(html);
	});

	$(".pagination").show();

	$('.movements-container-list').closest('.movements-container').each(function (_, elem) {
		pagerDelegate.init($(elem));
	});
	
	ajustarAltoMovementsList();
}

/**************************************
 * Inicialización al cargar la página
 **************************************/
$(document).ready(function () {
	renderDateJugadas()
	loadBalanceDataDebounced();
	
	$('#fecha_inicio, #fecha_fin').on('change', function () {
		loadBalanceDataDebounced();
	});
});

/**************************************
 * Evento de cambio en el selector de filas
 **************************************/
$('#row-limit').on('change', function () {
	renderItems(data);
});

/**************************************
 * Delegado del paginador
 **************************************/
const pagerDelegate = (function () {
	const init = function ($list) {
		let toShow = $list.find('[data-show-items]').attr('data-show-items');
		let $items = $list.find('.movements-container-list .item');
		let $pager = $list.find('.pagination .pages');
		let $arrows = $list.find('.pagination .next, .pagination .prev');
		let currentPager = 1;
		let limit = 7;

		const showItems = function (current) {
			let from = (current - 1) * toShow;
			let to = from + parseInt(toShow);
			$items.removeClass('shown');
			for (let i = from; i < to; i++) $items.eq(i).addClass('shown');
		};

		const refreshNumber = function (current) {
			let pages = $pager.find('a').length;
			let dots = 0;

			$pager.find('a').removeClass('avaible');
			$pager.children().first().addClass('avaible');
			$pager.children().last().addClass('avaible');

			if (limit >= pages) {
				$pager.find('a').addClass('avaible');
			} else {
				const addPage = (index) => $pager.find(`a[href="${index}"]`).addClass('avaible');

				if ((limit - current) < 2) {
					$pager.children().eq(1).addClass('avaible');
					dots += 1;
				}

				if (pages - (current + 2) > 0) {
					$pager.find('span').eq(1).addClass('avaible');
					dots += 1;
				}

				dots = dots === 0 ? 1 : dots;

				for (let i = 1; i <= (limit - 2 - dots); i++) {
					if (dots === 1 && current < 6) {
						addPage(i);
					} else {
						addPage(current - 2);
						addPage(current - 1);
						addPage(current);

						if ((pages - current) === 2) addPage(current + 1);
						if ((pages - current) === 1) {
							addPage(current - 3);
						}
						if ((pages - current) === 0) {
							addPage(current - 4);
						}
					}
				}
			}
		};

		const updatePager = function (event) {
			if (event) event.preventDefault();

			const $target = $(event.currentTarget);
			const isNext = $target.hasClass('next');
			const isPrev = $target.hasClass('prev');
			const hrefVal = parseInt($target.attr('href'));

			if (isNext) currentPager += 1;
			else if (isPrev) currentPager -= 1;
			else currentPager = hrefVal || currentPager || 1;

			currentPager = Math.max(1, currentPager);
			const maxPage = Math.ceil($items.length / toShow);
			currentPager = Math.min(currentPager, maxPage);

			const $pagination = $list.find('.pagination');
			const $prev = $pagination.find('.prev');
			const $next = $pagination.find('.next');

			$prev.toggleClass('is-disabled', currentPager === 1);
			$next.toggleClass('is-disabled', currentPager === maxPage);

			$pager.find('a').removeClass('is-this');
			$pager.find('a').eq(currentPager - 1).addClass('is-this');

			showItems(currentPager);
			refreshNumber(currentPager);
			
			$('#items-hispayment').scrollTop(0);
		};

		const buildPager = function () {
			const totalPages = Math.ceil($items.length / toShow);
			if ($items.length <= toShow) {
				$pager.html('');
				$arrows.hide();
				$items.addClass('shown');
				return;
			}

			let tpl = '';
			for (let i = 1; i <= totalPages; i++) {
				tpl += `<a class="${i === 1 ? 'is-this' : ''}" href="${i}">${i}</a>`;
				if (i === 1 || i === totalPages - 1) tpl += '<span class="is-ellipsis">...</span>';
			}

			$pager.html(tpl);
			$arrows.remove();
			$list.find('.pagination').append('<a class="prev is-disabled" href="#"><i class="icon-regresar"></i></a>');
			$list.find('.pagination').append('<a class="next" href="#"><i class="icon-siguiente"></i></a>');

			setTimeout(() => {
				$list.find('.pagination .next, .pagination .prev').on('click', updatePager);
			}, 100);

			$pager.find('a').on('click', updatePager);
			currentPager = 1;
			showItems(1);
			refreshNumber(1);
		};

		buildPager();
	};

	return { init };
})();

/**************************************
 * Utilidades para el manejo de fechas
 **************************************/
function renderDateJugadas() {
	const $inputinicio = $('#fecha_inicio');
	const $inputfin = $('#fecha_fin');

	const today = new Date();
	const dd = String(today.getDate()).padStart(2, '0');
	const mm = String(today.getMonth() + 1).padStart(2, '0');
	const yyyy = today.getFullYear();
	const formattedDateFin = `${dd}/${mm}/${yyyy}`;

	const startDate = new Date();
	startDate.setDate(startDate.getDate() - 6);
	const formattedDateInicio = `${String(startDate.getDate()).padStart(2, '0')}/${String(startDate.getMonth() + 1).padStart(2, '0')}/${startDate.getFullYear()}`;

	$inputinicio.val(formattedDateInicio);
	$inputfin.val(formattedDateFin);

	const maxDate = new Date();
	const minDate = new Date();
	minDate.setFullYear(minDate.getFullYear() - 2);
	let isUpdating = false;

	function formatDate(date) {
		return date.toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' });
	}

	function calculateEndDate(startDate) {
		const date = new Date(startDate);
		date.setDate(date.getDate() + 29);
		return date;
	}

	function calculateStartDate(endDate) {
		const date = new Date(endDate);
		date.setDate(date.getDate() - 29);
		return date;
	}

	function updateEndDate(startDate) {
		const maxDiffDays = 29;

		const [day, month, year] = $inputfin.val().split('/');
		const selectedEndDate = new Date(year, month - 1, day);

		const diffTime = selectedEndDate.getTime() - startDate.getTime();
		const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

		if (diffDays < 0 || diffDays > maxDiffDays) {
			let newEnd = new Date(startDate);
			newEnd.setDate(startDate.getDate() + maxDiffDays);
			const finalDate = newEnd > maxDate ? maxDate : newEnd;

			if (!isUpdating) {
				isUpdating = true;
				$inputfin.datepicker('setDate', finalDate);
				$inputfin.val(formatDate(finalDate));
				isUpdating = false;
			}
		}
	}

	function updateStartDate(endDate) {
		const maxDiffDays = 29;

		const [day, month, year] = $inputinicio.val().split('/');
		const selectedStartDate = new Date(year, month - 1, day);

		const diffTime = endDate.getTime() - selectedStartDate.getTime();
		const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

		if (diffDays < 0 || diffDays > maxDiffDays) {
			let newStart = new Date(endDate);
			newStart.setDate(endDate.getDate() - maxDiffDays);
			const finalStart = newStart < minDate ? minDate : newStart;

			if (!isUpdating) {
				isUpdating = true;
				$inputinicio.datepicker('setDate', finalStart);
				$inputinicio.val(formatDate(finalStart));
				isUpdating = false;
			}
		}
	}

	function initializeDatePicker(element, isStartDate) {
		element.datepicker({
			language: 'es-ES',
			autoHide: true,
			format: 'dd/mm/yyyy',
			startDate: minDate,
			endDate: maxDate,
			autoclose: true,
			startView: 'days',
			minView: 'days'
		}).on('pick.datepicker', function (e) {
			e.preventDefault();
			const selectedDate = e.date;
			element.val(formatDate(selectedDate));
			isStartDate ? updateEndDate(selectedDate) : updateStartDate(selectedDate);
			element.trigger('change');
		});
	}

	initializeDatePicker($inputinicio, true);
	initializeDatePicker($inputfin, false);
}

function openLoader() {
	$('#loading').addClass('showed');
}

function closeLoader() {
	$('#loading').removeClass('showed');
}

function loadBalanceData(params = {}) {
	if (isLoading) return;
	isLoading = true;
	
	openLoader();

	const vheaders = { "authToken": $('#token').val() };

	let requestData = {};

	const startdate = $("#fecha_inicio").val();
	const enddate = $("#fecha_fin").val();
	requestData = { startdate, enddate };

	$.ajax({
		type: "POST",
		url: "client_balance_information_api_data.html",
		headers: vheaders,
		dataType: "json",
		async: true,
		data: requestData
	})
		.done(function (response) {
			console.log("response client_balance_information_api_data", response);
			$("#token").val(response.token);

			if (response.status == 'ERROR') {
				const $container = $("#items-hispayment").empty();
				$container.html(`
					<div class='empty-movements'>
						<div class='empty-movements-text'><p>${response.message}</p></div>
						<p class='empty-movements-instructions'>
							* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas".
						</p>
					</div>
				`);
				$(".pagination").hide();
				$("#movements-filter-count").hide();
				ajustarAltoMovementsListEmpty();
				return;
			}
			
			if (response.status == 'OK') {
				if (response.data && response.data.balances) {
					
					const total = response.data.total;
					const totalFormatted = 'S/ ' + total.toLocaleString('es-PE', { minimumFractionDigits: 2 });
					$('#total-balance').text(totalFormatted);

					$('#row-limit').val(15);

					renderItems(response);

					$('#row-limit').off('change').on('change', function () {
						renderItems(response);
					});

				}
			}
		})
		.fail(function (jqXHR, textStatus, errorThrown) {
			if (jqXHR.status == 403) {
				window.location.href = 'inicio.html';
			}
		})
		.always(function () {
			isLoading = false;
    		closeLoader();
		});
}
