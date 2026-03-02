package pe.com.intralot.loto.layer.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(
		name = "CLIENTSALE_GETCASINOPRODUCTS", 
		query = "{ call LOTOCARD.CLIENTSALE.GETCASINOPRODUCTS(?) }", 
		callable = true, 
		resultClass = ClientProcedureGetCasinoProductList.class
		)

public class ClientProcedureGetCasinoProductList {

    @Id
    @Column(name = "w_product_id")
    private String gameproductid;
    
    @Column(name = "w_name")
    private String name;
    
    @Column(name = "w_prov_id")
    private String provid;
    
    @Column(name = "w_prov_short_name")
    private String provname;
    
    @Column(name = "w_image")
    private String image;
    
    @Column(name = "w_demo_link")
    private String demolink;
    
    @Column(name = "w_type")
    private String type;
    
    @Column(name = "w_new")
    private String newtag;
    
    @Column(name = "w_jackpot_id")
    private String jackpotid;
    
    @Column(name = "w_subtype")
    private String subtype;
    
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

	public String getJackpotid() {
		return jackpotid;
	}

	public void setJackpotid(String jackpotid) {
		this.jackpotid = jackpotid;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getMainprovider() {
		return mainprovider;
	}

	public void setMainprovider(String mainprovider) {
		this.mainprovider = mainprovider;
	}
    
}

