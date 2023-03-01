package com.sparta.mg.sakilajpademo.service;


import com.sparta.mg.sakilajpademo.model.entities.Actor;
import com.sparta.mg.sakilajpademo.model.entities.FilmActor;
import com.sparta.mg.sakilajpademo.model.repositories.ActorRepository;
import com.sparta.mg.sakilajpademo.model.repositories.FilmActorRepository;
import com.sparta.mg.sakilajpademo.model.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmActorService {

    private final FilmActorRepository filmActorRepository;
    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;


    @Autowired
    public FilmActorService(FilmActorRepository filmActorRepository, FilmRepository filmRepository, ActorRepository actorRepository) {
        this.filmActorRepository = filmActorRepository;
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;

    }

    public List<Actor> getActorsByMovieIdJPQL(int id){
        return filmActorRepository.getActorsByFilm_idJPQL(id);
    }

}
