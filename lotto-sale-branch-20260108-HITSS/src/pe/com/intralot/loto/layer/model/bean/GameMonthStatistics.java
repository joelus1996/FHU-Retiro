package pe.com.intralot.loto.layer.model.bean;


public class GameMonthStatistics{

	private int mes;
	private int cantidad;
	private int ancho;
	private static String meses[]={"Null","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getMesAsString() {
		return 0 < mes && mes <= 12 ? meses[mes] : meses[0];
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	
	
}
