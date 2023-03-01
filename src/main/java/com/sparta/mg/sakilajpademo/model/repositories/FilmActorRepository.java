package com.sparta.mg.sakilajpademo.model.repositories;

import com.sparta.mg.sakilajpademo.model.entities.Actor;
import com.sparta.mg.sakilajpademo.model.entities.FilmActor;
import com.sparta.mg.sakilajpademo.model.entities.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {

    @Query(value  = "SELECT Count(sakila.film.film_id) FROM sakila.film \n" +
            "JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id \n" +
            "where sakila.film_actor.actor_id = :actorId", nativeQuery = true)
    List<Integer> findMoviesActorActedInByActorID(@Param("actorId") int id);


//    @Query(value  = "Select distinct sakila.actor.actor_id, sakila.film_actor.film_id, sakila.actor.first_name, sakila.actor.last_name, sakila.actor.last_update\n" +
//            "from sakila.actor, sakila.film_actor\n" +
//            "where sakila.actor.actor_id = sakila.film_actor.actor_id\n" +
//            "and sakila.film_actor.film_id = :filmId", nativeQuery = true)
//    List<FilmActor>findActorsByMovie(@Param("filmId") Integer id);

    @Query(value = "Select e from Actor e WHERE e.id IN ( SELECT fa.id.actorId FROM FilmActor fa WHERE fa.id.filmId = :filmId)")
    List<Actor> getActorsByFilm_idJPQL(@Param("filmId") Integer filmId);


}