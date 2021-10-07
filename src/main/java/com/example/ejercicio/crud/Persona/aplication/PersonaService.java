package com.example.ejercicio.crud.Persona.aplication;

import com.example.ejercicio.crud.Persona.domain.Persona;
import com.example.ejercicio.crud.Persona.domain.PersonaInputDto;
import com.example.ejercicio.crud.Persona.domain.PersonaOutputDto;
import com.example.ejercicio.crud.Persona.infrastructure.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public List<PersonaOutputDto> findAll() throws Exception {
        try{
            List<PersonaOutputDto> entitiesDto = new ArrayList();
            List<Persona> entities = personaRepository.findAll();
            ModelMapper modelMapper = new ModelMapper();
            for (Persona persona : entities){
                entitiesDto.add(new PersonaOutputDto(persona));
            }
            return entitiesDto;
        }catch(Exception e){
            throw new Exception("Error, no se encuentra ningun usuario");
        }
    }

    @Override
    public PersonaOutputDto findById(Long id) throws Exception {
            Persona persona = personaRepository.findById(id).orElseThrow(()-> new Exception("La persona con el id: " + id + " no existe"));
            PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
            return personaOutputDto;

    }

    public PersonaOutputDto findByUser(String user) throws Exception {
        try{
            Persona persona = personaRepository.findByUser(user);
            PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
            return personaOutputDto;
        }catch(Exception e){
            throw new Exception("Usuario no encontrado");
        }
    }

    @Override
    public PersonaOutputDto savePersona(PersonaInputDto personaInputDto) throws Exception {
            Persona persona = new Persona(personaInputDto);
            if(!persona.checkEmail(persona.getCompany_email())||!persona.checkEmail(persona.getPersonal_email())){
                throw new Exception("El email entroducido no es valido");
            }
            if(!persona.checkLength(6,10, persona.getUser())){
                throw new Exception("El nombre del usuario no cumple los requsitos de longitud (min:6, max:10)");
            }
            personaRepository.save(persona);
            return new PersonaOutputDto(persona);

    }

    @Override
    public PersonaOutputDto update(Long id, PersonaInputDto personaInputDto) throws Exception {
            Persona persona = new Persona(id, personaInputDto);
            if(!persona.checkEmail(persona.getCompany_email())||!persona.checkEmail(persona.getPersonal_email())){
                throw new Exception("El email introducido no es valido");
            }
            if(!persona.checkLength(6,10, persona.getUser())){
                throw new Exception("El nombre del usuario no cumple los requsitos de longitud (min:6, max:10)");
            }
            persona  = personaRepository.save(persona);
            return new PersonaOutputDto(persona);

    }

    @Override
    public boolean delete(Long id) throws Exception {
            if(personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception("No existe un usuario con el id: " + id + " en la aplicación");
            }
    }
}
