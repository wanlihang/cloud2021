package com.wlh.springcloud.controller;

import com.wlh.springcloud.entity.Pianke;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class piankeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentTranscriptsService studentTranscriptsService;
    private Integer studentId;

    @RequestMapping("/pianke")
    public String pianke(@ModelAttribute("studentId") Integer s, Model model){
        // model.addAttribute("test", "就哈哈哈哈哈哈哈哈哈哈哈");
        studentId = s;
        //获取studentInfo
        Student studentInfo = studentService.selectByBfStudentId(studentId);
        model.addAttribute("studentInfo", studentInfo);
        int claId = studentInfo.getClassId();
        showPianke(model, claId);

        return "pianke";
    }

    private void showPianke(Model model, int claId) {
        List<Student> studentInfoList = studentService.selectByClaId(claId);
        if(studentInfoList.isEmpty()){
            return;
        }
        int len = studentInfoList.size();
        List<Pianke> piankeList = new ArrayList<Pianke>();
        int scoreTotal[][] = new int[len][65];
        int num = 0;
        for(Student studentInfo : studentInfoList){
            List<StudentTranscripts> chengjiList = studentTranscriptsService.selectByStudentId(studentInfo.getStudentId());
            int score[] = new int[65];
            float dengdi[] = new float[65];
            for(StudentTranscripts chengji1 : chengjiList){
                //选择最新的期中考试，由于期末考试无科目分类数据
                if(chengji1.getExamKindId().equals(2) && chengji1.getExamTerm().equals("2018-2019-1")){
                    score[chengji1.getSubjectId()] = chengji1.getScore();
                    if(chengji1.getDengdi().isEmpty() || chengji1.getDengdi().equals("0")){//排除干扰
                        continue;
                    }
                    dengdi[chengji1.getSubjectId()] = Float.valueOf(chengji1.getDengdi());
                }
            }
            //打标签
            int good = 0;
            int poor = 0;
            String temp = " ";
            for(int i = 0; i < 65; i++){

                if(dengdi[i] > 0){
                    if(dengdi[i] < 0.45){
                        good++;
                    }
                    if(dengdi[i] > 0.75){
                        poor++;
                        switch (i){
                            case 1:
                                temp += "语文 ";
                                break;
                            case 2:
                                temp += "数学 ";
                                break;
                            case 3:
                                temp += "英语 ";
                                break;
                            case 4:
                                temp += "物理 ";
                                break;
                            case 5:
                                temp += "化学 ";
                                break;
                            case 6:
                                temp += "生物 ";
                                break;
                            case 7:
                                temp += "地理 ";
                                break;
                            case 8:
                                temp += "历史 ";
                                break;
                            case 17:
                                temp += "政治 ";
                                break;
                            case 59:
                                temp += "技术 ";
                                break;
                        }
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < 65; i++){
                if(dengdi[i] != 0){
                    count++;
                }
            }
            //偏科判断
            if(good >= (count/2 + 1) && poor >= 1){
                piankeList.add(new Pianke(studentInfo.getStudentName() + studentInfo.getStudentId(), temp));
                //System.out.println(score[1]);
                for(int i = 0; i < 65; i++){

                    scoreTotal[num][i] = score[i];
                }
                num++;
            }
        }
        model.addAttribute("piankeList", piankeList);
        model.addAttribute("scoreTotal", scoreTotal);

    }


    @RequestMapping("/pitoIndex")
    public String pitoIndex(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }
    @RequestMapping("/pitoCharts")
    public String pitoCharts(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/charts";
    }
    @RequestMapping("/pitoScore")
    public String pitoScore(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/score";
    }
    @RequestMapping("/pitoChoice")
    public String pitoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/choice";
    }
    @RequestMapping("/pitoProfile")
    public String pitoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }

    @RequestMapping("/pitoSubsidies")
    public String pitoSubsidies(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/subsidies";
    }
    @RequestMapping("/pitoXuefeng")
    public String pitoXuefeng(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/xuefeng";
    }
}
