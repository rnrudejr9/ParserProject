package com.example.parserproject.parser;

import com.example.parserproject.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//이 부분이 스프링부트에서는 자동으로 만들어짐

@Configuration
public class ParserFactory {
    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext(){
        return new ReadLineContext<Hospital>(new HospitalParser());
    }
}
