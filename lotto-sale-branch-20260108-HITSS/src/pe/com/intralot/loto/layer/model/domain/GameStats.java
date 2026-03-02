package pe.com.intralot.loto.layer.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the GAME_STATS database table.
 * 
 */
@Entity
@Table(name="LOTOCARD.GAME_STATS")
public class GameStats implements Serializable{
	
//	@EmbeddedId
//	private DrawPK id;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GS_GAME_ID")
	private Integer gameId;
	
	@Id
	@Column(name="GS_POSITION")
	private Integer position;

	@Id
	@Column(name="GS_NUMBER")
	private Integer number;

	@Column(name="GS_COUNT")
	private Integer count;

	@Id
	@Column(name="GS_YEAR")
	private Integer year;

	@Transient
	private Integer ancho;

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getAncho() {
		return ancho;
	}

	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}
	
	
}