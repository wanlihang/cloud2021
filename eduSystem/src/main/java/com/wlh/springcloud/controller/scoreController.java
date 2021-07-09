package com.wlh.springcloud.controller;

import com.wlh.springcloud.entity.Student;
import com.wlh.springcloud.entity.StudentTranscripts;
import com.wlh.springcloud.service.StudentService;
import com.wlh.springcloud.service.StudentTranscriptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class scoreController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentTranscriptsService studentTranscriptsService;
    private Integer studentId;

    @RequestMapping("/score")
    public String score(@ModelAttribute("studentId") Integer s, Model model){
        studentId = s;
        //获取studentInfo
        Student student = studentService.selectByBfStudentId(studentId);
        model.addAttribute("studentInfo", student);
        showHistoryScore(model, student.getGradeId());

        return "score";
    }

    private void showHistoryScore(Model model, int flag) {
        List<StudentTranscripts> chengjiList = studentTranscriptsService.selectByStudentId(studentId);
        //最多5个学期

        int score[][] = new int[30][65];//语文-技术10门课程分数
        String type[][] = new String[30][65];//对应的考试类型信息（期中 期末 平时 总评）
        String tip[][] = new String[30][65];//对应的学期信息
        int count[] = new int[65];//记录每门课程的成绩数
        int prediction[] = new int[65];//记录每门课程的预测分数

        for(StudentTranscripts chengji1 : chengjiList) {
            //无课程号、或无学期、或无分数则不记录
            if (chengji1.getSubjectId().equals(0) || chengji1.getExamTerm().isEmpty() || chengji1.getTScore().isEmpty()) {
                continue;
            }

            int subId = chengji1.getSubjectId();
            int examType = chengji1.getExamKindId();
            int sco = Float.valueOf(chengji1.getTScore()).intValue();
            //去掉00:00:00
            String dsplit[] = chengji1.getExamDate().split(" ");
            String date = dsplit[0];

            if(flag == 1){
                if(examType == 2 || examType == 3 ||examType == 19){
                    score[count[subId]][subId] = sco;
                    tip[count[subId]][subId] = date;
                    count[subId]++;
                }
            }
            if(flag == 2){
                if(examType == 2 || examType == 3 ||examType == 8){
                    score[count[subId]][subId] = sco;
                    tip[count[subId]][subId] = date;
                    count[subId]++;
                }
            }
            if(flag == 3){
                if(examType == 2 || examType == 3 ||examType == 6 || examType == 7){
                    score[count[subId]][subId] = sco;
                    tip[count[subId]][subId] = date;
                    count[subId]++;
                }
            }
        }

        //权重预测
        for(int i = 0; i < 65; i++) {
            //无记录
            if (count[i] == 0) {
                continue;
            }
            //等于一条记录时，预测结果记为当前分数
            if (count[i] == 1) {
                prediction[i] = score[0][i];
                continue;
            }
            //大于一条记录，前30%权重1.1，中间40%权重1.05，剩余1.0
            int x = (int)(count[i] * 0.3);
            int y = (int)(count[i] * 0.4);
            for (int j = 0; j < count[i]; j++) {
                if(j < x){
                    prediction[i] += score[0][i] * 1.1;
                }
                else if(j < x + y){
                    prediction[i] += score[0][i] * 1.05;
                }
                else{
                    prediction[i] += score[0][i];
                }
            }
            prediction[i] /= count[i];
        }

        model.addAttribute("score", score);
        model.addAttribute("tip", tip);
        model.addAttribute("count", count);
        model.addAttribute("prediction", prediction);
    }

    @RequestMapping("/stoIndex")
    public String stoIndex(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }
    @RequestMapping("/stoCharts")
    public String stoCharts(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/charts";
    }
    @RequestMapping("/stoChoice")
    public String stoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/choice";
    }
    @RequestMapping("/stoProfile")
    public String stoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }
    @RequestMapping("/stoPianke")
    public String stoPianke(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/pianke";
    }
    @RequestMapping("/stoSubsidies")
    public String stoSubsidies(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/subsidies";
    }
    @RequestMapping("/stoXuefeng")
    public String stoXuefeng(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/xuefeng";
    }



}
