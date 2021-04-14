/*** # Autor: Mtro. Christian Mauricio Castillo Estrada  (2021) # ***/
/*** # Facultad de Negocios Campus IV de la UNACH  # ***/

package app.cmce.Moviesapi.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_peliculas")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idM")
	private Integer idMovie;

	@Column(name = "TituloMovie")
	private String NameMovie;

	@Column(name = "Year")
	private Integer Year;

	@ManyToOne
	@JoinColumn(name = "idG")
	private Genre genre;

	public Integer getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}

	public String getNameMovie() {
		return NameMovie;
	}

	public void setNameMovie(String nameMovie) {
		NameMovie = nameMovie;
	}

	public Integer getYear() {
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movies [idMovie=" + idMovie + ", NameMovie=" + NameMovie + ", Year=" + Year + ", genre=" + genre + "]";
	}

}
