package Pedidos;

import java.util.ArrayList;
import Usuarios.Cliente;
import Usuarios.Repartidor;

public class Pedido {
	
	private static int contadorId = 1;
	 
	private int id;
	private String fechaPedido;
	private EstadoPedido estado;
	private Cliente cliente;
	private Repartidor repartidor;
	private ArrayList<Producto> productos;
 
	public Pedido(Cliente cliente) {
		this.id = contadorId;
		contadorId++;
		this.cliente = cliente;
		this.estado = EstadoPedido.PENDIENTE;
		this.repartidor = null;
		this.productos = new ArrayList<Producto>();
		this.fechaPedido = java.time.LocalDate.now().toString();
	}
	
	public int getId() {
		return id;
	}
 
	public String getFechaPedido() {
		return fechaPedido;
	}
 
	public EstadoPedido getEstado() {
		return estado;
	}
 
	public Cliente getCliente() {
		return cliente;
	}
 
	public Repartidor getRepartidor() {
		return repartidor;
	}
 
	public ArrayList<Producto> getProductos() {
		return productos;
	}
 
	public boolean añadirProducto(Producto p) {
		for (Producto prod : productos) {
			if (prod.getNombre().equals(p.getNombre())) {
				System.out.println("Error: el producto '" + p.getNombre() + "' ya está en el pedido.");
				return false;
			}
		}
		productos.add(p);
		System.out.println("Producto '" + p.getNombre() + "' añadido al pedido.");
		return true;
	}
 
	public boolean asignarRepartidor(Repartidor r) {
		if (productos.isEmpty()) {
			System.out.println("Error: no se puede asignar un repartidor sin productos en el pedido.");
			return false;
		} else if (!r.estaDisponible()) {
			System.out.println("Error: el repartidor " + r.getNombre() + " está ocupado.");
			return false;
		} else {
			repartidor = r;
			estado = EstadoPedido.EN_REPARTO;
			r.setEstado(false);
			System.out.println("Repartidor " + r.getNombre() + " asignado. El pedido está en reparto.");
			return true;
		}
	}
 
	public boolean marcarEntregado() {
		if (estado != EstadoPedido.EN_REPARTO) {
			System.out.println("Error: el pedido no está en reparto, no se puede entregar.");
			return false;
		} else {
			estado = EstadoPedido.ENTREGADO;
			repartidor.setEstado(true);
			System.out.println("Pedido entregado. El repartidor " + repartidor.getNombre() + " vuelve a estar disponible.");
			return true;
		}
	}
 
	public double calcularTotal() {
		double total = 0;
		for (Producto p : productos) {
			total += p.getPrecio();
		}
		return total;
	}
 
	public void mostrarInfo() {
		System.out.println("--- Pedido #" + id + " ---");
		System.out.println("Fecha: " + fechaPedido);
		System.out.println("Estado: " + estado);
		System.out.println("Cliente: " + cliente.getNombre());
 
		if (repartidor != null) {
			System.out.println("Repartidor: " + repartidor.getNombre());
		} else {
			System.out.println("Repartidor: sin asignar");
		}
 
		System.out.println("Productos:");
		if (productos.isEmpty()) {
			System.out.println("  (sin productos)");
		} else {
			for (Producto p : productos) {
				p.mostrarInfo();
			}
			System.out.println("Total: " + calcularTotal() + " €");
		}
	}
}