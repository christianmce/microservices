** Ejemplos para el manejo de error en las capas: Controller/Service
//ClienteService.java ----------------------------------------------------------------------------------------------------------
@Override
public Optional<Cliente> consultarCliente(int idC) {
	return Optional.ofNullable(repCliente.findById(idC).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue encontrado")));	
}

---------------------------------------------------------------------------------------------------------------------------------
@GetMapping(path = "/clientes/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
public Optional<Cliente> mostrarUno(@PathVariable("id") int idC){
	return serviceLogNeg.consultarCliente(idC);
}

En el pom.xml añadir:
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
https://www.appsdeveloperblog.com/return-xml-json-spring-mvc/
---------------------------------------------------------------------------------------------------------------------------------
@GetMapping("/clientes")
public ResponseEntity<List<Cliente>> mostrarTodos(){
	try {
		return new ResponseEntity<>(serviceLogNeg.consultarLista(), HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
	
-----------------------------------------------------------------------------------------------------------------------------------------------	
EN EL CONTROLLER DEBE SER ASÍ ------>
@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") int idCat){
		return lognegocioCatego.eliminarCategoria(idCat);        
		
}

EN EL SERVICE COLOCAR LO SIGUIENTE:
@Override
public ResponseEntity<Map<String, String>> eliminarCategoria(int idCat) {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "Ese articulo no fue encontrado");
	    errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
	    
	    Map<String, String> errorResponse2 = new HashMap<>();
		errorResponse2.put("message", "El articulo fue eliminado correctamente");
	    errorResponse2.put("status", HttpStatus.OK.toString());
	    
		return repoCategoria.findById(idCat).map( p -> {
					repoCategoria.deleteById(idCat);
					return new ResponseEntity<>(errorResponse2, HttpStatus.OK);
				})
				.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
}

