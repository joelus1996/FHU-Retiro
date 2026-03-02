package pe.com.intralot.loto.layer.model.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;

import pe.com.intralot.loto.utils.IntralotUtils;

@Entity
@NamedNativeQuery(
		name = "KABALASALE_BET_DATA", 
		query = "{ call LOTOCARD.LOTTOMOBILE.BET_DATA_KABALA_2(?,?) }", 
		callable = true, 
		resultClass = KabalaSale.class)
public class KabalaSale {

	@Id
	@Column (name="w_status")
	private String status;
	
	@Column (name="w_message")
	private String message;
	
	@Column (name="w_prize")
	private String prize;
	
	@Column (name="w_prize_extra")
	private String prizeExtra;
	
	@Column (name="w_active_draw")
	private Integer activeDraw;
	
	@Column (name="w_close_date")
	private String closeDate;
	
	@Column (name="w_close_hour")
	private String closeHour;
	
	@Column (name="w_next_draw")
	private Integer nextDraw;
	
	@Column (name="w_open_date")
	private String openDate;
	
	@Column (name="w_open_hour")
	private String openHour;

	@Column (name="w_last_draw")
	private Integer lastDraw;
	
	@Column (name="w_result")
	private String lastResult;
	
	@Column (name="w_yapa")
	private String lastYapa;
	
	@Column (name="w_numbers_more")
	private String numbersMore;
	
	@Column (name="w_numbers_less")
	private String numbersLess;
	
	@Column(name="w_price_type")
	private String priceType;
	
	@Column(name="w_price_message")
	private String priceMessage;
	
	@Column(name="w_simple_bet_price")
	private Double simpleBetPrice;
	
	@Column(name="w_promotion_type")
	private String promotionType;
	
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
	
	@Column(name="w_1st_months")
	private Integer firstMonths;
	
	@Column(name="w_1st_draws")
	private Integer firstDraws;
	
	@Column(name="w_1st_discount")
	private Double firstDiscount;
	
	@Column(name="w_2nd_months")
	private Integer secondMonths;
	
	@Column(name="w_2nd_draws")
	private Integer secondDraws;
	
	@Column(name="w_2nd_discount")
	private Double secondDiscont;
	
	@Column(name="w_3rd_months")
	private Integer thirdMonths;
	
	@Column(name="w_3rd_draws")
	private Integer thirdDraws;
	
	@Column(name="w_3rd_discount")
	private Double thirdDiscount;
	
	@Column(name="w_4th_months")
	private Integer fourthMonths;
	
	@Column(name="w_4th_draws")
	private Integer fourthDraws;
	
	@Column(name="w_4th_discount")
	private Double fourthDiscount;
	
	@Column(name="w_balance_amount")
	private Double balanceAmount;
	
	@Column(name="w_balance_amount_game")
	private Double balanceAmountGame;
	
	@Column(name="w_balance_quantity_game")
	private Integer balanceQuantityGame;
	
	@Column(name="w_other_amount")
	private String otherAmount;
	
	@Column(name="w_other_quantity")
	private String otherQuantity;
	
	@Transient
	private Double prevBetPrice;
	
	@Transient
	private String pozo;
	
	@Transient
	private String regularCost;
	
	@Transient
	private String firstCost;
	
	@Transient
	private String secondCost;
	
	@Transient
	private String thirdCost;
	
	@Transient
	private String fourthCost;
	
