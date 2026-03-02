package pe.com.intralot.loto.layer.model.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pe.com.intralot.loto.utils.IntralotUtils;

public class Kabala {

	private Integer months;//meses
	private Integer draws;//cantidad de sorteos
	private Double discount;//descuento
	private String formatDicount;
	private String formatPricePerPlay;//S/ 0.85
	private Double pricePerPlay;// 0.85, 1.0
	private Double regularPricePerPlay;
	private Double regularPayment;//total sin descuento
	private Integer state;//valida correcta creacion del objeto
	private Double discountPayment;//pago por el total de jugadas en la suscripcion
	private Integer jugadas;//cantidad de jugadas por boleto 
	private String typeKabala;//REG,S12,S36,S72
	private String typePlay;//AZAR por default, CHOOSE, REGULAR
	private Map<String,Map<String,List<String>>>  game;//boleto
	private List<String> bolillas;//bolillas
	@SuppressWarnings("rawtypes")
	private TreeMap boleto;//boleto item for frontend
	/*promotion data*/
	private String promotionAlgorithm;
	private Integer promotionBets;
	private Integer promotionPay;
	private Double promotionCost;
	private Integer promotionDraws; 
	private String promotionMessage;
	private String ticket;
	private Integer jugadasActuales;
	private Integer jugadasLimite;
	private Map<String,String> lastJugada;
	private Double amountGame;
	private Integer quantityGame;

	public Kabala() {}
	
