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
import javax.persistence.Table;

@Entity
@Table(name = "LOTOCARD.TB_DISTRITO")
public class District implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DIS_ID")
	private String districId;

	@Column(name = "DEP_ID")
	private String departmentId;

	@Column(name = "PRO_ID")
	private String provinceId;

	@Column(name = "DIS_NOM")
	private String districtName;

	@Column(name = "DIS_CAP")
	private String capital;

	public String getDistricId() {
		return districId;
	}

	public void setDistricId(String districId) {
		this.districId = districId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}	
}
