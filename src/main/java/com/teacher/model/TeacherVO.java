package com.teacher.model;


import com.classroom.model.ClassRoomVO;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="teacher")
@DynamicInsert
public class TeacherVO {

    @Id
    @Column(name="teacherid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @Column(name="name")
    private String name;

    @JoinColumn(name="classid")
    @ManyToOne
    private ClassRoomVO classRoomVO;

    public TeacherVO() {
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassRoomVO getClassRoomVO() {
        return classRoomVO;
    }

    public void setClassRoomVO(ClassRoomVO classRoomVO) {
        this.classRoomVO = classRoomVO;
    }
}
