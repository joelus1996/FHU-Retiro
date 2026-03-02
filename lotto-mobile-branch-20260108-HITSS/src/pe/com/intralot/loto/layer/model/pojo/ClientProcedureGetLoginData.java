package pe.com.intralot.loto.layer.model.pojo;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;

/**
 * <p>
 * NOMBRE: ClientProcedureGetLoginData.java
 * <br></p>
 * <p>
 * FUNCION: Entidad Hibernate de inicio de sesión
 * <br></p>
 * <p>
 * NOTAS: Ninguna.
 * <br></p>
 * <p>
 * VERSIONES
 * <pre>
 * VER   MODIFICADO       FECHA       PEDIDO         REVISADO
 * 001   Edgar Narro  	  08/03/2023  login y registro unificado (playerId)
 * </pre>
 * <br></p>
 */

@Entity
@NamedNativeQuery(name = "CLIENTSALE_LOGIN_DATA", query = "{ call LOTOCARD.CLIENTSALE.GETLOGINDATA(?,?) }", callable = true, resultClass = ClientProcedureGetLoginData.class)
public class ClientProcedureGetLoginData {

	@Id
    @Column(name = "p_sessionid")
    private Integer sessionId;
    @Column(name = "p_clientid")
    private Integer clientId;
    @Column(name = "p_cl_nombre")
    private String cl_nombre;
    @Column(name = "p_status")
    private String status;
    @Column(name = "p_mode")
    private String mode;
    @Column(name = "p_nsessions")
    private Integer nsessions;
    @Column(name = "p_state")
    private Integer state;
    @Column(name = "p_today")
    private String today;
    @Column(name = "p_lucky_icon")
    private String luckyIcon;
    @Column(name = "p_balance_amount")
    private Double balanceAmount;
    @Column(name = "p_mail_status")
    private String mailStatus;
    @Column(name = "p_session_code")
    private String sessionCode;
    @Column(name = "p_agreement")
    private String agreement;
    @Column(name = "p_mail")
    private String mail;
    @Column(name = "p_mail_verified")
    private String mailVerified;
    @Column(name = "p_mail_code")
    private String mailCode;
    @Column(name = "p_mobile_phone")
    private String mobilePhone;
    @Column(name = "p_mobile_sms_status")
    private String mobileStatus;
    @Column(name = "p_promotion")
    private String promotion;
    @Column(name = "p_promotion_ibk")
    private String promotionibk;
    @Column(name = "p_user")
    private String user;
    
    @Transient
    private String pToken;
    
    @Transient
    private String samount;
    @Transient
    private String nombre;
    
    @Transient
    private String lapollaToken;
    
    @Transient
    private String tav2Token;
    
    @Transient
    private String title;
    
    @Transient
    private String message;
    
    @Transient
    private String button;
    
    @Column(name = "p_mask_phone")
    private Integer mask_phone;    
    @Column(name = "p_register_incomplete")
    private Integer register_incomplete;
   
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

    public String getCl_nombre() {
        return cl_nombre;
    }

    public void setCl_nombre(String cl_nombre) {
        this.cl_nombre = cl_nombre;
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

    public Integer getNsessions() {
        return nsessions;
    }

    public void setNsessions(Integer nsessions) {
        this.nsessions = nsessions;
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

    public String getSamount() {
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        return df.format(balanceAmount);
    }
    
    public String getNombre() {
        return cl_nombre;
    }

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getMailVerified() {
		return mailVerified;
	}

	public void setMailVerified(String mailVerified) {
		this.mailVerified = mailVerified;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMobileStatus() {
		return mobileStatus;
	}

	public void setMobileStatus(String mobileStatus) {
		this.mobileStatus = mobileStatus;
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

	public String getpToken() {
		return pToken;
	}

	public void setpToken(String pToken) {
		this.pToken = pToken;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	
	public String getPromotionibk() {
		return promotionibk;
	}

	public void setPromotionibk(String promotionibk) {
		this.promotionibk = promotionibk;
	}
	
	public String getLapollaToken() {
		return lapollaToken;
	}

	public void setLapollaToken(String lapollaToken) {
		this.lapollaToken = lapollaToken;
	}

	public String getTav2Token() {
		return tav2Token;
	}

	public void setTav2Token(String tav2Token) {
		this.tav2Token = tav2Token;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getButton() {
		return button;
	}

	public void setButton(String button) {
		this.button = button;
	}
	
	public Integer getMask_phone() {
		return mask_phone;
	}

	public Integer getRegister_incomplete() {
		return register_incomplete;
	}
	
}
