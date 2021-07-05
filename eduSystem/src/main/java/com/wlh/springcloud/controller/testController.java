package com.wlh.springcloud.controller;

import com.wlh.springcloud.entities.T6ExamType;
import com.wlh.springcloud.service.T6ExamTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class testController {
    @Resource
    private T6ExamTypeService examTypeService;

    @RequestMapping("/test")
    public String index(Model model){
        List<T6ExamType> t6ExamTypeList = examTypeService.getAllExamType();

        model.addAttribute("ext", t6ExamTypeList);

        //System.out.println(t6ExamTypeList);
        return "test";
    }
}
