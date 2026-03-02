package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobil
 *
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOTOCARD.TEAPUESTO_ITEM")
public class Item implements Serializable {
    
	private static final long serialVersionUID = 8799656478674716638L;

	
	@EmbeddedId
	private ItemPk itempk;	
	
	@Column(name = "EI_ITEM")
    private Integer item;
	
	@Column(name = "EI_LOCAL_SCORE")
    private Integer localScore;
	
	@Column(name = "EI_VISITOR_SCORE")
    private Integer visitorScore;
	
	@Column(name = "EI_STATUS")
    private String status;	
	
    @ManyToOne
	@JoinColumns({
		@JoinColumn(name="EI_DRAW_ID", referencedColumnName="TE_DRAW_ID"),
		@JoinColumn(name="EI_EVENT_ID", referencedColumnName="TE_EVENT_ID"),
		@JoinColumn(name="EI_GAME_ID", referencedColumnName="TE_GAME_ID")
		})
	private Event teapuestoEvent;
	
    public Item() {
    
    }

	public ItemPk getItempk() {
		return itempk;
	}

	public void setItempk(ItemPk itempk) {
		this.itempk = itempk;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getLocalScore() {
		return localScore;
	}

	public void setLocalScore(Integer localScore) {
		this.localScore = localScore;
	}

	public Integer getVisitorScore() {
		return visitorScore;
	}

	public void setVisitorScore(Integer visitorScore) {
		this.visitorScore = visitorScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Event getTeapuestoEvent() {
		return this.teapuestoEvent;
	}

	public void setTeapuestoEvent(Event teapuestoEvent) {
		this.teapuestoEvent = teapuestoEvent;
	}
	
	public String toString(){
		
		return "itempk:"+itempk.toString()+" localScore:"+localScore+" visitorScore:"+visitorScore+" status:"+status;
	}
	
}