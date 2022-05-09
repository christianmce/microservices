** Ejemplos para el manejo de error en las capas: Controller/Service
//CategoriaService.java ----------------------------------------------------------------------------------------------------------
import com.app.nomproyecto.exception.ResourceNotFoundException;

@Override
public ResponseEntity<Categoria> consultarUno(int idCat) {
	Categoria obj = repoCategoria.findById(idCat).orElseThrow(() -> new ResourceNotFoundException("No existe categoría con el Id :" + idCat));
	return ResponseEntity.ok(obj);
}

---------------------------------------------------------------------------------------------------------------------------------
//Es necesario crear un subpaquete de excepcion y añadir una nueva clase llamada ResourceNotFound
package com.app.seminario.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}	



-----------------------------------------------------------------------------------------------------------------------------------------------	>>>>
//EN LA CLASE CONTROLLER DEBE AÑADIR EL SIGUIENTE CODIGO:
@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") int idCat){
		return lognegocioCatego.eliminarCategoria(idCat);        
		
}

//EN LA CLASE DE SERVICE COLOCAR LO SIGUIENTE:
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
				}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));
}

