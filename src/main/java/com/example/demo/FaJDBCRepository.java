package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.FaEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FaJDBCRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM fauser WHERE ID = ?", id);
    }

    public List<FaEntity> searchById(Long id){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE ID LIKE '%" + id + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchByFirstName(String firstName){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE FIRST_NAME LIKE '%" + firstName + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchByLastName(String lastName){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE LAST_NAME LIKE '%" + lastName + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchByName(String firstName, String lastName){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE FIRST_NAME LIKE '%" + firstName + "%' " + "OR LAST_NAME LIKE '%" + lastName + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchByAge(int age){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE AGE LIKE '%" + age + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchBySex(String sex){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE SEX LIKE '%" + sex + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchByBirthday(String birthday){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE BIRTHDAY LIKE '%" + birthday + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchByDateSave(String dateSave){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE DATE_SAVE LIKE '%" + dateSave + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchBySaveBy(String saveBy){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE SAVE_BY LIKE '%" + saveBy + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

    public List<FaEntity> searchByAll(String text){
        return jdbcTemplate.query("SELECT * FROM fauser WHERE ID LIKE '%" + text + "%' " +
                "OR FIRST_NAME LIKE '%" + text + "%' " +
                "OR LAST_NAME LIKE '%" + text + "%' " +
                "OR AGE LIKE '%" + text + "%' " +
                "OR SEX LIKE '%" + text + "%' " +
                "OR BIRTHDAY LIKE '%" + text + "%' " +
                "OR DATE_SAVE LIKE '%" + text + "%' " +
                "OR SAVE_BY LIKE '%" + text + "%' ", new BeanPropertyRowMapper<>(FaEntity.class));
    }

}
