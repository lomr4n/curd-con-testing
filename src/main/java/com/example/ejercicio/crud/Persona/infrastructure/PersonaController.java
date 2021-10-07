package com.example.ejercicio.crud.Persona.infrastructure;

import com.example.ejercicio.crud.Persona.aplication.IPersonaService;
import com.example.ejercicio.crud.Persona.domain.PersonaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        System.err.print("getAll() Metodo del controller");
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        System.err.print("getOne() Metodo del controller");
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/usuario/{user}")
    public ResponseEntity<?> getOneByUser(@PathVariable String user){
        System.err.print("getOneByUser() Metodo del controller");
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findByUser(user));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PersonaInputDto personaInputDto){
        System.err.print("save() Metodo del controller");

        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.savePersona(personaInputDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody PersonaInputDto entity){
        System.err.print("update() Metodo del controller");

        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        System.err.print("delete() Metodo del controller");
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
