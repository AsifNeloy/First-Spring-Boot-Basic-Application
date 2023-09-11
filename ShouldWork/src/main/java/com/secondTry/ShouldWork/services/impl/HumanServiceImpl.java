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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanRepo humanRepo;

    @Autowired
    private ModelMapper modelMapper;

    public HumanServiceImpl() {
        this.humanRepo = humanRepo;
    }

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
    public HumanDTO findById(Integer integer) {

        Human human = this.humanRepo.findById(integer).get();
        HumanDTO humanDTO = this.modelMapper.map(human, HumanDTO.class);
        return humanDTO;
    }

    @Override
    public Human save(Human h){
        return humanRepo.save(h);
    }



    @Override
    public void deleteById(Integer id){
        Human h = humanRepo.findById(id).get();
        humanRepo.delete(h);
    }
}
