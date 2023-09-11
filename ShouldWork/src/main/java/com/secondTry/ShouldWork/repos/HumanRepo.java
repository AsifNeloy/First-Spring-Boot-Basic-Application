package com.secondTry.ShouldWork.repos;

import com.secondTry.ShouldWork.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepo extends JpaRepository<Human, Integer> {


}
