package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "PRIZE_PAYMENT_GET_DATA_COLLECT_PRIZES",
		query = "{ call LOTOCARD.PRIZE_PAYMENT.GET_DATA_COLLECT_PRIZES(?,?) }",
		callable = true,
		resultClass = PaymentPrizeProcedureGetDataCollectPrizes.class
		)
public class PaymentPrizeProcedureGetDataCollectPrizes implements Serializable{
	
	private static final long serialVersionUID = 1187489054157100539L;

	@Id
	@Column(name="o_client_id")
	private Integer clientId;
	
	@Column(name="o_saldo_liquidable")	
	private Double saldoLiquidable;
	
	@Column(name="o_saldo_liquidable_completo")	
	private Double saldoLiquidableCompleto;
	
	@Column(name="o_balance_amount")	
	private Double balanceAmount;
	
	@Column(name="o_amount_min_request_cash")	
	private Double amountMinRequestCash;
	
	@Column(name="o_amount_max_request_cash")	
	private Double amountMaxRequestCash;
	
	@Column(name="o_item_x_page_hr_mobile")
	private Integer itemXPageHRMobile;
	
	@Column(name="o_item_x_page_hr_desktop")
	private Integer itemXPageHRDesktop;
	
	@Column(name="o_state_dni")
	private String stateDni;
	
	@Column(name="o_amount_min_request_visa")
	private Integer amountMinRequestVisa;
	
	@Column(name="o_amount_max_request_visa")
	private Integer amountMaxRequestVisa;
	
	@Column(name="o_max_mb_per_image_visa")
	private Integer maxMbPerImageVisa;
	
	@Column(name="o_days_expire_request")
	private Integer daysExpireRequest;
	
	@Column(name = "o_amount_max_automatic_visa")
	private Integer amountMaxAutomaticVisa;
    
    @Column(name = "o_amount_min_enable_dni")
	private Integer amountMinEnableDni;
    
    @Column(name = "o_msg_automatic_visa_apr")
	private String msgAutomaticVisaApr;
    
    @Column(name = "o_msg_automatic_visa_den")
	private String msgAutomaticVisaDen;
    
    @Column(name = "o_amount_max_automatic_cash")
	private Integer amountMaxAutomaticCash;
    
    @Column(name = "o_msg_automatic_cash_apr")
	private String msgAutomaticCashApr;
    
    @Column(name = "o_amount_min_enbl_dni_cash")
    private Integer amountMinEnblDniCash;
    
    @Column(name = "o_max_request_per_day_cash")
    private Integer maxRequestPerDayCash;
    
    @Column(name = "o_max_amount_per_day_cash")
    private Integer maxAmountPerDayCash;
    
    @Column(name = "o_max_amount_per_week_cash")
    private Integer maxAmountPerWeekCash;
    
    @Column(name = "o_msg_max_rqu_per_day_cash")
    private String msgMaxRquPerDayCash;
    
    @Column(name = "o_msg_max_amt_per_day_cash")
    private String msgMaxAmtPerDayCash;
    
    @Column(name = "o_msg_max_amt_per_week_cash")
    private String msgMaxAmtPerWeekCash;
    
    @Column(name = "o_msg_amt_avbl_per_day_cash")
    private String msgAmtAvblPerDayCash;
    
    @Column(name = "o_msg_amt_avbl_per_week_cash")
    private String msgAmtAvblPerWeekCash;
    
    @Column(name = "o_min_acc_amt_enbl_dni_cash")
    private Integer minAccAmtEnblDniCash;
    
    @Column(name = "o_min_acc_amt_enbl_dni_visa")
    private Integer minAccAmtEnblDniVisa;

    @Column(name = "o_acc_amt_visa")
    private Integer accAmtVisa;
    
    @Column(name = "o_acc_amt_cash")
    private Integer accAmtCash;
    
    @Column(name = "o_acc_amt_agora")
    private Integer accAmtAgora;
    
    @Column(name = "o_acc_amt_trans")
    private Integer accAmtTrans;
    
    @Column(name = "o_amount_min_request_agr")
    private Integer amountMinRequestAgr;
    
    @Column(name = "o_amount_max_request_agr")
    private Integer amountMaxRequestAgr;
    
    @Column(name = "o_amount_min_enbl_dni_agr")
    private Integer amountMinEnblDniAgr;
    
    @Column(name = "o_min_acc_amt_enbl_dni_agr")
    private Integer minAccAmtEnblDniAgr;
    
    @Column(name = "o_amount_max_automatic_agr")
    private Integer amountMaxAutomaticAgr;
    
