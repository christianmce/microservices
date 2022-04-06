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
	
---------------------------------------------------------------------------------------------------------------------------------	
@DeleteMapping("/{id}")
public void deletePost(@PathVariable("id") int idC)
{
        Post post = postRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("No post found with id="+id));
        try {
		postRepository.deleteById(post.getId());
	} catch (Exception e) {
		throw new PostDeletionException("Post with id="+id+" can't be deleted");
	}      
	return ResponseEntity.ok().body("User deleted with success!");     
}

---------------------------------------------------------------------------------------------------------------------------------	
@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<UserRest> create(@Valid @RequestBody UserRest userRest) {
    System.out.println(userRest);
    userRest.setUserId("");
    return new ResponseEntity<>(userRest, HttpStatus.OK);
}

