package com.wlh.springcloud.controller;

import com.wlh.springcloud.entity.Student;
import com.wlh.springcloud.entity.StudentConsumptionRecord;
import com.wlh.springcloud.service.StudentConsumptionRecordService;
import com.wlh.springcloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class subsidiesController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentConsumptionRecordService consumptionService;
    private Integer studentId;

    @RequestMapping("/subsidies")
    public String subsidies(@ModelAttribute("studentId") Integer s, Model model){
        // model.addAttribute("test", "就哈哈哈哈哈哈哈哈哈哈哈");
        studentId = s;
        //获取studentInfo
        Student studentInfo = studentService.selectByBfStudentId(studentId);
        model.addAttribute("studentInfo", studentInfo);
        int claId = studentInfo.getClassId();
        showPoorStudent(model, claId);

        return "subsidies";
    }

    public void showPoorStudent(Model model, int claId){
        int avgComsp = 2174;//计算出来的学期平均消费金额
        List<Student> studentInfoList = studentService.selectByClaId(claId);
        if(studentInfoList.isEmpty()){
            return;
        }
        int len = studentInfoList.size();
        int comsp[] = new int[len];//记录学期消费金额
        String name[] = new String[len];//记录学生姓名和id
        int count = 0;
        //得到班级学生消费金额（2018-2019-1学期）
        for(Student studentInfo : studentInfoList){
            int temp = 0;
            List<StudentConsumptionRecord> consumptionList = consumptionService.selectByStudentId(studentInfo.getStudentId());
            for(StudentConsumptionRecord consumption : consumptionList){
                String[] csplit = consumption.getConsumptionTime().split("/");
                int yue = Integer.valueOf(csplit[1]);
                if(yue == 9 || yue == 10 || yue == 11 || yue == 12 || yue == 1){
                    temp -= consumption.getAmount();
                }
            }
            comsp[count] = temp;
            name[count] = studentInfo.getStudentName() + studentId;
            count++;
        }
        int num = len/10 + 1;
        int min[] = new int[num];
        String minTip[] = new String[num];
        int avg[] = new int[num];
        //将前num个最低的消费找出来
        for(int i = 0; i < num; i++){
            avg[i] = avgComsp;
            minTip[i] = "学生姓名和学号";
            min[i] = 999999;
        }

//        for(int i = 0; i < len; i++){
//            System.out.println(comsp[i][0] +" : "+ comsp[i][1]);
//        }
        for(int i = 0; i < num; i++){
            int temp = -1;
            for(int j = 1; j < len; j++){
                if(min[i] > comsp[j] && comsp[j] != 0){
                    minTip[i] = name[i];
                    min[i] = comsp[j];
                    temp = j;
                }
            }
            comsp[temp] = 999999;//每找出一个最小值则排除该值

        }
        int buzhu = 0;
        for(int i = 0; i < num; i++){
            buzhu += (avgComsp - min[i]) * Math.pow(0.5, i+1);
        }

        model.addAttribute("min", min);
        model.addAttribute("minTip", minTip);
        model.addAttribute("avg", avg);
        model.addAttribute("buzhu", buzhu);
    }
    @RequestMapping("/sutoIndex")
    public String sutoIndex(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }
    @RequestMapping("/sutoCharts")
    public String sutoCharts(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/charts";
    }
    @RequestMapping("/sutoScore")
    public String sutoScore(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/score";
    }
    @RequestMapping("/sutoChoice")
    public String sutoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/choice";
    }
    @RequestMapping("/sutoProfile")
    public String sutoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }
    @RequestMapping("/sutoPianke")
    public String sutoPianke(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/pianke";
    }

    @RequestMapping("/sutoXuefeng")
    public String sutoXuefeng(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/xuefeng";
    }

}
