package pe.com.intralot.loto.layer.model.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_TUTORIALMOBILE",
		query = "{ call LOTOCARD.clientsale.tutorial_mobile(?,?,?,?,?) }",
		callable = true,
		resultClass = ClientTutorial.class
		)
public class ClientTutorial {

	@Id
	@Column(name="w_client_id")	
	private Integer clientId;
	
	@Column(name="w_date_init")
	private Date dateInit;
	
	@Column(name="w_count_date")
	private Date countDate;
	
	@Column(name="w_count_day")
	private Integer countDay;
	
	@Column(name="w_count_tot")
	private Integer countTot;
	
	@Column(name="w_date_limit")
	private Date dateLimit;
	
	@Column(name="w_visible")
	private String visible;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getCountDate() {
		return countDate;
	}

	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}

	public Integer getCountDay() {
		return countDay;
	}

	public void setCountDay(Integer countDay) {
		this.countDay = countDay;
	}

	public Integer getCountTot() {
		return countTot;
	}

	public void setCountTot(Integer countTot) {
		this.countTot = countTot;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}
}
