package com.example.ejercicio.crud.Persona.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @Column(name="id_persona")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "user", nullable = false)
    String user;
    @Column(name = "password",nullable = false)
    String password;
    @Column(name="surname",nullable = false)
    String surname;
    @Column(name = "company_email",nullable = false)
    String company_email;
    @Column(name = "personal_email",nullable = false)
    String personal_email;
    @Column(name = "city",nullable = false)
    String city;
    @Column(name="active",nullable = false)
    Boolean active;
    @Column(name="imagen_url")
    String imagen_url;





        public Persona(PersonaInputDto personaInputDto)
        {
            setUser(personaInputDto.getUser());
            setPassword(personaInputDto.getPassword());
            setSurname(personaInputDto.getSurname());
            setCompany_email(personaInputDto.getCompany_email());
            setPersonal_email(personaInputDto.getPersonal_email());
            setCity(personaInputDto.getCity());
            setActive(personaInputDto.isActive());
            setImagen_url(personaInputDto.getImagen_url());

        }
        public Persona(Long id, PersonaInputDto personaInputDto)
        {
            setId(id);
            setUser(personaInputDto.getUser());
            setPassword(personaInputDto.getPassword());
            setSurname(personaInputDto.getSurname());
            setCompany_email(personaInputDto.getCompany_email());
            setPersonal_email(personaInputDto.getPersonal_email());
            setCity(personaInputDto.getCity());
            setActive(personaInputDto.isActive());
            setImagen_url(personaInputDto.getImagen_url());

        }
        public boolean checkEmail(String email){
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(email);
            if (matcher.find() == true) {
                return true;
            }else{
                return false;
            }
        }
        public boolean checkLength(int min, int max, String s){
            if (s.length()<=max && s.length()>=min) {
                return true;
            }else{
                return false;
            }
        }
    }
