package com.br.frases.repository;

import com.br.frases.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface FraseRepository extends JpaRepository<Frase, Long> {
    @Query("SELECT f FROM Frase f ORDER BY RANDOM() LIMIT 1")
    Optional<Frase> findById(Long id);
}