    @Column(name = "o_msg_automatic_agr_apr")
    private String msgAutomaticAgrApr;
    
    @Column(name = "o_msg_automatic_agr_den")
    private String msgAutomaticAgrDen;
    
    @Column(name = "o_max_request_per_day_agr")
    private Integer maxRequestPerDayAgr;
    
    @Column(name = "o_msg_max_rqu_per_day_agr")
    private String msgMaxRquPerDayAgr;
    
    @Column(name = "o_max_amount_per_day_agr")
    private Integer maxAmountPerDayAgr;
    
    @Column(name = "o_msg_max_amt_per_day_agr")
    private String msgMaxAmtPerDayAgr;
    
    @Column(name = "o_msg_amt_avbl_per_day_agr")
    private String msgAmtAvblPerDayAgr;
    
    @Column(name = "o_max_amount_per_week_agr")
    private Integer maxAmountPerWeekAgr;
    
    @Column(name = "o_msg_max_amt_per_week_agr")
    private String msgMaxAmtPerWeekAgr;
    
    @Column(name = "o_msg_amt_avbl_per_week_agr")
    private String msgAmtAvblPerWeekAgr;
    
    @Column(name = "o_state_request_agr")
    private String stateRequestAgr;
    
    @Column(name = "o_cpp_com_min_ran1_visa")
   	private Integer comMinRan1Visa;

    @Column(name = "o_cpp_com_max_ran1_visa")
   	private Integer comMaxRan1Visa;

    @Column(name = "o_cpp_com_amt_ran1_visa")
   	private Double comAmtRan1Visa;

    @Column(name = "o_cpp_com_min_ran2_visa")
   	private Integer comMinRan2Visa;

    @Column(name = "o_cpp_com_max_ran2_visa")
   	private Integer comMaxRan2Visa;

    @Column(name = "o_cpp_com_amt_ran2_visa")
   	private Double comAmtRan2Visa;
       
    @Column(name = "o_cpp_com_min_ran3_visa")
   	private Integer comMinRan3Visa;

    @Column(name = "o_cpp_com_max_ran3_visa")
   	private Integer comMaxRan3Visa;

    @Column(name = "o_cpp_com_amt_ran3_visa")
   	private Double comAmtRan3Visa;
       
    @Column(name = "o_cpp_com_min_ran4_visa")
   	private Integer comMinRan4Visa;

    @Column(name = "o_cpp_com_max_ran4_visa")
   	private Integer comMaxRan4Visa;

    @Column(name = "o_cpp_com_amt_ran4_visa")
   	private Double comAmtRan4Visa;
       
    @Column(name = "o_cpp_com_min_ran1_agr")
   	private Integer comMinRan1Agr;

    @Column(name = "o_cpp_com_max_ran1_agr")
   	private Integer comMaxRan1Agr;

    @Column(name = "o_cpp_com_amt_ran1_agr")
   	private Double comAmtRan1Agr;

    @Column(name = "o_cpp_com_min_ran2_agr")
   	private Integer comMinRan2Agr;

    @Column(name = "o_cpp_com_max_ran2_agr")
   	private Integer comMaxRan2Agr;

    @Column(name = "o_cpp_com_amt_ran2_agr")
   	private Double comAmtRan2Agr;
       
    @Column(name = "o_cpp_com_min_ran3_agr")
   	private Integer comMinRan3Agr;

    @Column(name = "o_cpp_com_max_ran3_agr")
   	private Integer comMaxRan3Agr;

    @Column(name = "o_cpp_com_amt_ran3_agr")
   	private Double comAmtRan3Agr;
       
    @Column(name = "o_cpp_com_min_ran4_agr")
   	private Integer comMinRan4Agr;

    @Column(name = "o_cpp_com_max_ran4_agr")
   	private Integer comMaxRan4Agr;

    @Column(name = "o_cpp_com_amt_ran4_agr")
   	private Double comAmtRan4Agr;
    
    @Column(name = "o_cpp_msj_com_visa")
    private String msjComVisa;
    
    @Column(name = "o_cpp_msj_com_agr")
    private String msjComAgr;
    
    @Column(name = "o_cpp_msj_com_den_visa")
    private String msjComDenVisa;
    
    @Column(name = "o_cpp_msj_com_den_agr")
    private String msjComDenAgr;
    
    @Column(name = "o_amount_min_request_tra")
    private Integer amountMinRequestTra;
    
    @Column(name = "o_amount_max_request_tra")
    private Integer amountMaxRequestTra;
    
    @Column(name = "o_amount_min_enbl_dni_tra")
    private Integer amountMinEnblDniTra;
    
