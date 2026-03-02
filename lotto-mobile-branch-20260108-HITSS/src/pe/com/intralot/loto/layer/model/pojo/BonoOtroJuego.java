package pe.com.intralot.loto.layer.model.pojo;

public class BonoOtroJuego {
	
	private Integer idGame;
	private String  nameGame;
	private Integer  games;
	//ruth
	private String visible;
	private int cantidadDetalle;
	
	private String visibleCuadro;
	private String expireDate;
	private String unitPriceBonus;
	
	public String getUnitPriceBonus() {
		return unitPriceBonus;
	}
	public void setUnitPriceBonus(String unitPriceBonus) {
		this.unitPriceBonus = unitPriceBonus;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public int getCantidadDetalle() {
		return cantidadDetalle;
	}
	public void setCantidadDetalle(int cantidadDetalle) {
		this.cantidadDetalle = cantidadDetalle;
	}
	
	public String getVisibleCuadro() {
		return visibleCuadro;
	}
	public void setVisibleCuadro(String visibleCuadro) {
		this.visibleCuadro = visibleCuadro;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public Integer getIdGame() {
		return idGame;
	}
	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}
	public String getNameGame() {
		return nameGame;
	}
	public void setNameGame(String nameGame) {
		this.nameGame = nameGame;
	}
	public Integer getGames() {
		return games;
	}
	public void setGames(Integer games) {
		this.games = games;
	}
	
	

}
