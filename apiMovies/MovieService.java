package app.cmce.Moviesapi.service.jpa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import app.cmce.Moviesapi.entity.Movie;
import app.cmce.Moviesapi.repository.MoviesRepository;
import app.cmce.Moviesapi.service.IMovieService;

public class MovieService implements IMovieService{
	
	@Autowired
	private MoviesRepository repMovie;
	
	@Override
	public List<Movie> consultarLista() {		
		
		return repMovie.findAll();
	}
	
	public void insertarGenero(Movie obj) {
		repMovie.save(obj);  //SpringDataJPA
	}
	
	public void actualizarGenero(Movie obj,int idMov) {
		//obj.setIdGen(idMov);
		repMovie.save(obj);  //SpringDataJPA
	}
	
	public void eliminarGenero(int idMov) {
		repMovie.deleteById(idMov); //SpringDataJPA
	}

}
