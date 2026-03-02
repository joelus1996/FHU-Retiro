package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_GETVIRTUALESPRODUCTSORDER", 
		query = "{ call LOTOCARD.CLIENTSALE.GETVIRTUALESPRODUCTSORDER(?) }", 
		callable = true, 
		resultClass = ClientProcedureGetVirtualesProductListOrder.class
		)

public class ClientProcedureGetVirtualesProductListOrder {

    @Id
    @Column(name = "w_product_id")
    private String gameproductid;
    
    @Column(name = "w_name")
    private String name;
    
    @Column(name = "w_prov_id")
    private String provid;
    
    @Column(name = "w_prov_name")
    private String provname;
    
    @Column(name = "w_image")
    private String image;
    
    @Column(name = "w_demo_link")
    private String demolink;
    
    @Column(name = "w_type")
    private String type;
    
    @Column(name = "w_new")
    private String newtag;
    
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

	public String getProvid() {
		return provid;
	}

	public void setProvid(String provid) {
		this.provid = provid;
	}

	public String getProvname() {
		return provname;
	}

	public void setProvname(String provname) {
		this.provname = provname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDemolink() {
		return demolink;
	}

	public void setDemolink(String demolink) {
		this.demolink = demolink;
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
    
}

