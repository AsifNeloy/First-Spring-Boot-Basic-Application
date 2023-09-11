package com.secondTry.ShouldWork.controllers;

import com.secondTry.ShouldWork.dtos.HumanDTO;
import com.secondTry.ShouldWork.entity.Human;

import com.secondTry.ShouldWork.services.impl.HumanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/human")
public class HumanController {

    @Autowired
    HumanServiceImpl humanService;

    @GetMapping("/all")
    public ResponseEntity<List<HumanDTO>> showAll(){
        List<HumanDTO> humanDTOS = humanService.findAll();
        return new ResponseEntity<List<HumanDTO>>(humanDTOS, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HumanDTO> findById(@PathVariable("id") Integer id){

        HumanDTO foundHuman = humanService.findById(id);
        return new ResponseEntity<HumanDTO>(foundHuman, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Human> save(@RequestBody Human h){

        Human human = humanService.save(h);
        return new ResponseEntity<>(human, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        humanService.deleteById(id);
        return new ResponseEntity<>("Information Deleted!", HttpStatus.OK);
    }
}