    @Column(name = "o_min_acc_amt_enbl_dni_tra")
    private Integer minAccAmtEnblDniTra;
    
    @Column(name = "o_amount_max_automatic_tra")
    private Integer amountMaxAutomaticTra;
    
    @Column(name = "o_msg_automatic_tra_apr")
    private String msgAutomaticTraApr;
    
    @Column(name = "o_msg_automatic_tra_den")
    private String msgAutomaticTraDen;
    
    @Column(name = "o_max_request_per_day_tra")
    private Integer maxRequestPerDayTra;
    
    @Column(name = "o_msg_max_rqu_per_day_tra")
    private String msgMaxRquPerDayTra;
    
    @Column(name = "o_max_amount_per_day_tra")
    private Integer maxAmountPerDayTra;
    
    @Column(name = "o_msg_max_amt_per_day_tra")
    private String msgMaxAmtPerDayTra;
    
    @Column(name = "o_msg_amt_avbl_per_day_tra")
    private String msgAmtAvblPerDayTra;
    
    @Column(name = "o_max_amount_per_week_tra")
    private Integer maxAmountPerWeekTra;
    
    @Column(name = "o_msg_max_amt_per_week_tra")
    private String msgMaxAmtPerWeekTra;
    
    @Column(name = "o_msg_amt_avbl_per_week_tra")
    private String msgAmtAvblPerWeekTra;

    @Column(name = "o_max_request_per_day_visa")
    private Integer maxRequestPerDayVisa;
    
    @Column(name = "o_max_amount_per_week_visa")
    private Integer maxAmountPerWeekVisa;
    
    @Column(name="o_amount_min_rqu_tra_ran2")
	private Integer amountMinRquTraRan2;
	
	@Column(name="o_amount_max_rqu_tra_ran2")
	private Integer amountMaxRquTraRan2;	
	
	@Column(name="o_validity_dni_tra_ran2")
	private Integer validityDniTraRan2;	
	
	@Column(name="o_max_rqu_per_day_tra_ran2")
	private Integer maxRquPerDayTraRan2;
	
	@Column(name="o_max_amt_per_week_tra_ran2")
	private Integer maxAmtPerWeekTraRan2;
	
	@Column(name="o_amount_min_rqu_tra_ran3")
	private Integer amountMinRquTraRan3;
	
	@Column(name="o_validity_dni_tra_ran3")
	private Integer validityDniTraRan3;	
	
	@Column(name="o_max_rqu_per_day_tra_ran3")
	private Integer maxRquPerDayTraRan3;
	
	@Column(name="o_max_amt_per_week_tra_ran3")
	private Integer maxAmtPerWeekTraRan3;
	
	@Column(name="o_state_request_tra_ran1")
	private String stateRequestTraRan1;

	@Column(name="o_state_request_tra_ran2")
	private String stateRequestTraRan2;
	
	@Column(name="o_state_request_tra_ran3")
	private String stateRequestTraRan3;
	
	@Column(name="o_state_request_tra")
	private String stateRequestTra;
	
	@Column(name="o_state_request_visa")
	private String stateRequestVisa;
	
	@Column(name="o_state_request_cash")
	private String stateRequestCash;
	
	@Column(name="o_days_elapsed_dni")
	private Integer daysElapsedDni;
	
	@Column(name="o_white_list")
	private String whiteList;
	
	@Column(name = "o_required_kyc_ef")
	private String requiredKycEf;
	@Column(name = "o_required_kyc_visa")
	private String requiredKycVisa;
	@Column(name = "o_required_kyc_trans")
	private String requiredKycTrans;
	
	@Column(name = "o_amount_min_req_ef")
    private Integer amountMinRequiredKycEf;
    @Column(name = "o_amount_min_req_visa")
	private Integer amountMinRequiredKycVisa;
    @Column(name = "o_amount_min_req_trans")
	private Integer amountMinRequiredKycTrans;
	@Column(name = "o_nombre")
	private String nombre;
    @Column(name = "o_apellido_paterno")
	private String apellidoPaterno;
    @Column(name = "o_apellido_materno")
	private String apellidoMaterno;
	
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Double getSaldoLiquidable() {
		return saldoLiquidable;
	}

	public void setSaldoLiquidable(Double saldoLiquidable) {
		this.saldoLiquidable = saldoLiquidable;
	}

	public Double getAmountMinRequestCash() {
		return amountMinRequestCash;
	}

	public void setAmountMinRequestCash(Double amountMinRequestCash) {
		this.amountMinRequestCash = amountMinRequestCash;
	}

