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

    @RequestMapping("/getall")
    public List<Hospital> getHospital(){
        return hospitalDao.findAll();
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable Integer id) {
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(hospital);
        String status=null;
        if (!opt.isEmpty()) {
            return "EMPTY";
        } else {
            Hospital p = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital()).getBody();
            if(p.getBusinessStatusCode() == 13){
                status = "영업";
            }
            return "ID : " + p.getId() +" 이름 : "+ p.getHospitalName() + " 상태 : " + status;
        }
    }


    @RequestMapping("/isfail")
    public List<Hospital> isFailed(){
        return hospitalDao.findByFail();
    }
}
