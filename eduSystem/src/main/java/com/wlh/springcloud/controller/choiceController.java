package com.wlh.springcloud.controller;

import com.wlh.springcloud.entities.Score;
import com.wlh.springcloud.entities.T2StudentInfo;
import com.wlh.springcloud.entities.T5Chengji;
import com.wlh.springcloud.service.T2StudentInfoService;
import com.wlh.springcloud.service.T5ChengjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class choiceController {
    @Autowired
    private T2StudentInfoService studentInfoService;
    @Autowired
    private T5ChengjiService chengjiService;
    private Integer studentId;

    @RequestMapping("/choice")
    public String choice(@ModelAttribute("studentId") Integer s, Model model){
        // model.addAttribute("test", "就哈哈哈哈哈哈哈哈哈哈哈");
        studentId = s;
        //获取studentInfo
        T2StudentInfo studentInfo = studentInfoService.selectByBfStudentId(studentId);
        model.addAttribute("studentInfo", studentInfo);
        int flag = 0;
        flag = scoreController.getFlag(studentInfo, flag);
        //分高一高二高三
        showChoice(model, flag);

        return "choice";
    }

    private void showChoice(Model model, int flag) {
        String sug[] = new String[3];
        int preScore[] = new int[7];

        List<T5Chengji> chengjiList = chengjiService.selectByStudentId(studentId);
        //最多5个学期

        int score[][] = new int[30][65];//语文-技术10门课程分数
        String tip[][] = new String[30][65];//对应的信息
        int count[] = new int[65];//记录每门课程的成绩数
        int prediction[] = new int[65];//记录每门课程的预测分数

        for(T5Chengji chengji1 : chengjiList) {
            //无课程号、无学期、无分数则不记录
            if (chengji1.getMesSubId().equals(0) || chengji1.getExamTerm().isEmpty() || chengji1.getMesTScore().isEmpty()) {
                continue;
            }
            String examTerm = chengji1.getExamTerm();
            int subId = chengji1.getMesSubId();
            int examType = chengji1.getExamType();
            int sco = Float.valueOf(chengji1.getMesTScore()).intValue();
            //去掉00:00:00
            String dsplit[] = chengji1.getExamSdate().split(" ");
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

        //预测
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

        preScore[0] = prediction[4];
        preScore[1] = prediction[5];
        preScore[2] = prediction[6];
        preScore[3] = prediction[7];
        preScore[4] = prediction[8];
        preScore[5] = prediction[17];
        preScore[6] = prediction[59];

        List<Score> list = new ArrayList<Score>();
        list.add(new Score("物理", preScore[0]));
        list.add(new Score("化学", preScore[1]));
        list.add(new Score("生物", preScore[2]));
        list.add(new Score("地理", preScore[3]));
        list.add(new Score("历史", preScore[4]));
        list.add(new Score("政治", preScore[5]));
        list.add(new Score("技术", preScore[6]));
        Collections.sort(list); // 按分数排序
        sug[0] = list.get(0).getSub();
        sug[1] = list.get(1).getSub();
        sug[2] = list.get(2).getSub();

        model.addAttribute("preScore", preScore);
        model.addAttribute("sug", sug);
    }

    @RequestMapping("/chtoIndex")
    public String chtoIndex(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }
    @RequestMapping("/chtoCharts")
    public String chtoCharts(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/charts";
    }
    @RequestMapping("/chtoScore")
    public String chtoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/score";
    }
    @RequestMapping("/chtoProfile")
    public String chtoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }
    @RequestMapping("/chtoPianke")
    public String chtoPianke(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/pianke";
    }
    @RequestMapping("/chtoSubsidies")
    public String chtoSubsidies(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/subsidies";
    }
    @RequestMapping("/chtoXuefeng")
    public String chtoXuefeng(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/xuefeng";
    }

}
