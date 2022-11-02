package com.example.parserproject.controller;


import com.example.parserproject.domain.Hospital;
import com.example.parserproject.domain.dao.HospitalDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalDao hospitalDao;
    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/getall")
    public List<Hospital> getHospital(){
        return hospitalDao.findAll();
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable Integer id) {
        Hospital hospital = hospitalDao.findById(id);
        return hospital.getHospitalName();
    }


    @GetMapping("/isfail")
    public List<Hospital> isFailed(){
        return hospitalDao.findByFail();
    }
}
