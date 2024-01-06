package com.example.restwithspringboot.services;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restwithspringboot.data.vo.v1.PersonVO;
import com.example.restwithspringboot.data.vo.v2.PersonVOV2;
import com.example.restwithspringboot.model.Person;
import com.example.restwithspringboot.exceptions.ResourceNotFoundException;
import com.example.restwithspringboot.mapper.DozerMapper;
import com.example.restwithspringboot.mapper.custom.PersonMapper;
import com.example.restwithspringboot.repository.PersonRepository;

// Utilizado pelo spring para injetar dados em outras classes durante a aplicação
@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll(){
        logger.info("Finding All people");
        
        return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        logger.info("Creating one person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person){
        logger.info("Creating one person with birthday");
        var entity = mapper.convertVoToEntity(person);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person){
        logger.info("Updating one people");

        // Procura a pessoa pelo Id e após achar coloca em um atributo
        // para poder mudar os atributos
        var entity = repository.findById(person.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAdress(person.getAdress());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting one people");

        var entity = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));

        repository.delete(entity);
    }

    public PersonVO findById(Long id){
        logger.info("Finding one person");

        var entity = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }
}
