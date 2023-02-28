package com.sparta.mg.sakilajpademo.model.repositories;

import com.sparta.mg.sakilajpademo.model.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    //param sets the userNameLength in the query to the Integer length in the mehtod parameter
    // if we dont use nativeQuery, then spring will by default assume its a JPQL query
    @Query(value  = "SELECT * from actor where length(first_name) = :userNameLength", nativeQuery = true)
    List<Actor>findActorByLength(@Param("userNameLength") Integer length);


    //this is using JPQL Java Persistance Query Language (this is the most common method)
    //in this query it points to the class actor rather than the table
    //Note how Intellij is tellung us how declaring NativeQuery is false is redundant as by default
    //Spring will use JPQL queries
    @Query(value = "SELECT a from Actor a where LENGTH(a.firstName) = :length ", nativeQuery = false)
    List<Actor> findActorByNativeLength(Integer length);

    //just by using an appropriate name that intellij will help you construct,
    //we can build a repository method that generates a query just from the methods name
    //therefore no sql or jpqa queries required
    List<Actor>findActorByFirstNameIsLessThan(Integer length);

    List<Actor>findActorByFirstNameIs(String name);
}