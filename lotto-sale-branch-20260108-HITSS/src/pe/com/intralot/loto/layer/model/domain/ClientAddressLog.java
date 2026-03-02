package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   DParreno
 * @rol:	  Analista Programador
 * @proyecto: 
 *
 */

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOTOCARD.CLIENT_ADDRESS_LOG")
public class ClientAddressLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_generator_client_address_log")
	@SequenceGenerator(name="sec_generator_client_address_log", sequenceName = "lotocard.sec_client_address_log", allocationSize=1)
	@Column(name = "cal_id")
	private Integer cal_id;
	
	@Column(name = "cal_procedure")
	private String cal_procedure;
	
	@Column(name = "cal_user")
	private String cal_user;
	
	@Column(name = "cal_client_id")
	private Integer cal_client_id;	
	
	@Column(name = "cal_date")
    private Date cal_date;
	
	@Column(name = "cal_ip")
    private String cal_ip;
	
	@Column(name = "cal_address")
    private String cal_address;
	
	@Column(name = "cal_status")
    private String cal_status;

	public String getCal_procedure() {
		return cal_procedure;
	}

	public void setCal_procedure(String cal_procedure) {
		this.cal_procedure = cal_procedure;
	}

	public String getCal_user() {
		return cal_user;
	}

	public void setCal_user(String cal_user) {
		this.cal_user = cal_user;
	}

	public Integer getCal_client_id() {
		return cal_client_id;
	}

	public void setCal_client_id(Integer cal_client_id) {
		this.cal_client_id = cal_client_id;
	}

	public Date getCal_date() {
		return cal_date;
	}

	public void setCal_date(Date cal_date) {
		this.cal_date = cal_date;
	}

	public String getCal_ip() {
		return cal_ip;
	}

	public void setCal_ip(String cal_ip) {
		this.cal_ip = cal_ip;
	}

	public String getCal_address() {
		return cal_address;
	}

	public void setCal_address(String cal_address) {
		this.cal_address = cal_address;
	}

	public String getCal_status() {
		return cal_status;
	}

	public void setCal_status(String cal_status) {
		this.cal_status = cal_status;
	}
}