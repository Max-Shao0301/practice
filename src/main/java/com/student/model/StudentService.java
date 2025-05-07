package com.student.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentVO> getAll(){
        List<StudentVO> list = studentRepository.findAll();
        return list;
    }

    public StudentVO getById(int no){
        Optional<StudentVO> optional = studentRepository.findById(no);
        return optional.orElse(null);
    }

    public StudentVO save(StudentVO studentVO){
        return studentRepository.save(studentVO);
    }

    public void deleteById(int no){
        studentRepository.deleteById(no);
    }

    public void update(Integer eng, Integer math, Integer no) {
        studentRepository.updateScores(eng, math, no);
    }
}
