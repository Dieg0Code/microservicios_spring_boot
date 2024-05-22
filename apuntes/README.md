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
server.port=8001
```

Y en ese archivo podemos establecer las configuraciones que queremos que tengan nuestros microservicios.