	public Double getAmountMaxRequestCash() {
		return amountMaxRequestCash;
	}

	public void setAmountMaxRequestCash(Double amountMaxRequestCash) {
		this.amountMaxRequestCash = amountMaxRequestCash;
	}

	public Integer getItemXPageHRMobile() {
		return itemXPageHRMobile;
	}

	public void setItemXPageHRMobile(Integer itemXPageHRMobile) {
		this.itemXPageHRMobile = itemXPageHRMobile;
	}

	public Integer getItemXPageHRDesktop() {
		return itemXPageHRDesktop;
	}

	public void setItemXPageHRDesktop(Integer itemXPageHRDesktop) {
		this.itemXPageHRDesktop = itemXPageHRDesktop;
	}
	
	public String getStateDni() {
		return stateDni;
	}

	public void setStateDni(String stateDni) {
		this.stateDni = stateDni;
	}

	public Integer getAmountMinRequestVisa() {
		return amountMinRequestVisa;
	}

	public void setAmountMinRequestVisa(Integer amountMinRequestVisa) {
		this.amountMinRequestVisa = amountMinRequestVisa;
	}

	public Integer getAmountMaxRequestVisa() {
		return amountMaxRequestVisa;
	}

	public void setAmountMaxRequestVisa(Integer amountMaxRequestVisa) {
		this.amountMaxRequestVisa = amountMaxRequestVisa;
	}

	public Integer getMaxMbPerImageVisa() {
		return maxMbPerImageVisa;
	}

	public void setMaxMbPerImageVisa(Integer maxMbPerImageVisa) {
		this.maxMbPerImageVisa = maxMbPerImageVisa;
	}

	public Integer getDaysExpireRequest() {
		return daysExpireRequest;
	}

	public void setDaysExpireRequest(Integer daysExpireRequest) {
		this.daysExpireRequest = daysExpireRequest;
	}

	public Integer getAmountMaxAutomaticVisa() {
		return amountMaxAutomaticVisa;
	}

	public void setAmountMaxAutomaticVisa(Integer amountMaxAutomaticVisa) {
		this.amountMaxAutomaticVisa = amountMaxAutomaticVisa;
	}

	public Integer getAmountMinEnableDni() {
		return amountMinEnableDni;
	}

	public void setAmountMinEnableDni(Integer amountMinEnableDni) {
		this.amountMinEnableDni = amountMinEnableDni;
	}

	public String getMsgAutomaticVisaApr() {
		return msgAutomaticVisaApr;
	}

	public void setMsgAutomaticVisaApr(String msgAutomaticVisaApr) {
		this.msgAutomaticVisaApr = msgAutomaticVisaApr;
	}

	public String getMsgAutomaticVisaDen() {
		return msgAutomaticVisaDen;
	}

	public void setMsgAutomaticVisaDen(String msgAutomaticVisaDen) {
		this.msgAutomaticVisaDen = msgAutomaticVisaDen;
	}

	public Integer getAmountMaxAutomaticCash() {
		return amountMaxAutomaticCash;
	}

	public void setAmountMaxAutomaticCash(Integer amountMaxAutomaticCash) {
		this.amountMaxAutomaticCash = amountMaxAutomaticCash;
	}

	public String getMsgAutomaticCashApr() {
		return msgAutomaticCashApr;
	}

	public void setMsgAutomaticCashApr(String msgAutomaticCashApr) {
		this.msgAutomaticCashApr = msgAutomaticCashApr;
	}

	public Integer getAmountMinEnblDniCash() {
		return amountMinEnblDniCash;
	}

	public void setAmountMinEnblDniCash(Integer amountMinEnblDniCash) {
		this.amountMinEnblDniCash = amountMinEnblDniCash;
	}

	public Integer getMaxRequestPerDayCash() {
		return maxRequestPerDayCash;
	}

	public void setMaxRequestPerDayCash(Integer maxRequestPerDayCash) {
		this.maxRequestPerDayCash = maxRequestPerDayCash;
	}

	public Integer getMaxAmountPerDayCash() {
		return maxAmountPerDayCash;
	}

	public void setMaxAmountPerDayCash(Integer maxAmountPerDayCash) {
		this.maxAmountPerDayCash = maxAmountPerDayCash;
	}

	public Integer getMaxAmountPerWeekCash() {
		return maxAmountPerWeekCash;
	}

	public void setMaxAmountPerWeekCash(Integer maxAmountPerWeekCash) {
		this.maxAmountPerWeekCash = maxAmountPerWeekCash;
	}

	public String getMsgMaxRquPerDayCash() {
		return msgMaxRquPerDayCash;
	}

