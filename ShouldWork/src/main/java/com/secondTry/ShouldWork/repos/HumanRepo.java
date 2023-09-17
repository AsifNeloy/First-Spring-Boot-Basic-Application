package com.secondTry.ShouldWork.repos;

import com.secondTry.ShouldWork.dtos.HumanDTO;
import com.secondTry.ShouldWork.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //to initialize the class as repo
public interface HumanRepo extends JpaRepository<Human, Integer> {


    Optional<Human> findByName(String name);
}
