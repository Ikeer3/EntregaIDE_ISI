package Usuarios;

import java.util.ArrayList;
import Pedidos.Pedido;

public class Cliente extends Usuario {

	private ArrayList<Pedido> pedidos;
	 
	public Cliente(String nombre, String email, String telefono) {
		super(nombre, email, telefono);
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
 
	public Pedido crearPedido() {
		Pedido nuevoPedido = new Pedido(this);
		pedidos.add(nuevoPedido);
		System.out.println("Pedido creado correctamente.");
		return nuevoPedido;
	}
 
	public void mostrarPedidos() {
		if (pedidos.isEmpty()) {
			System.out.println("El cliente " + getNombre() + " no tiene pedidos.");
		} else {
			System.out.println("Pedidos de " + getNombre() + ":");
			for (Pedido p : pedidos) {
				p.mostrarInfo();
			}
		}
	}
}