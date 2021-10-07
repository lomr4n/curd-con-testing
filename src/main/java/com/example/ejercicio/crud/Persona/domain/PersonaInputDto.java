package com.example.ejercicio.crud.Persona.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDto {

    private String user;

    private String password;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private boolean active;

    private String imagen_url;

    private Date termination_date;



}
