<div class="box-wrapper-game box-content-right">
	<div class="box-content-game">

		<div class="current-games">
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

		<div class="current-game-detail">
			<h5>Sorteos consecutivos</h5>

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

			<div class="main-box-detail">
				<div class="main-single-detail">
					<span class="detail-text">
						${tinkaSale.promotionMessage} <span class="detail-value" id="price-message">${tinkaSale.priceMessage}</span>
					</span>
				</div>
				<div class="main-single-detail">
					<span class="detail-text">
						Jugadas <span class="detail-value" id="comb">0</span>
					</span>
				</div>
				<div class="main-single-detail">
					<span class="detail-text">
						Costo total <span class="detail-value">S/ <b id="total_apagar">0</b></span>
					</span>
				</div>
			</div>
			<div class="action-buy">
				<button id="btn_desktop_comprar_boleto_tinka" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange">
					<b>COMPRAR</b>
				</button>
			</div>

		</div>


	</div>
</div>