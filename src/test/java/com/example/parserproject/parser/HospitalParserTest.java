package com.example.parserproject.parser;

import com.example.parserproject.domain.Hospital;
import com.example.parserproject.domain.dao.DaoFactory;
import com.example.parserproject.domain.dao.HospitalDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class HospitalParserTest {
    HospitalDao hospitalDao;
    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    ApplicationContext context;
    @BeforeEach
    void setUp() {
        this.hospitalDao = context.getBean("hospitalDao", HospitalDao.class);
    }

    @Test
    @DisplayName("csv 10만개 이상 파일읽기 및 파싱 테스트")
    List<Hospital> oneHundredThousandRead() throws IOException {
        String filename = "nation_wide_hospital.csv";
        List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);

        return hospitalList;
    }

    @Test
    @DisplayName("csv 1줄을 parser 만드는지 테스트")
    Hospital convertTOHospital() {
        HospitalParser hp = new HospitalParser();
        String str = "\"2\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA1199936200200411014004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
        Hospital hospital =hp.parse(str);
        return hospital;
    }

    @Test
    @DisplayName("Add")
    void Add() throws IOException {
        hospitalDao.deleteAll();
        List<Hospital> list = oneHundredThousandRead();
        for(Hospital p : list){
            hospitalDao.add(p);
        }
    }

    @Test
    @DisplayName("DeleteAll")
    void deleteAll(){
        hospitalDao.deleteAll();
    }

    @Test
    @DisplayName("findById")
    void findById(){
        hospitalDao.findById("123");
    }

    @Test
    @DisplayName("GetCount")
    void getCount(){
        System.out.println(hospitalDao.getCount());
    }

}