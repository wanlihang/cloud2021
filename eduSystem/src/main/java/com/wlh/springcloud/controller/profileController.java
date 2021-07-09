package com.wlh.springcloud.controller;

import com.wlh.springcloud.entity.Student;
import com.wlh.springcloud.entity.StudentTranscripts;
import com.wlh.springcloud.service.AttendanceService;
import com.wlh.springcloud.service.StudentConsumptionRecordService;
import com.wlh.springcloud.service.StudentService;
import com.wlh.springcloud.service.StudentTranscriptsService;
import com.wlh.springcloud.utils.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class profileController {
    private Integer studentId;
    private Student student;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentTranscriptsService chengjiService;

    @Autowired
    private StudentConsumptionRecordService consumptionService;

    private List<Student> studentInfoList;

    @RequestMapping("/profile")
    public String profile(@ModelAttribute("studentId") Integer s, Model model){
        studentId = s;
        student = studentService.selectByBfStudentId(studentId);
        studentInfoList = studentService.getAllStudent();
        model.addAttribute("student", student);

//        showSex(model);
//        showAge(model);
        showScore(model);
//        showAttd(model);
//        showComsp(model);

        return "profile";
    }

//    public void showSex(Model model){
//        int manNumTotal = 0;
//        int womenNumTotal = 0;
//        int manNum[] = new int[3];
//        int womenNum[] = new int[3];
//        for(Student student : studentInfoList){
//            if(student.getGender().equals("男")){
//                if(student.getClaName().contains("高一")){
//                    manNum[0]++;
//                }
//                if(student.getClaName().contains("高二")){
//                    manNum[1]++;
//                }
//                if(student.getClaName().contains("高三")){
//                    manNum[2]++;
//                }
//                manNumTotal++;
//            }
//            else {
//                if(student.getClaName().contains("高一")){
//                    womenNum[0]++;
//                }
//                if(student.getClaName().contains("高二")){
//                    womenNum[1]++;
//                }
//                if(student.getClaName().contains("高三")){
//                    womenNum[2]++;
//                }
//                womenNumTotal++;
//            }
//        }
//        model.addAttribute("manNumTotal", manNumTotal);
//        model.addAttribute("womenNumTotal", womenNumTotal);
//        model.addAttribute("manNum", manNum);
//        model.addAttribute("womenNum", womenNum);
//
//    }

//    public void showAge(Model model){
//        //高中生年龄,一般在18岁以内
//        int ageNum1[] = new int[20];
//        int ageNum2[] = new int[20];
//        int ageNum3[] = new int[20];
//        for(Student student : studentInfoList){
//            String[] ysplit = student.getClaTerm().split("-");
//            int year = Integer.valueOf(ysplit[0]);
//            if(student.getBirthYear() != null){
//                int temp = year - Integer.valueOf(student.getBirthYear());
//                if(temp <= 14){
//                    temp = 14;
//                }
//                if(temp >= 19){
//                    temp = 19;
//                }
//                if(student.getClaName().contains("高一")){
//                    ageNum1[temp]++;
//                }
//                if(student.getClaName().contains("高二")){
//                    ageNum2[temp]++;
//                }
//                if(student.getClaName().contains("高三")){
//                    ageNum3[temp]++;
//                }
//            }
//        }
//        model.addAttribute("ageNum1", ageNum1);
//        model.addAttribute("ageNum2", ageNum2);
//        model.addAttribute("ageNum3", ageNum3);
//
//    }

    public void showScore(Model model){
        int avgScore1[] = new int[10];//高一，各科总平均分
        int avgScore2[] = new int[10];//高二，各科总平均分
        int avgScore3[] = new int[10];//高三，各科总平均分

        int avgClaScore1[][] = new int[10][20];//高一，各班各科平均分
        int avgClaScore2[][] = new int[10][20];//高二
        int avgClaScore3[][] = new int[10][20];//高三

        List<String> claName1 = new ArrayList<>();//高一
        List<String> claName2 = new ArrayList<>();//高二
        List<String> claName3 = new ArrayList<>();//高三

        List<Integer> classId1 = new ArrayList<>();//保存分年级班级号
        List<Integer> classId2 = new ArrayList<>();
        List<Integer> classId3 = new ArrayList<>();

        List<Integer> classIds = new ArrayList<>();//记录所有班级号
        //获取所有学生信息


        //初始化记录各年级班级号和班级名
//        for(Student student : studentInfoList){
//            int sid = student.getStudentName();
//            int claId = student.getClassId();
//            String claName = student.getClaName();
//            if(!classIds.contains(claId)){//记录所有班级号，用于从数据库拿数据
//                classIds.add(claId);
//            }
//            if(claName.contains("高一")) {
//                if(!classId1.contains(claId)){
//                    classId1.add(claId);
//                    claName1.add(claName);
//                }
//            }
//            else if(claName.contains("高二")){
//                if(!classId2.contains(claId)){
//                    classId2.add(claId);
//                    claName2.add(claName);
//                }
//            }
//            else if(claName.contains("高三")){
//                if(!classId3.contains(claId)){
//                    classId3.add(claId);
//                    claName3.add(claName);
//                }
//            }
//        }

        //获取同年级的成绩、考勤数据
        List<StudentTranscripts> chengjiList = chengjiService.getAllChengjiFromClaIds(classIds);//只拿一次

//        List<StudentTranscripts> chengjiListTemp = chengjiService.getAllChengji();//只拿一次
//
//        List<StudentTranscripts> chengjiList = new ArrayList<>();
//        for(StudentTranscripts chengji : chengjiListTemp){
//            if(classIds.contains(chengji.getClassId())){
//                chengjiList.add(chengji);
//            }
//        }


        //高一、高二、高三
        int stuCount1[][] = new int[10][20];//记录参与考试的人数
        int stuCount2[][] = new int[10][20];
        int stuCount3[][] = new int[10][20];

        for(StudentTranscripts chengji : chengjiList){
            int subId = Format.formatSubId(chengji.getSubjectId());//将课程号映射到0-9
            //高一
            if(classId1.contains(chengji.getClassId()) && chengji.getExamId().equals(304)){
                int index = classId1.indexOf(chengji.getClassId());//班级号位置
                avgClaScore1[subId][index] += chengji.getScore();
                stuCount1[subId][index]++;
            }
            //高二
            if(classId2.contains(chengji.getClassId()) && chengji.getExamId().equals(304)){
                int index = classId2.indexOf(chengji.getClassId());//班级号位置
                avgClaScore2[subId][index] += chengji.getScore();
                stuCount2[subId][index]++;
            }
            //高三
            if(classId3.contains(chengji.getClassId()) && chengji.getExamId().equals(304)){
                int index = classId3.indexOf(chengji.getClassId());//班级号位置
                avgClaScore3[subId][index] += chengji.getScore();
                stuCount3[subId][index]++;
            }
        }


        //按年级计算平均成绩
        int stuNum1[] = new int[10];//记录参与考试的总人数，高一
        int stuNum2[] = new int[10];//记录参与考试的总人数，高二
        int stuNum3[] = new int[10];//记录参与考试的总人数，高三
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 20; j++){
                avgScore1[i] += avgClaScore1[i][j];
                avgScore2[i] += avgClaScore2[i][j];
                avgScore3[i] += avgClaScore3[i][j];
                stuNum1[i] += stuCount1[i][j];
                stuNum2[i] += stuCount2[i][j];
                stuNum3[i] += stuCount3[i][j];
            }
            if(stuNum1[i] > 0){
                avgScore1[i] /= stuNum1[i];
            }
            if(stuNum2[i] > 0){
                avgScore2[i] /= stuNum2[i];
            }
            if(stuNum3[i] > 0){
                avgScore3[i] /= stuNum3[i];
            }
        }

        //按班级计算出平均成绩
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 20; j++){
                if(stuCount1[i][j] > 0){
                    avgClaScore1[i][j] /= stuCount1[i][j];
                }
                if(stuCount2[i][j] > 0){
                    avgClaScore2[i][j] /= stuCount2[i][j];
                }
                if(stuCount3[i][j] > 0){
                    avgClaScore3[i][j] /= stuCount3[i][j];
                }
            }
        }

        model.addAttribute("avgScore1", avgScore1);
        model.addAttribute("avgScore2", avgScore2);
        model.addAttribute("avgScore3", avgScore3);

        model.addAttribute("claName1", claName1);
        model.addAttribute("claName2", claName2);
        model.addAttribute("claName3", claName3);

        model.addAttribute("avgClaScore1", avgClaScore1);
        model.addAttribute("avgClaScore2", avgClaScore2);
        model.addAttribute("avgClaScore3", avgClaScore3);

    }

