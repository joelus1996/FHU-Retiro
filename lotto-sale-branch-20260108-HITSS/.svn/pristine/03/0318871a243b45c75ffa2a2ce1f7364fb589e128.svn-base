package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_ACCOUNTDATAPART",
		query = "{ call LOTOCARD.clientsale.ACCOUNT_DATA_PART(?,?) }",
		callable = true,
		resultClass = ClientProcedureAccountDataPart.class
		)

public class ClientProcedureAccountDataPart implements Serializable{
	
	private static final long serialVersionUID = -7708028957668449183L;

	@Id
	@Column(name="w_client_user")	
	private String clientUser;
	
	@Column(name="w_balance_amount")
	private Double balanceAmount;
	
	@Column(name="w_bonus_amount")
	private String bonusAmount;
	
	@Column(name="w_other_amount")
	private String otherAmount;
	
	@Column(name="w_amt_min_recharge_agr")	
	private Double amtMinRechargeAgr;
	
	@Column(name="w_amt_max_recharge_agr")	
	private Double amtMaxRechargeAgr;
	
	@Column(name="w_state_recharge_agr")
	private String stateRechargeAgr;
	
	@Column(name="w_amt_min_recharge_visa")	
	private Double amtMinRechargeVisa;
	
	@Column(name="w_amt_max_recharge_visa")	
	private Double amtMaxRechargeVisa;
	
	@Column(name = "w_com_min_ran1_visa")
   	private Integer comMinRan1Visa;

    @Column(name = "w_com_max_ran1_visa")
   	private Integer comMaxRan1Visa;

    @Column(name = "w_com_amt_ran1_visa")
   	private Double comAmtRan1Visa;

    @Column(name = "w_com_min_ran2_visa")
   	private Integer comMinRan2Visa;

    @Column(name = "w_com_max_ran2_visa")
   	private Integer comMaxRan2Visa;

    @Column(name = "w_com_amt_ran2_visa")
   	private Double comAmtRan2Visa;
       
    @Column(name = "w_com_min_ran3_visa")
   	private Integer comMinRan3Visa;

    @Column(name = "w_com_max_ran3_visa")
   	private Integer comMaxRan3Visa;

    @Column(name = "w_com_amt_ran3_visa")
   	private Double comAmtRan3Visa;
       
    @Column(name = "w_com_min_ran4_visa")
   	private Integer comMinRan4Visa;

    @Column(name = "w_com_max_ran4_visa")
   	private Integer comMaxRan4Visa;

    @Column(name = "w_com_amt_ran4_visa")
   	private Double comAmtRan4Visa;
       
    @Column(name = "w_com_min_ran1_agr")
   	private Integer comMinRan1Agr;

    @Column(name = "w_com_max_ran1_agr")
   	private Integer comMaxRan1Agr;

    @Column(name = "w_com_amt_ran1_agr")
   	private Double comAmtRan1Agr;

    @Column(name = "w_com_min_ran2_agr")
   	private Integer comMinRan2Agr;

    @Column(name = "w_com_max_ran2_agr")
   	private Integer comMaxRan2Agr;

    @Column(name = "w_com_amt_ran2_agr")
   	private Double comAmtRan2Agr;
       
    @Column(name = "w_com_min_ran3_agr")
   	private Integer comMinRan3Agr;

    @Column(name = "w_com_max_ran3_agr")
   	private Integer comMaxRan3Agr;

    @Column(name = "w_com_amt_ran3_agr")
   	private Double comAmtRan3Agr;
       
    @Column(name = "w_com_min_ran4_agr")
   	private Integer comMinRan4Agr;

    @Column(name = "w_com_max_ran4_agr")
   	private Integer comMaxRan4Agr;

    @Column(name = "w_com_amt_ran4_agr")
   	private Double comAmtRan4Agr;
	
    @Column(name = "w_msj_com_visa")
    private String msjComVisa;
    
    @Column(name = "w_msj_com_agr")
    private String msjComAgr;
    
    @Column(name = "w_recharge_agora")
    private String rechargeAgora;
    
