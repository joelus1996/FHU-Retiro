package pe.com.intralot.loto.layer.dto.pam;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginDataBean {
	
	private Integer sessionId;
	private Integer clientId;
	private String user;
	private String clientName;
	private String status;
	private String mode;
	private Integer numSessions;
	private Integer state;
	private String today;
	private String luckyIcon;
	private Double balanceAmount;
	private String mailStatus;
	private String sessionCode;
	private String agreement;
	private String mail;
	private String mailVerified;
	private String mailCode;
	private String mobilePhone;
	private String mobileSmsStatus;
	private String promotion;
	private String promotionIbk;
	private String maskPhone;
	private String registerIncomplete;
	private String lastName;
	private String maternalLastName;
	private String documentType;
	private String documentNumber;
	private Double kironAmount;
	private String playerIdXpg;
	private String mobileUpdate;
	private ResponseServiceBean responseService;

	public Integer getSessionId() {
		return sessionId;
	}


	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}


	public Integer getClientId() {
		return clientId;
	}


	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public Integer getNumSessions() {
		return numSessions;
	}


	public void setNumSessions(Integer numSessions) {
		this.numSessions = numSessions;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public String getToday() {
		return today;
	}


	public void setToday(String today) {
		this.today = today;
	}


	public String getLuckyIcon() {
		return luckyIcon;
	}


	public void setLuckyIcon(String luckyIcon) {
		this.luckyIcon = luckyIcon;
	}


	public Double getBalanceAmount() {
		return balanceAmount;
	}


	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}


	public String getMailStatus() {
		return mailStatus;
	}


	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}


	public String getSessionCode() {
		return sessionCode;
	}


	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}


	public String getAgreement() {
		return agreement;
	}


	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getMailVerified() {
		return mailVerified;
	}


	public void setMailVerified(String mailVerified) {
		this.mailVerified = mailVerified;
	}


	public String getMailCode() {
		return mailCode;
	}


	public void setMailCode(String mailCode) {
		this.mailCode = mailCode;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public String getMobileSmsStatus() {
		return mobileSmsStatus;
	}


	public void setMobileSmsStatus(String mobileSmsStatus) {
		this.mobileSmsStatus = mobileSmsStatus;
	}


	public String getPromotion() {
		return promotion;
	}


	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}


	public String getPromotionIbk() {
		return promotionIbk;
	}


	public void setPromotionIbk(String promotionIbk) {
		this.promotionIbk = promotionIbk;
	}


	public String getMaskPhone() {
		return maskPhone;
	}


	public void setMaskPhone(String maskPhone) {
		this.maskPhone = maskPhone;
	}


	public String getRegisterIncomplete() {
		return registerIncomplete;
	}


	public void setRegisterIncomplete(String registerIncomplete) {
		this.registerIncomplete = registerIncomplete;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMaternalLastName() {
		return maternalLastName;
	}


	public void setMaternalLastName(String maternalLastName) {
		this.maternalLastName = maternalLastName;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	public String getDocumentNumber() {
		return documentNumber;
	}


	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}


	public Double getKironAmount() {
		return kironAmount;
	}


	public void setKironAmount(Double kironAmount) {
		this.kironAmount = kironAmount;
	}
	
	public String getPlayerIdXpg() {
		return playerIdXpg;
	}

	public void setPlayerIdXpg(String playerIdXpg) {
		this.playerIdXpg = playerIdXpg;
	}
	
	public String getMobileUpdate() {
		return mobileUpdate;
	}

	public void setMobileUpdate(String mobileUpdate) {
		this.mobileUpdate = mobileUpdate;
	}


	public ResponseServiceBean getResponseService() {
		return responseService;
	}


	public void setResponseService(ResponseServiceBean responseService) {
		this.responseService = responseService;
	}


	@Override
    public String toString() {
	    return ToStringBuilder.reflectionToString(this,new pe.com.intralot.loto.layer.model.bean.JsonStyle());
    }
	
}
