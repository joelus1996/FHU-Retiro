package pe.com.intralot.loto.layer.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_GETRASPAYAPRODUCTSPRICE", 
		query = "{ call LOTOCARD.CLIENTSALE.GETRASPAYAPRODUCTSPRICE(?) }", 
		callable = true, 
		resultClass = ClientProcedureGetRaspayaProductPriceList.class
		)

public class ClientProcedureGetRaspayaProductPriceList {

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
    
    
}
