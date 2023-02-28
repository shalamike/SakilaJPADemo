package com.sparta.mg.sakilajpademo.model.repositories;

import com.sparta.mg.sakilajpademo.model.entities.Actor;
import com.sparta.mg.sakilajpademo.model.entities.Film;
import com.sparta.mg.sakilajpademo.model.entities.FilmActor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(value  = "Select distinct sakila.actor.actor_id, sakila.actor.first_name, sakila.actor.last_name, sakila.actor.last_update\n" +
            "from sakila.actor, sakila.film_actor\n" +
            "where sakila.actor.actor_id = sakila.film_actor.actor_id\n" +
            "and sakila.film_actor.film_id = :filmId", nativeQuery = true)
    List<Integer>findActorsByMovie(@Param("filmId") Integer id);


//    @Query(value = "Select * from sakila.actor \n" + "WHERE sakila.actor.actor_id IN (\n" + "SELECT sakila.film_actor.actor_id FROM sakila.film_actor\n" + "WHERE sakila.film_actor.film_id = :filmId)", nativeQuery = true)
//    List<Object[]> getActorsByFilm_id(@Param("filmId") Integer filmId);

}