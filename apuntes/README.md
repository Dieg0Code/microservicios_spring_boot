# Microservicios

Los microservicios son un enfoque de arquitectura en el cual separamos una aplicación en servicios, en ves de tener una gran aplicación, comúnmente llamada **monolito**, la dividimos en servicios más pequeños independientes, que se comunican entre sí mediante protocolos HTTP o mensajes. Este enfoque nos da la ventaja de poder escalar mucho  más rápido las aplicaciones, ademas de que es mucho mas fácil desarrollar y mantener una aplicación de este tipo.

Características de los microservicios:

- **Autónomos**: Cada servicio es independiente y puede tener su propio equipo de desarrollo, ademas se pueden desplegar de manera independiente sin efector al resto de microservicios.

- **Especializados**: Cada servicio tiene una tarea única.
- **Registro automático**: Se conoce como auto descubrimiento, cuando se despliega un microservicio, automáticamente se registra en un **servidor de nombre** y almacena en ese servidor su dirección IP, puerto y nombre de dominio, estos datos son importante para que se pueda comunicar con otros microservicios.
- **Escalado flexible**: Los servicios se pueden escalar dependiendo de la demanda, cuando hay mucha demanda en un microservicio determinado, automáticamente se tiene que aumentar su disponibilidad en el cloud, esto se puede hacer desplegando más instancias del microservicio.
- **Balanceo de cargas**: Se puede distribuir la carga entre las instancias de un microservicio, para que no se saturen y se pueda mantener la disponibilidad del servicio.
- **Tolerancia a fallos**: Si un microservicio falla, no afecta al resto de microservicios, ya que son independientes, esto es una de las principales ventajas de los microservicios frente a los monolitos, en donde si un modulo falla, afecta a toda la aplicación.
- **Configuración centralizada**: Podemos tener muchos microservicios desplegados, pero la configuración de todos estos servicios se puede centralizar en un solo servidor de configuración usando **Spring Cloud Config**.
- **Libertad de tecnología**: Cada microservicio puede ser desarrollado con la tecnología que mejor se adapte a la necesidad del servicio, no es necesario que todos los microservicios sean desarrollados con la misma tecnología.
- **Agilidad y equipos de desarrollo mas pequeños**: Cada microservicio puede ser desarrollado por un equipo de desarrollo pequeño, lo que permite que los equipos sean mas ágiles y se puedan desplegar nuevas funcionalidades de manera mas rápida.
- **Ciclos de desarrollos mas cortos**: Al tener equipos de desarrollo mas pequeños, los ciclos de desarrollo son mas cortos, lo que permite que se puedan desplegar nuevas funcionalidades de manera mas rápida.
- **Código reutilizable**: Los microservicios se pueden reutilizar en diferentes aplicaciones, ya que son independientes y no tienen dependencias con otros microservicios. 

Conceptos relevantes:

- **Spring Boot**: Framework de Java para el desarrollo de aplicaciones web.
- **Spring IoC**: Inversión de control, es un patrón de diseño que permite desacoplar los objetos de una aplicación.
- **Spring Data JPA e Hibernate**: Frameworks de Java para el mapeo objeto-relacional o ORM.
- **API REST**: Arquitectura de desarrollo web basada en el protocolo HTTP.
- **Spring Cloud**: Framework de Java para el desarrollo de aplicaciones en la nube.
- **Servidor Eureka**: Servidor de nombres para el auto descubrimiento de microservicios.
- **Eureka Client**: Cliente de Eureka, se encarga de registrar los microservicios en el servidor Eureka.
- **RestTemplate**: Cliente HTTP de Spring para consumir servicios REST.
- **Feign**: Cliente HTTP de Spring Cloud para consumir servicios REST.
- **Ribbon**: Balanceador de cargas de Spring Cloud.
- **Hystrix**: Librería de Spring Cloud para tolerancia a fallos.
- **Gateway Zuul**: Servidor de puertas de enlace para los microservicios.
- **Sepring Cloud Server Config**: Servidor de configuración centralizada para los microservicios.
- **Spring Security OAuth2**: Framework de Java para la autenticación y autorización de los microservicios.
- **JWT**: JSON Web Token, es un estándar abierto basado en JSON propuesto por IETF para la creación de tokens de acceso que permiten la propagación de identidad y privilegios.

## ¿Que son los microservicios?

Los microservicios son un conjunto de componentes pequeños y autónomos que colaboran entre si para cumplir con una funcionalidad de negocio. Cada microservicio es un proceso independiente que se comunica con otros microservicios mediante protocolos HTTP o mensajes.

### Características de los microservicios

