package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DRAW_ITEM database table.
 * 
 */
@Embeddable
public class DrawItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="GAME_ID")
	private long gameId;

	@Column(name="DRAW_ID")
	private long drawId;

	private long item;

	public long getGameId() {
		return this.gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public long getDrawId() {
		return this.drawId;
	}
	public void setDrawId(long drawId) {
		this.drawId = drawId;
	}
	public long getItem() {
		return this.item;
	}
	public void setItem(long item) {
		this.item = item;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DrawItemPK)) {
			return false;
		}
		DrawItemPK castOther = (DrawItemPK)other;
		return 
			(this.gameId == castOther.gameId)
			&& (this.drawId == castOther.drawId)
			&& (this.item == castOther.item);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.gameId ^ (this.gameId >>> 32)));
		hash = hash * prime + ((int) (this.drawId ^ (this.drawId >>> 32)));
		hash = hash * prime + ((int) (this.item ^ (this.item >>> 32)));
		
		return hash;
	}
}