# Sistema Integral de Pedidos (SIP) - OrderSync

El **Sistema Integral de Pedidos (SIP)** es una solución completa para gestionar clientes, productos, pedidos y facturación en un negocio. Está diseñado utilizando Java y Spring Boot, siguiendo buenas prácticas de desarrollo y una arquitectura escalable.

## Características principales

### Gestión de Clientes
- Crear, leer, actualizar y eliminar clientes (CRUD).
- Búsqueda de clientes por nombre o identificación. 

### Gestión de Productos
- CRUD para productos.
- Listar productos con stock bajo (menos de 5 unidades).
- Búsqueda de productos por categoría o nombre. 

### Gestión de Pedidos
- CRUD para pedidos.
- Asociación de pedidos a clientes.
- Cálculo automático del total del pedido.


## Modelos y Relaciones

### Cliente
- **Atributos**: id, nombre, email, teléfono, dirección.
- **Relaciones**: Uno a muchos con Pedido.

### Producto
- **Atributos**: id, nombre, descripción, precio, stock, categoría.
- **Relaciones**: Muchos a muchos con Pedido.

### Pedido
- **Atributos**: id, fecha, total.
- **Relaciones**: Muchos a uno con Cliente; muchos a muchos con Producto (tabla intermedia con cantidad).



## Estructura del Proyecto

1. **Capa de Controladores**
   - Gestiona las peticiones HTTP.
   - Endpoints para CRUD y reportes:
     - `/clients`: Gestión de clientes.
     - `/products`: Gestión de productos.
     - `/Order`: Gestión de pedidos y facturación.

2. **Capa de Servicios**
   - Contiene la lógica de negocio.
   - Clases: `ClientService`, `ProductService`, `OrderService`.

3. **Capa de Repositorios**
   - Interactúa con la base de datos mediante Spring Data JPA.
   - Interfaces: `ClientRepository`, `ProductRepository`, etc.

4. **Capa de Modelos**
   - Representa las entidades del sistema.

5. **Capa de DTOs**
   - Clases para estructurar la información transferida entre las capas.
   - ClientDTO

## Tecnologías utilizadas

- **Backend**: Java 17, Spring Boot.
- **Persistencia**: Spring Data JPA, Hibernate.
- **Base de Datos**: PostgreSQL.
- **Contenedores**: Docker.

## Instalación y configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/usuario/sistema-integral-pedidos.git
   cd sistema-integral-pedidos
   ```

2. Configura las variables de entorno en el archivo `.env`:
   ```env
   DB_URL=jdbc:postgresql://localhost:5432/sip
   DB_USERNAME=root
   DB_PASSWORD=admin
   ```
