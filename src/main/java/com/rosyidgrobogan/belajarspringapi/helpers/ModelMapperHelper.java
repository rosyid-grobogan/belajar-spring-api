package com.rosyidgrobogan.belajarspringapi.helpers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperHelper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
