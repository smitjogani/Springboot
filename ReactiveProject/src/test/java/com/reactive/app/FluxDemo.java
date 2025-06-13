package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxDemo {
    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    public void fluxTest() {
        fluxLearnService
                .getFlux()
                .subscribe(data -> {
                    System.out.println(data);
                    System.out.println("done with flux data");
                });
        System.out.println("--------------------------------------");
        fluxLearnService.fruitFlux().subscribe(System.out::println);
    }

    @Test
    public void mapTest() {
        //fluxLearnService.mapExampleFlux().subscribe(System.out::println);
        Flux<String> capFlux = fluxLearnService.mapExampleFlux();
        StepVerifier.create(capFlux)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void filterTest() {
        Flux<String> filterFlux = fluxLearnService.filterExampleFlux();
        StepVerifier.create(filterFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void flatmapTest() {
        Flux<String> stringFlux = fluxLearnService.flatmapExample();
        StepVerifier.create(stringFlux)
                .expectNextCount(21)
                .verifyComplete();
    }

    @Test
    void transformExampleTest() {
        Flux flux = fluxLearnService.transformExample();
        StepVerifier
                .create(flux)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void  ifExampleTest()
    {
        Flux<String> stringFlux = fluxLearnService.ifExample(3);
        StepVerifier.create(stringFlux).expectNextCount(4).verifyComplete();
    }
}
