package com.sparta.mg.sakilajpademo.service;

import com.sparta.mg.sakilajpademo.model.entities.Actor;
import com.sparta.mg.sakilajpademo.model.repositories.ActorRepository;
import com.sparta.mg.sakilajpademo.model.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service  //service acts very similar to the way been does in the way it gives java permission to create an object of the service type
public class ActorService {

    private final ActorRepository actorRepository;

    private final FilmRepository filmRepository;

    @Autowired //the purpose of autowired
    public ActorService (ActorRepository actorRepository, FilmRepository filmRepository){
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    public void printEverything(){
        System.out.println(actorRepository.findAll().toString());
        System.out.println(filmRepository.findAll().toString());
    }

    public List<Optional<Actor>> findActorsByMovie(int filmId){
        ArrayList<Optional<Actor>> actors = new ArrayList<>();
        for (Integer actorId: filmRepository.findActorsByMovie(filmId)) {
            actors.add(actorRepository.findById(actorId));
        }
        return actors;
    }
}
