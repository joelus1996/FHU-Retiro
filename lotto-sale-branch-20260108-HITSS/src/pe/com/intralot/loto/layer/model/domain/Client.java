package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

/**
 * @author:   Oscar Erick Candela Carbajal
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOTOCARD.CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CLIENT_ID")
	private Integer idClient;
	
	@Column(name = "CL_NAME")
	private String name;
	
	@Column(name = "CL_NOMBRE")
	private String nombre;
	
	@Column(name = "CL_DOC_NUMBER")
	private String docNumber;
	
	@Column(name="CL_DOC_TYPE")
	private String docType;
	
	@Column(name = "CL_MOBILE_PHONE")
	private String mobilePhone;
		
	@Column(name = "CL_BIRTH_DATE")
	private Date birthDate;	
	
	@Column(name = "CL_USER")
    private String user;
	
	@Column(name = "CL_MAIL")
    private String mail;
	
	@Column(name = "CL_MAIL_STATUS")
    private String mailStatus;
	
	@Column(name = "CL_MAIL_RESULTS")
    private String mailResults;
	
	@Column(name = "CL_PASSWORD")
    private String password;
	
	@Column(name = "CL_PASSWORD_FLAG")
    private Integer passwordFlag;	
	
	@Column(name = "CL_FIRST_COMPANY")
    private String firstCompany;
	
	@Column(name = "CL_FIRST_CARRIER")
    private String firstCarrier;
	
	@Column(name = "CL_FIRST_PHONE")
    private String firstPhone;
	
	@Column(name = "CL_CLIENT_COMPANY")
    private String clientCompany;		
	
	@Column(name = "CL_CLIENT_CARRIER")
    private String clientCarrier;
	
	@Column(name = "CL_CLIENT_PHONE")
    private String clientPhone;		
	
	@Column(name = "CL_PHONE_FLAG")
    private Integer phoneFlag;	
	
	@Column(name = "CL_DATE_FLAG")
    private Date dateFlag;	
	
	@Column(name = "CL_LAST_LOGIN_DATE")
    private Date lastLoginDate;
	
	@Column(name = "CL_LAST_SMS_DATE")
    private Date lastSmsDate;	
	
	@Column(name = "CL_LAST_PIN")
    private String lastPin;
	
	@Column(name = "CL_LAST_IP")
    private String lastIp;	
	
	@Column(name = "CL_BALANCE_ITEM")
    private Integer balanceItem;
	
	@Column(name = "CL_BALANCE_DATE")
    private Date balanceDate;
	
	@Column(name = "cl_mobile_sms_status")
    private String mobileSmsStatus;

	@Column(name = "cl_data_update")
    private String dataUpdate;
	
	@Column(name = "cl_mobile_update")
    private String mobileUpdate;
	
	@Column(name = "cl_mail_update")
    private String mailUpdate;
	
    @Column(name = "CL_VISA_SESSION")
    private String visaSession;
    
	@Column(name="CL_APELLIDO_MATERNO")
	private String maidenname;

	@Column(name="CL_APELLIDO_PATERNO")
	private String lastname;
	
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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMailStatus() {
		return mailStatus;
	}

	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}

	public String getMailResults() {
		return mailResults;
	}

	public void setMailResults(String mailResults) {
		this.mailResults = mailResults;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPasswordFlag() {
		return passwordFlag;
	}

	public void setPasswordFlag(Integer passwordFlag) {
		this.passwordFlag = passwordFlag;
	}

	public String getFirstCompany() {
		return firstCompany;
	}

	public void setFirstCompany(String firstCompany) {
		this.firstCompany = firstCompany;
	}

	public String getFirstCarrier() {
		return firstCarrier;
	}

	public void setFirstCarrier(String firstCarrier) {
		this.firstCarrier = firstCarrier;
	}

	public String getFirstPhone() {
		return firstPhone;
	}

	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}

	public String getClientCompany() {
		return clientCompany;
	}

	public void setClientCompany(String clientCompany) {
		this.clientCompany = clientCompany;
	}

	public String getClientCarrier() {
		return clientCarrier;
	}

	public void setClientCarrier(String clientCarrier) {
		this.clientCarrier = clientCarrier;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Integer getPhoneFlag() {
		return phoneFlag;
	}

	public void setPhoneFlag(Integer phoneFlag) {
		this.phoneFlag = phoneFlag;
	}

	public Date getDateFlag() {
		return dateFlag;
	}

	public void setDateFlag(Date dateFlag) {
		this.dateFlag = dateFlag;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastSmsDate() {
		return lastSmsDate;
	}

	public void setLastSmsDate(Date lastSmsDate) {
		this.lastSmsDate = lastSmsDate;
	}

	public String getLastPin() {
		return lastPin;
	}

	public void setLastPin(String lastPin) {
		this.lastPin = lastPin;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Integer getBalanceItem() {
		return balanceItem;
	}

	public void setBalanceItem(Integer balanceItem) {
		this.balanceItem = balanceItem;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getMobileSmsStatus() {
		return mobileSmsStatus;
	}

	public void setMobileSmsStatus(String mobileSmsStatus) {
		this.mobileSmsStatus = mobileSmsStatus;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getDataUpdate() {
		return dataUpdate;
	}

	public void setDataUpdate(String dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public String getVisaSession() {
		return visaSession;
	}

	public void setVisaSession(String visaSession) {
		this.visaSession = visaSession;
	}

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
	
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	
}