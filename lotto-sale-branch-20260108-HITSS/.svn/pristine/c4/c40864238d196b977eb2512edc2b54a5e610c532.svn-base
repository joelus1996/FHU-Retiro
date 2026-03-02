<div class="box-wrapper-game box-content-right">
	<div class="box-content-game">

		<div class="current-games" style="padding-top: 68px;margin-bottom: 16px;">
			<p class="text-body" ><span id="morePlaysText">¿Quieres agregar más jugadas?</span></p>
			<div class="boxes-current-games clearfix">
				<div data-game="a" class="box-current-game game-playing">
					<a href="#">A</a>
				</div>
				<div data-game="b" class="box-current-game">
					<a href="#">B</a>
				</div>
				<div data-game="c" class="box-current-game">
					<a href="#">C</a>
				</div>
				<div data-game="d" class="box-current-game">
					<a href="#">D</a>
				</div>
			</div>
		</div>

		<div class="current-game-detail" style="margin-top: 0px;">
			<p class="text-body mb-4">¿Para cuántos sorteos quieres jugar?</p>

			<div class="selectBox">
				<c:if test="${flagConsecutivaTk!=1}">
					<div class="box" id="box">1 Sorteo</div>
					<select disabled="" name="model" id="mySelectBox" onchange="this.parentNode.getElementsByTagName('div')[0].innerHTML=this.options[this.selectedIndex].text">
						<option value="1">1 Sorteo</option>
					</select>
				</c:if>
				<c:if test="${flagConsecutivaTk==1}">
					<c:forEach items="${tinkaSaleList}" var="tinkaSaleList" begin="0" end="0">
						<div class="box" id="box">${tinkaSaleList.messageDraw}</div>
					</c:forEach>

					<select name="model" id="mySelectBox" onChange="this.parentNode.getElementsByTagName('div')[0].innerHTML=this.options[this.selectedIndex].text">
						<c:forEach items="${tinkaSaleList}" var="tinkaSaleList">
							<option value="${tinkaSaleList.numDraws}">${tinkaSaleList.messageDraw}</option>
						</c:forEach>
					</select>
				</c:if>
			</div>

			<div class="main-box-detail" style="margin-bottom: 8px;">
				<c:if test="${tinkaSale.flagPromotionMessage == true}">
					<div class="main-single-detail">
						<span class="detail-text">
							${tinkaSale.promotionMessage}
						</span>
					</div>
				</c:if>
				<div class="main-single-detail">
					<span class="detail-text text-consecutivo">
						Costo por jugada: <span class="detail-value" id="price-message">S/ ${tinkaSale.simpleBetPriceInt}</span>
					</span>
				</div>
				<div class="main-single-detail">
					<span class="detail-text">
						Total de Jugadas: <span class="detail-value" id="comb">0</span>
					</span>
				</div>
				<div class="main-single-detail" style="display:none">
					<span class="detail-text">
						Consecutivo de <span id="consecutivo-text">${tinkaSaleList[0].messageDraw}</span>
					</span>
				</div>
				<div class="main-single-detail">
					<strong>
						<span class="detail-text">
							Importe a pagar: <span class="detail-value">S/ <b id="total_apagar">0</b></span>
						</span>
					</strong>
				</div>
			</div>

			<div class="box-content-info">
				<p class="box-content-info-text">*No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto.</p>
				<p>
					¿Necesitas ayuda?
					<a href="https://latinkaportal.com.pe/como-jugar/tinka/?origin=i" target="_blank" onclick="datalayerFinalizaCompraAyuda(this,'Ayuda');">
						Haz click aquí
					</a>
				</p>
			</div>
			<div class="action-buy">
				<button id="btn_desktop_comprar_boleto_tinka" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange">
					<b>COMPRAR</b>
				</button>
			</div>

		</div>


	</div>
</div>