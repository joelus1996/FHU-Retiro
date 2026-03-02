package pe.com.intralot.loto.layer.dto.visa;

public class Merchant {

	private String name;//Nombre del comercio. valor: (?)
	private String categoryCode;//Codigo de categoría del comercio. valor (?)
	private Address address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
