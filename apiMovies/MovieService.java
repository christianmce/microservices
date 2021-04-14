/*** # Autor: Mtro. Christian Mauricio Castillo Estrada  (2021) # ***/
/*** # Facultad de Negocios Campus IV de la UNACH  # ***/

package app.cmce.Moviesapi.service.jpa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import app.cmce.Moviesapi.entity.Movie;
import app.cmce.Moviesapi.repository.MoviesRepository;
import app.cmce.Moviesapi.service.IMovieService;

@Service
public class MovieService implements IMovieService{
	
	@Autowired
	private MoviesRepository repMovie;
	
	@Override
	public List<Movie> consultarLista() {		
		
		return repMovie.findAll();
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

}
