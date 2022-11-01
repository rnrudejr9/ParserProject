package com.example.parserproject.domain.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DaoFactory {
    private final JdbcTemplate jdbcTemplate;
    public DaoFactory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public HospitalDao hospitalDao(){
        return new HospitalDao(this.jdbcTemplate);
    }

}
