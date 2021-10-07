package com.example.ejercicio.crud.Persona.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDto {
    private Long id;

    private String user;

    private String password;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private boolean active;

    private String imagen_url;


    public PersonaOutputDto(Persona persona) {

        setId(persona.getId());
        setUser(persona.getUser());
        setPassword(persona.getPassword());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setImagen_url(persona.getImagen_url());
    }

}
