let jugadasData = null;
let isLoading = false;
let countLoad = 0;

function debounce(func, wait) {
	let timeout;
	return function (...args) {
		clearTimeout(timeout);
		timeout = setTimeout(() => func.apply(this, args), wait);
	};
}

const loadGamesDataDebounced = debounce(loadGamesData, 300);

function ajustarAltoGamesList() {
	  const formHeight = $('.form_filter_movimientos').outerHeight(true);
	  const filterHeight = $('#game-filter-count').outerHeight(true);
	  const paginationHeight = $('#pagination-items-hispayment').outerHeight(true);
	  const gameFooter =  $('.game-footer').outerHeight(true);
	  const windowHeight = $(window).height();
	  	  
	  const espacioDisponible = windowHeight - (formHeight + filterHeight + paginationHeight + gameFooter);

	  $('#items-hispayment').css('max-height', `${espacioDisponible}px`);
	  $('#items-hispayment').css('height', `${espacioDisponible}px`);
}

function ajustarAltoGamesListEmpty(){
	  const formHeight = $('.form_filter_movimientos').outerHeight(true);
	  const gameFooter =  $('.game-footer').outerHeight(true);
	  const windowHeight = $(window).height();
	 
	  const espacioDisponible = windowHeight - (formHeight + gameFooter);

	  $('#items-hispayment').css('height', `${espacioDisponible}px`);	
	  $('#items-hispayment').css('max-height', '');

}


/**************************************
 * Función principal para renderizar los ítems
 **************************************/
function renderItems(data, tipoFiltro = 'pendientes', filtrosEstado = []) {
	const $container = $("#items-hispayment").empty();
	$("#game-filter-count").show();
	const limit = $('#row-limit').val();
	$container.attr('data-show-items', limit);

	if (!data.data.games || data.data.games.length === 0) {
		$container.html("<div class='empty-games'><div class='empty-games-text'><p>No tienes jugadas</p></div>");
		$(".pagination").hide();
		$("#game-filter-count").hide();
		ajustarAltoGamesListEmpty();
		return;
	}

	let filtrados = data.data.games.filter(item => {
		if (tipoFiltro === 'pendientes') {
			return item.status === 'Pendiente';
		} else {
			if (!filtrosEstado || filtrosEstado.length === 0 || filtrosEstado.includes('todo')) {
				return item.status !== 'Pendiente';
			}
			return filtrosEstado.includes(item.status);
		}
	});

	if (filtrados.length === 0) {
		$container.html("<div class='empty-games'><div class='empty-games-text'><p>No tienes jugadas</p></div>");
		$(".pagination").hide();
		$("#game-filter-count").hide();
		ajustarAltoGamesListEmpty();
		return;
	}

	filtrados.forEach(item => {

		const itemStatus = item.status.toUpperCase();
		
		const badgeClass = (itemStatus === 'GANADO' || itemStatus === 'PAGADO')  ? 'badge-success'
			: itemStatus === 'PENDIENTE' ? 'badge-pending'
				: 'badge-error';

		const description = item.description.length > 28
			? item.description.substring(0, 23) + '...'
			: item.description;
			
		const html = `
		       <div class="game-item item"
		           data-game="${item.gameId}"
			       data-ticket="${item.ticket}"
			       data-canal="${item.salesChannel}"
			       data-pidticket="${item.pidTicket}"
			       data-programa="${item.program}"
			       data-cpn="${item.cpn}">
		        <div class="game-left">
		          <div class="game-description">${description}</div>
		          <div class="game-date">${item.date}</div>
		        </div>
		        <div class="game-status-wrapper">
		          <div class="game-status ${badgeClass}">${item.status}</div>
		          <i class="icon-open-popup icon-popup-red"></i>
		        </div>
		      </div>
		    `;

		$container.append(html);
	});

	$(".pagination").show();

	$('.game-container-list').closest('.game-container').each((_, elem) => {
		pagerDelegate.init($(elem));
	});
	
	ajustarAltoGamesList();
	countLoad++;
}

/**************************************
 * Inicialización al cargar la página
 **************************************/
$(document).ready(function () {
	renderDateJugadas()
	loadGamesDataDebounced();

	$('#fecha_inicio, #fecha_fin').on('change', function () {
		loadGamesDataDebounced();
	});
});

/**************************************
 * Tabs de filtros de tipo de jugada
 **************************************/
$('.tab-btn').on('click', function () {
	$('.tab-btn').removeClass('active');
	$(this).addClass('active');
	const tipo = $(this).data('type');

	if (tipo === 'finalizadas') {
		$('.button-group').show();
	} else {
		$('.button-group').hide();
	}

	renderItems(jugadasData, tipo);
});

