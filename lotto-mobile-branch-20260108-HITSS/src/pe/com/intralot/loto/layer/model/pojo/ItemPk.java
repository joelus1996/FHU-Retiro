package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobile
 *
 */ 

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class ItemPk implements Serializable {
    
	private static final long serialVersionUID = 8799656478674716638L;
			      
    private Integer draw;
    private Integer event;
    private Integer game;
	
    public ItemPk() {
    
    }

	public Integer getGame() {
		return game;
	}

	public void setGame(Integer game) {
		this.game = game;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getEvent() {
		return event;
	}

	public void setEvent(Integer event) {
		this.event = event;
	}
	
	public String toString(){
		return "draw:"+draw+" event:"+event+" game:"+game;
	}
}