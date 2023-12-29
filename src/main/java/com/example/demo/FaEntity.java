package com.example.demo;

import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table (name = "fauser", catalog = "db")
public class FaEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String sex;
    private LocalDate birthday;
    private LocalDate dateSave;
    private String saveBy;

    public FaEntity() {
    }

    public FaEntity(Long id, String firstName, String lastName, int age, String sex, LocalDate birthday, LocalDate dateSave, String saveBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.dateSave = dateSave;
        this.saveBy = saveBy;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME", length = 1000)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", length = 1000)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "AGE", length = 20)
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "BIRTHDAY")
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void setBirthday(String birthday) {
        String[] array = birthday.split("/");
        this.birthday = LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
    }

    @Column(name = "DATE_SAVE")
    public LocalDate getDateSave() {
        return dateSave;
    }
    public void setDateSave(LocalDate dateSave) {
        this.dateSave = dateSave;
    }
    public void setDateSave() {
        this.dateSave = LocalDate.now();
    }

    @Column(name = "SAVE_BY", length = 20)
    public String getSaveBy() {
        return saveBy;
    }
    public void setSaveBy(String saveBy) {
        this.saveBy = saveBy;
    }
}