/**************************************
 * Selector de cantidad de filas
 **************************************/
$('#row-limit').on('change', function () {
	const tipoActivo = $('.tab-btn.active').data('type');
	renderItems(jugadasData, tipoActivo);
});

/**************************************
 * Filtros avanzados por estado
 **************************************/
$('#button-filter').on('click', function (e) {
	e.stopPropagation();
	$('#filtro-popover').toggle();
});

$(document).on('click', function (e) {
	if (!$(e.target).closest('#filtro-popover, #button-filter').length) {
		$('#filtro-popover').hide();
	}
});

$('#filtro-popover input[value="todo"]').on('change', function () {
	const checked = $(this).is(':checked');
	$('#filtro-popover input[type="checkbox"]').not(this).prop('checked', checked);
});

$('#filtro-popover input[type="checkbox"]').not('[value="todo"]').on('change', function () {
	const allChecked = $('#filtro-popover input[type="checkbox"]').not('[value="todo"]').length ===
		$('#filtro-popover input[type="checkbox"]:not([value="todo"]):checked').length;
	$('#filtro-popover input[value="todo"]').prop('checked', allChecked);
});

$('#aplicar-filtro').on('click', function () {
	const filtrosSeleccionados = [];

	$('#filtro-popover input[type="checkbox"]:checked').each(function () {
		filtrosSeleccionados.push($(this).val());
	});

	console.log('Filtros seleccionados:', filtrosSeleccionados);
	$('#filtro-popover').hide();

	renderItems(jugadasData, 'finalizadas', filtrosSeleccionados);
});

/**************************************
 * Inicialización del datepicker
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

/**************************************
 * Paginador reutilizable
 **************************************/
