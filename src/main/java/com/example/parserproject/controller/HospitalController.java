package com.example.parserproject.controller;


import com.example.parserproject.domain.Hospital;
import com.example.parserproject.domain.dao.HospitalDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalDao hospitalDao;
    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @RequestMapping("/get")
    public List<Hospital> getHospital(){
        return hospitalDao.findAll();
    }
}