    @Column(name = "w_mobile_phone")
    private String mobilePhone;
    
    @Column(name = "w_amt_min_recharge_bcp")
   	private Integer amtMinRechargeBcp;
    
    @Column(name = "w_amt_max_recharge_bcp")
   	private Integer amtMaxRechargeBcp;
   
    @Column(name = "w_max_recharge_per_day_visa")
   	private Integer maxRechargePerDayVisa;
    
    @Column(name = "w_msg_max_rch_per_day_visa")
   	private String msgMaxRchPerDayVisa;
    
    @Column(name = "w_max_amt_per_week_visa")
   	private Integer maxAmtPerWeekVisa;
    
    @Column(name = "w_msg_max_amt_per_week_visa")
   	private String msgMaxAmtPerWeekVisa;
    
    @Column(name="w_state_recharge_visa")
	private String stateRechargeVisa;
    
    @Column(name="w_state_recharge_bcp")
	private String stateRechargeBcp;
    
    @Column(name="w_state_recharge_loto")
	private String stateRechargeLoto;
	
    @Column(name="w_state_recharge_ibk")
	private String stateRechargeIbk;
	
	@Column(name="w_amt_min_recharge_ibk")	
	private Double amtMinRechargeIbk;
	
	@Column(name="w_amt_max_recharge_ibk")	
	private Double amtMaxRechargeIbk;

    @Column(name="w_state_recharge_pefe")
	private String stateRechargePefe;

	@Column(name="w_amt_min_recharge_pefe")	
	private Double amtMinRechargePefe;

	@Column(name="w_amt_max_recharge_pefe")	
	private Double amtMaxRechargePefe;
	
    @Column(name="w_state_recharge_spay")
	private String stateRechargeSpay;

	@Column(name="w_amt_min_recharge_spay")	
	private Double amtMinRechargeSpay;
	
	@Column(name="w_amt_max_recharge_spay")	
	private Double amtMaxRechargeSpay;
	
    @Column(name="w_state_recharge_plin")
	private String stateRechargePlin;

	@Column(name="w_amt_min_recharge_plin")	
	private Double amtMinRechargePlin;

	@Column(name="w_amt_max_recharge_plin")	
	private Double amtMaxRechargePlin;
	
    @Column(name="w_state_recharge_yape")
	private String stateRechargeYape;

	@Column(name="w_amt_min_recharge_yape")	
	private Double amtMinRechargeYape;

	@Column(name="w_amt_max_recharge_yape")	
	private Double amtMaxRechargeYape;
	
	@Column(name="w_state_recharge_bbva")
	private String stateRechargeBbva;

	@Column(name="w_amt_min_recharge_bbva")	
	private Double amtMinRechargeBbva;

	@Column(name="w_amt_max_recharge_bbva")	
	private Double amtMaxRechargeBbva;
	
    @Column(name = "w_max_amt_per_day_pefe")
   	private Integer maxAmtPerDayPefe;
    
    @Column(name = "w_msg_max_amt_per_day_pefe")
   	private String msgMaxAmtPerDayPefe;
	
    @Column(name = "w_max_recharge_per_day_pefe")
   	private Integer maxRechargePerDayPefe;
    
    @Column(name = "w_msg_max_rch_per_day_pefe")
   	private String msgMaxRchPerDayPefe;
    
    @Column(name = "w_max_amt_per_day_spay")
   	private Integer maxAmtPerDaySpay;
    
    @Column(name = "w_msg_max_amt_per_day_spay")
   	private String msgMaxAmtPerDaySpay;
	
    @Column(name = "w_max_recharge_per_day_spay")
   	private Integer maxRechargePerDaySpay;
    
    @Column(name = "w_msg_max_rch_per_day_spay")
   	private String msgMaxRchPerDaySpay;
	
	@Column(name="w_cl_session_id")	
	private Integer sessionId;
	
    @Column(name = "w_state_recharge_izi")
   	private String stateRechargeIzi;
	
    @Column(name = "w_amt_min_recharge_izi")
   	private Integer amtMinRechargeIzi;
    