const pagerDelegate = (function () {
	const init = function ($list) {
		const toShow = $list.find('[data-show-items]').attr('data-show-items');
		const $items = $list.find('.game-container-list .item');
		const $pager = $list.find('.pagination .pages');
		let $arrows = $list.find('.pagination .next, .pagination .prev');
		let currentPager = 1;
		const limit = 7;

		const showItems = function (current) {
			const from = (current - 1) * toShow;
			const to = from + parseInt(toShow);
			$items.removeClass('shown');
			for (let i = from; i < to; i++) {
				$items.eq(i).addClass('shown');
			}
		};

		const refreshNumber = function (current) {
			const pages = $pager.find('a').length;
			let dots = 0;
			$pager.find('a').removeClass('avaible');
			$pager.children().first().addClass('avaible');
			$pager.children().last().addClass('avaible');

			if (limit >= pages) {
				$pager.find('a').addClass('avaible');
			} else {
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
					$pager.find(`a[href="${current - 2}"]`).addClass('avaible');
					$pager.find(`a[href="${current - 1}"]`).addClass('avaible');
					$pager.find(`a[href="${current}"]`).addClass('avaible');
					if ((pages - current) === 2) $pager.find(`a[href="${current + 1}"]`).addClass('avaible');
					if ((pages - current) === 1) $pager.find(`a[href="${current - 3}"]`).addClass('avaible');
					if ((pages - current) === 0) $pager.find(`a[href="${current - 4}"]`).addClass('avaible');
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

	return {
		init
	};
})();

function openLoader() {
	$('#loading').addClass('showed');
}

function closeLoader() {
	$('#loading').removeClass('showed');
}

function loadGamesData(params = {}) {
	if (isLoading) return;
	isLoading = true;
	
	openLoader()

	const vheaders = { "authToken": $('#token').val() };

	let requestData = {};

	const startdate = $("#fecha_inicio").val();
	const enddate = $("#fecha_fin").val();
	
	const dataEncrypted = $("#dataSession").val();
	const dataSession = encodeURIComponent(dataEncrypted);
	
	requestData = { startdate, enddate, dataSession };

	$.ajax({
		type: "POST",
		url: "client_play_information_api_data.html",
		headers: vheaders,
		dataType: "json",
		async: true,
		data: requestData
	})
		.done(function (response) {
			console.log("response client_play_information_api_data", response);
			$("#token").val(response.token);
			$("#dataSessionCoupon").val(response.dataSession);
			
			if (response.status == 'ERROR') {
				const $container = $("#items-hispayment").empty();
				$container.html(`
					<div class='empty-games'><div class='empty-games-text'><p>${response.message}</p></div>
				`);
				$(".pagination").hide();
				$("#game-filter-count").hide();
				ajustarAltoGamesListEmpty();
				return;
			}
			
			if (response.status == 'OK') {
				if (response.data && response.data.games) {
															
					$('#row-limit').val(15);
					const tipoActivo = $('.tab-btn.active').data('type');
					renderItems(response, tipoActivo);
					jugadasData = response;
					$('#row-limit').off('change').on('change', function () {
						const tipoActivo = $('.tab-btn.active').data('type');
						renderItems(response, tipoActivo);
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
			closeLoader()
		});
}

$(document).on('click', '.game-item', function () {
	const $this = $(this);
	const game = parseInt($this.data('game'));
	const ticket = $this.data('ticket');
	const canal = $this.data('canal');
	const pid_ticket = $this.data('pidticket');
	const programa = $this.data('programa');
	const cpn = $this.data('cpn');
	const startdate = countLoad > 1 ? $("#fecha_inicio").val() : '';
	const listaFiltrada = countLoad > 1 ? 'OK' : '';
	const dataEncrypted = $("#dataSession").val();
	const dataSession = encodeURIComponent(dataEncrypted);
	
	$('body').addClass('loading');

	const isWeb = canal === 'Web' || canal === 'Web Invitado';

	const loadIframePopup = (selector, url) => {
		$(`${selector} .main-modal`).html(`<iframe src="${url}" frameborder="0" style="height: 70vh; width: 99.5%; padding-top: 20px;"></iframe>`);
		$(selector).addClass('opened');
		$(`${selector} .popup-sm2`).css("max-width", "70vh");
		$(selector).css("height", "100vh");
	};

	const renderHTMLPopup = (url, retail) => {
		
		const dataSessionPopup = retail ? $("#dataSession").val() : $("#dataSessionCoupon").val();

		$.ajax({
			url: url,
			method: "POST",
			data: {
				dataSession : dataSessionPopup
			},
			success: function(res) {
				const $res = $(res);
				$('#popup .main-modal').html($res.find(".wrap-modal"));
				const GNAME = $.trim($(".GNAME").html());
				if (GNAME !== "Kinelo") {
					$(".play-game-result").each(function () {
						$(this).html($(this).html().split(" ").join(" - "));
					});
				}
				openModal("#popup", "");
				$('.popup-sm').addClass('resizePopup');
				$('.box-desc').addClass('resizePopupBox');
			},
			error: function() {
				console.log("error");
			},
			complete: function() {
				$('body').removeClass('loading');
			}
		});

	};
	
	if (isWeb) {
		if (game !== 108) {
			const url = `./client_play_find_information.html?gameId=${game}&ticket=${ticket}` +
				(startdate ? `&startdate=${startdate}` : '') +
				(listaFiltrada ? `&listaFiltrada=${listaFiltrada}` : '');
			renderHTMLPopup(url, false);
		} else {
			$.get("client_play_show_detail_teapuesto.html", { ticket, dataSession })
				.done(res => loadIframePopup('#popup2', res.url))
				.fail(() => console.log("error"))
				.always(() => $('body').removeClass('loading'));
		}
	} else {
		// Retail
		if (game === 108) {
			$.get("consultarDataTeApuestoGrecia.html", { programa, cpn })
				.done(res => {
					const url = `./client_play_show_detail_teapuesto_grecia.html?gameId=${game}&ticket=${ticket}&programa=${programa}&cpn=${cpn}&dataSession=${dataSession}`;
					loadIframePopup('#popup2', url);
				})
				.fail(() => console.log("error"))
				.always(() => $('body').removeClass('loading'));
		} else if ([7, 10].includes(game)) {
			if (!pid_ticket) return ico.removeClass('loading');
			$.get("client_play_show_detail_teapuesto.html", { ticket: pid_ticket, dataSession })
				.done(res => loadIframePopup('#popup2', res.url))
				.fail(() => console.log("error"))
				.always(() => $('body').removeClass('loading'));
		} else if ([8, 9].includes(game)) {
			if (!cpn) return ico.removeClass('loading');
			$.get("consultaDetalleVirtuales.html", { ticket: cpn })
				.done(res => {
					if (res.status !== "OK") return;
					const url = `detalleVirtualesTicket.html?ticket=${cpn}`;
					loadIframePopup('#popup2', url);
				})
				.fail(err => console.log(err))
				.always(() => $('body').removeClass('loading'));
		} else {
			const url = `./client_play_find_information_retail.html?gameId=${game}&ticket=${ticket}&dataSession=${dataSession}` +
				(startdate ? `&startdate=${startdate}` : '') +
				`&isweb=${canal}`;
			renderHTMLPopup(url, true);
		}
	}
});

$('.js-close-modal').click(function (e) {
	e.preventDefault();
	$('#popup').removeClass('opened');
});

$('.js-close-modal2').click(function (e) {
	e.preventDefault();
	$('#popup2').removeClass('opened');
});

