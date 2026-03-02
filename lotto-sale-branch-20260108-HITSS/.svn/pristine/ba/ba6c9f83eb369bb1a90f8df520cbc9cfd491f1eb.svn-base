package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "BALANCESALE_GETBONUSLIST", query = "{ call LOTOCARD.BALANCESALE.GETBONUSLIST(?,?) }", callable = true, resultClass = BalanceProcedureGetBonusList.class)
public class BalanceProcedureGetBonusList {

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
    @Column(name = "w_rollover_times")
    private String rolloverTimes;
    @Column(name = "w_rollover_validated")
    private String rolloverValidates;
    @Column(name = "w_rollover_status")
    private String rolloverStatus;
    @Column(name = "w_prize_status")
    private String prizeStatus;

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

	public String getRolloverTimes() {
		return rolloverTimes;
	}

	public void setRolloverTimes(String rolloverTimes) {
		this.rolloverTimes = rolloverTimes;
	}

	public String getRolloverValidates() {
		return rolloverValidates;
	}

	public void setRolloverValidates(String rolloverValidates) {
		this.rolloverValidates = rolloverValidates;
	}

	public String getRolloverStatus() {
		return rolloverStatus;
	}

	public void setRolloverStatus(String rolloverStatus) {
		this.rolloverStatus = rolloverStatus;
	}
	
	public String getPrizeStatus() {
		return prizeStatus;
	}

	public void setPrizeStatus(String prizeStatus) {
		this.prizeStatus = prizeStatus;
	}
}
