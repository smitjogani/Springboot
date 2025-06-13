package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveProjectApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ReactiveProjectApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    void workingWithMono() {
        //Create Mono
        Mono<String> errorMono = Mono
                .error(new RuntimeException("Error !"));

        Mono<String> m2b = Mono
                .just("Learning Map")
                .map(data -> {
                    return "Jenish";
                });

        StepVerifier.create(m2b).consumeNextWith(s -> {
            Assert.isTrue(s == "Jenish", "does not match");
        });

        Mono<String> m1 = Mono
                .just("Learning Reactive API")
                .log()
                .then(errorMono);

        Mono<String> m2 = Mono
                .just("First Mono for Zip");

        Mono<String> m3 = Mono
                .just("Second Mono for Zip");
        Mono<Integer> m4 = Mono
                .just(1234);

        //Zip the mono
        Mono<Tuple3<String, String, Integer>> combinedMono = Mono.zip(m2,m3, m4);
        Mono<Tuple2<String, String>> combinedWithZipWith = m2.zipWith(m3);
        Flux<String> stringFlux = m1.flatMapMany(valueM1 -> Flux.just(valueM1.split(" "))).log();

        //Consume mono by subscribing
        m1.subscribe(System.out::println);
        errorMono.subscribe(System.out::println);
        combinedMono.subscribe(System.out::println);
        combinedWithZipWith.subscribe(System.out::println);
        stringFlux.subscribe(System.out::println);
    }
}
