package com.sparta.mg.sakilajpademo;

import com.sparta.mg.sakilajpademo.model.entities.Actor;
import com.sparta.mg.sakilajpademo.model.repositories.ActorRepository;
import com.sparta.mg.sakilajpademo.model.repositories.FilmRepository;
import com.sparta.mg.sakilajpademo.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
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

    @Bean
    public CommandLineRunner runner(ActorService service){
        return args -> logger.info(service.findActorsByMovie(6).toString());
    }

}
