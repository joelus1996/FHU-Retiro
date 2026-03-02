package pe.com.intralot.loto.layer.model.pojo;

/**
 * @author:   Joel Ramirez
 * @rol:	  Analista Programador 
 * @proyecto: lotto-mobile
 *
 */

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class DrawItemPk implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="GAME_ID")
	private Integer gameId;

	@Column(name="DRAW_ID")
	private Integer drawId;

	@Column(name="ITEM")
	private Integer item;

    public DrawItemPk() {
    	
    }

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getDrawId() {
		return drawId;
	}

	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}
	
}