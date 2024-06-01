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

## Eureka Server

Eureka funciona como un servidor de nombres, en donde los microservicios se registran y se almacenan, de esta forma los microservicios pueden comunicarse entre si conociendo solo el nombre del servicio.

Para este ejemplo necesitamos las dependencias de **devtools** y **Eureka Server**.

Ademas, por defecto Eureka se registra a si mismo como servidor y como cliente, en este caso solo necesitamos que sea servidor, por lo que debemos xonfigurar esto en el archivo `application.properties`.

```properties
spring.application.name=eureka
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

También debemos agregar la dependencia de `jaxb` en el `pom.xml`.

```xml
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
</dependency>
```

Esta dependencia es necesaria para que Eureka pueda leer los archivos XML.

Para habilitar Eureka debemos agregar la anotación **@EnableEurekaServer** en la clase principal de la aplicación.

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
```

Con estas configuraciones ya podemos levantar el servidor y ver la pagina de Eureka en la URL `http://localhost:8761`. En esta página se nos muestra el estado del sistema y los microservicios que están registrados.

### Configurando los microservicios como Eureka Client

Para que los microservicios se registren en Eureka, debemos agregar la dependencia de **Eureka Client** en el `pom.xml`.

```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
```

También debemos indicar en el archivo `application.properties` la URL del servidor de Eureka.

```properties
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

Cuando el servidor Eureka y los clientes están en maquinas distintas, es obligatorio indicar la dirección del servidor. Ya que cada cliente se tiene que registrar enviando una señal al servidor, esta señal se conoce como **heartbeat**, con esto indica que está habilitado y provee al servidor sus datos, una vez registrado, el servidor le pasa el registro de los demás servicios registrados. Cada 30 seg cada cliente debe estar enviando esta señal, si no lo hace durante 3 periodos, 90 seg, el servidor lo elimina del registro, si luego otra vez después de 90 seg envía la señal, el servidor lo vuelve a registrar.

### Escalar microservicios con puerto dinámico

Podemos configurar el microservicio de productos para que Spring elija de forma automática el puerto en el que se va a desplegar, para esto debemos configurar el puerto en el archivo `application.properties` de la siguiente forma.

```properties
server.port=${PORT:0}
eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}
```

Con esto configuramos el puerto de forma dinámica, Spring va a elegir un puerto disponible y lo va a asignar a la variable **${PORT}**, ademas configuramos el **instance-id** de forma dinámica, Spring va a asignar un id de instancia de forma automática.

## Tolerancia a fallos y latencia con Hystrix

**Hystrix** es una librería de **Spring Cloud** que nos permite manejar fallos en la comunicación entre microservicios, añade funcionalidades para manejar la latencia y tolerancia a fallos, por ejemplo en caso de alcanzar un cierto limite de fallos en una instancia en particular, **Hystrix** deja de realizar solicitudes a esa instancia y redirige el trafico a otra instancia.

Para usar **Hystrix** debemos agregar la dependencia en el `pom.xml`.

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

Es importante resaltar que **Hystrix** solo funciona en versiones anteriores a **Spring Boot 2.5**, en versiones posteriores se recomienda usar **Resilience4j**.

Una vez agregada la dependencia debemos habilitar **Hystrix** en la clase principal de la aplicación usando la anotación **@EnableCircuitBreaker**.

```java
@EnableCircuitBreaker
@SpringBootApplication
public class MicroserviceItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceItemApplication.class, args);
    }

}
```

Con esto podemos usar anotaciones como **@HystrixCommand** en los controladores para manejar los fallos.

```java
@HystricCommand(fallbackMethod = "metodoAlternativo")
@GetMapping("/ver/{id}/cantidad/{cantidad}")
public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
    return itemService.findById(id, cantidad);
}
```

Entonces con esto estamos indicando a **Hystrix** que si hay un fallo en el método **findById()** se ejecute el método **metodoAlternativo()**, el cual debe tener la misma firma que el método que se está manejando.

```java
public Item metodoAlternativo(Long id, Integer cantidad) {
    Item item = new Item();
    Producto producto = new Producto();

    item.setCantidad(cantidad);
    producto.setId(id);
    producto.setNombre("Producto por defecto");
    producto.setPrecio(0.0);
    item.setProducto(producto);

    return item;


}
```

Osea que debe retornar el mismo tipo de dato y recibir los mismos tipos de parámetros.

En este ejemplo estamos creando un nuevo objeto **Item** y retornándolo, pero en un caso real lo que se suele hacer es implementar un mecanismo que funcione como salvavidas, ya sea llamando a otra instancia o a otro servicio para de esta forma redireccionar el trafico y no afectar la disponibilidad del servicio.

### Timeout en Hystrix y Ribbon

**Hystrix** y **Ribbon** nos permiten configurar el tiempo de espera de una petición, esto es útil para manejar la latencia y tolerancia a fallos, por ejemplo si una instancia tarda mucho en responder, **Hystrix** puede redirigir el trafico a otra instancia.

Para configurar el tiempo de espera en **Hystrix** debemos agregar la siguiente configuración en el archivo `application.properties`.

```properties
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=6000
```

Con esto estamos configurando el tiempo de espera en 2 segundos, si una instancia tarda mas de 2 segundos en responder, **Hystrix** va a redirigir el trafico a otra instancia.

Para configurar el tiempo de espera en **Ribbon** debemos agregar la siguiente configuración en el archivo `application.properties`.

```properties
ribbon.ReadTimeout=3000
ribbon.ConnectTimeout=1000
```

Con esto estamos configurando el tiempo de espera en 3 segundos, si una instancia tarda mas de 3 segundos en responder, **Ribbon** va a redirigir el trafico a otra instancia.

**Hystrix** envuelve a **Ribbon** por esto el tiempo de espera de **Hytrix** es mayor al de **Ribbon**.

## API Gateway con Zuul

Una **API Gateway** es un servicio que funciona como puerta de entrada a los demás microservicios, se encarga de erutar las peticiones a los microservicios correspondientes, ademas de la autenticación y autorización de los usuarios.

Para este ejemplo usaremos **Zuul**, el cual es usado en versiones anteriores a **Spring Boot 2.4**, en versiones posteriores se recomienda usar **Spring Cloud Gateway**.

Las **API Gateway** tienen varias características, como:

- **Enrutamiento dinámico**: ya que enruta cada uno de los servicios registrados con Eureka y les puede otorgar una ruta base o prefijo a cada uno de ellos, esto nos permite centralizar el acceso a todo este ecosistema en un solo punto de entrada.
- **Balanceo de cargas**: ya que puede distribuir la carga entre las instancias de un microservicio, para que no se saturen y se pueda mantener la disponibilidad del servicio.
- **Compuesto por un conjunto de filtros**: que nos permiten interceptar las peticiones y las respuestas, para realizar tareas como la autenticación y autorización de los usuarios, la compresión de las respuestas, el encriptado de las peticiones, etc. En vez de implementar la autenticación en cada uno de los servicios, podemos implementarla una sola vez en la **API Gateway**.

Para crear nuestro servicio **Zuul** debemos agregar las dependencias de:

- Eureka Client: esta es importante ya que **Zuul** se va a registrar como cliente en el servidor de Eureka.
- Devtools
- Spring Web

Ademas debemos agregar la dependencia de **Zuul** en el `pom.xml`.

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```

Para habilitar **Zuul** debemos agregar la anotación **@EnableZuulProxy** en la clase principal de la aplicación.

```java
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
```

también debemos configurar el **application.properties** para que **Zuul** se registre en el servidor de Eureka.

```properties
spring.application.name=gateway
server.port=8090

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

zuul.routes.productos.serviceId=microservice-products
zuul.routes.productos.path=/api/productos/**

zuul.routes.items.serviceId=microservice-item
zuul.routes.items.path=/api/items/**
```

Con esto estamos configurando **Zuul** para que enrute las peticiones a los microservicios de productos e items, ademas estamos configurando las rutas de acceso a estos microservicios.

### Filtros en Zuul

**Zuul** está básicamente compuesto por filtros, estos filtros tienen 3 tipos de ejecución que manejan en ciclo de vida de una petición HTTP:

- **pre**: se ejecuta antes de que la petición sea enrutada. Se usa para asignar datos e información al request para que posteriormente estos puedan ser usados por los otros filtros.
- **route**: se ejecuta cuando la petición es enrutada. Aquí es en donde se resuelve la ruta hacia el microservicio y se envía la petición.
- **post**: se ejecuta después de que la petición es enrutada. Se usa para manipular el response, típicamente los headers.

En este ejemplo implementaremos un filtro que calculara el tiempo transcurrido en una comunicación con un microservicio. Para esto necesitamos 2 filtros un pre, que se encarga de calcular el tiempo inicial antes de realizar el Enrutamiento y la comunicación con el microservicio y un post que va a obtener el parámetro del tiempo inicial asignado por el filtro pre y se le restara el tiempo actual para obtener el tiempo transcurrido.

Creamos un nuevo package **filters** y una clase **PreTiempoTranscurridoFilter**.

```java
@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

        Long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

        return null;
    }
}
```

En este filtro estamos obteniendo el tiempo inicial en el método **run()** y lo estamos asignando al request, para que luego el filtro post pueda obtener este tiempo y calcular el tiempo transcurrido.

Luego creamos una clase **PostTiempoTranscurridoFilter**.

```java
@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

        log.info(String.format("Tiempo transcurrido en segundos %s seg.", tiempoTranscurrido.doubleValue()/1000.00));

        return null;
    }
}
```

En este filtro estamos obteniendo el tiempo inicial que asignamos en el filtro pre y estamos calculando el tiempo transcurrido, este tiempo lo estamos imprimiendo en la consola.

## Spring Cloud Gateway

Para efectos prácticos es un servidor de enrutamiento dinámico compuesto por filtros de autorización, monitoreo, métricas, etc. Al igual que con Zuul, podemos implementar nuestros propios filtros para por ejemplo trabajar con multiples lenguajes, para modificar respuestas, manejo de errores personalizado, modificar headers, etc.

#### Principales características:

- Dos implementaciones principales: **Zuul** y **Spring Cloud Gateway**.
- Puerta de enlace, acceso centralizado.
- Enrutamiento dinámico de los microservicios.
- Balanceo de carga.
- Maneja filtros propios.
- Permite extender funcionalidades.

### Configuración de Spring Cloud Gateway

Para crear el servidor gateway debemos agregar dos dependencias principales:

- **Spring Cloud Gateway**: para habilitar el servidor.
- **Spring Cloud Eureka Client**: para registrar el servidor en Eureka.

Luego en el archivo `application.properties` debemos configurar el puerto, el nombre de la aplicación y la dirección de Eureka.

```properties
spring.application.name=gateway-server
server.port=8090

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
```

