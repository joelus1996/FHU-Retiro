package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PORTALDATA.TB_UBICACION_RED_DIGITAL")
public class UbicacionRedDigital {
	
	@Id
	@Column(name = "UB_ID")
	private Integer id;
	
	@Column(name = "DEP_NOM")
	private String departmentId;

	@Column(name = "PRO_NOM")
	private String provinceId;

	@Column(name = "DIS_NOM")
	private String districtId;

	@Column(name = "UB_DIRE")
	private String address;

	@Column(name = "UB_X")
	private String length;
	
	@Column(name = "UB_Y")
	private String latitude;

	@Column(name = "UB_REFERENCIA")
	private String reference;
	
	@Column(name = "UB_STATUS")
	private String status;
	
	@Column(name = "UB_NOMPOS")
	private String luckyPoint;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLuckyPoint() {
		return luckyPoint;
	}

	public void setLuckyPoint(String luckyPoint) {
		this.luckyPoint = luckyPoint;
	}
	
	
	
	
	

}





