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
@Table(name = "LOTOCARD.VW_PROVINCIA_LIST")
public class ViewProvinciaList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "DEP_ID")
	private String departmentId;
	
	@Column(name = "PRO_ID")
	private String provinceId;	

	@Column(name = "PRO_NOM")
	private String provinceName;

	@Column(name = "PRO_CAP")
	private String provinceCapital;

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}	

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvinceCapital() {
		return provinceCapital;
	}

	public void setProvinceCapital(String provinceCapital) {
		this.provinceCapital = provinceCapital;
	}	
	
}