Luego para configurar las direcciones de los microservicios debemos crear un archivo de configuración `application.yaml` en la carpeta `resources`.

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
```

Con esta configuración estamos indicando las rutas que manejará la gateway, los **id** deben ser el nombre del microservicio, la **uri** comienza con **lb** que quiere decir **load balancer** seguido de la dirección del servicio, luego los **predicates** o predicados que son los prefijos que se le ponen a la url por ejemplo **localhost:8090/api/item/listar** y por último los **filters**, en este caso **StripPrefix=2** para indicar que el prefijo que le ponemos al servicio tiene 2 segmentos **api** y **item/products** respectivamente.

### Filtros en Spring Cloud Gateway

Podemos implementar filtro globales en la gateway, cada request que pase por esta va a pasar por los filtros. Adicional podemos implementar filtros específicos por rutas

Para esto creamos un nuevo package llamado **filters** y una clase **EjGlobalFilter**.

```java
package com.dieg0code.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class EjGlobalFilter implements GlobalFilter {

    private final Logger log = LoggerFactory.getLogger(EjGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Ejecutando pre filtro");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("Ejecutando post filtro");
            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "rojo").build());
            exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        }));
    }
}
```

En este filtro estamos implementando la interfaz **GlobalFilter** y sobrescribiendo el método **filter()**, en este método estamos imprimiendo un mensaje en la consola, luego estamos llamando al método **chain.filter(exchange)** para que la petición siga su curso, y por último estamos imprimiendo otro mensaje en la consola y estamos agregando una cookie a la respuesta.

### Modificar la request en el filtro pre

Si queremos modificar la petición antes de que esta sea enviada al microservicio podemos hacerlo de la siguiente forma.

```java
@Component
public class EjGlobalFilter implements GlobalFilter {

    private final Logger log = LoggerFactory.getLogger(EjGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Ejecutando pre filtro");

        exchange.getRequest().mutate().headers(h -> h.add("token", "123456"));

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("Ejecutando post filtro");

            Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(value -> {
                exchange.getResponse().getHeaders().add("token", value);
            });

            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "rojo").build());
            exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        }));
    }
}
```

Por lo general si modificamos una request, solo modificamos los headers, ya que seria raro, aunque no imposible, modificar el cuerpo de la petición.

En este ejemplo estamos agregando un header a la petición. Obtenemos las request y mutamos el header, agregándole un "token" con el valor "123456". Luego dentro del método **then()** estamos obteniendo el valor del header "token" y lo estamos agregando a la respuesta.

### Order en los filtros

También podemos indicar el orden en el que se van a ejecutar los filtros, para esto debemos implementar la interfaz **Ordered** y sobrescribir el método **getOrder()**.

```java
  @Override
    public int getOrder() {
        return 1;
    }
```

Con esto estamos indicando que este filtro se va a ejecutar primero, si tenemos varios filtros y queremos que se ejecuten en un orden especifico, debemos indicar el orden en el que se van a ejecutar.

### Gateway filter factory

**Spring Cloud Gateway** nos permite crear nuestros propios filtros, para esto debemos crear un package llamado **filters** y una clase **EjemploGatewayFilterFactory**. Debe llamarse **nombre del filtro** + **GatewayFilterFactory** para que **Spring Cloud Gateway** lo reconozca.

```java
@Component
public class EjemploGatewayFilterFactory extends AbstractGatewayFilterFactory<EjemploGatewayFilterFactory.Config> {

    private final Logger log = LoggerFactory.getLogger(EjemploGatewayFilterFactory.class);

    public EjemploGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("Ejecutando pre gateway filter factory: " + config.mensaje);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {

                Optional.ofNullable(config.cookieValue).ifPresent(cookie -> {
                    exchange.getResponse().addCookie(ResponseCookie.from(config.cookieName, cookie).build());
                });

                log.info("Ejecutando post gateway filter factory");
            }));
        };
    }

    public class Config {
        private String mensaje;
        private String cookieValue;
        private String cookieName;

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getCookieValue() {
            return cookieValue;
        }

        public void setCookieValue(String cookieValue) {
            this.cookieValue = cookieValue;
        }

        public String getCookieName() {
            return cookieName;
        }

        public void setCookieName(String cookieName) {
            this.cookieName = cookieName;
        }
    }

}
```

La clase debe comenzar extendiendo de **AbstractGatewayFilterFactory** y debe tener una clase interna llamada **Config** que va a tener los atributos que se van a configurar en el archivo **application.yaml**. Luego debemos sobrescribir el método **apply()** y dentro de este método vamos a implementar la lógica del filtro. En este caso estamos obteniendo el mensaje y la cookie que se van a configurar en el archivo **application.yaml** y estamos agregando el mensaje a la consola y la cookie a la respuesta.

Luego en el archivo **application.yaml** debemos configurar el filtro.

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
            - name: Ejemplo
              args:
                mensaje: Hola Mundo
                cookieName: cookie
                cookieValue: cookieValue
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
```

En la sección de **filters** del microservicio "microservice-products" estamos configurando el filtro **Ejemplo** y estamos pasando los argumentos que se van a pasar a la clase **Config** que posteriormente se usan en **apply()**.

Otra forma de configurar esto en el yaml es:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
            - Ejemplo=Hola mundo, cookie, cookieValue
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
```

Ambas formas son validas, aunque la segunda es menos explicita.

Para que la segunda forma funcione debemos hacer una configuración extra en la clase **EjemploGatewayFilterFactory**.

```java
@Override
public List<String> shortcutFieldOrder() {
    return Arrays.asList("mensaje", "cookieName", "cookieValue");
}
```

Debemos agregar este método para indicar el orden de los argumentos que se van a pasar al filtro.

También podemos personalizar el nombre del filtro ya que por defecto toma el nombre de la clase. Para esto debemos agregar la siguiente configuración:

```java
@Override
public String name() {
    return "EjemploCookie";
}
```

Adicional a esto debemos cambiar el nombre que definimos para el filtro en el yaml:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
            - EjemploCookie=Hola mundo, cookie, cookieValue
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
```

### Filtros de fabrica en Spring Cloud Gateway

Spring Cloud Gateway también viene con una serie de filtros de fabrica que nos permiten modificar las peticiones y las respuestas, estos filtros son:

- **AddRequestHeader**: agrega un header a la petición.


```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
            - AddRequestHeader=X-Request-Foo, Bar
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
```

