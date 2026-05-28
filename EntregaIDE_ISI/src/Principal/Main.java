package Principal;

import Usuarios.Cliente;
import Usuarios.Repartidor;
import Pedidos.Pedido;
import Pedidos.Producto;

public class Main {

	public static void main(String[] args) {

		System.out.println("========================================");
		System.out.println("  SISTEMA DE GESTIÓN DE PEDIDOS        ");
		System.out.println("========================================\n");

		Cliente cliente1 = new Cliente("Ana García", "ana@email.com", "600111222");
		Cliente cliente2 = new Cliente("Luis Martínez", "luis@email.com", "600333444");

		Repartidor repartidor1 = new Repartidor("Carlos López", "carlos@email.com", "600555666", "Centro");
		Repartidor repartidor2 = new Repartidor("María Ruiz", "maria@email.com", "600777888", "Norte");

		Producto pizza = new Producto("Pizza Margarita", 9.50, "comida");
		Producto refresco = new Producto("Coca-Cola", 2.00, "bebida");
		Producto tiramisu = new Producto("Tiramisu", 4.50, "postre");
		Producto hamburguesa = new Producto("Hamburguesa", 8.00, "comida");

		System.out.println("--- PRUEBA 1: Pedido normal completo ---\n");

		Pedido pedido1 = cliente1.crearPedido();
		pedido1.añadirProducto(pizza);
		pedido1.añadirProducto(refresco);
		pedido1.añadirProducto(tiramisu);
		pedido1.mostrarInfo();

		System.out.println();

		pedido1.asignarRepartidor(repartidor1);
		System.out.println("Repartidor disponible: " + repartidor1.getEstado());
		pedido1.marcarEntregado();
		System.out.println("Repartidor disponible tras entrega: " + repartidor1.getEstado());

		System.out.println();
		pedido1.mostrarInfo();

		System.out.println("\n--- PRUEBA 2: No se pueden añadir productos duplicados ---\n");

		Pedido pedido2 = cliente2.crearPedido();
		pedido2.añadirProducto(hamburguesa);
		pedido2.añadirProducto(hamburguesa);

		System.out.println("\n--- PRUEBA 3: No asignar repartidor sin productos ---\n");

		Pedido pedido3 = cliente1.crearPedido();
		pedido3.asignarRepartidor(repartidor1);

		System.out.println("\n--- PRUEBA 4: No asignar repartidor ocupado ---\n");

		Pedido pedido4 = cliente2.crearPedido();
		pedido4.añadirProducto(refresco);
		pedido4.asignarRepartidor(repartidor2);
		System.out.println("Repartidor disponible: " + repartidor2.getEstado());

		Pedido pedido5 = cliente1.crearPedido();
		pedido5.añadirProducto(pizza);
		pedido5.asignarRepartidor(repartidor2);

		System.out.println("\n--- PRUEBA 5: No entregar pedido que no está en reparto ---\n");

		Pedido pedido6 = cliente1.crearPedido();
		pedido6.añadirProducto(tiramisu);
		pedido6.marcarEntregado();

		System.out.println("\n--- PEDIDOS FINALES DE CADA CLIENTE ---\n");
		cliente1.mostrarPedidos();
		System.out.println();
		cliente2.mostrarPedidos();
	}
}