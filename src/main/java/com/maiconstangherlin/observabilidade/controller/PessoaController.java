package com.maiconstangherlin.observabilidade.controller;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private MeterRegistry meterRegistry;

    public PessoaController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        Gauge.builder("total_de_pessoas_online", Math::random)
                .description("Número total de pessoas online")
                .register(meterRegistry);
    }

    @GetMapping("/women")
    List<String> findAllWomen() {
        meterRegistry.counter("total_de_chamadas", "sexo", "feminino").increment();
        return List.of("Fulana", "Ciclana");
    }

    @GetMapping("/men")
    List<String> findAllMen() {
        meterRegistry.counter("total_de_chamadas", "sexo", "masculino").increment();
        return List.of("Fulano", "Ciclano");
    }

}
