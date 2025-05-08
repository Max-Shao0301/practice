package com.teacher.controller;


import com.teacher.model.TeacherService;
import com.teacher.model.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("/teacher")
    public String teacher(Model model){
        List<TeacherVO> list = teacherService.teacherList();
        model.addAttribute("teacherList", list);
        return "teacher";
    }

    @PostMapping("/add/teacher")
    public String addTeacher(Model model,
                             @RequestParam String name,
                             @RequestParam Integer classId){
        if (name.trim().equals("") || name == null || classId == null) {
            model.addAttribute("msg", "請填寫所有欄位");
            return "teacher";
        } else {
            TeacherVO teacherVO = teacherService.add(name, classId);
            if (teacherVO == null) {
                model.addAttribute("msg1", "新增失敗");
            }
            return "redirect:/teacher";
        }
    }
}
