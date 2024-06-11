package com.reactive.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.reactive.app.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FluxLearnTest {

@Autowired
private FluxLearnService service;

@Test
public void testing(){
   // this.service.fluxTestingService();
//    service.getFlux().subscribe(data->{
//        System.out.println(data);
//        System.out.println("Dono with flux data");
//    });
    service.fruitFlux().subscribe(System.out::println);


}

@Test
public void mapTest(){
    service.mapExample().subscribe(data->{
        System.out.println(data);
    });
}



}
