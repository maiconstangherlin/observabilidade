package com.maiconstangherlin.observabilidade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @GetMapping
    List<String> findAll() {
        return List.of("Fulano", "Ciclano");
    }

}
