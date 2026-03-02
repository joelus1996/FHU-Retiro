package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobile
 *
 */

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOTOCARD.CLIENT")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLIENT_ID")
	private Integer clientId;
	
	@Column(name="CL_APELLIDO_MATERNO")
	private String maidenname;

	@Column(name="CL_APELLIDO_PATERNO")
	private String lastname;
		
	@Column(name="CL_BIRTH_DATE")
	private Date birthDate;
    
	@Column(name="CL_DOC_NUMBER")
	private String docNumber;

	@Column(name="CL_DOC_TYPE")
	private String docType;

	@Column(name="CL_MAIL")
	private String mail;
	
	@Column(name="CL_MAIL_CODE")
	private String mailCode;
	
	@Column(name="CL_MAIL_STATUS")
	private String mailStatus;

	@Column(name="CL_NOMBRE")
	private String name;

	@Column(name="CL_PASSWORD")
	private String password;

	@Column(name="CL_USER")
	private String user;
	
	@Column(name="CL_BALANCE_AMOUNT")
	private Double balanceAmount;
	
	@Column(name="CL_AGREEMENT_DATE")
	private String agreement;
	
	@Column(name="CL_PASSWORD_CODE")
	private String passwordCode;
	
	@Column(name = "CL_CLIENT_REGION")
    private String region;
	
	@Column(name = "CL_COUNTRY")
    private String country;
	
	@Column(name = "CL_ADDRESS")
    private String address;
	
    @Column(name = "CL_MOBILE_PHONE")
    private String mobilePhone;
    
    @Column(name = "CL_MOBILE_SMS_STATUS")
    private String mobileStatus;
    
    @Column(name = "CL_DATA_UPDATE")
    private String dataUpdate;
    
    @Column(name = "CL_MOBILE_UPDATE")
    private String mobileUpdate;
    
    @Column(name = "CL_MAIL_UPDATE")
    private String mailUpdate;
    
    @Column(name = "CL_PLAYER_ID_XPG")
    private String playerIdXpg;
    
    @Column(name = "CL_VISA_SESSION")
    private String visaSession;
    
    @Transient
    private String pToken;
    
    @Transient
    private String pStatus;
   
    @Transient
    private String pPromotion;
    
	public Client() {}	

	public String getMaidenname() {
		return maidenname;
	}

	public void setMaidenname(String maidenname) {
		this.maidenname = maidenname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMailCode() {
		return mailCode;
	}

	public void setMailCode(String mailCode) {
		this.mailCode = mailCode;
	}

	public String getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}
	
	public Double getBalanceAmountDouble() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	
	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getPasswordCode() {
		return passwordCode;
	}

	public void setPasswordCode(String passwordCode) {
		this.passwordCode = passwordCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getpToken() {
		return pToken;
	}

	public void setpToken(String pToken) {
		this.pToken = pToken;
	}

	public String toString (){
		return 
		"clientId:"+clientId+" maidenname:"+maidenname+" lastname:"+lastname
		+" birthDate:"+birthDate+" docNumber:"+docNumber+" docType:"+docType
		+" mail:"+mail+" mailStatus:"+mailStatus+" name:"+name//+" password:"+password
		+" user:"+user+" balanceAmount:"+balanceAmount+" agreement:"+agreement
		+" region:"+region+" country:"+country+" address:"+address+" mobilePhone:"+mobilePhone;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public String getMobileStatus() {
		return mobileStatus;
	}

	public void setMobileStatus(String mobileStatus) {
		this.mobileStatus = mobileStatus;
	}
	
	public String getpPromotion() {
		return pPromotion;
	}

	public void setpPromotion(String pPromotion) {
		this.pPromotion = pPromotion;
	}

	public String getPlayerIdXpg() {
		return playerIdXpg;
	}

	public void setPlayerIdXpg(String playerIdXpg) {
		this.playerIdXpg = playerIdXpg;
	}	

	public String getVisaSession() {
		return visaSession;
	}

	public void setVisaSession(String visaSession) {
		this.visaSession = visaSession;
	}

	public String getDataUpdate() {
		return dataUpdate;
	}

	public void setDataUpdate(String dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public String getMobileUpdate() {
		return mobileUpdate;
	}

	public void setMobileUpdate(String mobileUpdate) {
		this.mobileUpdate = mobileUpdate;
	}

	public String getMailUpdate() {
		return mailUpdate;
	}

	public void setMailUpdate(String mailUpdate) {
		this.mailUpdate = mailUpdate;
	}
}