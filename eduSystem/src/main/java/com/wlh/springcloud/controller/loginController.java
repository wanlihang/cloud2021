package com.wlh.springcloud.controller;

import com.wlh.springcloud.entity.Student;
import com.wlh.springcloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class loginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("studentInfo",new Student());
        return "login";
    }
    @PostMapping("/submit")
        public String studentInfoSubmit(@ModelAttribute Student studentInfo, Model model, RedirectAttributes attr) {
        Integer studentId = studentInfo.getStudentId();
        if(studentId < 13012 || studentId > 16162){
            attr.addFlashAttribute("msg", "请输入13012-16162范围内的学生学号。");
            return "redirect:/login";
        }
        Student studentInfo1 = studentService.selectByBfStudentId(studentId);
//        System.out.println(studentInfo1);
        if (studentInfo1 == null) {
            attr.addFlashAttribute("msg", "学号：" + studentId + "，该学生学号不存在，请重新输入。");
            return "redirect:/login";
        }
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }

}
