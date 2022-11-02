package com.example.parserproject.domain.dao;

import com.example.parserproject.domain.Hospital;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
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

    RowMapper<Hospital> rowMapper = (rs, rowNum) -> {
        Hospital hospital = new Hospital();
        hospital.setId(Integer.parseInt(rs.getString(1)));
        hospital.setOpenServiceName(rs.getString(2));
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(rs.getString(3)));
        hospital.setManagementNumber(rs.getString(4));
        hospital.setLicenseDate(rs.getTimestamp("license_date").toLocalDateTime());
        hospital.setBusinessStatus(Integer.parseInt(rs.getString(6)));
        hospital.setBusinessStatusCode(Integer.parseInt(rs.getString(7)));
        hospital.setPhone(rs.getString(8));
        hospital.setFullAddress(rs.getString(9));
        hospital.setRoadNameAddress(rs.getString(10));
        hospital.setHospitalName(rs.getString(11));
        hospital.setBusinessTypeName(rs.getString(12));
        hospital.setHealthcareProviderCount(Integer.parseInt(rs.getString(13)));
        hospital.setPatientRoomCount(Integer.parseInt(rs.getString(14)));
        hospital.setTotalNumberOfBeds(Integer.parseInt(rs.getString(15)));
        hospital.setTotalAreaSize(Float.parseFloat(rs.getString(16)));
        return hospital;
    };

    public Hospital findById(String id){
        Hospital p = jdbcTemplate.queryForObject("select * from nation_wide_hospitals where id = ?",rowMapper,id);
        return p;
    }
    public List<Hospital> findByRoadName(String roadNameAddress){
        List<Hospital> list = new ArrayList<>();
        list.add(jdbcTemplate.queryForObject("select * from nation_wide_hospitals where road_name_address regexp ?",rowMapper,roadNameAddress));
        return list;
    }
    public List<Hospital> findAll(){
        return jdbcTemplate.query("select * from nation_wide_hospitals",rowMapper);
    }


    public int getCount(){
            String sql = "select count(id) from nation_wide_hospitals;";
            return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