	public Kabala(KabalaSale kabala,Integer type) {
		this.regularPayment=kabala.getSimpleBetPrice()*type;
		this.typePlay="SUS_AZAR";
		this.promotionMessage="";
		this.jugadasLimite = 5005;
		if(type.equals(12)) {
			this.typeKabala = "S12";
			this.months=kabala.getFirstMonths();
			this.draws=kabala.getFirstDraws();
			this.discount=kabala.getFirstDiscount();
			this.formatPricePerPlay=kabala.getFirstCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
		} else if(type.equals(36)) {
			this.typeKabala = "S36";
			this.months=kabala.getSecondMonths();
			this.draws=kabala.getSecondDraws();
			this.discount=kabala.getSecondDiscont();
			this.formatPricePerPlay=kabala.getSecondCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
		} else if (type.equals(72)) {
			this.typeKabala = "S72";
			this.months=kabala.getThirdMonths();
			this.draws=kabala.getThirdDraws();
			this.discount=kabala.getThirdDiscount();
			this.formatPricePerPlay=kabala.getThirdCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
		} else if (type.equals(144)) {
			this.typeKabala = "S144";
			this.months=kabala.getFourthMonths();
			this.draws=kabala.getFourthDraws();
			this.discount=kabala.getFourthDiscount();
			this.formatPricePerPlay=kabala.getFourthCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
		} else if (type.equals(1)){
			this.typeKabala = "REG";
			this.draws=1;
			//this.months=tinka.getThirdMonths();
			//this.draws=tinka.getThirdDraws(); ESTE PUEDE MANEJARSE COMO LA CONSECUTIVA
			this.discount=(double) 0;
			this.formatPricePerPlay=kabala.getRegularCost();
			this.typePlay="NORMAL";
			this.state = 200;
			/*Promotion data*/
			this.promotionAlgorithm=kabala.getAlgorithm();
			this.promotionBets=kabala.getBets()==null?0:kabala.getBets().intValue();
			this.promotionPay=kabala.getPay()==null?0:kabala.getPay().intValue();
			this.promotionCost=kabala.getCost();
			this.promotionDraws=kabala.getDraws()==null?0:kabala.getDraws().intValue();
			this.promotionMessage=kabala.getPriceMessage();
			this.amountGame=kabala.getBalanceAmountGame();
			this.quantityGame=kabala.getBalanceQuantityGame();
		} else {
			this.state=404;
		}
		
		this.jugadas = type;
		this.regularPricePerPlay=kabala.getSimpleBetPrice();
		this.pricePerPlay = kabala.getSimpleBetPrice()*(100-this.discount)/100;
		this.discountPayment=this.pricePerPlay*type;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public String getFormatPricePerPlay() {
		return formatPricePerPlay;
	}

	public void setFormatPricePerPlay(String formatPricePerPlay) {
		this.formatPricePerPlay = formatPricePerPlay;
	}

	public Double getPricePerPlay() {
		return pricePerPlay;
	}

	public void setPricePerPlay(Double pricePerPlay) {
		this.pricePerPlay = pricePerPlay;
	}

	public String getTypeKabala() {
		return typeKabala;
	}

	public void setTypeKabala(String typeKabala) {
		this.typeKabala = typeKabala;
	}

	public Integer getDraws() {
		return draws;
	}

	public void setDraws(Integer draws) {
		this.draws = draws;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getRegularPayment() {
		return regularPayment;
	}

	public void setRegularPayment(Double regularPayment) {
		this.regularPayment = regularPayment;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	public Double getDiscountPayment() {
		return discountPayment;
	}

	public void setDiscountPayment(Double discountPayment) {
		this.discountPayment = discountPayment;
	}

	public Integer getJugadas() {
		return jugadas;
	}

	public void setJugadas(Integer jugadas) {
		this.jugadas = jugadas;
	}
	
	public String getTypePlay() {
		return typePlay;
	}

	public void setTypePlay(String typePlay) {
		this.typePlay = typePlay;
	}

	public Map<String, Map<String, List<String>>> getGame() {
		return game;
	}

	public void setGame(Map<String, Map<String, List<String>>> game) {
		this.game = game;
	}

	public List<String> getBolillas() {
		return bolillas;
	}

	public void setBolillas(List<String> bolillas) {
		this.bolillas = bolillas;
	}

	public TreeMap getBoleto() {
		return boleto;
	}

	public void setBoleto(TreeMap boleto) {
		this.boleto = boleto;
	}

	public String getPromotionAlgorithm() {
		return promotionAlgorithm;
	}

	public void setPromotionAlgorithm(String promotionAlgorithm) {
		this.promotionAlgorithm = promotionAlgorithm;
	}

	public Integer getPromotionBets() {
		return promotionBets;
	}

	public void setPromotionBets(Integer promotionBets) {
		this.promotionBets = promotionBets;
	}

	public Integer getPromotionPay() {
		return promotionPay;
	}

	public void setPromotionPay(Integer promotionPay) {
		this.promotionPay = promotionPay;
	}

	public Double getPromotionCost() {
		return promotionCost;
	}

	public void setPromotionCost(Double promotionCost) {
		this.promotionCost = promotionCost;
	}

	public Integer getPromotionDraws() {
		return promotionDraws;
	}

	public void setPromotionDraws(Integer promotionDraws) {
		this.promotionDraws = promotionDraws;
	}

	public String getPromotionMessage() {
		return promotionMessage;
	}

	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getJugadasActuales() {
		return jugadasActuales;
	}

	public void setJugadasActuales(Integer jugadasActuales) {
		this.jugadasActuales = jugadasActuales;
	}

	public Integer getJugadasLimite() {
		return jugadasLimite;
	}

	public void setJugadasLimite(Integer jugadasLimite) {
		this.jugadasLimite = jugadasLimite;
	}

	public String getFormatDicount() {
		return formatDicount;
	}

	public void setFormatDicount(String formatDicount) {
		this.formatDicount = formatDicount;
	}

	public Double getRegularPricePerPlay() {
		return regularPricePerPlay;
	}

	public void setRegularPricePerPlay(Double regularPricePerPlay) {
		this.regularPricePerPlay = regularPricePerPlay;
	}

	public Map<String, String> getLastJugada() {
		return lastJugada;
	}

	public void setLastJugada(Map<String, String> lastJugada) {
		this.lastJugada = lastJugada;
	}
	
	public Double getAmountGame() {
		return amountGame;
	}

	public void setAmountGame(Double amountGame) {
		this.amountGame = amountGame;
	}

	public Map<String, String> toMap(){
		Map<String, String> map = new HashMap<String, String>();
		IntralotUtils util =  new IntralotUtils();
		map.put("draws", String.valueOf(draws));
		map.put("months", String.valueOf(months));
		map.put("pricePerPlay", String.valueOf(pricePerPlay));
		map.put("jugadas", String.valueOf(jugadas));
		map.put("discount", String.valueOf(discount.intValue())+'%');
		map.put("formatPricePerPlay", String.valueOf(formatPricePerPlay));
		map.put("discountPayment", String.valueOf(discountPayment));
		map.put("regularPayment", String.valueOf(regularPayment));
		map.put("formatDiscountPayment", util.formatCurrency(discountPayment));
		map.put("formatDiscountPayment2", String.valueOf(discountPayment));
		map.put("formatRegularPayment", util.formatCurrency(regularPayment));
		map.put("promotionMessage", promotionMessage);
		if(jugadasActuales!=null)map.put("jugadasActuales", String.valueOf(jugadasActuales*draws));
		map.put("kabalaJugadas", String.valueOf(jugadasLimite));
		if(amountGame!=null)map.put("formatAmountGame", util.formatCurrency(amountGame));
		if(quantityGame!=null)map.put("quantityGame", quantityGame.toString());
		return map;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String,Map> sendBoleto(){
		Map<String, Map> map = new HashMap<String, Map>();
		map.put("boleto",boleto);
		return map;
	}
	
	public String toString() {
		return " months:"+months+" draws:"+draws+" discount:"+discount+" pricePerPlay:"+pricePerPlay+" formatPricePerPlay:"+formatPricePerPlay
				+" regularPayment:"+regularPayment+" state:"+state+" discountPayment:"+discountPayment+" typePlay:"+typePlay;
	}
	
}
