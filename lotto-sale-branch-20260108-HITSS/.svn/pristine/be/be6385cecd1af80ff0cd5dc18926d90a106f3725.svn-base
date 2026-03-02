package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "BALANCESALE_GETBALANCELIST_FILTER", query = "{ call LOTOCARD.BALANCESALE.GETBALANCELISTFILTER(?,?,?,?) }", callable = true, resultClass = BalanceProcedureGetBalanceListFilter.class)
public class BalanceProcedureGetBalanceListFilter {

    @Id
    @Column(name = "w_balance_item")	
    private Integer balanceItem;
    @Column(name = "w_client_id")
    private Integer clientId;
    @Column(name = "w_description")
    private String description;
    @Column(name = "w_balance_date")
    private String balanceDate;
    @Column(name = "w_prev_amount")
    private Double prevAmount;
    @Column(name = "w_load_amount")
    private Double loadAmount;
    @Column(name = "w_new_amount")
    private Double newAmount;
    @Column(name = "w_neoprize_amount")
    private Double neoprizeAmount;
    @Column(name = "w_kironprize_amount")
    private Double kironprizeAmount;
    @Column(name = "w_movil_company")
    private String movilCompany;
    @Column(name = "w_client_carrier")
    private String clientCarrier;
    @Column(name = "w_client_phone")
    private String clientPhone;
    @Column(name = "w_commission_recharge")
    private Double commissionRecharge;
    @Column(name = "w_commission_request")
    private Double commissionRequest;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getBalanceItem() {
        return balanceItem;
    }

    public void setBalanceItem(Integer balanceItem) {
        this.balanceItem = balanceItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Double getPrevAmount() {
        return prevAmount;
    }

    public void setPrevAmount(Double prevAmount) {
        this.prevAmount = prevAmount;
    }

    public Double getLoadAmount() {
        return loadAmount;
    }

    public void setLoadAmount(Double loadAmount) {
        this.loadAmount = loadAmount;
    }

    public Double getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(Double newAmount) {
        this.newAmount = newAmount;
    }

    public Double getNeoprizeAmount() {
        return neoprizeAmount;
    }

    public void setNeoprizeAmount(Double neoprizeAmount) {
        this.neoprizeAmount = neoprizeAmount;
    }

    public Double getKironprizeAmount() {
        return kironprizeAmount;
    }

    public void setKironprizeAmount(Double kironprizeAmount) {
        this.kironprizeAmount = kironprizeAmount;
    }

    public String getMovilCompany() {
        return movilCompany;
    }

    public void setMovilCompany(String movilCompany) {
        this.movilCompany = movilCompany;
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

	public Double getCommissionRecharge() {
		return commissionRecharge;
	}

	public void setCommissionRecharge(Double commissionRecharge) {
		this.commissionRecharge = commissionRecharge;
	}

	public Double getCommissionRequest() {
		return commissionRequest;
	}

	public void setCommissionRequest(Double commissionRequest) {
		this.commissionRequest = commissionRequest;
	}
	
}