	@Transient
	private Integer drwid;
	
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
	public String getPrizeExtra() {
		return prizeExtra;
	}
	public void setPrizeExtra(String prizeExtra) {
		this.prizeExtra = prizeExtra;
	}
	public Integer getActiveDraw() {
		return activeDraw;
	}
	public void setActiveDraw(Integer activeDraw) {
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
	public Integer getNextDraw() {
		return nextDraw;
	}
	public void setNextDraw(Integer nextDraw) {
		this.nextDraw = nextDraw;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getOpenHour() {
		return openHour;
	}
	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}
	public Integer getLastDraw() {
		return lastDraw;
	}
	public void setLastDraw(Integer lastDraw) {
		this.lastDraw = lastDraw;
	}
	public String getLastResult() {
		return lastResult;
	}
	public void setLastResult(String lastResult) {
		this.lastResult = lastResult;
	}
	public String getLastYapa() {
		return lastYapa;
	}
	public void setLastYapa(String lastYapa) {
		this.lastYapa = lastYapa;
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
	public Integer getFirstMonths() {
		return firstMonths;
	}
	public void setFirstMonths(Integer firstMonths) {
		this.firstMonths = firstMonths;
	}
	public Integer getFirstDraws() {
		return firstDraws;
	}
	public void setFirstDraws(Integer firstDraws) {
		this.firstDraws = firstDraws;
	}
	public Double getFirstDiscount() {
		return firstDiscount;
	}
	public void setFirstDiscount(Double firstDiscount) {
		this.firstDiscount = firstDiscount;
	}
	public Integer getSecondMonths() {
		return secondMonths;
	}
	public void setSecondMonths(Integer secondMonths) {
		this.secondMonths = secondMonths;
	}
	public Integer getSecondDraws() {
		return secondDraws;
	}
	public void setSecondDraws(Integer secondDraws) {
		this.secondDraws = secondDraws;
	}
	public Double getSecondDiscont() {
		return secondDiscont;
	}
	public void setSecondDiscont(Double secondDiscont) {
		this.secondDiscont = secondDiscont;
	}
	public Integer getThirdMonths() {
		return thirdMonths;
	}
	public void setThirdMonths(Integer thirdMonths) {
		this.thirdMonths = thirdMonths;
	}
	public Integer getThirdDraws() {
		return thirdDraws;
	}
	public void setThirdDraws(Integer thirdDraws) {
		this.thirdDraws = thirdDraws;
	}
	public Double getThirdDiscount() {
		return thirdDiscount;
	}
	public void setThirdDiscount(Double thirdDiscount) {
		this.thirdDiscount = thirdDiscount;
	}
	public Integer getFourthMonths() {
		return fourthMonths;
	}
	public void setFourthMonths(Integer fourthMonths) {
		this.fourthMonths = fourthMonths;
	}
	public Integer getFourthDraws() {
		return fourthDraws;
	}
	public void setFourthDraws(Integer fourthDraws) {
		this.fourthDraws = fourthDraws;
	}
	public Double getFourthDiscount() {
		return fourthDiscount;
	}
	public void setFourthDiscount(Double fourthDiscount) {
		this.fourthDiscount = fourthDiscount;
	}
	public String getFourthCost() {
		return fourthCost;
	}
	public void setFourthCost(String fourthCost) {
		this.fourthCost = fourthCost;
	}
	public String getPozo() {
		return pozo;
	}
	public void setPozo(String pozo) {
		this.pozo = pozo;
	}
	public String getRegularCost() {
		return regularCost;
	}
	public void setRegularCost(String regularCost) {
		this.regularCost = regularCost;
	}
	public String getFirstCost() {
		return firstCost;
	}
	public void setFirstCost(String firstCost) {
		this.firstCost = firstCost;
	}
	public String getSecondCost() {
		return secondCost;
	}
	public void setSecondCost(String secondCost) {
		this.secondCost = secondCost;
	}
	public String getThirdCost() {
		return thirdCost;
	}
	public void setThirdCost(String thirdCost) {
		this.thirdCost = thirdCost;
	}
	public Integer getDrwid() {
		return drwid;
	}
	public void setDrwid(Integer drwid) {
		this.drwid = drwid;
	}
	public Double getPrevBetPrice() {
		return prevBetPrice;
	}
	public void setPrevBetPrice(Double prevBetPrice) {
		this.prevBetPrice = prevBetPrice;
	}
	public Map<String, String> toMap(){
		SimpleDateFormat df = new SimpleDateFormat("EEEEE dd/MM/yyyy", new Locale("es", "ES"));
		SimpleDateFormat defaultDf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss",Locale.getDefault());
		Map<String, String> map = new HashMap<String, String>();	
		IntralotUtils util =  new IntralotUtils(); 
		map.put("pozo", ((prize!=null && !prize.equals("") && !prize.equals("0"))?util.formatCurrency2(new Double(prize)):""));
		map.put("closeHour", ((closeHour!=null && !closeHour.equals(""))?closeHour:""));
		if(closeDate!=null && !closeDate.isEmpty()) {
			try {
				closeDate = df.format(defaultDf.parse(closeDate));
			} catch (ParseException e) {
				closeDate = "";
			}//closeDate);
			map.put("closeDate", closeDate);
		}
		map.put("openHour", ((openHour!=null && !openHour.equals(""))?openHour:""));
		if(openDate!=null && !openDate.isEmpty()) {
			try {
				openDate = df.format(defaultDf.parse(openDate));
			} catch (ParseException e) {
				openDate = "";
			}
			map.put("openDate", openDate);
		}
		map.put("lastDraw", ((lastDraw!=null && lastDraw!=0)?String.valueOf(lastDraw):""));
		map.put("lastResult", ((lastResult!=null && !lastResult.equals(""))?lastResult:""));
		map.put("drwid", ((drwid!=null && drwid!=0)?String.valueOf(drwid):""));
		map.put("status", status);
		//map.put("regularCost", util.formatCurrencyOneDecimal(simpleBetPrice));
		return map;
	}
	
	public String toString(){
		return " status:"+status+" message:"+message+" prize:"+prize+" activeDraw:"+activeDraw+" closeDate:"+closeDate
				+" closeHour:"+closeHour+" nextDraw:"+nextDraw+" openDate:"+openDate+" openHour:"+openHour
				+" lastDraw:"+lastDraw+" lastResult:"+lastResult+" lastYapa:"+lastYapa
				+" numbersMore:"+numbersMore+" numbersLess:"+numbersLess+" priceType:"+priceType
				+" priceMessage:"+priceMessage+" simpleBetPrice:"+simpleBetPrice+" promotionType:"+promotionType
				+" algorithm:"+algorithm+" bets:"+bets+" pay:"+pay+" draws:"+draws+" cost:"+cost
				+" firstMonths:"+firstMonths+" firstDiscount:"+firstDiscount+" firstDraws:"+firstDraws
				+" secondMonths:"+secondMonths+" secondDiscont:"+secondDiscont+" secondDraws:"+secondDraws
				+" thirdMonths:"+thirdMonths+" thirdDiscount:"+thirdDiscount+" thirdDraws:"+thirdDraws
				+" fourthMonths:"+fourthMonths+" fourthDiscount:"+fourthDiscount+" fourthDraws:"+thirdDraws+" drwid:"+drwid
				+" balanceAmount:"+balanceAmount+" balanceAmountGame:"+balanceAmountGame+" balanceQuantityGame:"+balanceQuantityGame+" otherAmount:"+otherAmount;
	}

}
