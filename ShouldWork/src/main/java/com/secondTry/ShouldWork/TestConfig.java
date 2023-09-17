package com.secondTry.ShouldWork;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
