package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="TEAPUESTOSALE_BETDATA",
		query="{ call LOTOCARD.TEAPUESTOSALE.BET_DATA(?,?) }",
		callable=true,
		resultClass=TeapuestoProcedureBetData.class
		)
public class TeapuestoProcedureBetData {
	
	@Id
	@Column(name="w_status")
	private String status;
	
	@Column(name="w_message")
    private String message;
	
	@Column(name="w_draw_1")
    private Integer draw1;
	
	@Column(name="w_draw_2")
    private Integer draw2;
	
	@Column(name="w_draw_3")
    private Integer draw3;
	
	@Column(name="w_draw_4")
    private Integer draw4;
	
	@Column(name="w_draw_5")
    private Integer draw5;
	
	@Column(name="w_draw_6")
    private Integer draw6;
	
	@Column(name="w_draw_7")
    private Integer draw7;
	
	@Column(name="w_date_1")
    private String date1;
	
	@Column(name="w_date_2")
    private String date2;
	
	@Column(name="w_date_3")
    private String date3;
	
	@Column(name="w_date_4")
    private String date4;
	
	@Column(name="w_date_5")
    private String date5;
	
	@Column(name="w_date_6")
    private String date6;
	
	@Column(name="w_date_7")
    private String date7;
	
	@Column(name="w_price_type")
    private String priceType;
	
	@Column(name="w_price_message")
    private String priceMessage;
	
	@Column(name="w_simple_bet_price")
    private Integer simpleBetPrice;
	
	@Column(name="w_promotion_type")
    private String promotionType;
	
	@Column(name="w_balance_amount")
    private Double balanceAmount;
	
	@Column(name="w_balance_amount_game")
    private Double balanceAmountGame;
	
	@Column(name="w_algorithm")
    private String algorithm;
	
	@Column(name="w_bets")
    private Double bets;
	
	@Column(name="w_pay")
    private Double pay;
	
	@Column(name="w_draws")
    private Double draws;
	
	@Column(name="w_cost")
    private Double cost;
	
	@Column(name="w_channel1_order")
	private String channel1Order;
	
	@Column(name="w_channel2_order")
	private String channel2Order;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getDraw1() {
		return draw1;
	}

	public void setDraw1(Integer draw1) {
		this.draw1 = draw1;
	}

	public Integer getDraw2() {
		return draw2;
	}

	public void setDraw2(Integer draw2) {
		this.draw2 = draw2;
	}

	public Integer getDraw3() {
		return draw3;
	}

	public void setDraw3(Integer draw3) {
		this.draw3 = draw3;
	}

	public Integer getDraw4() {
		return draw4;
	}

	public void setDraw4(Integer draw4) {
		this.draw4 = draw4;
	}

	public Integer getDraw5() {
		return draw5;
	}

	public void setDraw5(Integer draw5) {
		this.draw5 = draw5;
	}

	public Integer getDraw6() {
		return draw6;
	}

	public void setDraw6(Integer draw6) {
		this.draw6 = draw6;
	}

	public Integer getDraw7() {
		return draw7;
	}

	public void setDraw7(Integer draw7) {
		this.draw7 = draw7;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDate3() {
		return date3;
	}

	public void setDate3(String date3) {
		this.date3 = date3;
	}

	public String getDate4() {
		return date4;
	}

	public void setDate4(String date4) {
		this.date4 = date4;
	}

	public String getDate5() {
		return date5;
	}

	public void setDate5(String date5) {
		this.date5 = date5;
	}

	public String getDate6() {
		return date6;
	}

	public void setDate6(String date6) {
		this.date6 = date6;
	}

	public String getDate7() {
		return date7;
	}

	public void setDate7(String date7) {
		this.date7 = date7;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getPriceMessage() {
		return priceMessage;
	}

	public void setPriceMessage(String priceMessage) {
		this.priceMessage = priceMessage;
	}

	public Integer getSimpleBetPrice() {
		return simpleBetPrice;
	}

	public void setSimpleBetPrice(Integer simpleBetPrice) {
		this.simpleBetPrice = simpleBetPrice;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Double getBalanceAmountGame() {
		return balanceAmountGame;
	}

	public void setBalanceAmountGame(Double balanceAmountGame) {
		this.balanceAmountGame = balanceAmountGame;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public Double getBets() {
		return bets;
	}

	public void setBets(Double bets) {
		this.bets = bets;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public Double getDraws() {
		return draws;
	}

	public void setDraws(Double draws) {
		this.draws = draws;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getChannel1Order() {
		return channel1Order;
	}

	public void setChannel1Order(String channel1Order) {
		this.channel1Order = channel1Order;
	}

	public String getChannel2Order() {
		return channel2Order;
	}

	public void setChannel2Order(String channel2Order) {
		this.channel2Order = channel2Order;
	}
}
