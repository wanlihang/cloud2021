package com.wlh.springcloud.controller;

import com.wlh.springcloud.entity.Student;
import com.wlh.springcloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class indexController {
    @Autowired
    private StudentService studentService;

    private Integer studentId;

    @RequestMapping("/index")
    public String index(@ModelAttribute("studentId") Integer s, Model model){
        // model.addAttribute("test", "就哈哈哈哈哈哈哈哈哈哈哈");
        studentId = s;
        //获取studentInfo
        Student student = studentService.selectByBfStudentId(studentId);
        model.addAttribute("student", student);
        return "index";
    }

    @RequestMapping("/itoCharts")
    public String itoCharts(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/charts";
    }
    @RequestMapping("/itoScore")
    public String itoScore(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/score";
    }
    @RequestMapping("/itoChoice")
    public String itoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/choice";
    }
    @RequestMapping("/itoProfile")
    public String itoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }
    @RequestMapping("/itoPianke")
    public String itoUnbalance(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/pianke";
    }
    @RequestMapping("/itoSubsidies")
    public String itoSubsidies(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/subsidies";
    }
    @RequestMapping("/itoXuefeng")
    public String itoXuefeng(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/xuefeng";
    }

}
