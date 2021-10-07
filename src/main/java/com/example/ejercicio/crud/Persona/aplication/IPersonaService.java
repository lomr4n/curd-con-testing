package com.example.ejercicio.crud.Persona.aplication;

import com.example.ejercicio.crud.Persona.domain.PersonaInputDto;
import com.example.ejercicio.crud.Persona.domain.PersonaOutputDto;

import java.util.List;

public interface IPersonaService {
    public List<PersonaOutputDto> findAll() throws Exception;
    public PersonaOutputDto findById(Long id) throws Exception;
    public PersonaOutputDto findByUser(String user) throws Exception;
    public PersonaOutputDto savePersona(PersonaInputDto persona) throws Exception;
    public PersonaOutputDto update(Long id, PersonaInputDto persona) throws Exception;
    public boolean delete(Long id) throws Exception;
}
