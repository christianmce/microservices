## ------------------------------------------------------------------------------------------------------------------------>>>
//Añadir en el archivo de interfaz JpaRepository

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {
	@Query ("select o from Categoria o where o.nombreCat like %?1")
	List<Categoria> findByNombre(String nombre);
}


## ------------------------------------------------------------------------------------------------------------------------>>>

//Añadir en la clase de servicio de datos

@Override
public List<Categoria> consultarbyNombre(String nombre) {		
	return repoCategoria.findByNombre(nombre);
}

## ------------------------------------------------------------------------------------------------------------------------>>>
//Añadir en la clase de Controller

@GetMapping("/categorias/nom/{nom}")
	public List<Categoria> muestraporNombre(@PathVariable("nom") String nom){
		return lognegocioCatego.consultarbyNombre(nom);
	}

## ------------------------------------------------------------------------------------------------------------------------>>>

https://www.arquitecturajava.com/spring-data-custom-query/
https://www.baeldung.com/jpa-query-parameters
