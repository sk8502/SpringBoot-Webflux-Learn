package com.reactive.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SpringBootTest
class ReactiveMonoApplicationTests {

	@Test
	void contextLoads() {
	}
@Test
	void workingWithMono() {

//	Mono<Object> errorMono =Mono.error(new RuntimeException("Error !!!!"));
//
//	Mono<Object> m1 = Mono.just("learn codw iwth sk")
//			.log()
//			.then(errorMono);
//
//	m1.subscribe(data->{
//		System.out.println("Datat is   --  "+data);
//	});
//
//	errorMono.subscribe(System.out::println);


	Mono<String > m1=Mono.just("learn with skssss");
	Mono<String > m2=Mono.just("NHK ho");


	Mono<String> s=m1.map(item -> item.toUpperCase());
	s.subscribe(System.out::println);

	Mono<String[]> mono = s.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
	mono.subscribe(data->{
		for (String a :data){
			System.out.println(a);
		}
	});


	//	Mono<Tuple2<String,String>> combine=Mono.zip(m1,m2);
//
//	combine.subscribe(data->{
//		System.out.println(data.getT1());
//		System.out.println(data.getT2());
//	});

}

}
