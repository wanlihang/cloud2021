package com.wlh.springcloud.controller;

import com.wlh.springcloud.entity.Attendance;
import com.wlh.springcloud.entity.Student;
import com.wlh.springcloud.entity.StudentConsumptionRecord;
import com.wlh.springcloud.entity.StudentTranscripts;
import com.wlh.springcloud.service.AttendanceService;
import com.wlh.springcloud.service.StudentConsumptionRecordService;
import com.wlh.springcloud.service.StudentService;
import com.wlh.springcloud.service.StudentTranscriptsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class chartsController {
    private Integer studentId;

    private Student student;

    @Resource
    private StudentService studentService;
    @Resource
    private AttendanceService kaoqinService;
    @Resource
    private StudentTranscriptsService chengjiService;
    @Resource
    private StudentConsumptionRecordService consumptionService;

    @RequestMapping("/charts")
    public String charts(@ModelAttribute("studentId") Integer s, Model model){
        studentId = s;
        student = studentService.selectByBfStudentId(studentId);
        model.addAttribute("student", student);
        showChengji(model);
        showKaoqin(model);
        showConsumption(model);

        return "charts";
    }

    public void showChengji(Model model){
        //获取自己的成绩信息（每年单独列出）
        List<StudentTranscripts> chengjiList = chengjiService.selectByStudentId(studentId);
        int score[] = new int[65];
        int testID[] = new int[65];//记录考试编码
        float dengdi[] = new float[65];
        for(StudentTranscripts chengji1 : chengjiList){
            if(chengji1.getExamKindId().equals(2)){
                score[chengji1.getSubjectId()] = chengji1.getScore();
                testID[chengji1.getSubjectId()] = chengji1.getTestId();
                if(chengji1.getDengdi().isEmpty()){
                    continue;
                }
                dengdi[chengji1.getSubjectId()] = Float.valueOf(chengji1.getDengdi());
            }
        }
        model.addAttribute("score", score);
        //计算平均分
        int avgScore[] = new int[65];
        //int maxChazhi[] = new int[65];//记录最大的差值，用于打标签
        int count = 0;//科目数量
        for(int i = 0; i < 65; i++){
            if(testID[i] > 0){
                avgScore[i] = chengjiService.getAvgScore(testID[i]);
                count++;
            }
        }
        model.addAttribute("avgScore", avgScore);
        //打标签
        int zongping[] = new int[4];
        for(int i = 0; i < 65; i++){
            if(score[i] == 0){
                model.addAttribute("biaoqian"+i, "无该门考试记录！");
                continue;
            }
            if(score[i] == -1){
                model.addAttribute("biaoqian"+i, "作弊！");
                continue;
            }
            if(score[i] == -2){
                model.addAttribute("biaoqian"+i, "缺考！");
                continue;
            }
            if(score[i] == -3){
                model.addAttribute("biaoqian"+i, "免考！");
                continue;
            }
            if(avgScore[i] > 0){
                if(dengdi[i] < 0.15){
                    model.addAttribute("biaoqian"+i, "A：优秀");
                    zongping[0]++;
                    zongping[1]++;
                    zongping[2]++;
                }
                else if(dengdi[i] < 0.45){
                    model.addAttribute("biaoqian"+i, "B：良好");
                    zongping[1]++;
                    zongping[2]++;
                }
                else if(dengdi[i] < 0.75){
                    model.addAttribute("biaoqian"+i, "C：一般");
                    zongping[2]++;
                }
                else if(dengdi[i] < 0.95){
                    model.addAttribute("biaoqian"+i, "D：低于平均水平");
                    zongping[3]++;
                }
                else {
                    model.addAttribute("biaoqian"+i, "E：不合格");
                    zongping[3]++;
                }
            }
        }
        if(zongping[0] >= count/2 && zongping[1] == count) {
            model.addAttribute("zongping", "成绩十分优秀，继续保持，争取更进一步！");
        }
        else if(zongping[0] >= 1 && zongping[2] ==count ){
            model.addAttribute("zongping", "成绩优秀，继续努力，争取更上一层楼！");
        }
        else if(zongping[1] >= count/2 + 1 && zongping[3] >= 1){
            model.addAttribute("zongping", "成绩良好，但有"+ zongping[3] +"门课程存在偏科现象，需要加倍努力！");
        }
        else if(zongping[2] >= (count - 3)){
            model.addAttribute("zongping", "成绩一般，请努力学习！");
        }
        else {
            model.addAttribute("zongping", "成绩暂时不合格，请用心学习！");
        }
    }

    public void showKaoqin(Model model){
        //获取自己的考勤信息
        List<Attendance> kaoqinList = kaoqinService.selectByStudentId(studentId);
        int kaoqinCount[] = new int[5];//0-4分别为正常进校、离校、迟到、早退、未穿校服
        int count = 0;
        for(Attendance kaoqin1 : kaoqinList) {
            int temp = kaoqin1.getControllerId();
            if (temp == 1001 || temp == 99001) {
                kaoqinCount[2]++;
            }
            if (temp == 1002 || temp == 99003) {
                kaoqinCount[3]++;
            }
            if (temp == 99002) {
                kaoqinCount[4]++;
            }
            //进校
            if (temp == 99004) {
                kaoqinCount[0]++;
            }
            //离校
            if (temp == 99005) {
                kaoqinCount[1]++;
            }
            count++;
            //System.out.println(kaoqinCount[0]);
        }
        if(count < 5){
            model.addAttribute("kaoqinFlag", "考勤数据太少，无法观察出特点！");
        }
        if(kaoqinCount[0]+kaoqinCount[1] >= 0){
            if((kaoqinCount[2]+kaoqinCount[3]) / (kaoqinCount[0]+kaoqinCount[1]+1) > 0.1){
                model.addAttribute("kaoqinFlag", "请遵守校规校纪，减少迟到、早退次数！");
            }
        }
        else {
            model.addAttribute("kaoqinFlag", "出勤情况很不错，请保持现在的态度，对出勤认真负责！");
        }
        if(kaoqinCount[4] > 0){
            model.addAttribute("kaoqinXiaofu", "请注意着装，如未有特殊情况，请在校内穿着校服！");
        }
        model.addAttribute("kaoqinCount", kaoqinCount);
    }

    public void showConsumption(Model model){
        //获取自己的消费信息
        List<StudentConsumptionRecord> consumptionList = consumptionService.selectByStudentId(studentId);
        //月消费额
        int comsp[] = new int[15];
        int comspCount[] = new int[15];
        //日消费额
        int comspDay[][] = new int[15][32];
        int comspDayCount[][] = new int[15][32];
        for(StudentConsumptionRecord consumption1 : consumptionList){
            String[] splitTemp = consumption1.getConsumptionTime().split(" ");//拿出年/月/日
            String[] dealDate = splitTemp[0].split("/");

            int month = Integer.valueOf(dealDate[1]);
            int day = Integer.valueOf(dealDate[2]);

            comsp[month] -= consumption1.getAmount();//转为正数
            comspCount[month]++;//月消费次数
            comspDay[month][day] -= consumption1.getAmount();//转为正数
            comspDayCount[month][day]++;//日消费次数
        }
        model.addAttribute("comsp", comsp);
        model.addAttribute("comspCount", comspCount);
        model.addAttribute("comspDay", comspDay);
        model.addAttribute("comspDayCount", comspDayCount);
    }

    @RequestMapping("/ctoIndex")
    public String ctoIndex(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }
    @RequestMapping("/ctoScore")
    public String ctoScore(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/score";
    }
    @RequestMapping("/ctoChoice")
    public String ctoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/choice";
    }
    @RequestMapping("/ctoProfile")
    public String ctoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }
    @RequestMapping("/ctoPianke")
    public String ctoPianke(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/pianke";
    }
    @RequestMapping("/ctoSubsidies")
    public String ctoSubsidies(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/subsidies";
    }
    @RequestMapping("/ctoXuefeng")
    public String ctoXuefeng(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/xuefeng";
    }
}
