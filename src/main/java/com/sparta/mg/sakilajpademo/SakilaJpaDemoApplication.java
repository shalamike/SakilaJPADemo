package com.sparta.mg.sakilajpademo;

import com.sparta.mg.sakilajpademo.model.entities.Actor;
import com.sparta.mg.sakilajpademo.model.entities.FilmActor;
import com.sparta.mg.sakilajpademo.model.repositories.ActorRepository;
import com.sparta.mg.sakilajpademo.model.repositories.FilmActorRepository;
import com.sparta.mg.sakilajpademo.model.repositories.FilmRepository;
import com.sparta.mg.sakilajpademo.service.ActorService;
import com.sparta.mg.sakilajpademo.service.FilmActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SakilaJpaDemoApplication {

    private Logger logger = LoggerFactory.getLogger(SakilaJpaDemoApplication.class);
    private final FilmRepository filmRepository;

    public SakilaJpaDemoApplication(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SakilaJpaDemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(ActorRepository actorRepository){
//        return args -> logger.info(actorRepository.findAll().toString());
//    }

//    @Bean
//    public CommandLineRunner runner(ActorRepository actorRepository){
//        return args -> logger.info(actorRepository.findActorByLength(3).toString());
//    }

//    @Bean
//    public CommandLineRunner runner(ActorRepository actorRepository){
//        return args -> logger.info(actorRepository.findActorByNativeLength(4).toString());
//    }

//    @Bean
//    public CommandLineRunner runner(ActorRepository actorRepository){
//        return args -> logger.info(actorRepository.findActorByFirstNameIs("joe").toString());
//    }

//    @Bean
//    public CommandLineRunner runner(ActorService actorService){
//        return args -> actorService.printEverything();
//    }

//    @Bean
//    public CommandLineRunner runner(FilmActorRepository filmActorRepository){
//        return args -> logger.info("" + filmActorRepository.findMoviesActorActedInByActorID(6));
//    }

//    @Bean
//    public CommandLineRunner runner(FilmRepository filmRepository, ActorRepository actorRepository){
//        ArrayList<Optional<Actor>> actors = new ArrayList<>();
//        for (Integer id: filmRepository.findActorsByMovie(6)) {
//            actors.add(actorRepository.findById(id));
//        }
//        return args -> logger.info("" + actors.toString());
//    }

//    @Bean
//    public CommandLineRunner runner(FilmActorRepository filmActorRepository){
//        return args -> logger.info(filmActorRepository.findActorsByMovie(6).toString());
//    }

//    @Bean
//    public CommandLineRunner runner(FilmActorRepository filmActorRepository) {
//        return args -> {
//            for (Actor a: filmActorRepository.getActorsByFilm_idJPQL(6)) {
//                logger.info(a.toString());
//            }
//
//        };
//    }

//    @Bean
//    public CommandLineRunner runner3(FilmRepository filmRepository) {
//        return args -> {
//            List<Actor> actors = new ArrayList<>();
//            List<Object[]> objectActors = filmRepository.getActorsByFilm_id(3);
//            for (Object[] o : objectActors) {
//                Actor actor = new Actor();
//                actor.setId(Integer.valueOf((Short) o[0]));
//                actor.setFirstName((String) o[1]);
//                actor.setLastName((String) o[2]);
//                actor.setLastUpdate(((Timestamp) o[3]).toInstant());
//                actors.add(actor);
//                logger.info(Arrays.toString(o));
//            }
//            logger.info(actors.toString());
//        };
//    }

//        @Bean
//    public CommandLineRunner runner(FilmActorRepository filmActorRepository){
//
//        return args -> logger.info(filmActorRepository.findActorsByMovie(6).toString());
//    }

    @Bean
    public CommandLineRunner runner(FilmActorService filmActorService) {
        return args -> {
            for (Actor a: filmActorService.getActorsByMovieIdJPQL(6)) {
                logger.info(a.toString());
            }

        };
    }

}
