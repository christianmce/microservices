//Añadir en el archivo de interfaz 

public interface IClientejpa extends JpaRepository<Cliente, Integer>{
	@Query ("select o from Ofertas o where o.fecha=>?")
	List<Cliente> findByFecha();
}


//Añadir en la clase de servicio de datos

@Override
	public List<Cliente> BuscarporFecha() {
		
		return repCliente.findByFecha();
		
	}

https://www.arquitecturajava.com/spring-data-custom-query/

https://www.baeldung.com/jpa-query-parameters
