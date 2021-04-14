/*** # Autor: Mtro. Christian Mauricio Castillo Estrada  (2021) # ***/
/*** # Facultad de Negocios Campus IV de la UNACH  # ***/

package app.cmce.Moviesapi.service;
import java.util.List;
import app.cmce.Moviesapi.entity.Movie;

public interface IMovieService {
	
	List<Movie> consultarLista();   
	void actualizarPelicula(Movie obj,int idMovie);
	void insertarPelicula(Movie obj);	
	void eliminarPelicula(int idMovie);
	
}
