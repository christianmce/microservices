
//Es necesario añadir una nueva dependencia en el archivo pom.xml para activar el librería de transformación de datos a XML

@GetMapping(path = "/clientes/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
public Optional<Cliente> mostrarUno(@PathVariable("id") int idC){
	return serviceLogNeg.consultarCliente(idC);
}



//En el pom.xml añadir:
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>

https://www.appsdeveloperblog.com/return-xml-json-spring-mvc/
---------------------------------------------------------------------------------------------------------------------------------
	
