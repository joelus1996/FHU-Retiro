package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;



@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_ACCOUNTDATA",
		query = "{ call LOTOCARD.CLIENTSALE.ACCOUNT_DATA(?,?) }",
		callable = true,
		resultClass = ClientProcedureAccountData.class
		)




public class ClientProcedureAccountData {
	
	
	@Id
	@Column(name="w_client_name")	
	private String clientName;
	
	@Column(name="w_mail_status")
	private String mailStatus;
	
	@Column(name="w_balance_amount")
	private Double balanceAmount;
	
	@Column(name="w_promotional")
	private String promotional;
	
	@Column(name="w_num_prizes")
	private Integer numPrizes;
	
	@Column(name="w_neoprize_amount")
	private Double neoprizeAmount;
	
	@Column(name="w_kironprize_amount")
	private Double kironPrizeAmount;
	
	@Column(name="w_bonus_status")
	private String bonusStatus;
	
	@Column(name="w_bonus_message")
	private String bonusMessage;
	
	@Column(name="w_bonus_date")
	private String bonusDate;
	
	@Column(name="w_bonus_client_status")
	private String bonusClientStatus;
	
	@Column(name="w_bonus_added_balance")
	private String bonusAddedBalance;
	
	@Column(name="w_bonus_forplay")
	private String bonusForPlay;
	
	@Column(name="w_bonus_last_date")
	private String bonusLastDate;
	
	@Column(name="w_min_odd")
	private String minOdd;
	
	@Column(name="w_bonus_amount")
	private String bonusAmount;
	
	@Column(name="w_bonus_limit")
	private String bonusLimit;
	
	@Column(name="w_bonus_percentage")
	private String bonusPercentage;
	
	@Column(name="w_bonus_channel")
	private String bonusChannel;
	
	@Column(name="w_channel1_order")
	private String channel1Order;
	
	@Column(name="w_channel2_order")
	private String channel2Order;
	
	@Column(name="w_step_amount")
	private String stepAmount;
	
	@Column(name="w_wb_step_amount")
	private String wbStepAmount;
	
	@Column(name="w_wb_status")
	private String welcomeBonusStatus;
	
	@Column(name="w_wb_percentage")
	private String welcomeBonusPercentaje;
	
	@Column(name="w_wb_message")
	private String welcomeBonusMessage;
	
	@Column(name="w_wb_bonus_last_date")
	private String welcomeBonusLastDate;	
	
	@Column(name="w_bonus_game")
	private String bonusGame;
	
	@Column(name="w_bonus_game_mobile")
	private String bonusGameMobile;
	
	@Column(name="w_other_amount")
	private String otherAmount;
	
	@Column(name="w_other_expire")
	private String otherExpire;
	
	@Column(name="w_other_expire_format")
	private String otherExpireFormat;
	
	@Column(name="w_other_quantity")
	private String otherQuantity;
	
	@Transient
	private String welcomeBonusMessagePor;
	
	@Column(name="w_promo_draw")
	private String promoDraw;
	
	@Column(name="w_promo_count")
	private Integer promoCount;
	
	@Column(name="w_promo")
	private String promo;
	
	@Column(name="w_promo_description")
	private String promoDescription;
	
	@Column(name="w_promo_message")
	private String promoMessage;
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getPromotional() {
		return promotional;
	}

	public void setPromotional(String promotional) {
		this.promotional = promotional;
	}

	public Integer getNumPrizes() {
		return numPrizes;
	}

	public void setNumPrizes(Integer numPrizes) {
		this.numPrizes = numPrizes;
	}

	public Double getNeoprizeAmount() {
		return neoprizeAmount;
	}

	public void setNeoprizeAmount(Double neoprizeAmount) {
		this.neoprizeAmount = neoprizeAmount;
	}

	public Double getKironPrizeAmount() {
		return kironPrizeAmount;
	}

	public void setKironPrizeAmount(Double kironPrizeAmount) {
		this.kironPrizeAmount = kironPrizeAmount;
	}

	public String getBonusStatus() {
		return bonusStatus;
	}

	public void setBonusStatus(String bonusStatus) {
		this.bonusStatus = bonusStatus;
	}

	public String getBonusMessage() {
		return bonusMessage;
	}

	public void setBonusMessage(String bonusMessage) {
		this.bonusMessage = bonusMessage;
	}

	public String getBonusDate() {
		return bonusDate;
	}

	public void setBonusDate(String bonusDate) {
		this.bonusDate = bonusDate;
	}

	public String getBonusClientStatus() {
		return bonusClientStatus;
	}

