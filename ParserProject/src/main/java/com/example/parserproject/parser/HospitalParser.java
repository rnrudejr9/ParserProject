package com.example.parserproject.parser;

import com.example.parserproject.domain.Hospital;
import lombok.AllArgsConstructor;

import java.util.Arrays;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str) {

        String[] row =str.replace("\"","").split(",");
        System.out.println(Arrays.toString(row));
        Hospital hospital = new Hospital();
        hospital.setId(Integer.parseInt(row[0]));
        hospital.setOpenServiceName(row[1]);
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(row[2]));
        hospital.setManagementNumber(row[3]);
        hospital.setLicenseDate(row[4]);
        hospital.setBusinessStatus(Integer.parseInt(row[5]));
        hospital.setBusinessStatusCode(Integer.parseInt(row[6]));
        hospital.setPhone(row[7]);
        hospital.setFullAddress(row[8]);
        hospital.setRoadNameAddress(row[9]);
        hospital.setHospitalName(row[10]);
        hospital.setBusinessTypeName(row[11]);
        hospital.setHealthcareProviderCount(Integer.parseInt(row[12]));
        hospital.setPatientRoomCount(Integer.parseInt(row[13]));
        hospital.setTotalNumberOfBeds(Integer.parseInt(row[14]));
        hospital.setTotalAreaSize(Integer.parseInt(row[15]));
        return new Hospital();

    }
}
