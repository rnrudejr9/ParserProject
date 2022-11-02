package com.example.parserproject.service;

import com.example.parserproject.domain.Hospital;
import com.example.parserproject.domain.dao.HospitalDao;
import com.example.parserproject.parser.ReadLineContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final ReadLineContext<Hospital> hospitalReadLineContext;
    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }

    // 파일명에 대한 의존성을 줄이기 위해
    @Transactional
    public int insertLargeVolumeHospitalData(String filename){
        int cnt = 0;

        try {
            List<Hospital> hospitalList= hospitalReadLineContext.readByLine(filename);

            for (Hospital hospital:hospitalList) {
                try {
                    this.hospitalDao.add(hospital);
                    cnt++;
                } catch (Exception e) {
                    System.out.printf("id: %d 레코드에 문제가 있습니다.", hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        return cnt;
    }

}