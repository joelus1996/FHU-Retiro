package pe.com.intralot.loto.layer.dto.reniec;

public class DataReniecResponse {
	private boolean apellidos;
	private boolean fechaNacimiento;
	private boolean nombre;
	
	
	public boolean isApellidos() {
		return apellidos;
	}
	public void setApellidos(boolean apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(boolean fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public boolean isNombre() {
		return nombre;
	}
	public void setNombre(boolean nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "DataReniecResponse [apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", nombre="
				+ nombre + "]";
	}
	
	
}
