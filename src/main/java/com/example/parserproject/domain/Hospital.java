package com.example.parserproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


//Lombok사용
//컬럼이 추가 되거나 제거 되어도 Constructor, Getter를 추가로 만들거나 지우지 않아도 되어서 편함

@AllArgsConstructor
//모든 컬럼을 받는 생성자
@Getter
@Setter
@NoArgsConstructor
//아무것도 받지않는 생성자
public class Hospital {
    private int id;
    private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;

}