	public void setBonusClientStatus(String bonusClientStatus) {
		this.bonusClientStatus = bonusClientStatus;
	}

	public String getBonusAddedBalance() {
		return bonusAddedBalance;
	}

	public void setBonusAddedBalance(String bonusAddedBalance) {
		this.bonusAddedBalance = bonusAddedBalance;
	}

	public String getBonusForPlay() {
		return bonusForPlay;
	}

	public void setBonusForPlay(String bonusForPlay) {
		this.bonusForPlay = bonusForPlay;
	}

	public String getBonusLastDate() {
		return bonusLastDate;
	}

	public void setBonusLastDate(String bonusLastDate) {
		this.bonusLastDate = bonusLastDate;
	}

	public String getMinOdd() {
		return minOdd;
	}

	public void setMinOdd(String minOdd) {
		this.minOdd = minOdd;
	}

	public String getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(String bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public String getBonusLimit() {
		return bonusLimit;
	}

	public void setBonusLimit(String bonusLimit) {
		this.bonusLimit = bonusLimit;
	}

	public String getBonusPercentage() {
		return bonusPercentage;
	}

	public void setBonusPercentage(String bonusPercentage) {
		this.bonusPercentage = bonusPercentage;
	}

	public String getBonusChannel() {
		return bonusChannel;
	}

	public void setBonusChannel(String bonusChannel) {
		this.bonusChannel = bonusChannel;
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

	public String getStepAmount() {
		return stepAmount;
	}

	public void setStepAmount(String stepAmount) {
		this.stepAmount = stepAmount;
	}

	
	public String getWelcomeBonusStatus() {
		return welcomeBonusStatus;
	}

	public void setWelcomeBonusStatus(String welcomeBonusStatus) {
		this.welcomeBonusStatus = welcomeBonusStatus;
	}

	public String getWelcomeBonusPercentaje() {
		return welcomeBonusPercentaje;
	}

	public void setWelcomeBonusPercentaje(String welcomeBonusPercentaje) {
		this.welcomeBonusPercentaje = welcomeBonusPercentaje;
	}

	public String getWelcomeBonusMessage() {
		return welcomeBonusMessage;
	}

	public void setWelcomeBonusMessage(String welcomeBonusMessage) {
		this.welcomeBonusMessage = welcomeBonusMessage;
	}

	public String getWelcomeBonusLastDate() {
		return welcomeBonusLastDate;
	}

	public void setWelcomeBonusLastDate(String welcomeBonusLastDate) {
		this.welcomeBonusLastDate = welcomeBonusLastDate;
	}

	public String getBonusGame() {
		return bonusGame;
	}

	public void setBonusGame(String bonusGame) {
		this.bonusGame = bonusGame;
	}

	public String getBonusGameMobile() {
		return bonusGameMobile;
	}

	public void setBonusGameMobile(String bonusGameMobile) {
		this.bonusGameMobile = bonusGameMobile;
	}

	public String getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}

	public String getOtherExpire() {
		return otherExpire;
	}

	public void setOtherExpire(String otherExpire) {
		this.otherExpire = otherExpire;
	}
	
	public String getOtherExpireFormat() {
		return otherExpireFormat;
	}

	public void setOtherExpireFormat(String otherExpireFormat) {
		this.otherExpireFormat = otherExpireFormat;
	}

	public String getOtherQuantity() {
		return otherQuantity;
	}

	public void setOtherQuantity(String otherQuantity) {
		this.otherQuantity = otherQuantity;
	}

	public String getWelcomeBonusMessagePor() {
		return welcomeBonusMessagePor;
	}

	public void setWelcomeBonusMessagePor(String welcomeBonusMessagePor) {
		this.welcomeBonusMessagePor = welcomeBonusMessagePor;
	}
	
	public String getPromoDraw() {
		return promoDraw;
	}

	public void setPromoDraw(String promoDraw) {
		this.promoDraw = promoDraw;
	}

	public Integer getPromoCount() {
		return promoCount;
	}

	public void setPromoCount(Integer promoCount) {
		this.promoCount = promoCount;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}
	
	public String getPromoDescription() {
		return promoDescription;
	}

	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}
	
	public String getPromoMessage() {
		return promoMessage;
	}

	public void setPromoMessage(String promoMessage) {
		this.promoMessage = promoMessage;
	}

	public String getWbStepAmount() {
		return wbStepAmount;
	}

	public void setWbStepAmount(String wbStepAmount) {
		this.wbStepAmount = wbStepAmount;
	}
	
	
}
