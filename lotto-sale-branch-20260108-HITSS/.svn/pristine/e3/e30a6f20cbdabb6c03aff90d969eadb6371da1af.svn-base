package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DRAW database table.
 * 
 */
@Embeddable
public class DrawPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GAME_ID")
	private Integer gameId;

	@Column(name="DRAW_ID")
	private Integer drawId;

	public Integer getGameId() {
		return this.gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	public Integer getDrawId() {
		return this.drawId;
	}
	public void setDrawId(Integer drawId) {
		this.drawId = drawId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DrawPK)) {
			return false;
		}
		DrawPK castOther = (DrawPK)other;
		return 
			(this.gameId == castOther.gameId)
			&& (this.drawId == castOther.drawId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.gameId ^ (this.gameId >>> 32)));
		hash = hash * prime + ((int) (this.drawId ^ (this.drawId >>> 32)));
		
		return hash;
	}
}