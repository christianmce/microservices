
package app.cmce.Moviesapi.service;
import java.util.List;
import app.cmce.Moviesapi.entity.Movie;

public interface IMovieService {
	
	List<Movie> consultarLista();   
	void actualizarGenero(Movie obj,int idGen);
	void insertarGenero(Movie obj);	
	void eliminarGenero(int idGen);
	
}
