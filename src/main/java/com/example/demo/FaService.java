package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.FaEntity;
import com.example.demo.FaModel;
import com.example.demo.FaJDBCRepository;
import com.example.demo.FaJPARepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class FaService {
    @Autowired
    private FaJPARepository faJPARepository;

    @Autowired
    private FaJDBCRepository faJDBCRepository;

    public void addUser(FaModel data) {
        try {
            FaEntity faEntity = new FaEntity();
            faEntity.setFirstName(data.getFirstName());
            faEntity.setLastName(data.getLastName());
            faEntity.setAge(data.getAge());
            faEntity.setSex(data.getSex());
            faEntity.setBirthday(data.getBirthday());
            faEntity.setDateSave();
            faEntity.setSaveBy(data.getSaveBy());
            faJPARepository.save(faEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editUser(Long id, FaModel data) {
        try {
            FaEntity faEntity = searchByIdJPA(id);
            faEntity.setId(id);
            faEntity.setFirstName(data.getFirstName());
            faEntity.setLastName(data.getLastName());
            faEntity.setAge(data.getAge());
            faEntity.setSex(data.getSex());
            faEntity.setBirthday(data.getBirthday());
            faEntity.setDateSave();
            faEntity.setSaveBy(data.getSaveBy());
            faJPARepository.save(faEntity);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FaEntity searchByIdJPA(Long id){
        return faJPARepository.findById(id).get();
    }

    public List<FaEntity> searchByIdJDBC(Long id){
        return faJDBCRepository.searchById(id);
    }

    public List<FaEntity> searchByFirstName(String firstName){
        return faJDBCRepository.searchByFirstName(firstName);
    }

    public List<FaEntity> searchByLastName(String lastName){
        return faJDBCRepository.searchByLastName(lastName);
    }

    public List<FaEntity> searchByName(String firstName, String lastName){
        return faJDBCRepository.searchByName(firstName, lastName);
    }

    public List<FaEntity> searchByAge(int age){
        return faJDBCRepository.searchByAge(age);
    }

    public List<FaEntity> searchBySex(String sex){
        return faJDBCRepository.searchBySex(sex);
    }

    public List<FaEntity> searchByBirthday(String birthday){
        return faJDBCRepository.searchByBirthday(birthday);
    }

    public List<FaEntity> searchByDateSave(String dateSave){
        return faJDBCRepository.searchByDateSave(dateSave);
    }

    public List<FaEntity> searchBySaveBy(String saveBy){
        return faJDBCRepository.searchBySaveBy(saveBy);
    }

    public List<FaEntity> searchByAll(String text){
        return faJDBCRepository.searchByAll(text);
    }

    public List<FaEntity> getAll(){
        return faJPARepository.findAll();
    }

    public void deleteById(Long id){
        faJDBCRepository.deleteById(id);
    }

    public void deleteAll(){
        faJPARepository.deleteAll();
    }

    public int calAge(String birthdayStr){
        int age = 0;
        try {
            //String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate today = LocalDate.now();
            String[] array = birthdayStr.split("/");
            LocalDate birthday = LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
            age = Period.between(birthday, today).getYears();
//            String[] arrayBirth = birthday.split("/");
//            String[] arrayToday = today.split("/");
//            age = Integer.parseInt(arrayToday[2]) - Integer.parseInt(arrayBirth[2]);
//            int m = Integer.parseInt(arrayToday[1]) - Integer.parseInt(arrayBirth[1]);
//            if (m < 0 || (m == 0 && Integer.parseInt(arrayToday[0]) < Integer.parseInt(arrayBirth[0]))) {
//                age--;
//            }
        }
        catch (Exception ignored) {
        }
        return age;

    }

}