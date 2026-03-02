package pe.com.intralot.loto.layer.model.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pe.com.intralot.loto.utils.IntralotUtils;

public class Ganadiario {

	private Integer months;//meses
	private Integer draws;//cantidad de sorteos
	private Double discount;//descuento
	private String formatDicount;
	private String formatPricePerPlay;//S/ 0.85
	private String formatPricePerPlay2;
	private Double pricePerPlay;// 0.85, 1.0
	private Double regularPricePerPlay;
	private Double regularPayment;//total sin descuento
	private Integer state;//valida correcta creacion del objeto
	private Double discountPayment;//pago por el total de jugadas en la suscripcion
	private Integer jugadas;//cantidad de jugadas por boleto 
	private String typeGanadiario;//REG,S12,S36,S72
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
	private Integer cantidadSorteos;
	public Ganadiario() {}
	
	public Ganadiario(GanadiarioSale ganadiario,Integer type) {
		this.regularPayment=ganadiario.getSimpleBetPrice()*type;
		this.typePlay="SUS_AZAR";
		this.promotionMessage="";
		this.jugadasLimite = 3003;
		if(type.equals(30)) {
			this.typeGanadiario = "S30";
			this.months=ganadiario.getFirstMonths();
			this.draws=ganadiario.getFirstDraws();
			this.discount=ganadiario.getFirstDiscount();
			this.formatPricePerPlay=ganadiario.getFirstCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
			this.quantityGame=ganadiario.getBalanceQuantityGame();
			this.cantidadSorteos=1;
		} else if(type.equals(90)) {
			this.typeGanadiario = "S90";
			this.months=ganadiario.getSecondMonths();
			this.draws=ganadiario.getSecondDraws();
			this.discount=ganadiario.getSecondDiscont();
			this.formatPricePerPlay=ganadiario.getSecondCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
			this.quantityGame=ganadiario.getBalanceQuantityGame();
			this.cantidadSorteos=1;
		} else if (type.equals(180)) {
			this.typeGanadiario = "S180";
			this.months=ganadiario.getThirdMonths();
			this.draws=ganadiario.getThirdDraws();
			this.discount=ganadiario.getThirdDiscount();
			this.formatPricePerPlay=ganadiario.getThirdCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
			this.quantityGame=ganadiario.getBalanceQuantityGame();
			this.cantidadSorteos=1;
		} else if (type.equals(365)) {
			this.typeGanadiario = "S365";
			this.months=ganadiario.getFourthMonths();
			this.draws=ganadiario.getFourthDraws();
			this.discount=ganadiario.getFourthDiscount();
			this.formatPricePerPlay=ganadiario.getFourthCost();
			this.state = 200;
			this.ticket="jugada_"+this.draws;
			this.formatDicount = String.valueOf(this.discount.intValue())+'%';
			this.quantityGame=ganadiario.getBalanceQuantityGame();
			this.cantidadSorteos=1;
		}else if (type.equals(1)){
			this.typeGanadiario = "REG";
			this.draws=1;
			//this.months=tinka.getThirdMonths();
			//this.draws=tinka.getThirdDraws(); ESTE PUEDE MANEJARSE COMO LA CONSECUTIVA
			this.discount=(double) 0;
			this.formatPricePerPlay=ganadiario.getRegularCost();
			this.typePlay="NORMAL";
			this.state = 200;
			/*Promotion data*/
			this.promotionAlgorithm=ganadiario.getAlgorithm();
			this.promotionBets=ganadiario.getBets()==null?0:ganadiario.getBets().intValue();
			this.promotionPay=ganadiario.getPay()==null?0:ganadiario.getPay().intValue();
			this.promotionCost=ganadiario.getCost();
			this.promotionDraws=ganadiario.getDraws()==null?0:ganadiario.getDraws().intValue();
			this.promotionMessage=ganadiario.getPriceMessage();
			this.amountGame=ganadiario.getBalanceAmountGame();
			this.quantityGame=ganadiario.getBalanceQuantityGame();
			this.quantityGame=ganadiario.getBalanceQuantityGame();
			this.cantidadSorteos=1;
		} else {
			this.state=404;
		}
		
		this.jugadas = type;
		this.regularPricePerPlay=ganadiario.getSimpleBetPrice();
		this.pricePerPlay = ganadiario.getSimpleBetPrice()*(100-this.discount)/100;
		this.discountPayment=this.pricePerPlay*type;
		this.formatPricePerPlay2=(this.formatPricePerPlay.substring(3, formatPricePerPlay.length()));
		
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

	public String getTypeGanadiario() {
		return typeGanadiario;
	}

	public void setTypeGanadiario(String typeGanadiario) {
		this.typeGanadiario = typeGanadiario;
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
		map.put("discountPaymentInt", String.valueOf(discountPayment.intValue()));
		map.put("formatPricePerPlay2", String.valueOf(formatPricePerPlay2));
		map.put("discountPayment", String.valueOf(discountPayment));
		map.put("regularPayment", String.valueOf(regularPayment));
		map.put("formatDiscountPayment", util.formatCurrency(discountPayment));	
		map.put("formatDiscountPayment2", String.valueOf(discountPayment));
		map.put("formatRegularPayment", util.formatCurrency(regularPayment));
		map.put("formatPricePerPlay2", String.valueOf(formatPricePerPlay2));
		map.put("promotionMessage", promotionMessage);
		if(jugadasActuales!=null)map.put("jugadasActuales", String.valueOf(jugadasActuales*draws));
		map.put("ganadiarioJugadas", String.valueOf(jugadasLimite));
		if(amountGame!=null)map.put("formatAmountGame", util.formatCurrency(amountGame));
		if(quantityGame!=null)map.put("quantityGame", quantityGame.toString());
		map.put("cantidadSorteos", String.valueOf(cantidadSorteos));
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
