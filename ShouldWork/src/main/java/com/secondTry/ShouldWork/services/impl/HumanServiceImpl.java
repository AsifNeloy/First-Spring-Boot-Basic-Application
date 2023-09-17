package com.secondTry.ShouldWork.services.impl;

import com.secondTry.ShouldWork.dtos.HumanDTO;
import com.secondTry.ShouldWork.entity.Human;
import com.secondTry.ShouldWork.repos.HumanRepo;
import com.secondTry.ShouldWork.services.HumanService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanRepo humanRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public HumanServiceImpl() {
//        this.humanRepo = humanRepo;
//    }

    @Override
    public List<HumanDTO> findAll() {

        List<Human> human = this.humanRepo.findAll();

        //strategy 1: works but returns only one from the list and null values
        //List<HumanDTO> humanDTOS = Collections.singletonList(this.modelMapper.map(human, HumanDTO.class));
        //return humanDTOS;

        //strategy 2: works but gives null values
        //return human.stream().map((human1) -> this.modelMapper.map(human, HumanDTO.class))
        //         .collect(Collectors.toList());

        //strategy 3: works
        List<HumanDTO> humanDTOS = new ArrayList<HumanDTO>();

        for(Human human1: human){
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            HumanDTO humanDTO = mapper.map(human1, HumanDTO.class);
            humanDTOS.add(humanDTO);
        }
        return humanDTOS;
    }

    @Override
    public HumanDTO findById(Integer id) {


        Optional<Human> optionalHuman = Optional.ofNullable(this.humanRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No user found with id = " + id)));
        //runtimeException is the last most exception. other exceptions must be before runtime.
        //implement try catch here

//isEmpty or isPresent should be in the service to use optional
//        if (optionalHuman.isEmpty()) {
//            return new HumanDTO();
//        }

        return this.modelMapper.map(optionalHuman.get(), HumanDTO.class);
    }

    @Override
    public Human save(Human human){



        return humanRepo.save(human);
    }


    @Override
    public Human update(Integer id, Human h) {

        Human human = humanRepo.findById(id).get();
        human.name= h.name;
        human.company = h.company;
        human.password = h.password;


        return humanRepo.save(human);

    }

    @Override
    public void deleteById(Integer id){
        Human human = humanRepo.findById(id).get();


        humanRepo.delete(human);
    }

    //finding by name method gets confused when there are more than one with same name
    @Override
    public HumanDTO findByName(String name){
        Optional<Human> optionalHuman;
        optionalHuman = Optional.ofNullable(this.humanRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("No user found with name = " + name)));
        if (optionalHuman.isEmpty()) {
            return new HumanDTO();
        }
        return this.modelMapper.map(optionalHuman.get(), HumanDTO.class);

    }
}
