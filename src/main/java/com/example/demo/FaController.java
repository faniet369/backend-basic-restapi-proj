package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.FaEntity;
import com.example.demo.FaModel;
import com.example.demo.FaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/factrl")
public class FaController {
    @Autowired
    private FaService faService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody FaModel faModel) {
        faService.addUser(faModel);
    }

    @PostMapping("/editUser")
    public void editUser(@RequestParam("id") Long id, @RequestBody FaModel faModel) {
        faService.editUser(id, faModel);
    }

    @GetMapping("/searchByIdJPA")
    public FaEntity searchByIdJPA(@RequestParam("id") Long id) {
        return faService.searchByIdJPA(id);
    }

    @GetMapping("/searchByIdJDBC")
    public List<FaEntity> searchByIdJDBC(@RequestParam("id") Long id) {
        return faService.searchByIdJDBC(id);
    }

    @GetMapping("/searchByFirstName")
    public List<FaEntity> searchByFirstName(@RequestParam String firstName) {
        return faService.searchByFirstName(firstName);
    }

    @GetMapping("/searchByLastName")
    public List<FaEntity> searchByLastName(@RequestParam String lastName) {
        return faService.searchByLastName(lastName);
    }

    @GetMapping("/searchByName")
    public List<FaEntity> searchByName(@RequestParam String firstName, @RequestParam String lastName) {
        return faService.searchByName(firstName, lastName);
    }

    @GetMapping("/searchByAge")
    public List<FaEntity> searchByAge(@RequestParam int age) {
        return faService.searchByAge(age);
    }

    @GetMapping("/searchBySex")
    public List<FaEntity> searchBySex(@RequestParam String sex) {
        return faService.searchBySex(sex);
    }

    @GetMapping("/searchByBirthday")
    public List<FaEntity> searchByBirthday(@RequestParam String birthday) {
        return faService.searchByBirthday(birthday);
    }

    @GetMapping("/searchByDateSave")
    public List<FaEntity> searchByDateSave(@RequestParam String dateSave) {
        return faService.searchByDateSave(dateSave);
    }

    @GetMapping("/searchBySaveBy")
    public List<FaEntity> searchBySaveBy(@RequestParam String saveBy) {
        return faService.searchBySaveBy(saveBy);
    }

    @GetMapping("/searchByAll")
    public List<FaEntity> searchByAll(@RequestParam String text) {
        return faService.searchByAll(text);
    }

    @GetMapping("/getAll")
    public List<FaEntity> getAll() {
        return faService.getAll();
    }

    @GetMapping("/calAge")
    public int calAge(@RequestParam String birthday) {
        return faService.calAge(birthday);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam("id") Long id) {
        faService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        faService.deleteAll();
    }

}