En donde **X-Request-Foo** es donde se va a agregar el header y **Bar** es el valor del header. Un ejemplo mas real seria:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
        - id: microservice-item
            uri: lb://microservice-item
            predicates:
                - Path=/api/items/**
            filters:
                - StripPrefix=2
                - AddRequestHeader=token-request, 123456
```

En este caso estamos agregando un header **token-request** con el valor **123456** a la petición.

Luego para capturar esto en el microservicio debemos hacer lo siguiente:

```java
@GetMapping("/listar")
public List<Producto> listar(@RequestHeader(name = "token-request", required = false) String token) {
    log.info("Token: " + token);
    return productoService.findAll();
}
```

Con esto estamos capturando el header **token-request** y lo estamos imprimiendo en la consola.

Otro filtro de fabrica es **AddRequestParameter** que agrega un parámetro a la petición.

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
            - AddRequestParameter=param, value
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
```

En este caso estamos agregando un parámetro **param** con el valor **value** a la petición.

Luego para capturar esto en el microservicio debemos hacer lo siguiente:

```java
@GetMapping("/listar")
public List<Producto> listar(@RequestParam(name = "param", required = false) String param) {
    log.info("Param: " + param);
    return productoService.findAll();
}
```

También podemos modificar la respuesta con el filtro **AddResponseHeader**.

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
            - AddResponseHeader=token-response, 123456
```

Con **AddResponseHeader** podemos agregar un header a la respuesta, cualquier Header que no tenga un valor asignado puede ser modificado por este filtro.

Para cambiar valores de Header que ya tienen un valor asignado debemos usar el filtro **SetResponseHeader**.

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - StripPrefix=2
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
            - SetResponseHeader=token-response, 123456
```

Hay que recordar que todos estos filtros se configuran en la **gateway** por lo que la utilidad de esto es que nos permite hacerle cambios a las respuestas nativas de los microservicios sin tener que modificar el código de estos.

### Request Predicates Factory

Los **Request Predicates Factory** nos permiten filtrar las peticiones que llegan a la **gateway**, por ejemplo podemos filtrar las peticiones por el método HTTP, por el host, por el path, por el puerto, etc.

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
            - Method=GET, POST
            - Host=**.google.com
            - Query=color, verde
            - RemoteAddr=
            - After=2021-12-31T00:00:00.000Z
            - Before=2021-12-31T00:00:00.000Z
            - Between=2021-12-31T00:00:00.000Z, 2021-12-31T00:00:00.000Z
            - Cookie=cookie
            - Header=token, \d+
            - Host=host
            - Method=method
            - Path=path
            - Port=port
            - Query=query
            - RemoteAddr=remoteAddr
```

Con **Path** estamos filtrando las peticiones por el path, con **Method** por el método HTTP, con **Host** por el host, con **Query** por el query, con **RemoteAddr** por la dirección IP, con **After** por la fecha después de la fecha indicada, con **Before** por la fecha antes de la fecha indicada, con **Between** por la fecha entre las fechas indicadas, con **Cookie** por la cookie, con **Header** por el header, con **Host** por el host, con **Method** por el método HTTP, con **Path** por el path, con **Port** por el puerto, con **Query** por el query, con **RemoteAddr** por la dirección IP.

Son una serie de reglas que podemos definir para filtrar las peticiones que llegan a la **gateway**, para que se puedan ejecutar las peticiones a algún microservicio se deben cumplir las reglas que establecimos.

## Resilience4j Resiliencia y tolerancia a fallos

**Resilience4j** es el reemplazo de **Hystrix**, el cual ya no se usa en las versiones mas recientes de **Spring Boot**. **Resilience4j** es una librería que nos permite implementar tolerancia a fallos y resiliencia en nuestras aplicaciones, nos permite implementar circuit breaker, retry, rate limiter, bulkhead, etc.

Muchas veces en un ecosistema de microservicios la comunicación puede fallar, puede que tarde demasiado en responder, que el servicio arroje alguna excepción o simplemente que el servicio no este disponible, para esto necesitamos implementar mecanismos que nos permitan manejar estos fallos y no afectar la disponibilidad del sistema.

Para prevenir esto se suele implementar el patrón **Circuit Breaker**, este patrón nos permite manejar los fallos en la comunicación entre microservicios, si uno de ellos falla, el circuit breaker se abre y redirige el trafico a otro microservicio, una vez que el microservicio vuelve a estar disponible, el circuit breaker se cierra y redirige el trafico nuevamente al original.

Es común que algunos servicios sean dependientes de otros, ya sea para obtener información o para realizar alguna acción, si uno de estos servicios falla, el servicio que depende de este también fallará y el que depende de este y así sucesivamente, esto se conoce como **cascada de fallos**, si falla uno falla toda la cadena.

### Resilience4j

Desde Spring Cloud 2020.0.0 Ilford y Spring Boot 2.4.1, se comenzó a usar por defecto **Resilience4j** en lugar de **Hystrix**, que ahora se encuentra en modo de mantenimiento.

#### Estados del Circuit Breaker

- **CLOSED**: el circuit breaker esta cerrado, el servicio esta disponible y se puede acceder a el. Si la taza de fallos supera el umbral, el circuit breaker se abre.
- **OPEN**: el circuit breaker esta abierto, el servicio no esta disponible y se redirige el trafico a otro servicio. Luego de un tiempo el circuit breaker se cierra y se vuelve a intentar acceder al servicio.
- **HALF_OPEN**: el circuit breaker esta medio abierto, se esta probando la disponibilidad del servicio, si el servicio esta disponible es decir la taza de fallos es menor al umbral, el circuit breaker se cierra, si no se vuelve a abrir.

#### Parámetros del Circuit Breaker

- **slidingWindowSize(100)**: tamaño de la ventana de tiempo, por defecto 100. Es el numero de peticiones que se van a monitorear, por defecto 100, en base a eso se va a calcular la taza de fallos, si esta tasas supera el umbral que configuramos, el circuit breaker se abre.
- **failureRateThreshold(50)**: umbral de fallos, por defecto 50. Es el porcentaje de fallos que se van a permitir, si la taza de fallos supera este umbral, el circuit breaker se abre.
- **waitDurationInOpenState(60000 ms)**: tiempo de espera en el estado abierto, por defecto 60 segundos. Es el tiempo que se va a esperar antes de volver a intentar acceder al servicio, si el circuit breaker esta abierto.
- **permittedNumberOfCallsInHalfOpenState(10)**: numero de peticiones permitidas en el estado medio abierto, por defecto 10. Es el numero de peticiones de prueba que se van a hacer para determinar si el servicio esta disponible, si la taza de fallos es menor al umbral, el circuit breaker se cierra, si no se vuelve a abrir.
- **slowCallRateThreshold(100)**: umbral de llamadas lentas, por defecto 100. Es el porcentaje de llamadas lentas que se van a permitir, si la taza de llamadas lentas supera este umbral, el circuit breaker se abre.
- **slowCallDurationThreshold(60000 ms)**: duración de llamadas lentas, por defecto 60 segundos. Es el tiempo que se va a considerar como una llamada lenta, si una llamada supera este tiempo, se considera lenta.

Para configurar el circuit breaker debemos agregar las dependencias de **Resilience4j** en el `pom.xml`.

```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
		</dependency>
```

Ademas de la dependencia de **bootstrap**

```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bootstrap</artifactId>
		</dependency>
```

Esta dependencia es necesaria porque **Resilience4j** necesita que se carguen las propiedades de configuración antes de que se cargue el contexto de la aplicación.

Debemos recordar que estas configuraciones son en el microservicio de item.

Luego debemos configurar el archivo `application.properties`.

```properties
spring.config.import=optional:configserver:
```

Esta configuración la dejamos para después cuando usemos **Spring Cloud Config** como servidor de configuración.

Para configurar el circuit breaker podemos inyectar la dependencia en el controlador.

```java
@RestController
public class ItemController {

   @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private ItemService itemService;

      @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item getItemById(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return circuitBreakerFactory.create("items")
                .run(() -> itemService.findById(id, cantidad), e -> metodoAlternativo(id, cantidad));
    }

        public Item metodoAlternativo(Long id, Integer cantidad) {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sony");
        producto.setPrecio(500.00);
        item.setProducto(producto);

        return item;
    }
}
```

Lo que estamos haciendo es crear un nuevo circuit breaker con el nombre **items** y estamos ejecutando el método **findById()** del servicio **itemService**, si este método falla, se ejecuta el método **metodoAlternativo()**.

### Personalizando parámetros del Circuit Breaker

Podemos configurar configurar ciertos parámetros del circuit breaker como el tamaño de la ventana de tiempo, el umbral de fallos, el tiempo de espera en el estado abierto, etc. Para esto podemos usar una clase de configuración.

```java
@Configuration
public class CircuitBreakerConfig {

       @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .slidingWindowSize(10)
                        .failureRateThreshold(50)
                        .waitDurationInOpenState(Duration.ofSeconds(10L))
                        .build())
                .timeLimiterConfig(TimeLimiterConfig.ofDefaults())
                .build());
    }
}
```

Con esto establecemos de forma customizada todos los valores para las configuraciones que nos interesan, en este caso estamos configurando el tamaño de la ventana de tiempo en 10, el umbral de fallos en 50, el tiempo de espera en el estado abierto en 10 segundos, etc.

En esta configuración estamos estableciendo estos parámetros para todos los circuit breaker que se creen en la aplicación, si queremos establecer estos parámetros para un circuit breaker en especifico debemos hacerlo de la siguiente forma.

```java
@Configuration
public class CircuitBreakerConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configure(builder -> builder
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .slidingWindowSize(10)
                        .failureRateThreshold(50)
                        .waitDurationInOpenState(Duration.ofSeconds(10L))
                        .build())
                .timeLimiterConfig(TimeLimiterConfig.ofDefaults())
                .build(), "items");
    }
}
```

Con esto estamos estableciendo estos parámetros para el circuit breaker con el nombre **items**.

También podemos customizar el TimeLimiter, el cual nos permite establecer un tiempo de espera para las peticiones.

```java
@Configuration
public class CircuitBreakerConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configure(builder -> builder
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .slidingWindowSize(10)
                        .failureRateThreshold(50)
                        .waitDurationInOpenState(Duration.ofSeconds(10L))
                        .build())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(5L))
                        .build())
                .build(), "items");
    }
}
```

### Llamadas lentas

**Resilience4j** nos permite configurar un tiempo de espera para las peticiones, si una petición supera este tiempo, se considera una llamada lenta y se puede configurar un umbral para las llamadas lentas.

```java
@Configuration
public class CircuitBreakerConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configure(builder -> builder
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                        .slidingWindowSize(10)
                        .failureRateThreshold(50)
                        .waitDurationInOpenState(Duration.ofSeconds(10L))
                        .slowCallRateThreshold(50)
                        .slowCallDurationThreshold(Duration.ofSeconds(5L))
                        .build())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(5L))
                        .build())
                .build(), "items");
    }
}
```

### Configurar Resilience4j con application.yaml

Podemos configurar **Resilience4j** con el archivo **application.yaml**.

```yaml
resilience4j:
  circuitbreaker:
    configs:
      defecto:
        sliding-window-size: 6
        failure-rate-threshold: 50
        wait-duration-in-open-state: 20s
        permitted-number-of-calls-in-half-open-state: 3
    instances:
      items:
        base-config: defecto
  timelimiter:
    configs:
      defecto:
        timeout-duration: 2s
    instances:
        items:
            base-config: defecto
```

Con esto nos ahorramos configurar estos parámetros en una clase de configuración.

Tambien podemos hacer esta misma configuración en un archivo **application.properties**.

```properties
resilience4j.circuitbreaker.configs.defecto.sliding-window-size=6
resilience4j.circuitbreaker.configs.defecto.failure-rate-threshold=50
resilience4j.circuitbreaker.configs.defecto.wait-duration-in-open-state=20s
resilience4j.circuitbreaker.configs.defecto.permitted-number-of-calls-in-half-open-state=4
resilience4j.circuitbreaker.configs.defecto.slow-call-rate-threshold=50
resilience4j.circuitbreaker.configs.defecto.slow-call-duration-threshold=2s
resilience4j.circuitbreaker.instances.items.base-config=defecto
 
resilience4j.timelimiter.configs.defecto.timeout-duration=2s
resilience4j.timelimiter.instances.items.base-config=defecto
```

Equivalente a:

```yaml
resilience4j:
  circuitbreaker:
    configs:
      defecto:
        sliding-window-size: 6
        failure-rate-threshold: 50
        wait-duration-in-open-state: 20s
        permitted-number-of-calls-in-half-open-state: 4
        slow-call-rate-threshold: 50
        slow-call-duration-threshold: 2s
    instances:
      items:
        base-config: defecto
  timelimiter:
    configs:
      defecto:
        timeout-duration: 2s
    instances:
      items:
        base-config: defecto
```

### Anotación @CircuitBreaker

Con la anotación **@CircuitBreaker** podemos configurar el circuit breaker en el método que queramos.

```java
    @CircuitBreaker(name = "items", fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver1/{id}/cantidad/{cantidad}")
    public Item getItemById1(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

    public Item metodoAlternativo(Long id, Integer cantidad, Throwable e) {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sony");
        producto.setPrecio(500.00);
        item.setProducto(producto);

        return item;
    }

```

La diferencia de esta forma de configurar el circuit breaker es que solo funcionan los parámetros definidos en **application.yaml** o **application.properties**, a diferencia de la otra forma en la que podíamos personalizar los parámetros en la clase de configuración.

### Anotación @TimeLimiter

Similar a la anotación **@CircuitBreaker** podemos configurar el tiempo de espera de una petición con la anotación **@TimeLimiter**.

```java
    @TimeLimiter(name = "items", fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver2/{id}/cantidad/{cantidad}")
    public CompletableFuture<Item> getItemById2(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return CompletableFuture.supplyAsync(() -> itemService.findById(id, cantidad));
    }
```

Esta anotación varia un poco ya que es necesario que el método retorne un **CompletableFuture**, esto es porque el método se va a ejecutar de forma asíncrona.

Debido a esto el metodo alternativo también debe retornar un **CompletableFuture**.

```java
    public CompletableFuture<Item> metodoAlternativo(Long id, Integer cantidad, Throwable e) {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sony");
        producto.setPrecio(500.00);
        item.setProducto(producto);

        return CompletableFuture.completedFuture(item);
    }
```

También es posible combinar ambas anotaciones en caso de que se necesite.

```java
    @CircuitBreaker(name = "items", fallbackMethod = "metodoAlternativo")
    @TimeLimiter(name = "items")
    @GetMapping("/ver3/{id}/cantidad/{cantidad}")
    public CompletableFuture<Item> getItemById3(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return CompletableFuture.supplyAsync(() -> itemService.findById(id, cantidad));
    }
```

Esto es util en caso de que se quiera configurar una lógica alternativa en ambos casos, que algún método falle o que se supere el tiempo de espera.

Es importante que si vamos a usar ambas anotaciones, el **fallbackMethod** no debe estar en **@TimeLimiter**, o en ninguno, o solo en el **@CircuitBreaker**.

### Spring Cloud Gateway con Resilience4j

Podemos agregar **Resilience4j** a la **gateway** para que esta tenga tolerancia a fallos. No es la misma dependencia que usamos en el microservicio, debemos agregar la dependencia de **Spring Cloud Gateway Resilience4j** en el `pom.xml`.

```xml
	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-circuitbreaker-reactor-resilience4j</artifactId>
		</dependency>
```

Luego debemos configurar el archivo `application.yaml`.

```yaml
resilience4j:
  circuitbreaker:
    configs:
      defecto:
        sliding-window-size: 6
        failure-rate-threshold: 50
        wait-duration-in-open-state: 20s
        permitted-number-of-calls-in-half-open-state: 4
        slow-call-rate-threshold: 50
        slow-call-duration-threshold: 2s
    instances:
      products:
        base-config: defecto
  timelimiter:
    configs:
      defecto:
        timeout-duration: 2s
    instances:
      products:
        base-config: defecto
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - name: CircuitBreaker
              args:
                name: products
                statusCodes: 500
                fallbackUri: forward:/api/items/ver/9/cantidad/1
            - StripPrefix=2
            - name: Ejemplo
              args:
                mensaje: Hola Mundo
                cookieName: cookie
                cookieValue: cookieValue
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
```

Con esto estamos configurando el circuit breaker en la **gateway** para que tenga tolerancia a fallos, si el servicio **products** falla, se redirige el trafico al servicio **items**, específicamente a la ruta **/api/items/ver/9/cantidad/1**.

