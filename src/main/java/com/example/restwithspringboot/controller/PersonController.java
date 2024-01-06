package com.example.restwithspringboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restwithspringboot.data.vo.v1.PersonVO;
import com.example.restwithspringboot.data.vo.v2.PersonVOV2;
import com.example.restwithspringboot.services.PersonServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/person")
public class PersonController {

    // Com isso o spring cuida da instanciação da variavel em tempo de execução
    // Precisa da utilização da anotation @Service
    @Autowired
    private PersonServices service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll(){
            return service.findAll();
    }

    // Entre chaves é necessário passar parâmetros obrigatórios
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") Long id){
            return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO PersonVO){
            return service.create(PersonVO);
    }

    @PostMapping(value = "/v2",consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
            return service.createV2(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO PersonVO){
            return service.update(PersonVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
            service.delete(id);

            // Retorna o status code correto, nesse caso o status 204
            return ResponseEntity.noContent().build();
    }

   
   
}
