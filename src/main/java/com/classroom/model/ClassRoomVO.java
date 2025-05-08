package com.classroom.model;


import com.teacher.model.TeacherVO;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@DynamicInsert
@Entity
@Table(name="classroom")
public class ClassRoomVO {

    @Id
    @Column(name="classid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @Column(name="location")
    private String location;

    @OneToMany(mappedBy = "classRoomVO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TeacherVO> teachers;

    public ClassRoomVO() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<TeacherVO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherVO> teachers) {
        this.teachers = teachers;
    }
}
