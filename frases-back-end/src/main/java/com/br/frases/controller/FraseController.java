package com.br.frases.controller;

import com.br.frases.dto.FraseDTO;
import com.br.frases.model.Frase;
import com.br.frases.services.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class FraseController {

    @Autowired
    private FraseService servico;

    @GetMapping("/frases")
    public FraseDTO frases() {
        return servico.obterFraseAleatoria();
    }
}
