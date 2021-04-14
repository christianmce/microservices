/*** # Autor: Mtro. Christian Mauricio Castillo Estrada  (2021) # ***/
/*** # Facultad de Negocios Campus IV de la UNACH  # ***/

package app.cmce.Moviesapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import app.cmce.Moviesapi.entity.Movie;
import app.cmce.Moviesapi.service.IMovieService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api")
public class MoviesController {
	
	@Autowired
	private IMovieService serviceMovies;
	
	@GetMapping("/peliculas")
	public List<Movie> mostrarTodos(){
		return serviceMovies.consultarLista();
	}
	
	@GetMapping("/peliculas/{id}")
	public String localizar(@PathVariable("id") int idG){
		return "localizado";
	}
	
	@PostMapping("/peliculas")
	public Movie insertar(@RequestBody Movie obj){
		serviceMovies.insertarPelicula(obj);
		return obj;
	}
	
	@PutMapping("/peliculas/{id}")
	public Movie actualizar(@RequestBody Movie obj,@PathVariable("id") int idMovie){
		serviceMovies.actualizarPelicula(obj,idMovie);
		return obj;
	}
	
	@DeleteMapping("/peliculas/{id}")
	public String eliminar(@PathVariable("id") int idMovie){
		serviceMovies.eliminarPelicula(idMovie);
		return "1";
	}
}
