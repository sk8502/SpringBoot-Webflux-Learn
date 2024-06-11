package com.reactive.app.services;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class FluxLearnService {

// public void fluxTestingService(){
//        System.out.println("Flux testing services");
//
//    }

    //All operaqtors example goes here

    public Flux<String> getFlux(){
        return Flux.just("Sk","rohit").log();
    }

    public Flux<String> fruitFlux(){
        List<String> fruits=List.of("Mango","Apple");
        return Flux.fromIterable(fruits).log();
    }

    public Flux<String> mapExample(){
        Flux<String> map = getFlux().map(String::toUpperCase).log();
   return map;
    }
}