    @Column(name = "w_amt_max_recharge_izi")
   	private String amtMaxRechargeIzi;
    
    @Column(name = "w_doc_type_izi")
   	private String docTypeIzi;
    
    @Column(name = "w_doc_number")
   	private String docNumber;
    
    @Column(name = "w_nombre")
   	private String nombre;
    
    @Column(name = "w_apellidos")
   	private String apellidos;
    
    @Column(name = "w_state_recharge_plin_tupay")
   	private String stateRechargePlinTupay;
	
    @Column(name = "w_amt_min_recharge_plin_tupay")
   	private Integer amtMinRechargePlinTupay;
    
    @Column(name = "w_amt_max_recharge_plin_tupay")
   	private Integer amtMaxRechargePlinTupay;
    
    @Column(name = "w_state_recharge_yape_tupay")
   	private String stateRechargeYapeTupay;
	
    @Column(name = "w_amt_min_recharge_yape_tupay")
   	private Integer amtMinRechargeYapeTupay;
    
    @Column(name = "w_amt_max_recharge_yape_tupay")
   	private Integer amtMaxRechargeYapeTupay;
    
	public String getClientUser() {
		return clientUser;
	}

	public void setClientUser(String clientUser) {
		this.clientUser = clientUser;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(String bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public String getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}

	public Double getAmtMinRechargeAgr() {
		return amtMinRechargeAgr;
	}

	public void setAmtMinRechargeAgr(Double amtMinRechargeAgr) {
		this.amtMinRechargeAgr = amtMinRechargeAgr;
	}

	public Double getAmtMaxRechargeAgr() {
		return amtMaxRechargeAgr;
	}

	public void setAmtMaxRechargeAgr(Double amtMaxRechargeAgr) {
		this.amtMaxRechargeAgr = amtMaxRechargeAgr;
	}

	public String getStateRechargeAgr() {
		return stateRechargeAgr;
	}

	public void setStateRechargeAgr(String stateRechargeAgr) {
		this.stateRechargeAgr = stateRechargeAgr;
	}

	public Double getAmtMinRechargeVisa() {
		return amtMinRechargeVisa;
	}

	public void setAmtMinRechargeVisa(Double amtMinRechargeVisa) {
		this.amtMinRechargeVisa = amtMinRechargeVisa;
	}

	public Double getAmtMaxRechargeVisa() {
		return amtMaxRechargeVisa;
	}

	public void setAmtMaxRechargeVisa(Double amtMaxRechargeVisa) {
		this.amtMaxRechargeVisa = amtMaxRechargeVisa;
	}

	public Integer getComMinRan1Visa() {
		return comMinRan1Visa;
	}

	public void setComMinRan1Visa(Integer comMinRan1Visa) {
		this.comMinRan1Visa = comMinRan1Visa;
	}

	public Integer getComMaxRan1Visa() {
		return comMaxRan1Visa;
	}

	public void setComMaxRan1Visa(Integer comMaxRan1Visa) {
		this.comMaxRan1Visa = comMaxRan1Visa;
	}

	public Double getComAmtRan1Visa() {
		return comAmtRan1Visa;
	}

	public void setComAmtRan1Visa(Double comAmtRan1Visa) {
		this.comAmtRan1Visa = comAmtRan1Visa;
	}

	public Integer getComMinRan2Visa() {
		return comMinRan2Visa;
	}

	public void setComMinRan2Visa(Integer comMinRan2Visa) {
		this.comMinRan2Visa = comMinRan2Visa;
	}

	public Integer getComMaxRan2Visa() {
		return comMaxRan2Visa;
	}

	public void setComMaxRan2Visa(Integer comMaxRan2Visa) {
		this.comMaxRan2Visa = comMaxRan2Visa;
	}

	public Double getComAmtRan2Visa() {
		return comAmtRan2Visa;
	}

	public void setComAmtRan2Visa(Double comAmtRan2Visa) {
		this.comAmtRan2Visa = comAmtRan2Visa;
	}

	public Integer getComMinRan3Visa() {
		return comMinRan3Visa;
	}

	public void setComMinRan3Visa(Integer comMinRan3Visa) {
		this.comMinRan3Visa = comMinRan3Visa;
	}

	public Integer getComMaxRan3Visa() {
		return comMaxRan3Visa;
	}

	public void setComMaxRan3Visa(Integer comMaxRan3Visa) {
		this.comMaxRan3Visa = comMaxRan3Visa;
	}

	public Double getComAmtRan3Visa() {
		return comAmtRan3Visa;
	}

	public void setComAmtRan3Visa(Double comAmtRan3Visa) {
		this.comAmtRan3Visa = comAmtRan3Visa;
	}

	public Integer getComMinRan4Visa() {
		return comMinRan4Visa;
	}

	public void setComMinRan4Visa(Integer comMinRan4Visa) {
		this.comMinRan4Visa = comMinRan4Visa;
	}

	public Integer getComMaxRan4Visa() {
		return comMaxRan4Visa;
	}

	public void setComMaxRan4Visa(Integer comMaxRan4Visa) {
		this.comMaxRan4Visa = comMaxRan4Visa;
	}

	public Double getComAmtRan4Visa() {
		return comAmtRan4Visa;
	}

	public void setComAmtRan4Visa(Double comAmtRan4Visa) {
		this.comAmtRan4Visa = comAmtRan4Visa;
	}

	public Integer getComMinRan1Agr() {
		return comMinRan1Agr;
	}

	public void setComMinRan1Agr(Integer comMinRan1Agr) {
		this.comMinRan1Agr = comMinRan1Agr;
	}

	public Integer getComMaxRan1Agr() {
		return comMaxRan1Agr;
	}

	public void setComMaxRan1Agr(Integer comMaxRan1Agr) {
		this.comMaxRan1Agr = comMaxRan1Agr;
	}

	public Double getComAmtRan1Agr() {
		return comAmtRan1Agr;
	}

	public void setComAmtRan1Agr(Double comAmtRan1Agr) {
		this.comAmtRan1Agr = comAmtRan1Agr;
	}

	public Integer getComMinRan2Agr() {
		return comMinRan2Agr;
	}

	public void setComMinRan2Agr(Integer comMinRan2Agr) {
		this.comMinRan2Agr = comMinRan2Agr;
	}

	public Integer getComMaxRan2Agr() {
		return comMaxRan2Agr;
	}

	public void setComMaxRan2Agr(Integer comMaxRan2Agr) {
		this.comMaxRan2Agr = comMaxRan2Agr;
	}

	public Double getComAmtRan2Agr() {
		return comAmtRan2Agr;
	}

	public void setComAmtRan2Agr(Double comAmtRan2Agr) {
		this.comAmtRan2Agr = comAmtRan2Agr;
	}

	public Integer getComMinRan3Agr() {
		return comMinRan3Agr;
	}

	public void setComMinRan3Agr(Integer comMinRan3Agr) {
		this.comMinRan3Agr = comMinRan3Agr;
	}

	public Integer getComMaxRan3Agr() {
		return comMaxRan3Agr;
	}

	public void setComMaxRan3Agr(Integer comMaxRan3Agr) {
		this.comMaxRan3Agr = comMaxRan3Agr;
	}

	public Double getComAmtRan3Agr() {
		return comAmtRan3Agr;
	}

	public void setComAmtRan3Agr(Double comAmtRan3Agr) {
		this.comAmtRan3Agr = comAmtRan3Agr;
	}

	public Integer getComMinRan4Agr() {
		return comMinRan4Agr;
	}

	public void setComMinRan4Agr(Integer comMinRan4Agr) {
		this.comMinRan4Agr = comMinRan4Agr;
	}

	public Integer getComMaxRan4Agr() {
		return comMaxRan4Agr;
	}

	public void setComMaxRan4Agr(Integer comMaxRan4Agr) {
		this.comMaxRan4Agr = comMaxRan4Agr;
	}

	public Double getComAmtRan4Agr() {
		return comAmtRan4Agr;
	}

	public void setComAmtRan4Agr(Double comAmtRan4Agr) {
		this.comAmtRan4Agr = comAmtRan4Agr;
	}

	public String getMsjComVisa() {
		return msjComVisa;
	}

	public void setMsjComVisa(String msjComVisa) {
		this.msjComVisa = msjComVisa;
	}

	public String getMsjComAgr() {
		return msjComAgr;
	}

	public void setMsjComAgr(String msjComAgr) {
		this.msjComAgr = msjComAgr;
	}
	
	public String getRechargeAgora() {
		return rechargeAgora;
	}

	public void setRechargeAgora(String rechargeAgora) {
		this.rechargeAgora = rechargeAgora;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getAmtMinRechargeBcp() {
		return amtMinRechargeBcp;
	}

	public void setAmtMinRechargeBcp(Integer amtMinRechargeBcp) {
		this.amtMinRechargeBcp = amtMinRechargeBcp;
	}

	public Integer getAmtMaxRechargeBcp() {
		return amtMaxRechargeBcp;
	}

	public void setAmtMaxRechargeBcp(Integer amtMaxRechargeBcp) {
		this.amtMaxRechargeBcp = amtMaxRechargeBcp;
	}

	public Integer getMaxRechargePerDayVisa() {
		return maxRechargePerDayVisa;
	}

	public void setMaxRechargePerDayVisa(Integer maxRechargePerDayVisa) {
		this.maxRechargePerDayVisa = maxRechargePerDayVisa;
	}

	public String getMsgMaxRchPerDayVisa() {
		return msgMaxRchPerDayVisa;
	}

	public void setMsgMaxRchPerDayVisa(String msgMaxRchPerDayVisa) {
		this.msgMaxRchPerDayVisa = msgMaxRchPerDayVisa;
	}

	public Integer getMaxAmtPerWeekVisa() {
		return maxAmtPerWeekVisa;
	}

	public void setMaxAmtPerWeekVisa(Integer maxAmtPerWeekVisa) {
		this.maxAmtPerWeekVisa = maxAmtPerWeekVisa;
	}

	public String getMsgMaxAmtPerWeekVisa() {
		return msgMaxAmtPerWeekVisa;
	}

	public void setMsgMaxAmtPerWeekVisa(String msgMaxAmtPerWeekVisa) {
		this.msgMaxAmtPerWeekVisa = msgMaxAmtPerWeekVisa;
	}

	public String getStateRechargeVisa() {
		return stateRechargeVisa;
	}

	public void setStateRechargeVisa(String stateRechargeVisa) {
		this.stateRechargeVisa = stateRechargeVisa;
	}

	public String getStateRechargeBcp() {
		return stateRechargeBcp;
	}

	public void setStateRechargeBcp(String stateRechargeBcp) {
		this.stateRechargeBcp = stateRechargeBcp;
	}

	public String getStateRechargeLoto() {
		return stateRechargeLoto;
	}

	public void setStateRechargeLoto(String stateRechargeLoto) {
		this.stateRechargeLoto = stateRechargeLoto;
	}

	public String getStateRechargeIbk() {
		return stateRechargeIbk;
	}

	public void setStateRechargeIbk(String stateRechargeIbk) {
		this.stateRechargeIbk = stateRechargeIbk;
	}

	public Double getAmtMinRechargeIbk() {
		return amtMinRechargeIbk;
	}

	public void setAmtMinRechargeIbk(Double amtMinRechargeIbk) {
		this.amtMinRechargeIbk = amtMinRechargeIbk;
	}

	public Double getAmtMaxRechargeIbk() {
		return amtMaxRechargeIbk;
	}

	public void setAmtMaxRechargeIbk(Double amtMaxRechargeIbk) {
		this.amtMaxRechargeIbk = amtMaxRechargeIbk;
	}

	public String getStateRechargePefe() {
		return stateRechargePefe;
	}

	public void setStateRechargePefe(String stateRechargePefe) {
		this.stateRechargePefe = stateRechargePefe;
	}

	public Double getAmtMinRechargePefe() {
		return amtMinRechargePefe;
	}

	public void setAmtMinRechargePefe(Double amtMinRechargePefe) {
		this.amtMinRechargePefe = amtMinRechargePefe;
	}

	public Double getAmtMaxRechargePefe() {
		return amtMaxRechargePefe;
	}

	public void setAmtMaxRechargePefe(Double amtMaxRechargePefe) {
		this.amtMaxRechargePefe = amtMaxRechargePefe;
	}

	public String getStateRechargeSpay() {
		return stateRechargeSpay;
	}

	public void setStateRechargeSpay(String stateRechargeSpay) {
		this.stateRechargeSpay = stateRechargeSpay;
	}

	public Double getAmtMinRechargeSpay() {
		return amtMinRechargeSpay;
	}

	public void setAmtMinRechargeSpay(Double amtMinRechargeSpay) {
		this.amtMinRechargeSpay = amtMinRechargeSpay;
	}

	public Double getAmtMaxRechargeSpay() {
		return amtMaxRechargeSpay;
	}

	public void setAmtMaxRechargeSpay(Double amtMaxRechargeSpay) {
		this.amtMaxRechargeSpay = amtMaxRechargeSpay;
	}

	public String getStateRechargePlin() {
		return stateRechargePlin;
	}

	public void setStateRechargePlin(String stateRechargePlin) {
		this.stateRechargePlin = stateRechargePlin;
	}

	public Double getAmtMinRechargePlin() {
		return amtMinRechargePlin;
	}

	public void setAmtMinRechargePlin(Double amtMinRechargePlin) {
		this.amtMinRechargePlin = amtMinRechargePlin;
	}

	public Double getAmtMaxRechargePlin() {
		return amtMaxRechargePlin;
	}

	public void setAmtMaxRechargePlin(Double amtMaxRechargePlin) {
		this.amtMaxRechargePlin = amtMaxRechargePlin;
	}

	public String getStateRechargeYape() {
		return stateRechargeYape;
	}

	public void setStateRechargeYape(String stateRechargeYape) {
		this.stateRechargeYape = stateRechargeYape;
	}

	public Double getAmtMinRechargeYape() {
		return amtMinRechargeYape;
	}

	public void setAmtMinRechargeYape(Double amtMinRechargeYape) {
		this.amtMinRechargeYape = amtMinRechargeYape;
	}

	public Double getAmtMaxRechargeYape() {
		return amtMaxRechargeYape;
	}

	public void setAmtMaxRechargeYape(Double amtMaxRechargeYape) {
		this.amtMaxRechargeYape = amtMaxRechargeYape;
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public String getStateRechargeBbva() {
		return stateRechargeBbva;
	}

	public void setStateRechargeBbva(String stateRechargeBbva) {
		this.stateRechargeBbva = stateRechargeBbva;
	}

	public Double getAmtMinRechargeBbva() {
		return amtMinRechargeBbva;
	}

	public void setAmtMinRechargeBbva(Double amtMinRechargeBbva) {
		this.amtMinRechargeBbva = amtMinRechargeBbva;
	}

	public Double getAmtMaxRechargeBbva() {
		return amtMaxRechargeBbva;
	}

	public void setAmtMaxRechargeBbva(Double amtMaxRechargeBbva) {
		this.amtMaxRechargeBbva = amtMaxRechargeBbva;
	}

	public Integer getMaxAmtPerDayPefe() {
		return maxAmtPerDayPefe;
	}

	public void setMaxAmtPerDayPefe(Integer maxAmtPerDayPefe) {
		this.maxAmtPerDayPefe = maxAmtPerDayPefe;
	}

	public String getMsgMaxAmtPerDayPefe() {
		return msgMaxAmtPerDayPefe;
	}

	public void setMsgMaxAmtPerDayPefe(String msgMaxAmtPerDayPefe) {
		this.msgMaxAmtPerDayPefe = msgMaxAmtPerDayPefe;
	}

	public Integer getMaxRechargePerDayPefe() {
		return maxRechargePerDayPefe;
	}

	public void setMaxRechargePerDayPefe(Integer maxRechargePerDayPefe) {
		this.maxRechargePerDayPefe = maxRechargePerDayPefe;
	}

	public String getMsgMaxRchPerDayPefe() {
		return msgMaxRchPerDayPefe;
	}

	public void setMsgMaxRchPerDayPefe(String msgMaxRchPerDayPefe) {
		this.msgMaxRchPerDayPefe = msgMaxRchPerDayPefe;
	}

	public Integer getMaxAmtPerDaySpay() {
		return maxAmtPerDaySpay;
	}

	public void setMaxAmtPerDaySpay(Integer maxAmtPerDaySpay) {
		this.maxAmtPerDaySpay = maxAmtPerDaySpay;
	}

	public String getMsgMaxAmtPerDaySpay() {
		return msgMaxAmtPerDaySpay;
	}

	public void setMsgMaxAmtPerDaySpay(String msgMaxAmtPerDaySpay) {
		this.msgMaxAmtPerDaySpay = msgMaxAmtPerDaySpay;
	}

	public Integer getMaxRechargePerDaySpay() {
		return maxRechargePerDaySpay;
	}

	public void setMaxRechargePerDaySpay(Integer maxRechargePerDaySpay) {
		this.maxRechargePerDaySpay = maxRechargePerDaySpay;
	}

	public String getMsgMaxRchPerDaySpay() {
		return msgMaxRchPerDaySpay;
	}

	public void setMsgMaxRchPerDaySpay(String msgMaxRchPerDaySpay) {
		this.msgMaxRchPerDaySpay = msgMaxRchPerDaySpay;
	}

	public String getStateRechargeIzi() {
		return stateRechargeIzi;
	}

	public void setStateRechargeIzi(String stateRechargeIzi) {
		this.stateRechargeIzi = stateRechargeIzi;
	}

	public Integer getAmtMinRechargeIzi() {
		return amtMinRechargeIzi;
	}

	public void setAmtMinRechargeIzi(Integer amtMinRechargeIzi) {
		this.amtMinRechargeIzi = amtMinRechargeIzi;
	}

	public String getAmtMaxRechargeIzi() {
		return amtMaxRechargeIzi;
	}

	public void setAmtMaxRechargeIzi(String amtMaxRechargeIzi) {
		this.amtMaxRechargeIzi = amtMaxRechargeIzi;
	}

	public String getDocTypeIzi() {
		return docTypeIzi;
	}

	public void setDocTypeIzi(String docTypeIzi) {
		this.docTypeIzi = docTypeIzi;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getStateRechargePlinTupay() {
		return stateRechargePlinTupay;
	}

	public void setStateRechargePlinTupay(String stateRechargePlinTupay) {
		this.stateRechargePlinTupay = stateRechargePlinTupay;
	}

	public Integer getAmtMinRechargePlinTupay() {
		return amtMinRechargePlinTupay;
	}

	public void setAmtMinRechargePlinTupay(Integer amtMinRechargePlinTupay) {
		this.amtMinRechargePlinTupay = amtMinRechargePlinTupay;
	}

	public Integer getAmtMaxRechargePlinTupay() {
		return amtMaxRechargePlinTupay;
	}

	public void setAmtMaxRechargePlinTupay(Integer amtMaxRechargePlinTupay) {
		this.amtMaxRechargePlinTupay = amtMaxRechargePlinTupay;
	}

	public String getStateRechargeYapeTupay() {
		return stateRechargeYapeTupay;
	}

	public void setStateRechargeYapeTupay(String stateRechargeYapeTupay) {
		this.stateRechargeYapeTupay = stateRechargeYapeTupay;
	}

	public Integer getAmtMinRechargeYapeTupay() {
		return amtMinRechargeYapeTupay;
	}

	public void setAmtMinRechargeYapeTupay(Integer amtMinRechargeYapeTupay) {
		this.amtMinRechargeYapeTupay = amtMinRechargeYapeTupay;
	}

	public Integer getAmtMaxRechargeYapeTupay() {
		return amtMaxRechargeYapeTupay;
	}

	public void setAmtMaxRechargeYapeTupay(Integer amtMaxRechargeYapeTupay) {
		this.amtMaxRechargeYapeTupay = amtMaxRechargeYapeTupay;
	}
}
