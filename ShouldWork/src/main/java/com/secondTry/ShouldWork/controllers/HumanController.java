package com.secondTry.ShouldWork.controllers;

import com.secondTry.ShouldWork.dtos.HumanDTO;
import com.secondTry.ShouldWork.entity.Human;

import com.secondTry.ShouldWork.services.impl.HumanServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/human")
@RequiredArgsConstructor
//@RestControllerAdvice
public class HumanController {

//    @Autowired
    private final HumanServiceImpl humanService;

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
    public ResponseEntity<Human> save(@Valid @RequestBody Human h){

        Human human = humanService.save(h);
        return new ResponseEntity<>(human, HttpStatus.OK);
    }


    //got an issue to resolve
    @PutMapping("/update/{id}")
    public ResponseEntity<Human> update(@PathVariable("id") Integer id,@RequestBody Human h){
        Human human = humanService.update(id, h);
        return new ResponseEntity<>(human, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        humanService.deleteById(id);
        return new ResponseEntity<>("Information Deleted!", HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<HumanDTO> nameFinder(@PathVariable("name") String name){

        HumanDTO foundHuman = humanService.findByName(name);
        return new ResponseEntity<HumanDTO>(foundHuman, HttpStatus.OK);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public String test(MethodArgumentNotValidException exception) {
//        return "TEST MethodArgumentNotValidException";
//    }
    //exceptions should be in the exception package
}
