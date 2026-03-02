package pe.com.intralot.loto.layer.model.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name="KABALASALE_BETDATA",
		query="{ call LOTOCARD.KABALASALE.BET_DATA_2(?,?) }",
		callable=true,
		resultClass=KabalaProcedureBetData.class
		)
public class KabalaProcedureBetData {
	
	@Id
	@Column(name = "w_time")
	private String time;
	
	@Column(name="w_status")
	private String status;
	
	@Column(name="w_message")
	private String message;
	
	@Column(name="w_prize")
	private String prize;
	
	@Column(name="w_active_draw")
	private String activeDraw;
	
	@Column(name="w_close_date")
	private String closeDate;
	
	@Column(name="w_close_hour")
	private String closeHour;
	
	@Column(name="w_next_draw")
	private String nextDraw;
	
	@Column(name="w_open_date")
	private Date openDate;
	
	@Column(name="w_open_hour")
	private String openHour;
	
	@Column(name="w_numbers_more")
	private String numbersMore;
	
	@Column(name="w_numbers_less")
	private String numbersLess;
	
	@Column(name="w_price_type")
	private String priceType;
	
	@Column(name="w_price_message")
	private String priceMessage;
	
	@Column(name="w_simple_bet_price")
	private Double simpleBetPrice;
	
	@Column(name="w_promotion_type")
	private String promotionType;
	
	@Column(name="w_balance_amount")
	private Double balanceAmount;
	
	@Column(name="w_balance_amount_game")
	private Double balanceAmountGame;
	
	@Column (name="w_balance_quantity_game")
	private Integer balanceQuantityGame;
	
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
	
	@Column(name="w_other_amount")
	private String otherAmount;
	
	@Column(name="w_other_quantity")
	private String otherQuantity;
	
	@Transient
	private String promotionMessage;
	
	@Transient
	private String balanceBill01;
	
	/*@Transient
	private String welcomeBonusMessage;
	
	@Transient
	private String welcomeBonusMessagePor;*/
	
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

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getActiveDraw() {
		return activeDraw;
	}

	public void setActiveDraw(String activeDraw) {
		this.activeDraw = activeDraw;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getCloseHour() {
		return closeHour;
	}

	public void setCloseHour(String closeHour) {
		this.closeHour = closeHour;
	}

	public String getNextDraw() {
		return nextDraw;
	}

	public void setNextDraw(String nextDraw) {
		this.nextDraw = nextDraw;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getOpenHour() {
		return openHour;
	}

	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}

	public String getNumbersMore() {
		return numbersMore;
	}

	public void setNumbersMore(String numbersMore) {
		this.numbersMore = numbersMore;
	}

	public String getNumbersLess() {
		return numbersLess;
	}

	public void setNumbersLess(String numbersLess) {
		this.numbersLess = numbersLess;
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

	public Double getSimpleBetPrice() {
		return simpleBetPrice;
	}

	public void setSimpleBetPrice(Double simpleBetPrice) {
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

	public Integer getBalanceQuantityGame() {
		return balanceQuantityGame;
	}

	public void setBalanceQuantityGame(Integer balanceQuantityGame) {
		this.balanceQuantityGame = balanceQuantityGame;
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

	public String getPromotionMessage() {
		return promotionMessage;
	}

	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
	}

	public String getBalanceBill01() {
		return balanceBill01;
	}

	public void setBalanceBill01(String balanceBill01) {
		this.balanceBill01 = balanceBill01;
	}
	
	public String getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}

	public String getOtherQuantity() {
		return otherQuantity;
	}

	public void setOtherQuantity(String otherQuantity) {
		this.otherQuantity = otherQuantity;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	/*public String getWelcomeBonusMessage() {
		return welcomeBonusMessage;
	}

	public void setWelcomeBonusMessage(String welcomeBonusMessage) {
		this.welcomeBonusMessage = welcomeBonusMessage;
	}

	public String getWelcomeBonusMessagePor() {
		return welcomeBonusMessagePor;
	}

	public void setWelcomeBonusMessagePor(String welcomeBonusMessagePor) {
		this.welcomeBonusMessagePor = welcomeBonusMessagePor;
	}*/
}
