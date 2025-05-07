package com.student.model;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class StudentVO {

    @Id
    @Column(name="no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column(name="name")
    private String name;

    @Column(name="math")
    private Integer math;

    @Column(name="eng")
    private Integer eng;

    @Column(name="gender")
    private Integer gender;

    public StudentVO() {
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEng() {
        return eng;
    }

    public void setEng(Integer eng) {
        this.eng = eng;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


}