//    public void showAttd(Model model){
//        List<Integer> classId1 = new ArrayList<>();//保存分年级班级号，高一
//
//        for(Student student : studentInfoList) {
//            int sid = student.getStudentId();
//            int claId = student.getClassId();
//            String claName = student.getClaName();
//            if(claName.contains("高一")) {
//                if(!classId1.contains(claId)){
//                    classId1.add(claId);
//                }
//            }
//        }
//        int kaoqinClaCount[] = new int[20];//
//
//        List<Attendance> kaoqinList = attendanceService.getAllKaoqin();
//        int kaoqinCount[][] = new int[3][5];//0-4分别为正常进校、离校、迟到、早退、未穿校服
//        for(Attendance kaoqin1 : kaoqinList) {
//            int temp = kaoqin1.getAttendanceId();
//            int flag = -1;
//            if(kaoqin1.getClaName().contains("高一")){
//                flag = 0;
//            }
//            if(kaoqin1.getClaName().contains("高二")){
//                flag = 1;
//            }
//            if(kaoqin1.getClaName().contains("高三")){
//                flag = 2;
//            }
//            //迟到
//            if (temp == 1001 || temp == 99001) {
//                if(classId1.contains(kaoqin1.getBfClassid())){
//                    kaoqinClaCount[classId1.indexOf(kaoqin1.getBfClassid())]++;
//                }
//                kaoqinCount[flag][2]++;
//            }
//            //早退
//            if (temp == 1002 || temp == 99003) {
//                kaoqinCount[flag][3]++;
//            }
//            //未穿校服
//            if (temp == 99002) {
//                kaoqinCount[flag][4]++;
//            }
//            //进校
//            if (temp == 99004) {
//                kaoqinCount[flag][0]++;
//            }
//            //离校
//            if (temp == 99005) {
//                kaoqinCount[flag][1]++;
//            }
//        }
//        model.addAttribute("kaoqinClaCount", kaoqinClaCount);
//        model.addAttribute("kaoqinCount", kaoqinCount);
//    }

