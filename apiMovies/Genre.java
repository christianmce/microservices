/*** # Autor: Mtro. Christian Mauricio Castillo Estrada  (2021) # ***/
/*** # Facultad de Negocios Campus IV de la UNACH  # ***/

package app.cmce.Moviesapi.entity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_generos")
public class Genre {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idG")
	private Integer idGen;
	
	@Column(name="Nombre")
	private String GenreName;	
	
	@OneToMany(mappedBy="genre")
	List<Movie> movies;

	public Integer getIdGen() {
		return idGen;
	}

	public void setIdGen(Integer idGen) {
		this.idGen = idGen;
	}

	public String getGenreName() {
		return GenreName;
	}

	public void setGenreName(String genreName) {
		GenreName = genreName;
	}

	@Override
	public String toString() {
		return "Genres [idGen=" + idGen + ", GenreName=" + GenreName + "]";
	}

}
