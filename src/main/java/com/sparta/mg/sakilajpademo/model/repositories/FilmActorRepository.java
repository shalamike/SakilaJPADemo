package com.sparta.mg.sakilajpademo.model.repositories;

import com.sparta.mg.sakilajpademo.model.entities.FilmActor;
import com.sparta.mg.sakilajpademo.model.entities.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {

    @Query(value  = "SELECT Count(sakila.film.film_id) FROM sakila.film \n" +
            "JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id \n" +
            "where sakila.film_actor.actor_id = :actorId", nativeQuery = true)
    int findMoviesActorActedInByActorID(@Param("actorId") int id);
}