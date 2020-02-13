package com.rad.kit.dsappsvc;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
public class DsAppSvcConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