## Spring Cloud Config Server

**Spring Cloud Config Server** es un servidor de configuración que nos permite centralizar las configuraciones de nuestras aplicaciones, esto significa que podemos centralizar configuraciones como puertos, rutas, nombres de servicios, etc. en un solo lugar y que nuestras aplicaciones puedan acceder a estas configuraciones y usarlas.

Cuando se inicia un microservicio, antes de registrarse en Eureka hace una petición al servidor de configuración para obtener las configuraciones, luego se registra en Eureka y ya puede ser accedido por otros microservicios.

Para comenzar debemos crear un nuevo proyecto de **Spring Boot** con las dependencias de **Spring Cloud Config Server**.

```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-config-server</artifactId>
    </dependency>
```

Luego hay que agregar la anotación **@EnableConfigServer** en la clase principal.

```java
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }

}
```

También debemos configurar el archivo `application.properties`.

```properties
spring.application.name=config-server
server.port=8888

spring.cloud.config.server.git.uri=
```

En la propiedad **spring.cloud.config.server.git.uri** debemos indicar la dirección del repositorio de **Git** donde vamos a almacenar las configuraciones. Puede ser un directorio local o un repositorio remoto.

Por ejemplo si queremos almacenar las configuraciones en un repositorio de **Git** local debemos hacer lo siguiente.

```properties
spring.application.name=config-server
server.port=8888

spring.cloud.config.server.git.uri=file:///C:/Users/diego/Documents/conf
```

Luego en esa carpeta que establecimos como la carpeta en donde va a estar nuestra configuración debemos crear un archivo llamado **application.properties**.

```properties
server.port=8081
configuracion.mensaje=Hola mundo desde microservicio item
```

Y en ese archivo podemos establecer las configuraciones que queremos que tengan nuestros microservicios.

Luego podemos hacer andar el servidor de configuración y acceder a las configuraciones desde **localhost:8888/nombre-del-microservicio/default**.

```json
{
  "name": "microservice-item",
  "profiles": [
    "default"
  ],
  "label": null,
  "version": "a671ca898d399a75a23abe238be54e6f30342ffa",
  "state": null,
  "propertySources": [
    {
      "name": "file:///C:/Users/Diego Obando/Desktop/conf/file:/C:/Users/Diego Obando/Desktop/conf/microservice-item.properties",
      "source": {
        "server.port": "8081",
        "configuracion.mensaje": "Hola mundo desde microservicio item"
      }
    }
  ]
}
```

Para que el o los microservicios puedan acceder a estas configuraciones es necesario instalar en ellos la dependencia de **Config Client**.

```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
```

Ademas debemos tener en el microservicio la dependencia de **bootstrap**.

```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-bootstrap</artifactId>
    </dependency>
```

Y crear el archivo `bootstrap.properties`.

```properties
spring.application.name=microservice-item
spring.cloud.config.uri=http://localhost:8888
```

Para definir el nombre del microservicio y la dirección del servidor de configuración.

### Leer configuraciones desde el controlador usando @Value

Podemos leer las configuraciones desde el controlador usando la anotación **@Value**.

```java
@RestController
public class ItemController {

    @Value("${configuracion.mensaje}")
    private String mensaje;


    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig() {
        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);
        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }
}
```

Con esto estamos leyendo la configuración **configuracion.mensaje** y la estamos mostrando en un endpoint.

### Configuración de ambientes

Podemos configurar diferentes ambientes mediante el archivo de configuración, para esto debemos crear un nuevo archivo de configuración llamado por ejemplo **microservice-item-dev.properties**.

```properties
configuracion.mensaje=Hola mundo desde microservicio item en ambiente de desarrollo
configuracion.autor.nombre=Diego
configuracion.autor.email=example@example.com
```

También podemos crear un archivo de configuración llamado **microservice-item-prod.properties**.

```properties
configuracion.mensaje=Hola mundo desde microservicio item en ambiente de producción
configuracion.autor.nombre=Diego
configuracion.autor.email=example@example.com
```

Para establcer el ambiente debemos agregar la propiedad **spring.profiles.active** en el archivo `bootstrap.properties`.

```properties
spring.application.name=microservice-item
spring.cloud.config.uri=http://localhost:8888
spring.profiles.active=dev
```

Luego para poder acceder a estas configuraciones desde el servicio necesitamos saber en que ambiente estamos, para esto podemos inyectar en el controlador la dependencia **Environment**.

```java
@RestController
public class ItemController {

    @Autowired
    private Environment env;

    @Value("${configuracion.mensaje}")
    private String mensaje;

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig() {
        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);

        if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
            json.put("autor", env.getProperty("configuracion.autor.nombre") + " - " + env.getProperty("configuracion.autor.email"));
        }

        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }
}
```

### Actualizar cambios en la configuración con @RefreshScope y Actuator

Para que los cambios en la configuración se reflejen en el microservicio debemos agregar la anotación **@RefreshScope** en el controlador.

```java
@RefreshScope
@RestController
public class ItemController {

    @Autowired
    private Environment env;

    @Value("${configuracion.mensaje}")
    private String mensaje;

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig() {
        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);

        if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
            json.put("autor", env.getProperty("configuracion.autor.nombre") + " - " + env.getProperty("configuracion.autor.email"));
        }

        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }
}
```

Esta anotación nos permite actualizar los componentes, controladores, clases anotadas con **@Component**, etc. sin tener que reiniciar el microservicio, refresca el contexto de la aplicación cada vez que hay cambios en la configuración.

Esta actualización requiere que definamos una ruta la cual será usada para refrescar la configuración, para esto debemos agregar la dependencia de **Actuator** en el `pom.xml`.

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
```

Luego en el archivo `bootstrap.properties` debemos agregar la propiedad **management.endpoints.web.exposure.include=refresh**.

```properties
spring.application.name=microservice-item
spring.profiles.active=dev
spring.cloud.config.uri=http://localhost:8888
management.endpoints.web.exposure.include=*
```

Con el `*` estamos indicando que se expongan todos los endpoints.

Con esto cuando realicemos un cambio en los archivos de configuración y hagamos commit de estos, podemos hacer que se actualicen los microservicios sin tener que reiniciarlos.

Entonces cuando queramos actualizar la configuración debemos hacer una petición **POST** a la ruta **/actuator/refresh**.

```bash
curl -X POST http://localhost:8081/actuator/refresh
```

Y con esto los cambios en la configuración se reflejaran en el microservicio.

Estos cambios a configuraciones solo funcionan con aquellas que hallamos definido nosotros, aquellas como el puerto, la dirección de la base de datos, etc. no se pueden actualizar de esta forma, para esto debemos reiniciar el microservicio.

## CRUD consumiendo los servicios con Feign y RestTemplate

Debemos terminar de crear las operaciones de **CRUD** en los microservicios.

Primero el microservicio de productos.

```java
public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void deletById(Long id);

}
```

```java
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

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void deletById(Long id) {
        productoDAO.deleteById(id);
    }
}
```

```java
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

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto createProduct(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto updateProduct(@RequestBody Producto producto, @PathVariable("id") Long id) {
        Producto product = productoService.findById(id);
        product.setNombre(producto.getNombre());
        product.setPrecio(producto.getPrecio());
        return productoService.save(product);
    }

    // ****************************************************************************************
    // ****************************************************************************************
    // ****************************************************************************************

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) {
        productoService.deletById(id);
    }
}
```

Luego el microservicio de items.

```java
public interface ItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);
    public Producto save(Producto producto);
    public Producto update(Producto producto, Long id);
    public void delete(Long id);

}
```

```java
@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://microservice-products/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://microservice-products/ver/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }

    @Override
    public Producto save(Producto producto) {
        HttpEntity<Producto> body = new HttpEntity<>(producto);
        ResponseEntity<Producto> response = clienteRest.exchange("http://microservice-products/crear", HttpMethod.POST, body, Producto.class);

        return response.getBody();
    }

    @Override
    public Producto update(Producto producto, Long id) {
        HttpEntity<Producto> body = new HttpEntity<>(producto);
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        ResponseEntity<Producto> response = clienteRest.exchange("http://microservice-products/editar/{id}", HttpMethod.PUT, body, Producto.class, pathVariables);

        return response.getBody();
    }

    @Override
    public void delete(Long id) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        clienteRest.delete("http://microservice-products/eliminar/{id}", pathVariables);
    }
}
```

```java
@RestController
public class ItemController {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    @Qualifier("serviceRestTemplate")
    private ItemService itemService;

    @Value("${configuracion.mensaje}")
    private String texto;

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
        return circuitBreakerFactory.create("items")
                .run(() -> itemService.findById(id, cantidad), e -> metodoAlternativo(id, cantidad));
    }

    @CircuitBreaker(name = "items", fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver1/{id}/cantidad/{cantidad}")
    public Item getItemById1(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

    @TimeLimiter(name = "items", fallbackMethod = "metodoAlternativo")
    @GetMapping("/ver2/{id}/cantidad/{cantidad}")
    public CompletableFuture<Item> getItemById2(@PathVariable("id") Long id, @PathVariable("cantidad") Integer cantidad) {
        return CompletableFuture.supplyAsync(() -> itemService.findById(id, cantidad));
    }

    public Item metodoAlternativo(Long id, Integer cantidad) {
        Item item = new Item();
        Producto producto = new Producto();

        item.setCantidad(cantidad);
        producto.setId(id);
        producto.setNombre("Camara Sony");
        producto.setPrecio(500.00);
        item.setProducto(producto);

        return item;
    }

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig() {
        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);
        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto saveProduct(Producto producto) {
        return itemService.save(producto);
    }

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @PostMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto updateProduct(@PathVariable Long id, Producto producto) {
        return itemService.update(producto, id);
    }

    // ******************************************************************************************
    // ******************************************************************************************
    // ******************************************************************************************

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        itemService.delete(id);
    }

}
```

## Servicio commons: librería de utilidades

Para no tener que repetir código en los microservicios podemos crear una librería de utilidades que contenga clases y métodos que se puedan reutilizar en los microservicios.

Por ejemplo, en ambos estamos usando la entidad producto, esta la podemos reutilizar en ambos abstraiéndola en una librería de utilidades.

Primero creamos un nuevo proyecto de **Spring Boot** con las dependencias de JPA y H2

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
    </dependency>
```

H2 es necesario porque JPA necesita que haya una base de datos para poder funcionar.

Luego hay que quitar de la clase main la qu está dentro de ella

```java
package com.dieg0code.commons;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonsApplication {

}

```

También no es necesario que usemos el plugin de maven, arique lo podemos quitar

```xml
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

Creamos en package **models.entity** y dentro la entidad **Producto**.

```java
package com.dieg0code.commons.models.entity;

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

Luego debemos generar el **jar** de la librería para poder usarla en los microservicios.

```cmd
mvn clean install
```

Con esto generamos un **jar** en la carpeta **target** que es un paquete con todas las clases y dependencias de la librería, el cual vamos a usar en los microservicios.

