package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_GETRASPAYAPRODUCTS", 
		query = "{ call LOTOCARD.CLIENTSALE.GETRASPAYAPRODUCTS(?) }", 
		callable = true, 
		resultClass = ClientProcedureGetRaspayaProductList.class
		)

public class ClientProcedureGetRaspayaProductList {

	@Id
    @Column(name = "w_product_id")
    private String gameproductid;
    
    @Column(name = "w_name")
    private String name;
    
    @Column(name = "w_title")
    private String title;
    
    @Column(name = "w_price")
    private String price;
    
    @Column(name = "w_pozo")
    private String pozo;
    
    @Column(name = "w_cintillo")
    private String cintillo;
    
    @Column(name = "w_prov_id")
    private String provid;
    
    @Column(name = "w_image")
    private String image;
    
    @Column(name = "w_type")
    private String type;
    
    @Column(name = "w_new")
    private String newtag;
    
    @Column(name = "w_main_provider")
    private String mainprovider;

	public String getGameproductid() {
		return gameproductid;
	}

	public void setGameproductid(String gameproductid) {
		this.gameproductid = gameproductid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPozo() {
		return pozo;
	}

	public void setPozo(String pozo) {
		this.pozo = pozo;
	}

	public String getCintillo() {
		return cintillo;
	}

	public void setCintillo(String cintillo) {
		this.cintillo = cintillo;
	}

	public String getProvid() {
		return provid;
	}

	public void setProvid(String provid) {
		this.provid = provid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNewtag() {
		return newtag;
	}

	public void setNewtag(String newtag) {
		this.newtag = newtag;
	}

	public String getMainprovider() {
		return mainprovider;
	}

	public void setMainprovider(String mainprovider) {
		this.mainprovider = mainprovider;
	}
    
}
