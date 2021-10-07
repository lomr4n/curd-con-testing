package com.example.ejercicio.crud.Persona.infrastructure.repository;

import com.example.ejercicio.crud.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByUser(String user);
}