	public void setMsgMaxRquPerDayCash(String msgMaxRquPerDayCash) {
		this.msgMaxRquPerDayCash = msgMaxRquPerDayCash;
	}

	public String getMsgMaxAmtPerDayCash() {
		return msgMaxAmtPerDayCash;
	}

	public void setMsgMaxAmtPerDayCash(String msgMaxAmtPerDayCash) {
		this.msgMaxAmtPerDayCash = msgMaxAmtPerDayCash;
	}

	public String getMsgMaxAmtPerWeekCash() {
		return msgMaxAmtPerWeekCash;
	}

	public void setMsgMaxAmtPerWeekCash(String msgMaxAmtPerWeekCash) {
		this.msgMaxAmtPerWeekCash = msgMaxAmtPerWeekCash;
	}

	public String getMsgAmtAvblPerDayCash() {
		return msgAmtAvblPerDayCash;
	}

	public void setMsgAmtAvblPerDayCash(String msgAmtAvblPerDayCash) {
		this.msgAmtAvblPerDayCash = msgAmtAvblPerDayCash;
	}

	public String getMsgAmtAvblPerWeekCash() {
		return msgAmtAvblPerWeekCash;
	}

	public void setMsgAmtAvblPerWeekCash(String msgAmtAvblPerWeekCash) {
		this.msgAmtAvblPerWeekCash = msgAmtAvblPerWeekCash;
	}

	public Integer getMinAccAmtEnblDniCash() {
		return minAccAmtEnblDniCash;
	}

	public void setMinAccAmtEnblDniCash(Integer minAccAmtEnblDniCash) {
		this.minAccAmtEnblDniCash = minAccAmtEnblDniCash;
	}

	public Integer getMinAccAmtEnblDniVisa() {
		return minAccAmtEnblDniVisa;
	}

	public void setMinAccAmtEnblDniVisa(Integer minAccAmtEnblDniVisa) {
		this.minAccAmtEnblDniVisa = minAccAmtEnblDniVisa;
	}

	public Integer getAccAmtVisa() {
		return accAmtVisa;
	}

	public void setAccAmtVisa(Integer accAmtVisa) {
		this.accAmtVisa = accAmtVisa;
	}

	public Integer getAccAmtCash() {
		return accAmtCash;
	}

	public void setAccAmtCash(Integer accAmtCash) {
		this.accAmtCash = accAmtCash;
	}

	public Integer getAccAmtAgora() {
		return accAmtAgora;
	}

	public void setAccAmtAgora(Integer accAmtAgora) {
		this.accAmtAgora = accAmtAgora;
	}

	public Integer getAmountMinRequestAgr() {
		return amountMinRequestAgr;
	}

	public void setAmountMinRequestAgr(Integer amountMinRequestAgr) {
		this.amountMinRequestAgr = amountMinRequestAgr;
	}

	public Integer getAmountMaxRequestAgr() {
		return amountMaxRequestAgr;
	}

	public void setAmountMaxRequestAgr(Integer amountMaxRequestAgr) {
		this.amountMaxRequestAgr = amountMaxRequestAgr;
	}

	public Integer getAmountMinEnblDniAgr() {
		return amountMinEnblDniAgr;
	}

	public void setAmountMinEnblDniAgr(Integer amountMinEnblDniAgr) {
		this.amountMinEnblDniAgr = amountMinEnblDniAgr;
	}

	public Integer getMinAccAmtEnblDniAgr() {
		return minAccAmtEnblDniAgr;
	}

	public void setMinAccAmtEnblDniAgr(Integer minAccAmtEnblDniAgr) {
		this.minAccAmtEnblDniAgr = minAccAmtEnblDniAgr;
	}

	public Integer getAmountMaxAutomaticAgr() {
		return amountMaxAutomaticAgr;
	}

	public void setAmountMaxAutomaticAgr(Integer amountMaxAutomaticAgr) {
		this.amountMaxAutomaticAgr = amountMaxAutomaticAgr;
	}

	public String getMsgAutomaticAgrApr() {
		return msgAutomaticAgrApr;
	}

	public void setMsgAutomaticAgrApr(String msgAutomaticAgrApr) {
		this.msgAutomaticAgrApr = msgAutomaticAgrApr;
	}

	public String getMsgAutomaticAgrDen() {
		return msgAutomaticAgrDen;
	}

	public void setMsgAutomaticAgrDen(String msgAutomaticAgrDen) {
		this.msgAutomaticAgrDen = msgAutomaticAgrDen;
	}

