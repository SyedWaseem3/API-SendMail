package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ObjectFactory {

    public ObjectFactory() {
        System.out.println("Configuration does create object as well!!!!!");
    }

    @Bean
    public List<Integer> createNumberList(){
        return new ArrayList<>();
    }
}