También podemos quitar la autoconfiguracion de la base de datos usando la anotación **@EnableAutoConfiguration** en la clase principal.

```java
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CommonsApplication {
  
  }
}
```

Ya que no necesitamos una base de datos en este proyecto, pero JPA lo configura por defecto por eso hay que excluirlo.

Ahora para usar la librería en los microservicios debemos agregar la dependencia en el `pom.xml`.

```xml
    <dependency>
      <groupId>com.dieg0code</groupId>
      <artifactId>commons</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
```

Es importante sacar del **pom** de la librería el **groupId**, **artifactId** y **version**.

Luego debemos modificar todas las clases para que usen la entidad **Producto** de la librería.

El problema que tenemos ahora es que el package de Producto está en **commons** el cual es otro proyecto con otro contexto. Para solucionar esto debemos agregar la anotación **@EntityScan** en la clase principal de los microservicios que usan la librería.

```java
@EntityScan({"com.dieg0code.commons.models.entity"})
@SpringBootApplication
public class MicroserviceItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceItemApplication.class, args);
    }

}
```

Con esto estamos indicando que busque las entidades en el package **com.dieg0code.commons.models.entity**.

De esta forma estamos reutilizando la entidad **Producto** en ambos microservicios. En este ejemplo estamos reutilizando solo una entidad, pero en proyectos grandes se nota mas la utilidad, ya que centralizamos las entidades y todo el código que sea necesario para después solo reutilizarlo y no tener que repetir lo mismo en cada uno de los servicios.

## Spring Cloud Security: OAuth2 y JWT

Una de las formas mas comunes de implementar seguridad en una aplicación es trabajar con sesiones, pero en una arquitectura de microservicios esto no es lo mas recomendable, ya que cada microservicio tendría que tener su propia sesión y esto no es escalable.

La solución a esto es usar **tokens** de seguridad. **JWT** (JSON Web Token) es un estándar abierto que define una forma compacta y autónoma para transmitir información entre las partes como un objeto JSON. Esta información puede ser verificada y es confiable porque está firmada digitalmente.

Un **JWT** consiste en tres partes separadas por un punto:

- **Header**: Contiene el tipo de token y el algoritmo de encriptación.
- **Payload**: Contiene la información que queremos transmitir.
- **Signature**: Contiene la firma digital que verifica que el mensaje no ha sido alterado. Para esta firma se usa un **secret** que solo el servidor conoce, una especie de contraseña.

Es una cadena alfanumérica que se puede enviar en la cabecera de una petición HTTP, en el cuerpo de una petición HTTP o en una cookie.

Por ejemplo:

```json
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

Los **token** también suelen caducar después de un tiempo, esto es para que si alguien intercepta el **token** no pueda usarlo indefinidamente.

Se suelen almacenar en el cliente, ya sea en el **sessionStorage** o en el **localStorage** del navegador, o en una cookie. Ya que el localStorage es persistente se suele guardar ahí tokens con una duración larga, mientras que en el sessionStorage se guardan tokens con una duración corta.

Si bien los JWT son un método de seguridad, son fácilmente reversibles, es por eso que no se debe guardar información sensible en ellos, como contraseñas, números de tarjeta de crédito, etc.

### Introducción a OAuth2

Spring Security es un framework de seguridad que se integra con Spring Boot, nos provee características de seguridad como autenticación, autorización, protección contra ataques, etc.

La **Autenticación** se refiere al proceso de establecer un principal (un principal significa un usuario, dispositivo o algún otro sistema el cual puede ejecutar alguna acción en nuestro sistema), en general permite a los principal autenticarse en base a cualquier proveedor de seguridad por ejemplo **LDAP**, **Base de datos relacional** y **Autenticación HTTP**.

La **Autorización** se refiere al proceso de decidir si se otorga acceso a un usuario para realizar una acción dentro de la aplicación, es decir, para controlar el acceso a los recursos de la aplicación por medio de la asignación de roles y permisos a grupos de usuario.

**OAuth2** es un protocolo de autorización que permite a las aplicaciones de terceros, una aplicación web o una móvil, autenticarse con cuentas de usuario que están en un servicio HTTP externo, de esta forma se puede compartir un sistema de autenticación entre varias aplicaciones sin compartir la información del usuario.

La implementación que trae **Spring security** de **OAuth2** se compone de dos partes:

- **Authorization Server**: Es el servidor que se encarga de emitir los tokens de acceso a los clientes después de autenticarlos y obtener su consentimiento.
- **Resource Server**: Es el servidor que protege los recursos, los cuales solo pueden ser accedidos por los clientes que tengan un token de acceso válido. Tras bambalinas, el servidor de recursos aplica el filtro de Spring **OAuth2AuthenticationProcessingFilter** para validar el token de acceso.

El proceso de autenticación con **OAuth2** es el siguiente:

- El cliente realiza una petición POST a una ruta del **Authorization Server**, por ejemplo **/auth/token** con las siguientes características:
  - header: 
    - Authorization: Basic base64(client_id:client_secret)
    - Content-Type: application/x-www-form-urlencoded
  - body: 
    - grant_type: password
    - username: usuario
    - password: contraseña

- Si todo sale bien el servidor de autorización responde con un **token** de acceso.

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "bearer",
  "refresh_token": "eyJbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "expires_in": 3600,
  "scope": "read write"
  "jti": "5e9e3b7b-3b7b-4b7b-8b7b-7b7b7b7b7b7b"
}
```
- Luego el cliente puede hace una petición GET al **Resource Server** con la ruta **/api/clientes**, por ejemplo, con las siguientes características:
  - header:
    - Authorization: Bearer access_token, en donde access_token es el token de acceso que se obtuvo en el paso anterior.
- Si el token es valido se otorga el acceso y los permisos para acceder al recurso y retorna por ejemplo:

```json
[
  {
    "id": 1,
    "nombre": "Diego",
    "apellido": "Obando",
    "email": "email@exampl.com"
  },
  {
    "id": 2,
    "nombre": "Juan",
    "apellido": "Perez",
    "email": "email@example.com"
  }
]
```

## Creando el Microservicio de Usuarios

Para todo este tema de seguridad, primero debemos tener usuarios a los que autenticar, para esto vamos a crear un microservicio de usuarios.

Necesitamos las dependencias de **Eureka Client**

```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
```

La de **Data JPA** y **H2**.

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
    </dependency>
```

La de **DevTools**.

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
    </dependency>
```

Y **Spring Web** para poder crear los controladores.

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```

Luego debemos crear las entidades de **Usuario** y **Rol**.

```java
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;
    private String nombre;
    private String apellido;

    @Column(unique = true, length = 100)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
    private List<Role> roles;

}
```

Esta clase tiene una relación **@ManyToMany** con la clase **Role**. Cabe mencionar las anotaciones que usa esta relación:

- **ManyToMany(fetch = FetchType.LAZY)**: Indica que la relación es de muchos a muchos y que se cargará de forma perezosa, es decir que se cargará solo cuando se necesite.
- **JoinTable**: Indica la tabla intermedia que se va a crear para la relación. Esto es común cuando hay una relación de muchos a muchos.
- **joinColumns = @JoinColumn(name = "usuario_id")**: Indica el nombre de la columna que va a ser la llave foránea de la tabla **usuarios**.
- **inverseJoinColumns = @JoinColumn(name = "role_id")**: Indica el nombre de la columna que va a ser la llave foránea de la tabla **roles**.
- **uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})}**: Indica que la combinación de **usuario_id** y **role_id** debe ser única, esto es para evitar que un usuario tenga el mismo rol dos veces.

Luego tenemos la entidad **Role**.

```java
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String nombre;
    
}
```

En esta tabla no es necesario una relación **@ManyToMany** ya que no se necesita saber que usuarios tienen un rol, solo se necesita saber que roles tiene un usuario.

### Repositorio JPA para usuries

Data JPA nos da la opción de implementar **Querys** en base al nombre de método.

```java
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

    public Usuario findByUsername(String username);
}
```

Creamos una interface que extienda de **PagingAndSortingRepository**, la cual nos da métodos para paginar y ordenar los resultados, y le pasamos la entidad **Usuario** y el tipo de dato de la llave primaria.

Luego dentro podemos implementar las consultas que se van a poder ejecutar en la base de datos.

**findByUsername** es equivalente a **SELECT * FROM usuarios WHERE username = ?**.

También tenemos la opción de implementar **Querys** personalizadas.

```java
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

    @Query("select u from Usuario u where u.username = ?1")
    public Usuario obtenerPorUsername(String username);
}
```

### Implementando un repositorio REST para el CRUD

Con la dependencia

```<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
    <version>3.3.0</version>
</dependency>
```

Podemos implementar de forma automática un repositorio REST.

```java
@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

    public Usuario findByUsername(String username);
}
```

Con la anotación **@RepositoryRestResource** indicamos que vamos a exponer este repositorio como un servicio REST, y con la propiedad **path** indicamos la ruta en la que se va a exponer.

De esta forma automatizamos el CRUD de la entidad **Usuario**, sin la necesidad de crear un controlador.

Para poder exportar nuestros métodos personalizados debemos agregar la anotación **@RestResource**.

```java
@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

    @RestResource(path = "buscar-username")
    public Usuario findByUsername(@Param("username") String username);
}
```

Con la anotación **@RestResource** indicamos que vamos a exponer este método como un servicio REST, y con la propiedad **path** indicamos la ruta en la que se va a exponer.

Para acceder a este método debemos hacer una petición **GET** a la ruta **/usuarios/search/buscar-username?username=nombre-usuario**. Siempre debe ir el prefijo **search** antes del nombre del método.

### Configuración para exponer el id en la respuesta JSON

Por defecto **Spring Data REST** no expone el id de las entidades en la respuesta JSON, para exponerlo debemos crear una clase de configuración, por ejemplo **RepositoryConfig.java**

```java
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Usuario.class, Role.class);
  }
}
```

### Librería commons para usuarios

Las entidad **Usuario** y **Role** las podemos mover a un proyecto de librería de utilidades, de esta forma podemos reutilizarlas en otros microservicios posteriormente.

Para esto creamos un nuevo proyecto de **Spring Boot** con la dependencia de **Spring Data JPA**.

También hay que excluir la autoconfiguración de la base de datos.

```java
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CommonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonsApplication.class, args);
    }

}
```

Creamos un package **models.entity** y dentro la entidad **Usuario**.

```java
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;
    private String nombre;
    private String apellido;

    @Column(unique = true, length = 100)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
    private List<Role> roles;

}
```

Y la entidad **Role**.

```java
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String nombre;
    
}
```

Generamos el **jar** de la librería.

```cmd
mvn clean install
```

Y agregamos la dependencia en los microservicios.

```xml
    <dependency>
      <groupId>com.dieg0code</groupId>
      <artifactId>commons</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
```

El **artifactId** puede variar dependiendo del nombre que le hayamos dado al proyecto de la librería.

### Modificación del microservicio de usuarios para usar la librería

En el microservicio de usuarios debemos modificar la clase principal para que escanee las entidades de la librería.

```java
@EntityScan({"com.dieg0code.commons.models.entity"})
@SpringBootApplication
public class MicroserviceUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUsersApplication.class, args);
    }

}
```

Y también reemplazar las entidades por las de la librería.

### Creación del microservicio OAuth (Authorization Server)

El servidor de autorización es el que se encarga de generar los tokens de acceso, para esto necesitamos las dependencias de **Spring Security OAuth2**.

Necesitamos la dependencia de **Eureka Client**.

```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
```

Spring Web para crear los controladores.

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```