- **Función única**: Cada microservicio tiene una función única y bien definida, se pueden realizar multiples procesos dentro del microservicio, pero siempre se debe cumplir con una función única.
- **Independientes**: Cada microservicio está desplegado en un servidor HTTP distinto, en puertos diferentes, cada uno se ejecuta en su propio proceso y se comunican con otros mediante protocolos HTTP o mensajes. Cada uno puede tener diferentes tipos de bases de datos, SQL, NoSQL, etc.
- **Registro y auto-descubrimiento de servicios**: Cada microservicio tiene desacoplado del código la IP y el puerto del servicio, en ves de usar estos datos en el código, se manejan de forma automática a través de un servidor de nombres, como **Eureka**.
- **Auto escalado y agilidad**: Podemos escalar los servicios con mas trafico desplegando mas instancias de estos en especifico de forma automática, esto es manejado por el servidor de nombres.
- **Confiabilidad y tolerancia a fallos**: En esta arquitectura podemos manejar los fallos de una forma mas eficiente, por ejemplo si algún servicio falla, podemos redirigir el trafico a otro servicio que cumpla con la misma función, la gracia es que no hay un punto único de fallo, al ser un conjunto de servicios no existe el problema de que algo falla todo el sistema se cae. En Spring Cloud se puede manejar esto con **Hystrix**, con esto podemos manejar los fallos en cascada que se pudiesen producir debido a la dependencia de un servicio con otro.
- **Balanceo de cargas**: Cuando hay varias instancias del mismo microservicio, podemos distribuir la carga entre estas de forma equitativa. Usamos el nombre de este microservicio que queremos consumir y le preguntamos al servidor de nombre todas las infancias disponibles, este nos entrega el registro de las instancias con sus respectivas direcciones IP y puertos, luego se determina de forma automática a que instancia se le va a enviar la petición. La herramienta que se encarga de esto en Spring Cloud es **Ribbon**.
- **Configuración centralizada**: Una aplicación que tenga muchos microservicios desplegados en donde cada uno se está ejecutando en diferentes instancias y diferentes entornos puede ser difícil de manejar, por eso se puede centralizar la configuración de todos los microservicios en un solo servidor de configuración, esto se puede hacer con **Spring Cloud Config**.

### Ventajas de los microservicios

- **Nueva tecnología**: Podemos desarrollar cada microservicio con la tecnología que mejor se adapte a la necesidad del servicio.
- **Reducción de costos**: Podemos escalar los servicios que mas trafico tienen y no tener que escalar toda la aplicación. Solo se usa lo que se necesita.
- **Ciclos de desarrollo mas cortos**: Al ser servicios mas pequeños y especializados, es mas fácil desarrollar y desplegar nuevas funcionalidades.
- **Equipos de desarrollo mas pequeños**: Cada microservicio puede ser desarrollado por un equipo de desarrollo pequeño, esto los vuelve mas especializados y ágiles.

## Crear y configurar un microservicio

