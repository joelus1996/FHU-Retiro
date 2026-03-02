package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Cristian Cortez
 * @rol:	  Analista en Desarrollo de Sistemas
 * @proyecto: 
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/*@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)*/
@Entity
@Table(name = "LOTOCARD.CULQI_CARD")
public class CulqiCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CulqiCardPK id;
    @Column(name = "QC_CARD_ID")
    private String cardId;
    @Column(name = "QC_LAST_FOUR")
    private String lastFour;
    @Column(name = "QC_CARD_BRAND")
    private String cardBrand;
    @Column(name = "QC_CARD_STATUS")
    private String cardStatus;
    @Column(name = "QC_CUSTOMER_ID")
    private String customerId;
    
	public CulqiCardPK getId() {
		return id;
	}
	public void setId(CulqiCardPK id) {
		this.id = id;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getLastFour() {
		return lastFour;
	}
	public void setLastFour(String lastFour) {
		this.lastFour = lastFour;
	}
	public String getCardBrand() {
		return cardBrand;
	}
	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