DevTools para reiniciar el servidor automáticamente.

```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
    </dependency>
```

OpenFeign para comunicarnos con el microservicio de usuarios.

```xml
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
```

También la dependencia de **Oauth**

```xml
<dependency>
    <groupId>org.springframework.security.oauth</groupId>
    <artifactId>spring-security-oauth2</artifactId>
    <version>2.3.8.RELEASE</version>
</dependency>
```

La de **JWT**

```xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-jwt</artifactId>
    <version>1.1.1.RELEASE</version>
</dependency>
```

Y la de **jaxb**
  
```xml
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
</dependency>
```

Ademas de la librería de **commons**.

```xml
    <dependency>
      <groupId>com.dieg0code</groupId>
      <artifactId>commons</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
```

La librería commons incluye la dependencia de **Spring Data JPA**, pero nuestro microservicio de OAuth no necesita una base de datos, por lo que debemos excluir la autoconfiguración de la base de datos. Podemos hacer esto también directamente en el pom.xml.

```xml
<dependency>
    <groupId>com.dieg0code</groupId>
    <artifactId>commons</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

Configuramos el servidor de autorización en el archivo **application.properties**.

```properties
spring.application.name=microservice-oauth
server.port=9100

eureka.client.service-url.default-zone=http://localhost:8761/eureka

spring.config.import=optional:configserver:http://localhost:8888
```

### Interfaz Feign Client

Con **Feign** podemos comunicarnos con otros microservicios de forma sencilla, solo debemos crear una interfaz con los métodos que vamos a usar y **Feign** se encarga de hacer la comunicación.

Comenzamos agrando la anotación **@EnableFeignClients** en la clase principal.

```java
@EnableFeignClients
@SpringBootApplication
public class MicroserviceOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceOauthApplication.class, args);
    }

}
```

Creamos el package **clients** y dentro la interfaz **UsuarioFeignClient**.

```java
@FeignClient(name = "microservice-usuarios")
public interface UsuarioFeignClient {

    @GetMapping("/usuarios/search/buscar-username")
    public Usuario findByUsername(@RequestParam String username);

}
```

En la anotación **@FeignClient** indicamos el nombre del microservicio con el que nos vamos a comunicar.

Luego en **@GetMapping** indicamos la ruta del microservicio al que vamos a hacer la petición.

Luego creamos la clase service que va a implementar la interfaz.

Comenzamos creando un nuevo package **services** y dentro la clase **UsuarioService**.

```java
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioFeignClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = client.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Error en el login, no existe el usuario '" + username + "' en el sistema");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> log.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        log.info("Usuario autenticado: " + username);

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }
}
```

Con la anotación **@Service** indicamos que esta clase es un servicio.

Con la interfaz **UserDetailsService** de **Spring Security** podemos cargar un usuario por su nombre de usuario, en este caso vamos a cargar un usuario por su nombre de usuario y vamos a devolver un **UserDetails**.

Con la anotación **@Autowired** inyectamos el cliente **Feign**.

En el método **loadUserByUsername** hacemos una petición al microservicio de usuarios para obtener el usuario por su nombre de usuario.

Si el usuario no existe lanzamos una excepción **UsernameNotFoundException**.

Luego obtenemos los roles del usuario y los convertimos en **GrantedAuthority**.

Con el método **stream** convertimos la lista de roles en un **Stream**.

Con el método **map** convertimos cada rol en un **SimpleGrantedAuthority**.

Con el método **peek** imprimimos los roles.

Con el método **collect** convertimos el **Stream** en una lista de **GrantedAuthority**.

Luego imprimimos el nombre del usuario autenticado.

Y finalmente retornamos un **User** con el nombre de usuario, la contraseña, si el usuario está habilitado, si la cuenta no ha expirado, si las credenciales no han expirado, si la cuenta no está bloqueada, los roles del usuario.

### Añadiendo la clase SpringSecurityConfig y registrando UserDetailsService

Debemos registrar en el authenticationManager el servicio que acabamos de crear.

Comenzamos creando un nuevo package **security** y dentro la clase **SpringSecurityConfig**.

```java
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService usuarioService;

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
```

Con la anotación **@Configuration** indicamos que esta clase es una clase de configuración.

Luego inyectamos el servicio **UserDetailsService** mediante la anotación **@Autowired**.

Inyectamos también el **AuthenticationManagerBuilder** en el método **configure**, este método nos permite configurar el **AuthenticationManager** y es heredado de **WebSecurityConfigurerAdapter**.

Con el método **userDetailsService** indicamos que vamos a usar el servicio **UserDetailsService** que acabamos de crear y con **passwordEncoder** indicamos que vamos a usar un **BCryptPasswordEncoder** para encriptar las contraseñas.

Con el método **passwordEncoder** creamos un **BCryptPasswordEncoder** el cual es un **PasswordEncoder** que usa el algoritmo **BCrypt** para encriptar las contraseñas.

Con el método **authenticationManager** indicamos que vamos a usar el **AuthenticationManager**, este método es necesario para poder usar el **AuthenticationManager** en la autenticación. 

### Configuración del servidor de autorización

En el package **security** creamos la clase **AuthorizationServerConfig**.

```java
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("frontendapp")
                .secret(passwordEncoder.encode("12345"))
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("algun_codigo_secreto_aqui");
        return tokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
}
```

#### Anotaciones
- **@Configuration**: Indica que esta clase define beans de configuración para Spring.
- **@EnableAuthorizationServer**: Marca esta clase como una configuración para un servidor de autorización OAuth2.

#### Inyecciones de Dependencias
- **BCryptPasswordEncoder**: Bean para codificar contraseñas usando BCrypt.
- **AuthenticationManager**: Bean para manejar la autenticación.
- **UsuarioService**: Servicio personalizado para gestionar los usuarios (no utilizado directamente en el código).

#### Métodos de Configuración

1. **configure(AuthorizationServerSecurityConfigurer security)**:
   - **security.tokenKeyAccess("permitAll()")**: Permite el acceso público a la ruta `/oauth/token_key`.
   - **security.checkTokenAccess("isAuthenticated()")**: Restringe el acceso a la ruta `/oauth/check_token` solo a usuarios autenticados.

2. **configure(ClientDetailsServiceConfigurer clients)**:
   - **clients.inMemory()**: Define que los detalles del cliente se almacenan en memoria.
   - **withClient("frontendapp")**: Configura el ID del cliente como "frontendapp".
   - **secret(passwordEncoder.encode("12345"))**: Codifica y establece la contraseña del cliente.
   - **scopes("read", "write")**: Define los alcances (permisos) que el cliente puede solicitar.
   - **authorizedGrantTypes("password", "refresh_token")**: Define los tipos de concesión permitidos (en este caso, `password` y `refresh_token`).
   - **accessTokenValiditySeconds(3600)**: Establece la validez del token de acceso en 3600 segundos (1 hora).
   - **refreshTokenValiditySeconds(3600)**: Establece la validez del token de refresco en 3600 segundos (1 hora).

3. **configure(AuthorizationServerEndpointsConfigurer endpoints)**:
   - **endpoints.authenticationManager(authenticationManager)**: Configura el `AuthenticationManager` para manejar la autenticación.
   - **endpoints.tokenStore(tokenStore())**: Configura el almacén de tokens (`TokenStore`).
   - **endpoints.accessTokenConverter(accessTokenConverter())**: Configura el convertidor de tokens (`AccessTokenConverter`).

#### Beans

1. **JwtAccessTokenConverter accessTokenConverter()**:
   - Crea y configura un `JwtAccessTokenConverter`, que se encarga de convertir un `AccessToken` en un `JWT`.
   - **tokenConverter.setSigningKey("algun_codigo_secreto_aqui")**: Establece la clave secreta para firmar los tokens JWT.

2. **TokenStore tokenStore()**:
   - Crea y configura un `JwtTokenStore` que utiliza el `JwtAccessTokenConverter` para almacenar los tokens JWT.

### Añadir información adicional al token JWT

Para añadir información adicional al token JWT debemos crear una clase que implemente una interfaz de **TokenEnhancer**, un **TokenEnhancer** es, en otras palabras, un potenciador, es decir, un objeto que puede agregar información adicional a un token, esta información extra tambien se conoce como **claims**.

Creamos dentro del package **security** la clase **InfoAdicionalToken**.

```java
@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Usuario usuario = usuarioService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("info_adicional", "Hola que tal! ".concat(authentication.getName()));
        info.put("nombre", usuario.getNombre());
        info.put("apellido", usuario.getApellido());
        info.put("email", usuario.getEmail());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
```

Necesitamos agregar esta interfaz al **UsuarioService**, para esto creamos en el package **services** la interfaz **IUsuarioService**.

```java
public interface IUsuarioService {

    public Usuario findByUsername(String username);

}
```

Y la implementamos en el **UsuarioService**.

```java
@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {

    @Autowired
    private UsuarioFeignClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = client.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Error en el login, no existe el usuario '" + username + "' en el sistema");
        }

        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> log.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        log.info("Usuario autenticado: " + username);

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }

    @Override
    public Usuario findByUsername(String username) {
        return client.findByUsername(username);
    }
}
```

Esto es para poder inyectar el servicio en la clase **InfoAdicionalToken**.

```java
((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
```

Este método esta entre paréntesis porque **accessToken** es de tipo **OAuth2AccessToken** y no tiene el método **setAdditionalInformation**, por eso lo casteamos a **DefaultOAuth2AccessToken**, es un cast, por eso va entre paréntesis.

Luego tenemos que configurar el **InfoAdicionalToken** en la clase **AuthorizationServerConfig**, especificamente el método de configuración **configure(AuthorizationServerEndpointsConfigurer endpoints)**.

```java
@Autowired
private InfoAdicionalToken infoAdicionalToken;

@Override
public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
  TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
  tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));

  endpoints.authenticationManager(authenticationManager)
          .tokenStore(tokenStore())
          .accessTokenConverter(accessTokenConverter())
          .tokenEnhancer(tokenEnhancerChain);
}
```

### Configurando Zuul como servidor de recursos

Debemos agregar las dependencias, spring security oauth2, jwt y jaxb al microservicio de zuul.

```xml
<dependency>
    <groupId>org.springframework.security.oauth</groupId>
    <artifactId>spring-security-oauth2</artifactId>
    <version>2.3.8.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-jwt</artifactId>
    <version>1.1.1.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
