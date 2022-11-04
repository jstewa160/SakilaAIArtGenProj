package APIComponents.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

    @Query(value = "SELECT sakila.film.* FROM sakila.film " +
            "INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id " +
            "INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id " +
            "WHERE actor.first_name = ?1", nativeQuery = true)
    List<Film> findByActor(String first_name);


}
