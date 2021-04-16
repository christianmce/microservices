@Service
public class MovieService implements IMovieService{
	
	@Autowired
	private MoviesRepository repMovie;
		
	public List<Movie> consultarLista() {	
		return repMovie.findAll();
	}
	
	@HystrixCommand(fallbackMethod="getFallbackPeliculas")
	public String consultarPelicula() {		
		return "Titulo Pelicula Matrix";
	}
	
	public void insertarPelicula(Movie obj) {
		repMovie.save(obj);  //SpringDataJPA
	}
	
	public void actualizarPelicula(Movie obj,int idMov) {
		obj.setIdMovie(idMov);
		repMovie.save(obj);  //SpringDataJPA
	}
	
	public void eliminarPelicula(int idMov) {
		repMovie.deleteById(idMov); //SpringDataJPA
	}
	
	public String getFallbackPeliculas() {	
		return "Error al seleccionar una pelicula";
	}

}