Para crear un microservicio en Spring Boot, lo primero que debemos hacer es crear un nuevo proyecto en Spring Boot, para esto podemos usar [Spring Initializr](https://start.spring.io/). En este caso vamos a crear un microservicio que se va a encargar de gestionar productos, para esto vamos a crear un proyecto con las siguientes dependencias:

- **Spring Web**: Para crear servicios REST.
- **Spring Data JPA**: Para el mapeo objeto-relacional.
- **H2 Database**: Base de datos en memoria.
- **Spring Boot DevTools**: Herramientas de desarrollo.


Para comenzar, en el archivo `aplication.properties` debemos configurar un nombre para la aplicación, esto es necesario para que el servidor de nombres pueda identificar la aplicación y podamos acceder a esta mediante el nombre y no por la dirección IP y puerto.

```properties
spring.application.name=microservice-products
```

Ademas cada servicio debe tener un puerto diferente para que no haya conflicto entre ellos, por eso también debemos configurar el puerto en el archivo `application.properties`.

```properties
server.port=8081
```

### Modelo de datos

Para este microservicio vamos a crear una entidad `Producto` con las siguientes características:

```java
package com.dieg0code.microserviceproducts.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
```

Usamos las anotaciones **@Entity** y **@Table** para indicar que esta clase es una entidad y que se va a mapear a una tabla en la base de datos. Usamos la anotación **@Id** para indicar que el atributo `id` es la llave primaria de la tabla, ademas usamos la anotación **@GeneratedValue** para indicar que el valor de este atributo se va a generar automáticamente. Usamos la anotación **@Column** para indicar que este atributo se va a mapear a una columna en la tabla, ademas usamos la anotación **@Temporal** para indicar que este atributo es de tipo fecha.

### DAO

Un `DAO` (data access object) es un objeto que proporciona una interfaz abstracta para algún tipo de base de datos o algún otro mecanismo de persistencia. En este caso vamos a crear un `DAO` para la entidad `Producto`.

```java
package com.dieg0code.microserviceproducts.models.dao;

import com.dieg0code.microserviceproducts.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDAO extends CrudRepository<Producto, Long> {
}
```

Usamos la interfaz **CrudRepository** de Spring Data JPA para tener acceso a los métodos CRUD de la entidad `Producto`, esta interfaz requiere que le pasemos el tipo de la entidad y el tipo de la llave primaria, en este caso, la entidad es `Producto` y la llave primaria es de tipo `Long`.

### Service

Debemos crea un servicio para gestionar los productos, en este caso vamos a crear primero una interfaz `IProductoService` con los métodos que vamos a implementar.

```java
package com.dieg0code.microserviceproducts.models.service;

import com.dieg0code.microserviceproducts.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

}
```

Y luego vamos a crear la implementación de esta interfaz en la clase `ProductoServiceImpl`.

```java
package com.dieg0code.microserviceproducts.models.service;

import com.dieg0code.microserviceproducts.models.dao.ProductoDAO;
import com.dieg0code.microserviceproducts.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoDAO.findById(id).orElseThrow();
    }
}
```

### Controlador

El controlador es el encargado de gestionar las peticiones HTTP, recibe las peticiones y se comunica con el servicio para obtener los datos necesarios.

Usamos la notación **@RestController** para indicar que esta clase es un controlador y que va a recibir peticiones HTTP, esta anotación ademas se encarga de convertir a JSON lo que retornan los métodos handler de la clase.

```java
package com.dieg0code.microserviceproducts.controllers;

import com.dieg0code.microserviceproducts.models.entity.Producto;
import com.dieg0code.microserviceproducts.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @GetMapping("/listar")
    public List<Producto> getAllProducts() {
        return productoService.findAll();
    }

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @GetMapping("/ver/{id}")
    public Producto getProductById(@PathVariable("id") Long id) {
        return productoService.findById(id);
    }
}
```

En este controlador vamos a crear dos métodos handler, uno para obtener todos los productos y otro para obtener un producto por su id. Usamos la anotación **@GetMapping** para indicar que estos métodos van a manejar peticiones HTTP de tipo GET, ademas usamos la anotación **@PathVariable** para indicar que el parámetro que recibe el método viene en la URL.

Para agregar datos de prueba a la BD H2, agregamos el archivo `import.sql` en la carpeta `resources` (debe llamarse así) con el siguiente contenido:

```sql
INSERT INTO productos (nombre, precio, created_at) VALUES ('Panasonic', 800, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Sony', 700, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('LG', 600, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Samsung', 500, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Apple', 400, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Huawei', 300, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Xiaomi', 200, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES ('Oppo', 100, NOW());
```

Entonces ahora podemos ejecutar la aplicación y podemos obtener los productos mediante las siguientes URL:

```http
GET http://localhost:8001/listar
GET http://localhost:8081/ver/1
```
## Crear un segundo microservicio

Como estamos trabajando bajo la arquitectura de microservicios, debemos crear un segundo microservicio que el cual va a consumir el de los productos.

Para esto, en nuestro nuevo proyecto, en **models** creamos una clase `Producto` con los mismos atributos que la clase `Producto` del microservicio de productos.

```java
public class Producto {

    private Long id;
    private String nombre;
    private Double precio;
    private Date createdAt;
    
}
```

A diferencia del microservicio de productos esta clase no es una **@Entity** ya que no se va a mapear a una tabla en la base de datos, esta clase es un **DTO** (Data Transfer Object) que se va a usar para transferir los datos entre los microservicios.

Adicional a esto, creamos en los modelos la clase `Item` la cual va a usar la clase `Producto` para crear un item.

```java
package com.dieg0code.microserviceitem.models;

public class Item {

    private Producto producto;
    private Integer cantidad;

    public Item() {
    }

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return producto.getPrecio() * cantidad.doubleValue();
    }
}
```

En donde tenemos el Producto y la cantidad de este producto que se va a comprar, ademas de un método para calcular el total de la compra.

```java
public double getTotal() {
    return producto.getPrecio() * cantidad.doubleValue();
}
```

Tambien hay que configurar el puerto y el nombre de la aplicación en el archivo `application.properties`.

```properties
spring.application.name=microservice-item
server.port=8082
```

### Service

Creamos una interfaz `ItemService` con los métodos que vamos a implementar.

```java
package com.dieg0code.microserviceitem.models.service;

import com.dieg0code.microserviceitem.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);

}
```

Y luego creamos la implementación de esta interfaz en la clase `ItemServiceImpl`.

```java
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        return List.of();
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return null;
    }
}
```

Debemos crear la clase de configuración para el **RestTemplate**, en esta clase vamos a configurar el **RestTemplate** para que se pueda comunicar con el microservicio de productos.

```java
//AppConfig.java
@Configuration
public class AppConfig {

    @Bean("clienteRest")
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }
}
```

### RestTemplate

El **RestTemplate** es un cliente HTTP de Spring que nos permite hacer peticiones HTTP a otros servicios REST, como lo inyectamos al servicio podemos usarlo para obtener datos desde el microservicio de productos.

```java
 @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8081/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }
```

**.getForObject()** es un método de **RestTemplate** que nos permite hacer una petición HTTP de tipo GET, recibe dos argumentos, una URL, en este caso la URL del microservicio de productos, y un responseType, en este caso una lista de productos.

Para obtener un producto por su id, podemos hacer lo siguiente:

```java
@Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8081/ver/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }
```

En este caso usamos el método **.getForObject()** de **RestTemplate** para obtener un producto por su id, este método recibe tres argumentos, una URL, en este caso la URL del microservicio de productos con el id del producto, un responseType, en este caso un producto, y un mapa con las variables de la URL, en este caso el id del producto.

De momento todo funciona, pero tenemos el problema, que el código está demasiado acoplado a la URL del servicio que consume, en un caso real podemos tener desplegadas varias instancias de este servicio y mediante un balanceador de carga podemos elegir a cual hacer la consulta. Todos estos problemas los podemos solucionar con **Ribbon**.

### Feign

**Feign** es una alternativa a **RestTemplate**, al igual que este nos permite hacer peticiones HTTP a otros servicios REST, pero de una forma mas fácil, ya que usa interfaces y anotaciones para definir las peticiones. **Feign** es parte de **Spring Cloud** y se integra con **Ribbon**, ademas de que viene configurado por defecto con **Eureka**.

Para usarlo debemos comenzar agregando la dependencia de **Feign** en el archivo `pom.xml`.

El pom.xml del microservicio de items debe quedar mas o menos así:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.2.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.dieg0code</groupId>
	<artifactId>microservice-item</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>microservice-item</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
		<spring-cloud.version>2023.0.1</spring-cloud.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

Luego debemos agregar la anotación **@EnableFeignClients** en la clase principal de la aplicación.

```java
@EnableFeignClients
@SpringBootApplication
public class MicroserviceItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceItemApplication.class, args);
	}

}
```

Para usar **Feign** debemos crear una interfaz que va a definir el cliente que va a hacer las peticiones al servicio de productos.

```java
@FeignClient(name = "microservice-products", url = "localhost:8081")
public interface ProductoClientRest {

    @GetMapping("/listar")
    public List<Producto> getAllProducts();

    @GetMapping("/ver/{id}")
    public Producto getProductById(Long id);

}
```

La anotación **@FeignClient** define el nombre del servicio con el que se va a comunicar, definido en el **application.properties** del microservicio de productos, y la URL del servicio.

En cada método mediante anotaciones, en este caso **@GetMapping**, definimos las rutas a las que se van a hacer las peticiones y los parámetros que se van a enviar.

Luego debemos crear una clase que implemente la interfaz que acabamos de crear.

```java
@Service
@Primary
public class ItemServiceFeignImpl implements  ItemService{

    @Autowired
    private ProductoClientRest feignClient;

    @Override
    public List<Item> findAll() {
        return feignClient.getAllProducts().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(feignClient.getProductById(id), cantidad);
    }
}
```

La anotación **@Primary** es para indicar que esta implementación que se va a inyectar en el controlador, como tenemos dos implementaciones de la interfaz **ItemService**, debemos indicarle a Spring cual de estas implementaciones debe inyectar.

Otra opción es usar la anotación **@Qualifier** en el controlador para indicarle a Spring cual implementación debe inyectar.

Agregamos un nombre especifico al servicio:

```java
@Service("serviceFeign")
@Primary
public class ItemServiceFeignImpl implements  ItemService{

    @Autowired
    private ProductoClientRest feignClient;

    @Override
    public List<Item> findAll() {
        return feignClient.getAllProducts().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(feignClient.getProductById(id), cantidad);
    }
}
```

Y con **@Qualifier** indicamos cual implementación inyectar en el controlador.

```java
@RestController
public class ItemController {

    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @GetMapping("/listar")
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item getItemById(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

}
```