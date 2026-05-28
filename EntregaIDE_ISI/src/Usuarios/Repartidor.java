package Usuarios;

public class Repartidor extends Usuario {
	
	private String zonaReparto;
	private boolean estado;
 
	public Repartidor(String nombre, String email, String telefono, String zonaReparto) {
		super(nombre, email, telefono);
		this.zonaReparto = zonaReparto;
		this.estado = false;
	}
 
	public String getZonaReparto() {
		return zonaReparto;
	}
 
	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean disponible) {
		this.estado = disponible;
	}
 
	public boolean estaDisponible() {
		return estado;
	}
}