</dependency>
```

Creamos un nuevo package **oauth** y dentro la clase **ResourceServerConfig**.

```java
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
              .antMatchers(HttpMethod.GET, "/api/productos/listar", "/api/items/listar", "/api/usuarios/usuarios").permitAll()
              .antMatchers(HttpMethod.GET, "/api/productos/ver/{id}", "/api/items/ver/{id}/cantidad/{cantidad}", "/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
              .antMatchers("/api/productos/**", "/api/items/**", "/api/usuarios/**").hasRole("ADMIN")
              .anyRequest().authenticated();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
      JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
      tokenConverter.setSigningKey("algun_codigo_secreto_aqui");
      return tokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
      return new JwtTokenStore(accessTokenConverter());
    }
}
```

El token tiene que tener la misma configuración que el servidor de autorización, por eso debemos tener la misma clave secreta.

Este método:

```java
    @Override
    public void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
              .antMatchers(HttpMethod.GET, "/api/productos/listar", "/api/items/listar", "/api/usuarios/usuarios").permitAll()
              .antMatchers(HttpMethod.GET, "/api/productos/ver/{id}", "/api/items/ver/{id}/cantidad/{cantidad}", "/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
              .antMatchers(HttpMethod.POST, "/api/productos/create", "/api/items/create", "/api/usuarios/create").hasRole("ADMIN")
              .antMatchers(HttpMethod.PUT, "/api/productos/edit/{id}", "/api/items/edit/{id}", "/api/usuarios/edit/{id}").hasRole("ADMIN")
              .antMatchers(HttpMethod.DELETE, "/api/productos/delete/{id}", "/api/items/delete/{id}", "/api/usuarios/delete/{id}").hasRole("ADMIN")
              .anyRequest().authenticated();
    }
```

Con **.antMatchers()** podemos estableces las rutas, metodos y roles que pueden acceder a estos endpoints.

Establece las reglas de seguridad, en este caso estamos permitiendo el acceso a las rutas **/api/security/oauth/**, **/api/productos/listar**, **/api/items/listar** y **/api/usuarios/usuarios** a todos los usuarios.

Estamos permitiendo el acceso a las rutas **/api/productos/ver/{id}**, **/api/items/ver/{id}/cantidad/{cantidad}** y **/api/usuarios/usuarios/{id}** a los usuarios con los roles **ADMIN** y **USER**.

Y estamos permitiendo  que solo los usuarios con rol **ADMIN** puedan hacer peticiones **POST** a las rutas **/api/productos/**, **/api/items/** y **/api/usuarios/**, para que solo ellos puedan crear productos, items y usuarios.

esto tambien puede ser simplificado con:

```java
    @Override
    public void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
              .antMatchers(HttpMethod.GET, "/api/productos/listar", "/api/items/listar", "/api/usuarios/usuarios").permitAll()
              .antMatchers(HttpMethod.GET, "/api/productos/ver/{id}", "/api/items/ver/{id}/cantidad/{cantidad}", "/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
              .antMatchers("/api/productos/**", "/api/items/**", "/api/usuarios/**").hasRole("ADMIN")
              .anyRequest().authenticated();
    }
```

### Configuraciónd de OAuth en el Servidor de configuración

Podemos centralizar algunas configuraciones en el servidor de configuración como el client id, client secret, etc. De esta manera desacopalmos un poco las configuraciones del código del servicio de OAuth.

Creamos un nuevo archivo en la carpeta de configuración **application.properties**.

```properties
config.security.oauth.client.id=frontendapp
config.security.oauth.client.secret=12345
config.security.oauth.jwt.key=algun_codigo_secreto_aqui
```

En el microservicio de OAuth agreagamos la dependencia de **Spring Cloud Config Client**.

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

Esta dependencia también hay que agregarla en el microservicio de zuul.

Todos los clientes del servidor de configuración deben tener el archivo **bootstrap.properties**, por lo que debemos agregarlo en el microservicio de OAuth.

```properties
spring.application.name=microservice-oauth
spring.cloud.config.uri=http://localhost:8888
management.endpoints.web.exposure.include=*
```

Tambien hay que agregar esto a Zuul.

```properties
spring.application.name=microservice-zuul-server
spring.cloud.config.uri=http://localhost:8888
management.endpoints.web.exposure.include=*
```

El siguiente paso es inyectar esta configuraciones en las clases de configuración.

Por ejemplo en el servidor de autorización, en el archivo **AuthorizationServerConfig.java**.

```java
@Autowire
private Environment env;

@Override
public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory().withClient(env.getProperty("config.security.oauth.client.id"))
            .secret(passwordEncoder.encode(env.getProperty("config.security.oauth.client.secret")))
            .scopes("read", "write")
            .authorizedGrantTypes("password", "refresh_token")
            .accessTokenValiditySeconds(3600)
            .refreshTokenValiditySeconds(3600);
}

@Bean
public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
    tokenConverter.setSigningKey(env.getProperty("config.security.oauth.jwt.key"));
    return tokenConverter;
}
```

En el archivo **ResourceServerConfig.java** del microservicio de zuul.

```java
@Value("${config.security.oauth.jwt.key}")
private String jwtKey;

@Bean
public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
    tokenConverter.setSigningKey(jwtKey);
    return tokenConverter;
}
```

También, si queremos que el microservicio actualize automaticamente las configuraciones, debemos agregar la anotación **@RefreshScope** en el archivo de configuración.

```java
@RefreshScope
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {}
```

Lo mismo en el microservicio de OAuth.

```java
@RefreshScope
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {}
```

### Token de refresco

Un token de refresco es un token que se puede usar para obtener un nuevo token de acceso, esto es útil cuando el token de acceso ha expirado y no queremos que el usuario tenga que volver a ingresar sus credenciales.

Para obtener uno de estos tokens debemos hacer una petición **POST** a la ruta **/oauth/token** con los siguientes parámetros:

- **grant_type**: refresh_token
- **refresh_token**: token de refresco

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "bearer",
  "refresh_token": "eyJbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "expires_in": 3599,
  "scope": "read write"
}
```

Enviamos el token de refresco y el servidor nos devuelve un nuevo token de acceso y un nuevo token de refresco.

### Configuración de CORS en el servidor de autorización

**CORS** (Cross-Origin Resource Sharing) es un mecanismo que permite que los recursos de un servidor web sean solicitados desde otro dominio fuera del dominio desde el que se sirvió el recurso, es decir, permite que un servidor comparta recursos con otros servidores externos. Por ejemplo un fronted creado en otro dominio, en otro servidor.

En el servidor Zuul, en eL package **oauth**, en el archivo **ResourceServerConfig.java** configuramos el CORS en el metodo **configure(HttpSecurity http)**.

```java
@Override
public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/productos/listar", "/api/items/listar", "/api/usuarios/usuarios").permitAll()
            .antMatchers(HttpMethod.GET, "/api/productos/ver/{id}", "/api/items/ver/{id}/cantidad/{cantidad}", "/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
            .antMatchers("/api/productos/**", "/api/items/**", "/api/usuarios/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and().cors().configurationSource(corsConfigurationSource());
}

@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOrigins(Arrays.asList("*"));
    corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    corsConfig.setAllowCredentials(true);
    corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return source;
}
```

Con **.cors().configurationSource(corsConfigurationSource())** habilitamos el CORS y le pasamos la configuración que queremos. En este caso permitimos que cualquier origen pueda acceder a los recursos, permitimos los métodos **GET**, **POST**, **PUT**, **DELETE** y **OPTIONS**, permitimos las credenciales y permitimos los headers **Authorization** y **Content-Type** para que se puedan autenticar y enviar datos en formato JSON.

**source.registerCorsConfiguration("/**", corsConfig)** le decimos que esta configuración es para todas las rutas.

Tambien podemos configurar un filtro global para el CORS en el microservicio de OAuth.

```java
@Bean
public FilterRegistrationBean<CorsFilter> corsFilter() {
    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
}
```

Con esto estamos creando un filtro global para el CORS, le pasamos la configuración que creamos anteriormente y le indicamos que este filtro tiene la mayor prioridad.

### Manejo de eventos de éxito y fracaso en la autenticación

Podemos implementar lógica que maneje los casos de éxito y fracaso en la autenticación, por ejemplo, podemos bloquear un usuario si falla en la autenticación 3 veces.

En el servicio oauth en el package **security.events** creamos la clase **AuthenticationSuccessErrorHandler**.

```java
@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("Success Login: " + userDetails.getUsername());
        Usuario usuario = usuarioService.findByUsername(authentication.getName());
        if (usuario.getIntentos() != null && usuario.getIntentos() > 0) {
            usuario.setIntentos(0);
            usuarioService.update(usuario, usuario.getId());
        }
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
        System.out.println("Error en el login: " + exception.getMessage());
        try {
            Usuario usuario = usuarioService.findByUsername(authentication.getName());
            if (usuario.getIntentos() == null) {
                usuario.setIntentos(0);
            }
            usuario.setIntentos(usuario.getIntentos() + 1);
            if (usuario.getIntentos() >= 3) {
                usuario.setEnabled(false);
            }
            usuarioService.update(usuario, usuario.getId());
        } catch (FeignException e) {
            System.out.println("El usuario no existe en el sistema");
        }
    }
}
```

Luego hay que registrar este Handler en la clase de configuración de Spring Security.

```java
@Autowired
private AuthenticationSuccessErrorHandler successErrorHandler;

@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
}

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/productos/listar", "/api/items/listar", "/api/usuarios/usuarios").permitAll()
            .antMatchers(HttpMethod.GET, "/api/productos/ver/{id}", "/api/items/ver/{id}/cantidad/{cantidad}", "/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
            .antMatchers("/api/productos/**", "/api/items/**", "/api/usuarios/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and().cors().configurationSource(corsConfigurationSource())
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    http.authenticationProvider(daoAuthenticationProvider());
    http.authenticationEventPublisher(authenticationEventPublisher());
}

@Bean
public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(usuarioService);
    return daoAuthenticationProvider;
}

@Bean
public AuthenticationEventPublisher authenticationEventPublisher() {
    return new DefaultAuthenticationEventPublisher(successErrorHandler);
}
```

### `@Autowired`
```java
@Autowired
private AuthenticationSuccessErrorHandler successErrorHandler;
```
- **@Autowired**: Es una anotación de Spring que permite la inyección automática de dependencias. En este caso, está inyectando una instancia de `AuthenticationSuccessErrorHandler` en la variable `successErrorHandler`.

### `authenticationManagerBean` Método
```java
@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}
```
- **@Bean**: Indica que este método produce un bean que debe ser gestionado por el contenedor de Spring.
- **authenticationManagerBean**: Está sobrescribiendo un método para proporcionar una instancia de `AuthenticationManager`. Esto es necesario para habilitar la autenticación personalizada en tu aplicación.

### `configure(AuthenticationManagerBuilder auth)` Método
```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
}
```
- **configure(AuthenticationManagerBuilder auth)**: Este método se utiliza para configurar la forma en que los usuarios son autenticados. 
  - **userDetailsService(usuarioService)**: Indica que el servicio `usuarioService` (que implementa `UserDetailsService`) se utilizará para cargar los detalles del usuario.
  - **passwordEncoder(passwordEncoder)**: Especifica el codificador de contraseñas a utilizar (probablemente una implementación de `PasswordEncoder`).

