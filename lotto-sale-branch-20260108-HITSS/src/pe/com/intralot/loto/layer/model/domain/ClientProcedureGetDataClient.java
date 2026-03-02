package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   Victor Farro Veramendi
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "CLIENTUPDATE_GETDATACLIENT", query = "{ call LOTOCARD.CLIENTUPDATE.GETDATACLIENT(?,?,?) }", callable = true, resultClass = ClientProcedureGetDataClient.class)
public class ClientProcedureGetDataClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "p_clientid")
    private String clientId;
    @Column(name = "p_nombre")
    private String nombre;
    @Column(name = "p_user")
    private String user;
    @Column(name = "p_appaterno")
    private String apPaterno;
    @Column(name = "p_apmaterno")
    private String apMaterno;
    @Column(name = "p_birthdate")
    private String birthDate;
    @Column(name = "p_mail")
    private String mail;
    @Column(name = "p_mailstatus")
    private String mailStatus;
    @Column(name = "p_confirm")
    private String confirm;
    @Column(name = "p_region")
    private String region;
    @Column(name = "p_mail2")
    private String mail2;
    @Column(name = "p_mail2status")
    private String mail2Status;
    @Column(name = "p_nickname")
    private String nickName;
    @Column(name = "p_gender")
    private String gender;
    @Column(name = "p_country")
    private String country;
    @Column(name = "p_marital")
    private String marital;
    @Column(name = "p_pnumbers")
    private String pNumbers;
    @Column(name = "p_pnumbers00")
    private String pNumbers00;
    @Column(name = "p_typeid")
    private String typeId;
    @Column(name = "p_numberid")
    private String numberId;
    @Column(name = "p_address")
    private String address;
    @Column(name = "p_terms")
    private String terms;
    @Column(name = "p_comtypeid")
    private String comTypeId;
    @Column(name = "p_comnumberid")
    private String comNumberId;
    @Column(name = "p_comname")
    private String comName;
    @Column(name = "p_comphones")
    private String comPhones;
    @Column(name = "p_comcountry")
    private String comCountry;
    @Column(name = "p_comregion")
    private String comRegion;
    @Column(name = "p_comaddress")
    private String comAddress;
    @Column(name = "p_comstatus")
    private String comStatus;
    @Column(name = "p_mode")
    private String mode;
    @Column(name = "p_lucky_icon")
    private String luckyIcon;
    @Column(name = "p_fixed_phone")
    private String fixedPhone;
    @Column(name = "p_mobile_phone")
    private String mobilePhone;    
    @Column(name = "p_control_amount")
    private Double controlAmount;    
    @Column(name = "p_control_hours")
    private Integer controlHours;    
    @Column(name = "p_control_last_date")
    private String controlLastDate;
    @Column(name = "p_insert_date")
    private String insertDate;
    
    @Column(name = "p_address2")
    private String address2;
    @Column(name = "p_province")
    private String province;
    @Column(name = "p_district")
    private String district;
    @Column(name = "p_ppe")
    private String ppe;
    
    @Column(name = "p_nregion")
    private String nregion;
    @Column(name = "p_nprovince")
    private String nprovince;
    @Column(name = "p_ndistrict")
    private String ndistrict;
    @Column(name = "p_ncountry")
    private String ncountry;
    
    //FHU desconexion del cliente
    @Column(name = "p_token_session")
    private String tokenSession;
    

    public String getTokenSession() {
		return tokenSession;
	}

	public void setTokenSession(String tokenSession) {
		this.tokenSession = tokenSession;
	}

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public String getMail2Status() {
        return mail2Status;
    }

    public void setMail2Status(String mail2Status) {
        this.mail2Status = mail2Status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getpNumbers() {
        return pNumbers;
    }

    public void setpNumbers(String pNumbers) {
        this.pNumbers = pNumbers;
    }

    public String getpNumbers00() {
        return pNumbers00;
    }

    public void setpNumbers00(String pNumbers00) {
        this.pNumbers00 = pNumbers00;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getComTypeId() {
        return comTypeId;
    }

    public void setComTypeId(String comTypeId) {
        this.comTypeId = comTypeId;
    }

    public String getComNumberId() {
        return comNumberId;
    }

    public void setComNumberId(String comNumberId) {
        this.comNumberId = comNumberId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComPhones() {
        return comPhones;
    }

    public void setComPhones(String comPhones) {
        this.comPhones = comPhones;
    }

    public String getComCountry() {
        return comCountry;
    }

    public void setComCountry(String comCountry) {
        this.comCountry = comCountry;
    }

    public String getComRegion() {
        return comRegion;
    }

    public void setComRegion(String comRegion) {
        this.comRegion = comRegion;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComStatus() {
        return comStatus;
    }

    public void setComStatus(String comStatus) {
        this.comStatus = comStatus;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLuckyIcon() {
        return luckyIcon;
    }

    public void setLuckyIcon(String luckyIcon) {
        this.luckyIcon = luckyIcon;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

	public Double getControlAmount() {
		return controlAmount;
	}

	public void setControlAmount(Double controlAmount) {
		this.controlAmount = controlAmount;
	}

	public Integer getControlHours() {
		return controlHours;
	}

	public void setControlHours(Integer controlHours) {
		this.controlHours = controlHours;
	}

	public String getControlLastDate() {
		return controlLastDate;
	}

	public void setControlLastDate(String controlLastDate) {
		this.controlLastDate = controlLastDate;
	}	

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPpe() {
		return ppe;
	}

	public void setPpe(String ppe) {
		this.ppe = ppe;
	}	

	public String getNregion() {
		return nregion;
	}

	public void setNregion(String nregion) {
		this.nregion = nregion;
	}

	public String getNprovince() {
		return nprovince;
	}

	public void setNprovince(String nprovince) {
		this.nprovince = nprovince;
	}

	public String getNdistrict() {
		return ndistrict;
	}

	public void setNdistrict(String ndistrict) {
		this.ndistrict = ndistrict;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNcountry() {
		return ncountry;
	}

	public void setNcountry(String ncountry) {
		this.ncountry = ncountry;
	}  

	public boolean isDataComplete() {
		if(this.getNombre() == null || this.getApPaterno() == null || this.getTypeId() == null || this.getNumberId() == null  || 
				this.getBirthDate() == null || this.getUser() == null || this.getMail() == null || this.getMobilePhone() == null ||
						this.getPpe() == null) {
					return false;
       }
		
		return true;
	} 
    
    /*
     * @Id
     * @Column(name = "p_user") private String user;
     * @Column(name = "p_nombre") private String nombre;
     * @Column(name = "p_appaterno") private String apPaterno;
     * @Column(name = "p_apmaterno") private String apMaterno;
     * @Column(name = "p_birthdate") private String birthDate;
     * @Column(name = "p_mail") private String mail;
     * @Column(name = "p_mailstatus") private String mailStatus;
     * @Column(name = "p_confirm") private String confirm;
     * @Column(name = "p_region") private String region;
     * @Column(name = "p_mail2") private String mail2;
     * @Column(name = "p_mail2status") private String mail2Status;
     * @Column(name = "p_nickname") private String nickName;
     * @Column(name = "p_gender") private String gender;
     * @Column(name = "p_country") private String country;
     * @Column(name = "p_marital") private String marital;
     * @Column(name = "p_pnumbers") private String pNumbers;
     * @Column(name = "p_pnumbers00") private String pNumbers00;
     * @Column(name = "p_typeid") private String typeId;
     * @Column(name = "p_numberid") private String numberId;
     * @Column(name = "p_address") private String address;
     * @Column(name = "p_terms") private String terms;
     * @Column(name = "p_comtypeid") private String comTypeId;
     * @Column(name = "p_comnumberid") private String comNumberId;
     * @Column(name = "p_comname") private String comName;
     * @Column(name = "p_comphones") private String comPhones;
     * @Column(name = "p_comcountry") private String comCountry;
     * @Column(name = "p_comregion") private String comRegion;
     * @Column(name = "p_comaddress") private String comAddress;
     * @Column(name = "p_comstatus") private String comStatus;
     * @Column(name = "p_mode") private String mode;
     * @Column(name = "p_lucky_icon") private String luckyIcon;
     * @Column(name = "p_fixed_phone") private String fixedPhone;
     * @Column(name = "p_mobile_phone") private String mobilePhone; public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; } public String
     * getApPaterno() { return apPaterno; } public void setApPaterno(String apPaterno) { this.apPaterno = apPaterno; } public String getApMaterno() { return apMaterno; } public void
     * setApMaterno(String apMaterno) { this.apMaterno = apMaterno; } public String getBirthDate() { return birthDate; } public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
     * public String getUser() { return user; } public void setUser(String user) { this.user = user; } public String getMail() { return mail; } public void setMail(String mail) { this.mail = mail; }
     * public String getMailStatus() { return mailStatus; } public void setMailStatus(String mailStatus) { this.mailStatus = mailStatus; } public String getConfirm() { return confirm; } public void
     * setConfirm(String confirm) { this.confirm = confirm; } public String getRegion() { return region; } public void setRegion(String region) { this.region = region; } public String getMail2() {
     * return mail2; } public void setMail2(String mail2) { this.mail2 = mail2; } public String getMail2Status() { return mail2Status; } public void setMail2Status(String mail2Status) {
     * this.mail2Status = mail2Status; } public String getNickName() { return nickName; } public void setNickName(String nickName) { this.nickName = nickName; } public String getGender() { return
     * gender; } public void setGender(String gender) { this.gender = gender; } public String getCountry() { return country; } public void setCountry(String country) { this.country = country; } public
     * String getMarital() { return marital; } public void setMarital(String marital) { this.marital = marital; } public String getpNumbers() { return pNumbers; } public void setpNumbers(String
     * pNumbers) { this.pNumbers = pNumbers; } public String getpNumbers00() { return pNumbers00; } public void setpNumbers00(String pNumbers00) { this.pNumbers00 = pNumbers00; } public String
     * getTypeId() { return typeId; } public void setTypeId(String typeId) { this.typeId = typeId; } public String getNumberId() { return numberId; } public void setNumberId(String numberId) {
     * this.numberId = numberId; } public String getAddress() { return address; } public void setAddress(String address) { this.address = address; } public String getTerms() { return terms; } public
     * void setTerms(String terms) { this.terms = terms; } public String getComTypeId() { return comTypeId; } public void setComTypeId(String comTypeId) { this.comTypeId = comTypeId; } public String
     * getComNumberId() { return comNumberId; } public void setComNumberId(String comNumberId) { this.comNumberId = comNumberId; } public String getComName() { return comName; } public void
     * setComName(String comName) { this.comName = comName; } public String getComPhones() { return comPhones; } public void setComPhones(String comPhones) { this.comPhones = comPhones; } public
     * String getComCountry() { return comCountry; } public void setComCountry(String comCountry) { this.comCountry = comCountry; } public String getComRegion() { return comRegion; } public void
     * setComRegion(String comRegion) { this.comRegion = comRegion; } public String getComAddress() { return comAddress; } public void setComAddress(String comAddress) { this.comAddress = comAddress;
     * } public String getComStatus() { return comStatus; } public void setComStatus(String comStatus) { this.comStatus = comStatus; } public String getMode() { return mode; } public void
     * setMode(String mode) { this.mode = mode; } public String getLuckyIcon() { return luckyIcon; } public void setLuckyIcon(String luckyIcon) { this.luckyIcon = luckyIcon; } public String
     * getFixedPhone() { return fixedPhone; } public void setFixedPhone(String fixedPhone) { this.fixedPhone = fixedPhone; } public String getMobilePhone() { return mobilePhone; } public void
     * setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; }
     */
}
