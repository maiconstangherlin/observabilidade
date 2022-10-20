package com.maiconstangherlin.observabilidade.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private MeterRegistry meterRegistry;
    private List<String> temporaryList = new ArrayList<>();

    public PersonController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        Gauge.builder("person.temporary.list", temporaryList, List::size)
                .register(meterRegistry);
    }

    @GetMapping("/women")
    List<String> findAllWomen() {
        Counter.builder("person.calls")
                .description("Total calls of ")
                .tag("sex", "feminine")
                .register(meterRegistry)
                .increment();

        temporaryList.add("feminine");

        return List.of("Fulana", "Ciclana");
    }

    @GetMapping("/men")
    List<String> findAllMen() {
        Counter.builder("person.calls")
                .description("Total calls of ")
                .tag("sex", "masculine")
                .register(meterRegistry)
                .increment();

        temporaryList.add("masculine");

        return List.of("Fulano", "Ciclano");
    }

    @Timed(value = "person.delete.time")
    @DeleteMapping
    void deleteTemporaryList() {
        temporaryList.clear();
    }

}
