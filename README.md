# EntregaIDE_ISI

Proyecto de la asignatura Entornos de Desarrollo. Consiste en un sistema de gestión de pedidos de comida a domicilio, desarrollado en Java con Eclipse.

## ¿De qué va el proyecto?

Una empresa de reparto necesita gestionar sus pedidos. En el sistema hay clientes, repartidores y pedidos con productos. La idea es que un cliente crea un pedido, le añade productos, se le asigna un repartidor disponible y cuando se entrega el repartidor vuelve a estar libre.

## Estructura del proyecto

El proyecto está organizado en tres paquetes:

- **Usuarios** — las clases Usuario, Cliente y Repartidor
- **Pedidos** — las clases Pedido y Producto
- **Principal** — la clase Main donde se prueba todo

## Clases principales

- `Usuario` — clase abstracta con los atributos comunes (nombre, email y teléfono)
- `Cliente` — hereda de Usuario, puede crear pedidos
- `Repartidor` — hereda de Usuario, tiene zona de reparto y un boolean para saber si está disponible
- `Pedido` — gestiona los productos, el repartidor asignado y el estado del pedido
- `Producto` — tiene nombre, precio y categoría

## Reglas del sistema

- No se pueden añadir productos duplicados a un pedido
- No se puede asignar un repartidor si el pedido no tiene productos
- No se puede asignar un repartidor que esté ocupado
- Al asignar un repartidor, el pedido pasa a "en reparto" y el repartidor a ocupado
- Al entregar, el pedido pasa a "entregado" y el repartidor vuelve a estar disponible
- No se puede marcar un pedido como entregado si no está en reparto

## Contenido del repositorio

- `EntregaIDE_ISI.drawio` — diagrama de clases UML hecho con diagrams.net
- Carpeta con el proyecto Java para importar en Eclipse
