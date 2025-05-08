package com.student.controller;

import com.student.model.StudentService;
import com.student.model.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/index")
    public String index(Model model) {


        return "index";
    }

    @PostMapping("/getone")
    public String getone(Model model, @RequestParam int no){
        StudentVO studentVO = studentService.getById(no);
        if(studentVO != null){
            model.addAttribute("student", studentVO);
        } else {
            model.addAttribute("msg", "查無此人");
        }

        return "index";
    }

    @PostMapping("/addone")
    public String addone(Model model,
                         @RequestParam String name,
                         @RequestParam Integer math,
                         @RequestParam Integer eng,
                         @RequestParam Integer gender
                         ){
        if(name.trim().isEmpty() || name == null || math == null || eng == null || gender == null){
            model.addAttribute("columnmsg", "請填寫所有欄位");
            return "index";
        } else if(math < 0 || eng < 0 || math > 100 || eng > 100 || gender < 1 || gender > 2){
            model.addAttribute("error", "error");
            return "index";
        }
       studentService.save(name, math, eng, gender);
        return "redirect:/index";
    }

    @PostMapping("/deleteone")
    public String deleteone(Model model, @RequestParam Integer no){
        if(no == null){
            model.addAttribute("nomsg", "請填寫學號");
            return "index";
        }
        StudentVO studentVO = studentService.getById(no);
        if(studentVO == null){
            model.addAttribute("noOne", "查無此人");
            return "index";
        }
        studentService.deleteById(no);
        return "redirect:/index";
    }
    
    @PostMapping("/updateScores")
    public String updateScores(Model model,
                               @RequestParam Integer eng,
                               @RequestParam Integer math,
                               @RequestParam Integer no){
        StudentVO studentVO = studentService.getById(no);
        if (studentVO == null) {
            model.addAttribute("noOne", "查無此人");
            return "index";
        } else if (eng < 0 || math < 0 || eng > 100 || math > 100) {
            model.addAttribute("error", "error");
            return "index";
        } else {
            studentService.update(eng, math, no);
            return "redirect:/index";
        }
    }

    @ModelAttribute("list")
    public List<StudentVO> list(){
        return studentService.getAll();
    }
}
