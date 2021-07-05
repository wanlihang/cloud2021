package com.wlh.springcloud.controller;

import com.wlh.springcloud.entities.T2StudentInfo;
import com.wlh.springcloud.service.T2StudentInfoService;
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
    private T2StudentInfoService studentInfoService;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("studentInfo",new T2StudentInfo());
        return "login";
    }
    @PostMapping("/submit")
        public String studentInfoSubmit(@ModelAttribute T2StudentInfo studentInfo, Model model, RedirectAttributes attr) {
        Integer studentId = studentInfo.getBfStudentid();
        if(studentId < 13012 || studentId > 16162){
            attr.addFlashAttribute("msg", "请输入13012-16162范围内的学生学号。");
            return "redirect:/login";
        }
        T2StudentInfo studentInfo1 = studentInfoService.selectByBfStudentId(studentId);
//        System.out.println(studentInfo1);
        if (studentInfo1 == null) {
            attr.addFlashAttribute("msg", "学号：" + studentId + "，该学生学号不存在，请重新输入。");
            return "redirect:/login";
        }
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }

}
