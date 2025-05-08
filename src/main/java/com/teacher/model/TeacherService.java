package com.teacher.model;

import com.classroom.model.ClassRoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherVO> teacherList(){
        List<TeacherVO> list = teacherRepository.findAll();
        return list;
    }

    public TeacherVO add(String name, Integer classId){
        TeacherVO teacherVO = new TeacherVO();
        ClassRoomVO classRoomVO = new ClassRoomVO();
        teacherVO.setName(name);
        classRoomVO.setClassId(classId);
        teacherVO.setClassRoomVO(classRoomVO);
        return teacherRepository.save(teacherVO);
    }

}
