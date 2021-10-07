package com.example.ejercicio.crud;

import com.example.ejercicio.crud.Persona.domain.Persona;
import com.example.ejercicio.crud.Persona.infrastructure.PersonaController;
import com.example.ejercicio.crud.Persona.infrastructure.repository.PersonaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MockTest {
    @Mock
    PersonaRepository personaRepository;

    @Mock
    PersonaController personaController;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void getReady(){
        Persona persona = new Persona();
        persona.setId(1L);
        persona.setUser("Javier");
        persona.setSurname("Marmol");
        persona.setPersonal_email("javier.marmol@gmail.com");
        persona.setCompany_email("javier.marmol@bosonit.com");
        persona.setPassword("1234");
        persona.setActive(true);
        persona.setCity("Logroño");
        persona.setImagen_url("https://googles.es");
    }
    @Test
    @DisplayName("Metodo getOne del persona controller con Mockito")
    void getTest(){
        Mockito.when(personaRepository.findAll()).thenReturn(new ArrayList<Persona>());
        List<Persona> personas=(List<Persona>)personaController.getAll().getBody();
        Assertions.assertEquals(0,personas.size());
    }
}