### `configure(HttpSecurity http)` Método
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/api/security/oauth/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/productos/listar", "/api/items/listar", "/api/usuarios/usuarios").permitAll()
            .antMatchers(HttpMethod.GET, "/api/productos/ver/{id}", "/api/items/ver/{id}/cantidad/{cantidad}", "/api/usuarios/usuarios/{id}").hasAnyRole("ADMIN", "USER")
            .antMatchers("/api/productos/**", "/api/items/**", "/api/usuarios/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and().cors().configurationSource(corsConfigurationSource())
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    http.authenticationProvider(daoAuthenticationProvider());
    http.authenticationEventPublisher(authenticationEventPublisher());
}
```
- **authorizeRequests()**: Define las reglas de autorización para las solicitudes HTTP.
  - **antMatchers()**: Define patrones de URL y los permisos asociados.
    - **permitAll()**: Permite el acceso sin autenticación.
    - **hasAnyRole("ADMIN", "USER")**: Permite el acceso a usuarios con los roles "ADMIN" o "USER".
    - **hasRole("ADMIN")**: Permite el acceso solo a usuarios con el rol "ADMIN".
  - **anyRequest().authenticated()**: Requiere autenticación para cualquier otra solicitud.
- **cors()**: Configura CORS (Cross-Origin Resource Sharing).
- **csrf().disable()**: Deshabilita la protección CSRF (Cross-Site Request Forgery).
- **sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)**: Configura la gestión de sesiones para ser sin estado, es decir, no se guardará la sesión del usuario en el servidor.
- **addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)**: Añade un filtro antes de `UsernamePasswordAuthenticationFilter` para manejar la autenticación JWT.
- **exceptionHandling().accessDeniedHandler(accessDeniedHandler())**: Configura un manejador para denegaciones de acceso.
- **authenticationProvider(daoAuthenticationProvider())**: Especifica el proveedor de autenticación.
- **authenticationEventPublisher(authenticationEventPublisher())**: Especifica el publicador de eventos de autenticación.

### `daoAuthenticationProvider` Método
```java
@Bean
public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(usuarioService);
    return daoAuthenticationProvider;
}
```
- **daoAuthenticationProvider()**: Crea y configura un `DaoAuthenticationProvider`, que es un proveedor de autenticación basado en un servicio de detalles del usuario (UserDetailsService) y un codificador de contraseñas (PasswordEncoder).

### `authenticationEventPublisher` Método
```java
@Bean
public AuthenticationEventPublisher authenticationEventPublisher() {
    return new DefaultAuthenticationEventPublisher(successErrorHandler);
}
```
- **authenticationEventPublisher()**: Crea un publicador de eventos de autenticación (`AuthenticationEventPublisher`) que utilizará `successErrorHandler` para manejar eventos de éxito y error en la autenticación.

Este conjunto de configuraciones asegura que tu aplicación maneje la autenticación y autorización de manera personalizada, gestionando tanto la seguridad de los endpoints como los eventos relacionados con la autenticación.

### Manejo de error 404 en componente de servicio de usuarios

Si el usuario no existe en el sistema, el servicio de usuarios devuelve un error 404, para manejar este error debemos capturarlo en el servicio de OAuth.

En el servicio de OAuth, en el package **services** creamos la clase **UsuarioService**.

```java
@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {

    @Autowired
    private UsuarioFeignClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = client.findByUsername(username);

            List<GrantedAuthority> authorities = usuario.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                    .peek(authority -> log.info("Role: " + authority.getAuthority()))
                    .collect(Collectors.toList());

            log.info("Usuario autenticado: " + username);

            return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
        } catch (FeignException e) {
            String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
            log.error(error);
            throw new UsernameNotFoundException(error);
        }
        
}
```

## Spring Cloud Gateway Security JWT

La implementación de OAuth2 que implementamos antaeriormente no es compatible con una aplicación reactiva como Spring Cloud Gateway, por lo que hay que hacer esta implementación de otra forma.

Para esto necesitamos dependencias como **JJwt**, **Spring Security**, **Cloud Bootstrap** y **Spring Cloud Config Client**.

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.5</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
    <version>0.12.5</version>
    <scope>runtime</scope>
</dependency>
```

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

También hay que actualizar el archivo **application.yaml**, para incluir los servicios de OAuth y de usuarios.

```yaml
resilience4j:
  circuitbreaker:
    configs:
      defecto:
        sliding-window-size: 6
        failure-rate-threshold: 50
        wait-duration-in-open-state: 20s
        permitted-number-of-calls-in-half-open-state: 4
        slow-call-rate-threshold: 50
        slow-call-duration-threshold: 2s
    instances:
      products:
        base-config: defecto
  timelimiter:
    configs:
      defecto:
        timeout-duration: 2s
    instances:
      products:
        base-config: defecto
spring:
  cloud:
    gateway:
      routes:
        - id: microservice-products
          uri: lb://microservice-products
          predicates:
            - Path=/api/products/**
          filters:
            - name: CircuitBreaker
              args:
                name: products
                statusCodes: 500
                fallbackUri: forward:/api/items/ver/9/cantidad/1
            - StripPrefix=2
            - name: Ejemplo
              args:
                mensaje: Hola Mundo
                cookieName: cookie
                cookieValue: cookieValue
        - id: microservice-item
          uri: lb://microservice-item
          predicates:
            - Path=/api/items/**
          filters:
            - StripPrefix=2
        - id: microservice-oauth
            uri: lb://microservice-oauth
            predicates:
                - Path=/api/security/**
            filters:
                - StripPrefix=2
        - id: microservice-users
            uri: lb://microservice-users
            predicates:
                - Path=/api/users/**
            filters:
                - StripPrefix=2
```

Ademas en al **application.properties** debemos agragar una configuración para el servidor de configuración.

```properties
spring.application.name=gateway-server
server.port=8090

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

spring.config.import=optional:configserver:http://localhost:8888
```

También hay que crear el archivo **bootstrap.properties**.

```properties
spring.application.name=gateway-server
spring.cloud.config.uri=http://localhost:8888
```

### Implementando la clase de configuración SecurityConfig

En el servicio de **Gateway** creamos un nuevo package **security** y dentro la clase **SpringSecurityConfig**.

```java
@EnableWebFluxSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .anyExchange().authenticated()
                .and().csrf().disable()
                .build();
    }
}
```

Con esto estamos indicando que cualquier ruta que no haya sido configurada, es decir, cualquier ruta, va a requerir autenticación.

### Reglas de seguridad para las rutas

Podemos implementar reglas ded seguridad para las rutas, por ejemplo, permitir el acceso a ciertas rutas a usuarios con ciertos roles.

```java
@EnableWebFluxSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/api/security/oauth/**").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/products/list", "/api/items/list", "/api/users/users").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/products/view/{id}", "/api/items/view/{id}/quantity/{quantity}", "/api/users/users/{id}").hasAnyRole("ADMIN", "USER")
                .pathMatchers("/api/products/**", "/api/items/**", "/api/users/**").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and().csrf().disable()
                .build();
    }
}
```

Con **.pathMatchers()** podemos establecer reglas de seguridad para las rutas, como los métodos HTTP que se pueden usar en dichas rutas. 

**.permitAll()** permite el acceso sin autenticación.

**.hasAnyRole("ADMIN", "USER")** permite el acceso a usuarios con los roles "ADMIN" o "USER".

**.hasRole("ADMIN")** permite el acceso solo a usuarios con el rol "ADMIN".

### Introducción a la Programación Reactiva con WebFlux

La programación reactiva está orientada a flujos de datos, somilar a las listas y arreglos pero de manera asíncrona y con programación funcional usando expresiones lambda, nos permite mediante operadores transformar, filtrar, combinar y manipular estos flujos de datos.

#### Características principales

- Inmutable: Cada operación sobre un flujo de datos no modifica el flujo original, sino que crea un nuevo flujo con los cambios.
- Asíncrono: Cada flujo se ejecuta en su propio proceso, permitiendo que múltiples flujos se ejecuten en paralelo, sin afectarse unos a otros.
- Cancelable: Se pueden cancelar las operaciones en cualquier momento, evitando la ejecución de operaciones innecesarias.
- Orientado a eventos: Se basa en la emisión de eventos, permitiendo la reacción a estos eventos de manera eficiente.

#### Tipos de flujo reactivo

- Mono [0..1] (Mono\<T>): Emite 0 o 1 elementos, un solo elemento.
- Flux [0..N] (Flux\<T>): Emite 0 o N elementos, varios elementos.

### Componente Autentication Manager Reactive

El **AuthenticationManager** es el encargado de autenticar a los usuarios, valida el token, la firma de este, etc. Este componente es necesario ya que despues es usado en el filtro de autorización.

Creamos la clase **AuthenticationManagerJwt** en el package **security**.

```java
@Component
public class AuthenticationManagerJwt implements ReactiveAuthenticationManager {

    @Autowired
    private UsuarioService usuarioService;

    @Value("${config.security.oauth.jwt.key}")
    private String secretKey;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.just(authentication.getCredentials().toString())
            .map(toekn -> {
                SecretKey key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(secretKey.getBytes()));

                return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            })
            .map(claims -> {
                String username = claims.get("user_name", String.class);
                List<String> roles = claims.get("authorities", List.class);
                Collection<GrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .collect(Collectors.toList());

                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            });
    }
}
```

Codificamos la clave secreta en Base64 para mayor seguridad. Pero debemos actualizar el método **accesTokenConverter** de la clase **AuthorizationServerConfig** del servicio OAuth2 para que sea compatible con esto

```java
@Bean
public JwtAccessTokenConverter accessTokenConverter() {
    JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
    tokenConverter.setSigningKey(Base64.getEncoder().encodeToString(env.getProperty("config.security.oauth.jwt.key").getBytes()));
    return tokenConverter;
}
```

### Implementando el componente JwtAuthenticationFilter

El **JwtAuthenticationFilter** es un filtro que se encarga de validar el token JWT, este filtro se ejecuta antes de que el servidor procese la petición, si el token es válido, el servidor procesa la petición, si no, el servidor devuelve un error.

Creamos la clase **JwtAuthenticationFilter** en el package **security**.

```java
@Component
public class JwtAuthenticationFilter implements WebFilter {

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
            .filter(authHeader -> authHeader.startsWith("Bearer"))
            .switchIfEmpty(chain.filter(exchange).then(Mono.empty()))
            .map(token -> token.replace("Bearer ", ""))
            .flatMap(token -> authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(null, token)))
            .flatMap(authentication -> chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(authentication)));
    }
}
```

Lo que estamos haciendo es obtener el token del header de la petición, validamos que empiece con "Bearer", si no, continuamos con la petición, si si, quitamos el "Bearer" del token, autenticamos el token y si es válido, continuamos con la petición, si no, devolvemos un error.

### Registrar el Filtro JwtAuthenticationFilter en la configuración de Spring Security

Para registrar el filtro **JwtAuthenticationFilter** en la configuración de Spring Security, debemos agregarlo a la clase **SpringSecurityConfig**.

```java
@EnableWebFluxSecurity
public class SpringSecurityConfig {
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/api/security/oauth/**").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/products/list", "/api/items/list", "/api/users/users").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/products/view/{id}", "/api/items/view/{id}/quantity/{quantity}", "/api/users/users/{id}").hasAnyRole("ADMIN", "USER")
                .pathMatchers("/api/products/**", "/api/items/**", "/api/users/**").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and()
                .addFilterAt(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf().disable()
                .build();
    }
}
```