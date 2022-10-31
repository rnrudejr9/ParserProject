package com.example.parserproject.parser;

import com.example.parserproject.domain.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HospitalParserTest {
    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Test
    @DisplayName("csv 10만개 이상 파일읽기 및 파싱 테스트")
    void oneHundredThousandRead() throws IOException {
        String filename = "nation_wide_hospital.csv";
        List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);

        for(int i =0 ; i<10;i++){
            System.out.println(hospitalList.get(i).getHospitalName());
        }
        System.out.println("파싱된 데이터 개수 : " + hospitalList.size());
    }

    @Test
    @DisplayName("csv 1줄을 parser 만드는지 테스트")
    void convertTOHospital() {
        HospitalParser hp = new HospitalParser();
        String str = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
        Hospital hospital =hp.parse(str);
    }

}