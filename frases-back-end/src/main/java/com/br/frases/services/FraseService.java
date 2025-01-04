package com.br.frases.services;

import com.br.frases.dto.FraseDTO;
import com.br.frases.model.Frase;
import com.br.frases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repositorio;

    public FraseDTO obterFraseAleatoria() {
        Long id = 0L;
        Frase frase = repositorio.findById(id).get();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }
}
