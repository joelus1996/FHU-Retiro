package pe.com.intralot.loto.layer.model.domain;

/**
 * @author:   Cristian Cortez
 * @rol:	  Analista en Desarrollo de Sistemas
 * @proyecto: 
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CulqiCardPK implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "QC_CLIENT_ID")
    private String clientId;
    @Column(name = "QC_ITEM_ID")
    private String itemId;
    
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
}
