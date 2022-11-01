package com.example.parserproject.domain.dao;

import com.example.parserproject.domain.Hospital;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

//스프링부트어플리케이션 어노테이션이 component 달려있는 어노테이션을 다 빈으로 등록함



public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // List<Hospital>
    public void add(Hospital hospital){
        String sql = "INSERT INTO `likelion-db`.`nation_wide_hospitals` (`id`, `open_service_name`, `open_local_government_code`, " +
                "`management_number`, `license_date`, `business_status`, `business_status_code`, " +
                "`phone`, `full_address`, `road_name_address`, `hospital_name`, `business_type_name`, " +
                "`healthcare_provider_count`, `patient_room_count`, `total_number_of_beds`, `total_area_size`) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql,hospital.getId(),hospital.getOpenServiceName(),hospital.getOpenLocalGovernmentCode()
        ,hospital.getManagementNumber(),hospital.getLicenseDate(),hospital.getBusinessStatus(),hospital.getBusinessStatusCode()
        ,hospital.getPhone(),hospital.getFullAddress(),hospital.getRoadNameAddress(),hospital.getHospitalName(),hospital.getBusinessTypeName()
        ,hospital.getHealthcareProviderCount(),hospital.getPatientRoomCount(),hospital.getTotalNumberOfBeds(),hospital.getTotalAreaSize());
    }
    public void deleteAll(){
        jdbcTemplate.update("delete from nation_wide_hospitals");
    }

    public Hospital findById(String id){
        Hospital p = jdbcTemplate.queryForObject("select * from nation_wide_hospitals where id = ?",(rs,count)->new Hospital(
                Integer.parseInt(rs.getString(1)),
                rs.getString(2),
                Integer.parseInt(rs.getString(3)),
                rs.getString(4),
                null, // 5번
                Integer.parseInt(rs.getString(6)),
                Integer.parseInt(rs.getString(7)),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10),
                rs.getString(11),
                rs.getString(12),
                Integer.parseInt(rs.getString(13)),
                Integer.parseInt(rs.getString(14)),
                Integer.parseInt(rs.getString(15)),
                Float.parseFloat(rs.getString(16))
        ),id);
        return p;
    }
    public int getCount(){
            String sql = "select count(id) from nation_wide_hospitals;";
            return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
