package com.secondTry.ShouldWork.services;

import com.secondTry.ShouldWork.dtos.HumanDTO;
import com.secondTry.ShouldWork.entity.Human;

import java.util.List;

public interface HumanService {

    public List<HumanDTO> findAll();

    public HumanDTO findById(Integer id);

    public Human save(Human h);

    public void deleteById(Integer id);
}