//    public void showComsp(Model model){
//        List<StudentConsumptionRecord> consumptionList = consumptionService.getAllConsumption();
//        //月消费额
//        int comsp[][] = new int[2][15];//分为男女
//        int comspCount[] = new int[15];
//
//        int countMan = 0;;//参与计数的学生数量
//        int countWomen = 0;;//参与计数的学生数量
//        int avgComspTotal[] = new int[15];
//        int avgManComsp[] = new int[15];
//        int avgWomanComsp[] = new int[15];
//
//        //日消费额
//        int comspDay[][] = new int[15][32];
//        int comspDayCount[][] = new int[15][32];
//
//        int sid = 0;
//        for(StudentConsumptionRecord consumption1 : consumptionList){
//
//            String[] splitTemp = consumption1.getDealtime().split(" ");//拿出年/月/日
//
//            String[] dealDate = splitTemp[0].split("/");
//
//            int month = Integer.valueOf(dealDate[1]);
//            int day = Integer.valueOf(dealDate[2]);
//
//            comspDay[month][day] -= consumption1.getMondeal();//日消费总金额，转为正数
//            comspDayCount[month][day]++;//日消费总次数
//
//            comspCount[month]++;//月消费次数
//
//            //统计男女数量
//            if(!consumption1.getStudentId().equals(sid)){
//                sid = consumption1.getStudentId();
//                if(consumption1.getPersex().equals("男")) {
//                    countMan++;
//                }
//                else {
//                    countWomen++;
//                }
//            }
//            //统计月消费金额
//            if(consumption1.getPersex().equals("男")){
//                comsp[0][month] -= consumption1.getAmount();//转为正数
//            }
//            else{
//                comsp[1][month] -= consumption1.getAmount();//转为正数
//            }
//        }
//
//        //计算平均消费金额
//        for(int i = 1; i < 15; i++){
//            if(countMan + countWomen > 0){
//                for(int j = 1; j < 32; j++){
//                    comspDay[i][j] /= (countMan + countWomen);
//                    comspDayCount[i][j] /= (countMan + countWomen);
//                }
//                avgComspTotal[i] = (comsp[0][i] + comsp[1][i]) / (countMan + countWomen);
//                comspCount[i] /= (countMan + countWomen);//月消费平均次数/人
//
//            }
//            if(countMan > 0){
//                avgManComsp[i] = comsp[0][i]  / countMan;
//            }
//            if(countWomen > 0){
//                avgWomanComsp[i] = comsp[1][i] / countWomen;
//            }
//        }
//
//
//        model.addAttribute("comspCount", comspCount);
//
//        model.addAttribute("comspDay", comspDay);
//        model.addAttribute("comspDayCount", comspDayCount);
//        model.addAttribute("avgComspTotal", avgComspTotal);
//        model.addAttribute("avgManComsp", avgManComsp);
//        model.addAttribute("avgWomanComsp", avgWomanComsp);
//    }

    @RequestMapping("/ptoIndex")
    public String ptoIndex(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }
    @RequestMapping("/ptoCharts")
    public String ptoCharts(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/charts";
    }
    @RequestMapping("/ptoScore")
    public String ptoScore(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/score";
    }
    @RequestMapping("/ptoChoice")
    public String ptoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/choice";
    }
    @RequestMapping("/ptoProfile")
    public String ptoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }
    @RequestMapping("/ptoPianke")
    public String ptoPianke(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/pianke";
    }
    @RequestMapping("/ptoSubsidies")
    public String ptoSubsidies(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/subsidies";
    }
    @RequestMapping("/ptoXuefeng")
    public String ptoXuefeng(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/xuefeng";
    }
}
