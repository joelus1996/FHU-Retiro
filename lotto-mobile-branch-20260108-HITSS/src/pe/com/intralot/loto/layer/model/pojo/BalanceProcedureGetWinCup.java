package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "BALANCE_GETWINCUP", query = "{ call LOTOCARD.WINCUP.GETWIN_CUP(?,?,?) }", callable = true, resultClass = BalanceProcedureGetWinCup.class)
public class BalanceProcedureGetWinCup {
		
    @Id
    @Column(name = "w_prom_id")
    private String promId;
    
    @Column(name = "w_client_win")
    private String clientId;
    
	@Column(name = "w_prize_amount")
    private String prizeAmount;
	
	@Column(name = "w_wallet")
    private String tipoWallet;
    
    @Column(name = "w_prom_date")
    private String promDate;
    
    public String getPromId() {
		return promId;
	}

	public void setPromId(String promId) {
		this.promId = promId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(String prizeAmount) {
		this.prizeAmount = prizeAmount;
	}
	
	public String getTipoWallet() {
		return tipoWallet;
	}

	public void setTipoWallet(String tipoWallet) {
		this.tipoWallet = tipoWallet;
	}

	public String getPromDate() {
		return promDate;
	}

	public void setPromDate(String promDate) {
		this.promDate = promDate;
	}
    
	

}