	public Integer getMaxRequestPerDayAgr() {
		return maxRequestPerDayAgr;
	}

	public void setMaxRequestPerDayAgr(Integer maxRequestPerDayAgr) {
		this.maxRequestPerDayAgr = maxRequestPerDayAgr;
	}

	public String getMsgMaxRquPerDayAgr() {
		return msgMaxRquPerDayAgr;
	}

	public void setMsgMaxRquPerDayAgr(String msgMaxRquPerDayAgr) {
		this.msgMaxRquPerDayAgr = msgMaxRquPerDayAgr;
	}

	public Integer getMaxAmountPerDayAgr() {
		return maxAmountPerDayAgr;
	}

	public void setMaxAmountPerDayAgr(Integer maxAmountPerDayAgr) {
		this.maxAmountPerDayAgr = maxAmountPerDayAgr;
	}

	public String getMsgMaxAmtPerDayAgr() {
		return msgMaxAmtPerDayAgr;
	}

	public void setMsgMaxAmtPerDayAgr(String msgMaxAmtPerDayAgr) {
		this.msgMaxAmtPerDayAgr = msgMaxAmtPerDayAgr;
	}

	public String getMsgAmtAvblPerDayAgr() {
		return msgAmtAvblPerDayAgr;
	}

	public void setMsgAmtAvblPerDayAgr(String msgAmtAvblPerDayAgr) {
		this.msgAmtAvblPerDayAgr = msgAmtAvblPerDayAgr;
	}

	public Integer getMaxAmountPerWeekAgr() {
		return maxAmountPerWeekAgr;
	}

	public void setMaxAmountPerWeekAgr(Integer maxAmountPerWeekAgr) {
		this.maxAmountPerWeekAgr = maxAmountPerWeekAgr;
	}

	public String getMsgMaxAmtPerWeekAgr() {
		return msgMaxAmtPerWeekAgr;
	}

	public void setMsgMaxAmtPerWeekAgr(String msgMaxAmtPerWeekAgr) {
		this.msgMaxAmtPerWeekAgr = msgMaxAmtPerWeekAgr;
	}

	public String getMsgAmtAvblPerWeekAgr() {
		return msgAmtAvblPerWeekAgr;
	}

	public void setMsgAmtAvblPerWeekAgr(String msgAmtAvblPerWeekAgr) {
		this.msgAmtAvblPerWeekAgr = msgAmtAvblPerWeekAgr;
	}

	public String getStateRequestAgr() {
		return stateRequestAgr;
	}

