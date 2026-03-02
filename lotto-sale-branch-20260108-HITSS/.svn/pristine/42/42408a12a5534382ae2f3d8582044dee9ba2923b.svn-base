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
@Table(name = "LOTOCARD.PARAMETER")
public class Parameter implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PARAMETER_ID")
	private String parameterId;
	
	@Column(name="PA_DESCRIPTION")
	private String description;
	
	@Column(name="PA_NUMBER")
	private Double number;

	@Column(name="PA_STATUS")
	private String status;
		
	@Column(name="PA_DATE")
	private Date date;
    
	@Column(name="PA_INI_VALUE")
	private Double iniValue;

	@Column(name="PA_END_VALUE")
	private Double endValue;
    
	public Parameter() {}	

	
	public String getParameterId() {
		return parameterId;
	}


	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getNumber() {
		return number;
	}


	public void setNumber(Double number) {
		this.number = number;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getIniValue() {
		return iniValue;
	}


	public void setIniValue(Double iniValue) {
		this.iniValue = iniValue;
	}


	public Double getEndValue() {
		return endValue;
	}


	public void setEndValue(Double endValue) {
		this.endValue = endValue;
	}


	public String toString (){
		return 
		"parameterId:"+parameterId+" description:"+description+" number:"+number
		+" status:"+status+" date:"+date+" iniValue:"+iniValue
		+" endValue:"+endValue;
	}
	
}