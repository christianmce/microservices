package app.cmce.Moviesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.cmce.Moviesapi.entity.Movie;

public interface MoviesRepository extends JpaRepository<Movie, Integer> {

}