	public void setStateRequestAgr(String stateRequestAgr) {
		this.stateRequestAgr = stateRequestAgr;
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

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
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

	public String getMsjComDenVisa() {
		return msjComDenVisa;
	}

	public void setMsjComDenVisa(String msjComDenVisa) {
		this.msjComDenVisa = msjComDenVisa;
	}

	public String getMsjComDenAgr() {
		return msjComDenAgr;
	}

	public void setMsjComDenAgr(String msjComDenAgr) {
		this.msjComDenAgr = msjComDenAgr;
	}

	public Integer getAccAmtTrans() {
		return accAmtTrans;
	}

	public void setAccAmtTrans(Integer accAmtTrans) {
		this.accAmtTrans = accAmtTrans;
	}

	public Integer getAmountMinRequestTra() {
		return amountMinRequestTra;
	}

	public void setAmountMinRequestTra(Integer amountMinRequestTra) {
		this.amountMinRequestTra = amountMinRequestTra;
	}

	public Integer getAmountMaxRequestTra() {
		return amountMaxRequestTra;
	}

	public void setAmountMaxRequestTra(Integer amountMaxRequestTra) {
		this.amountMaxRequestTra = amountMaxRequestTra;
	}

	public Integer getAmountMinEnblDniTra() {
		return amountMinEnblDniTra;
	}

	public void setAmountMinEnblDniTra(Integer amountMinEnblDniTra) {
		this.amountMinEnblDniTra = amountMinEnblDniTra;
	}

	public Integer getMinAccAmtEnblDniTra() {
		return minAccAmtEnblDniTra;
	}

	public void setMinAccAmtEnblDniTra(Integer minAccAmtEnblDniTra) {
		this.minAccAmtEnblDniTra = minAccAmtEnblDniTra;
	}

	public Integer getAmountMaxAutomaticTra() {
		return amountMaxAutomaticTra;
	}

	public void setAmountMaxAutomaticTra(Integer amountMaxAutomaticTra) {
		this.amountMaxAutomaticTra = amountMaxAutomaticTra;
	}

	public String getMsgAutomaticTraApr() {
		return msgAutomaticTraApr;
	}

	public void setMsgAutomaticTraApr(String msgAutomaticTraApr) {
		this.msgAutomaticTraApr = msgAutomaticTraApr;
	}

	public String getMsgAutomaticTraDen() {
		return msgAutomaticTraDen;
	}

	public void setMsgAutomaticTraDen(String msgAutomaticTraDen) {
		this.msgAutomaticTraDen = msgAutomaticTraDen;
	}

	public Integer getMaxRequestPerDayTra() {
		return maxRequestPerDayTra;
	}

	public void setMaxRequestPerDayTra(Integer maxRequestPerDayTra) {
		this.maxRequestPerDayTra = maxRequestPerDayTra;
	}

	public String getMsgMaxRquPerDayTra() {
		return msgMaxRquPerDayTra;
	}

	public void setMsgMaxRquPerDayTra(String msgMaxRquPerDayTra) {
		this.msgMaxRquPerDayTra = msgMaxRquPerDayTra;
	}

	public Integer getMaxAmountPerDayTra() {
		return maxAmountPerDayTra;
	}

	public void setMaxAmountPerDayTra(Integer maxAmountPerDayTra) {
		this.maxAmountPerDayTra = maxAmountPerDayTra;
	}

	public String getMsgMaxAmtPerDayTra() {
		return msgMaxAmtPerDayTra;
	}

	public void setMsgMaxAmtPerDayTra(String msgMaxAmtPerDayTra) {
		this.msgMaxAmtPerDayTra = msgMaxAmtPerDayTra;
	}

	public String getMsgAmtAvblPerDayTra() {
		return msgAmtAvblPerDayTra;
	}

	public void setMsgAmtAvblPerDayTra(String msgAmtAvblPerDayTra) {
		this.msgAmtAvblPerDayTra = msgAmtAvblPerDayTra;
	}

	public Integer getMaxAmountPerWeekTra() {
		return maxAmountPerWeekTra;
	}

	public void setMaxAmountPerWeekTra(Integer maxAmountPerWeekTra) {
		this.maxAmountPerWeekTra = maxAmountPerWeekTra;
	}

	public String getMsgMaxAmtPerWeekTra() {
		return msgMaxAmtPerWeekTra;
	}

	public void setMsgMaxAmtPerWeekTra(String msgMaxAmtPerWeekTra) {
		this.msgMaxAmtPerWeekTra = msgMaxAmtPerWeekTra;
	}

	public String getMsgAmtAvblPerWeekTra() {
		return msgAmtAvblPerWeekTra;
	}

	public void setMsgAmtAvblPerWeekTra(String msgAmtAvblPerWeekTra) {
		this.msgAmtAvblPerWeekTra = msgAmtAvblPerWeekTra;
	}

	public Integer getMaxRequestPerDayVisa() {
		return maxRequestPerDayVisa;
	}

	public void setMaxRequestPerDayVisa(Integer maxRequestPerDayVisa) {
		this.maxRequestPerDayVisa = maxRequestPerDayVisa;
	}

	public Integer getMaxAmountPerWeekVisa() {
		return maxAmountPerWeekVisa;
	}

	public void setMaxAmountPerWeekVisa(Integer maxAmountPerWeekVisa) {
		this.maxAmountPerWeekVisa = maxAmountPerWeekVisa;
	}

	public Integer getAmountMinRquTraRan2() {
		return amountMinRquTraRan2;
	}

	public void setAmountMinRquTraRan2(Integer amountMinRquTraRan2) {
		this.amountMinRquTraRan2 = amountMinRquTraRan2;
	}

	public Integer getAmountMaxRquTraRan2() {
		return amountMaxRquTraRan2;
	}

	public void setAmountMaxRquTraRan2(Integer amountMaxRquTraRan2) {
		this.amountMaxRquTraRan2 = amountMaxRquTraRan2;
	}

	public Integer getValidityDniTraRan2() {
		return validityDniTraRan2;
	}

	public void setValidityDniTraRan2(Integer validityDniTraRan2) {
		this.validityDniTraRan2 = validityDniTraRan2;
	}

	public Integer getMaxRquPerDayTraRan2() {
		return maxRquPerDayTraRan2;
	}

	public void setMaxRquPerDayTraRan2(Integer maxRquPerDayTraRan2) {
		this.maxRquPerDayTraRan2 = maxRquPerDayTraRan2;
	}

	public Integer getMaxAmtPerWeekTraRan2() {
		return maxAmtPerWeekTraRan2;
	}

	public void setMaxAmtPerWeekTraRan2(Integer maxAmtPerWeekTraRan2) {
		this.maxAmtPerWeekTraRan2 = maxAmtPerWeekTraRan2;
	}

	public Integer getAmountMinRquTraRan3() {
		return amountMinRquTraRan3;
	}

	public void setAmountMinRquTraRan3(Integer amountMinRquTraRan3) {
		this.amountMinRquTraRan3 = amountMinRquTraRan3;
	}

	public Integer getValidityDniTraRan3() {
		return validityDniTraRan3;
	}

	public void setValidityDniTraRan3(Integer validityDniTraRan3) {
		this.validityDniTraRan3 = validityDniTraRan3;
	}

	public Integer getMaxRquPerDayTraRan3() {
		return maxRquPerDayTraRan3;
	}

	public void setMaxRquPerDayTraRan3(Integer maxRquPerDayTraRan3) {
		this.maxRquPerDayTraRan3 = maxRquPerDayTraRan3;
	}

	public Integer getMaxAmtPerWeekTraRan3() {
		return maxAmtPerWeekTraRan3;
	}

	public void setMaxAmtPerWeekTraRan3(Integer maxAmtPerWeekTraRan3) {
		this.maxAmtPerWeekTraRan3 = maxAmtPerWeekTraRan3;
	}

	public String getStateRequestTraRan1() {
		return stateRequestTraRan1;
	}

	public void setStateRequestTraRan1(String stateRequestTraRan1) {
		this.stateRequestTraRan1 = stateRequestTraRan1;
	}

	public String getStateRequestTraRan2() {
		return stateRequestTraRan2;
	}

	public void setStateRequestTraRan2(String stateRequestTraRan2) {
		this.stateRequestTraRan2 = stateRequestTraRan2;
	}

	public String getStateRequestTraRan3() {
		return stateRequestTraRan3;
	}

	public void setStateRequestTraRan3(String stateRequestTraRan3) {
		this.stateRequestTraRan3 = stateRequestTraRan3;
	}

	public String getStateRequestTra() {
		return stateRequestTra;
	}

	public void setStateRequestTra(String stateRequestTra) {
		this.stateRequestTra = stateRequestTra;
	}

	public String getStateRequestVisa() {
		return stateRequestVisa;
	}

	public void setStateRequestVisa(String stateRequestVisa) {
		this.stateRequestVisa = stateRequestVisa;
	}

	public String getStateRequestCash() {
		return stateRequestCash;
	}

	public void setStateRequestCash(String stateRequestCash) {
		this.stateRequestCash = stateRequestCash;
	}

	public Integer getDaysElapsedDni() {
		return daysElapsedDni;
	}

	public void setDaysElapsedDni(Integer daysElapsedDni) {
		this.daysElapsedDni = daysElapsedDni;
	}

	public String getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(String whiteList) {
		this.whiteList = whiteList;
	}
	

	public String getRequiredKycEf() {
		return requiredKycEf;
	}

	public void setRequiredKycEf(String requiredKycEf) {
		this.requiredKycEf = requiredKycEf;
	}

	public String getRequiredKycVisa() {
		return requiredKycVisa;
	}

	public void setRequiredKycVisa(String requiredKycVisa) {
		this.requiredKycVisa = requiredKycVisa;
	}

	public String getRequiredKycTrans() {
		return requiredKycTrans;
	}

	public void setRequiredKycTrans(String requiredKycTrans) {
		this.requiredKycTrans = requiredKycTrans;
	}

	public Integer getAmountMinRequiredKycEf() {
		return amountMinRequiredKycEf;
	}

	public void setAmountMinRequiredKycEf(Integer amountMinRequiredKycEf) {
		this.amountMinRequiredKycEf = amountMinRequiredKycEf;
	}

	public Integer getAmountMinRequiredKycVisa() {
		return amountMinRequiredKycVisa;
	}

	public void setAmountMinRequiredKycVisa(Integer amountMinRequiredKycVisa) {
		this.amountMinRequiredKycVisa = amountMinRequiredKycVisa;
	}

	public Integer getAmountMinRequiredKycTrans() {
		return amountMinRequiredKycTrans;
	}

	public void setAmountMinRequiredKycTrans(Integer amountMinRequiredKycTrans) {
		this.amountMinRequiredKycTrans = amountMinRequiredKycTrans;
	}

	public Double getSaldoLiquidableCompleto() {
		return saldoLiquidableCompleto;
	}

	public void setSaldoLiquidableCompleto(Double saldoLiquidableCompleto) {
		this.saldoLiquidableCompleto = saldoLiquidableCompleto;
	}

		public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
}
