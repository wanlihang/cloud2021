package com.wlh.springcloud.controller;

import com.wlh.springcloud.service.AttendanceService;
import com.wlh.springcloud.service.StudentService;
import com.wlh.springcloud.service.StudentTranscriptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class xuefengController {

    @Autowired
    private StudentService studentInfoService;

    @Autowired
    private StudentTranscriptsService chengjiService;

    @Autowired
    private AttendanceService kaoqinService;

    private Integer studentId;

    private int classIndex;

//    @RequestMapping("/xuefeng")
//    public String xuefeng(@ModelAttribute("studentId") Integer s, Model model){
//        // model.addAttribute("test", "就哈哈哈哈哈哈哈哈哈哈哈");
//        studentId = s;
//
//        //获取studentInfo
//        Student studentInfo = studentInfoService.selectByBfStudentId(studentId);
//        model.addAttribute("studentInfo", studentInfo);
//
//        int claId = studentInfo.getClassId();
//        String flag = "";
//        if(studentInfo.getClaName().contains("高一")){
//            flag = "高一";
//        }
//        else if(studentInfo.getClaName().contains("高二")){
//            flag = "高二";
//        }
//        else if(studentInfo.getClaName().contains("高三")){
//            flag = "高三";
//        }
//        //传值
//        List<String> classNames = new ArrayList<>();//同年级所有班级名
//        List<Integer> classIds = new ArrayList<>();//同年级所有班级号
//        int stuNum[] = new int[20];//同年级各班级总人数
//
//        //获取同年级班级号及班级名
//        List<Student> studentInfoList = studentInfoService.getAllStudent();
//        for(Student studentInfo1 : studentInfoList) {
//            int classId = studentInfo1.getClassId();
//            String className = studentInfo1.getClaName();
//            if(className.contains(flag)) {
//                if(!classIds.contains(classId)){
//                    classIds.add(classId);
//                    classNames.add(className);
//                }
//                stuNum[classIds.indexOf(classId)]++;//高一年级各班级总人数计数
//            }
//        }
//        classIndex = classIds.indexOf(claId);
//        //前台所需要的部分数据
//        model.addAttribute("grade", flag);//年级信息（高一、高二、高三）
//        model.addAttribute("classIndex", classIndex);//本班在同年级中的位置
//        model.addAttribute("classNames", classNames);//该年级所有班级名称
//        model.addAttribute("stuNum", stuNum);//该年级各班级学生总数
//
//        switch (flag){
//            case "高一":
//                showXuefeng1(model, classIndex, classIds);break;
//            case "高二":
//                showXuefeng2(model, classIndex, classIds);break;
//            case "高三":
//                showXuefeng3(model, classIndex, classIds);break;
//        }
//
//        return "xuefeng";
//    }

//    private void showXuefeng1(Model model, int classIndex, List<Integer> classIds){
//        //数据库获取同年级的成绩、考勤数据
//        List<StudentTranscripts> chengjiList = chengjiService.getAllChengjiFromClaIds(classIds);//保证了成绩信息一定在classId中，后面无需判断
//        List<Attendance> kaoqinList = kaoqinService.getAllChengjiFromClaIds(classIds);//同上
//
//        //成绩情况——strat
//        //入学考试成绩-----得到班级所有科目平均分
//        int avgScoreEnterExam[] = new int[10];//本班平均分
//        int avgClaScoreEnterExam[][] = new int[10][20];//同年级所有班级平均分
//
//        //平时成绩1——（高一无期末成绩与期末总评）
//        int avgScoreRegular1[] = new int[10];//本班平均分
//        int avgClaScoreRegular1[][] = new int[10][20];//同年级所有班级平均分
//
//        //期中成绩——得到班级所有科目平均分
//        int avgScoreMidTerm[] = new int[10];//本班平均分
//        int avgClaScoreMidTerm[][] = new int[10][20];//同年级所有班级平均分
//
//        //平时成绩2——（高一无期末成绩与期末总评）
//        int avgScoreRegular2[] = new int[10];//本班平均分
//        int avgClaScoreRegular2[][] = new int[10][20];//同年级所有班级平均分
//
//        //记录参与考试的人数、四个考试
//        int stuCount1[][] = new int[10][20];
//        int stuCount2[][] = new int[10][20];
//        int stuCount3[][] = new int[10][20];
//        int stuCount4[][] = new int[10][20];
//
//        for(StudentTranscripts chengji : chengjiList){
//            int index = classIds.indexOf(chengji.getClassId());//班级号位置
//            int subId = Format.formatSubId(chengji.getSubjectId());//将课程号映射到0-9
//            if(index < 0 || subId < 0 || subId > 9){
//                continue;
//            }
//            Integer examNum = chengji.getExamKindId();
//            int score = chengji.getScore();
//
//            //入学考试成绩-300
//            if(examNum.equals(300)){
//                avgClaScoreEnterExam[subId][index] += score;
//                stuCount1[subId][index]++;
//            }
//            //平时成绩1-303
//            if(examNum.equals(303)){
//                avgClaScoreRegular1[subId][index] += score;
//                stuCount2[subId][index]++;
//            }
//            //期中304
//            if(examNum.equals(304)){
//                avgClaScoreMidTerm[subId][index] += score;
//                stuCount3[subId][index]++;
//            }
//
//            //平时成绩2-305
//            if(examNum.equals(305)){
//                avgClaScoreRegular2[subId][index] += score;
//                stuCount4[subId][index]++;
//            }
//        }
//
//        int claNum1[] = new int[10];//各科参与排名的班级数量
//        int claNum2[] = new int[10];//各科参与排名的班级数量
//        int claNum3[] = new int[10];//各科参与排名的班级数量
//        int claNum4[] = new int[10];//各科参与排名的班级数量
//
//        int rank1[] = new int[10];//各科的平均成绩在全年级中的位置
//        int rank2[] = new int[10];//各科的平均成绩在全年级中的位置
//        int rank3[] = new int[10];//各科的平均成绩在全年级中的位置
//        int rank4[] = new int[10];//各科的平均成绩在全年级中的位置
//
//        //计算出平均成绩
//        for(int i = 0; i < 10; i++){
//            for(int j = 0; j < 20; j++){
//                if(stuCount1[i][j] > 0){
//                    avgClaScoreEnterExam[i][j] /= stuCount1[i][j];
//                    if(avgClaScoreEnterExam[i][j] > 0){
//                        claNum1[i]++;
//                    }
//                }
//                if(stuCount2[i][j] > 0){
//                    avgClaScoreRegular1[i][j] /= stuCount2[i][j];
//                    if(avgClaScoreRegular1[i][j] > 0){
//                        claNum2[i]++;
//                    }
//                }
//                if(stuCount3[i][j] > 0){
//                    avgClaScoreMidTerm[i][j] /= stuCount3[i][j];
//                    if(avgClaScoreMidTerm[i][j] > 0){
//                        claNum3[i]++;
//                    }
//                }
//                if(stuCount4[i][j] > 0){
//                    avgClaScoreRegular2[i][j] /= stuCount4[i][j];
//                    if(avgClaScoreRegular2[i][j] > 0){
//                        claNum4[i]++;
//                    }
//                }
//
//            }
//            avgScoreEnterExam[i] = avgClaScoreEnterExam[i][classIndex];//本班入学考试
//            avgScoreRegular1[i] = avgClaScoreRegular1[i][classIndex];//本班平时成绩1
//            avgScoreMidTerm[i] = avgClaScoreMidTerm[i][classIndex];//本班期中考试
//            avgScoreRegular2[i] = avgClaScoreRegular2[i][classIndex];//本班平时成绩2
//
//            Integer temp1[] = new Integer[20];
//            Integer temp2[] = new Integer[20];
//            Integer temp3[] = new Integer[20];
//            Integer temp4[] = new Integer[20];
//
//            for(int k=0; k < avgClaScoreEnterExam[i].length; k++){
//                temp1[k]= new Integer(avgClaScoreEnterExam[i][k]);
//                temp2[k]= new Integer(avgClaScoreRegular1[i][k]);
//                temp3[k]= new Integer(avgClaScoreMidTerm[i][k]);
//                temp4[k]= new Integer(avgClaScoreRegular2[i][k]);
//            }
//            Arrays.sort(temp1, Collections.reverseOrder());
//            Arrays.sort(temp2, Collections.reverseOrder());
//            Arrays.sort(temp3, Collections.reverseOrder());
//            Arrays.sort(temp4, Collections.reverseOrder());
//
//            int rankIndex = 1;
//            for(int num : temp1){
//                if(num == avgScoreEnterExam[i]){
//                    rank1[i] = rankIndex;
//                    break;
//                }
//                rankIndex++;
//            }
//            rankIndex = 1;
//            for(int num : temp2){
//                if(num == avgScoreRegular1[i]){
//                    rank2[i] = rankIndex;
//                    break;
//                }
//                rankIndex++;
//            }
//            rankIndex = 1;
//            for(int num : temp3){
//                if(num == avgScoreMidTerm[i]){
//                    rank3[i] = rankIndex;
//                    break;
//                }
//                rankIndex++;
//            }
//            rankIndex = 1;
//            for(int num : temp4){
//                if(num == avgScoreRegular2[i]){
//                    rank4[i] = rankIndex;
//                    break;
//                }
//                rankIndex++;
//            }
//        }
//
//        //学风报告——start
//        String chengjiRank = "";
//        String chengjiChange = "从历史成绩变化上来看";
//        int chengjiFinal = 0;
//        int cj1 = 0;
//        int cj2 = 0;
//        int rankTemp = 0;
//        int countTemp = 0;
//        for(int i = 0; i < 10; i++){
//            if(claNum3[i] > 0){
//                countTemp++;
//                rankTemp += (rank3[i] * 100 / claNum3[i] );
//            }
//        }
//        if(countTemp > 0){
//            rankTemp /= countTemp;//得到所有成绩的总平均排名，百分比，最大值100
//        }
//        if(rankTemp < 20){
//            chengjiRank += "该班级成绩同年级名列前茅，";
//            cj1 = 90;
//        }
//        else if(rankTemp < 50){
//            chengjiRank += "该班级成绩高于平均水平，";
//            cj1 = 70;
//        }
//        else if(rankTemp < 60){
//            chengjiRank += "该班级成绩在同年级中稍有落后，";
//            cj1 = 50;
//        }
//        else{
//            chengjiRank += "该班级成绩比较落后，仅";
//            cj1 = 40;
//        }
//        chengjiRank += "超越了百分之" + (100-rankTemp) + "的同年级班级。";
//
//        int rankTemp0 = 0;
//        int countTemp0 = 0;
//        for(int i = 0; i < 10; i++){
//            if(claNum3[i] > 0){
//                countTemp0++;
//                rankTemp0 += (rank1[i] * 100 / claNum1[i] );
//            }
//        }
//        if(countTemp0 > 0){
//            rankTemp0 /= countTemp0;//得到所有成绩的总平均排名，百分比，最大值100
//        }
//        if(rankTemp > rankTemp0){
//            chengjiChange += "，总体上呈下降趋势。";
//            cj2 = 40;
//        }
//        else{
//            chengjiChange += "，总体上呈上升趋势。";
//            cj2 = 90;
//        }
//        chengjiFinal = (cj1 * 6 + cj2 * 4) / 10;
//        model.addAttribute("chengjiFinal", chengjiFinal);//各科平均成绩 年级排名，从0开始
//        model.addAttribute("chengjiRank", chengjiRank);//各科平均成绩 年级排名，从0开始
//        model.addAttribute("chengjiChange", chengjiChange);//各科平均成绩 年级排名，从0开始
//        //学风报告——end
//
//
//        //成绩排名数据
//        model.addAttribute("rank1", rank1);//各科平均成绩 年级排名，从0开始
//        model.addAttribute("rank2", rank2);//各科平均成绩 年级排名，从0开始
//        model.addAttribute("rank3", rank3);//各科平均成绩 年级排名，从0开始
//        model.addAttribute("rank4", rank4);//各科平均成绩 年级排名，从0开始
//
//        //参与成绩统计的班级数
//        model.addAttribute("claNum1", claNum1);//该年级所有班级参与分数统计的数量
//        model.addAttribute("claNum2", claNum2);//该年级所有班级参与分数统计的数量
//        model.addAttribute("claNum3", claNum3);//该年级所有班级参与分数统计的数量
//        model.addAttribute("claNum4", claNum4);//该年级所有班级参与分数统计的数量
//
//        //本班
//        model.addAttribute("avgScoreEnterExam", avgScoreEnterExam);
//        model.addAttribute("avgScoreRegular1", avgScoreRegular1);
//        model.addAttribute("avgScoreMidTerm", avgScoreMidTerm);
//        model.addAttribute("avgScoreRegular2", avgScoreRegular2);
//
//        //全年级
//        model.addAttribute("avgClaScoreEnterExam", avgClaScoreEnterExam);
//        model.addAttribute("avgClaScoreRegular1", avgClaScoreRegular1);
//        model.addAttribute("avgClaScoreMidTerm", avgClaScoreMidTerm);
//        model.addAttribute("avgClaScoreRegular2", avgClaScoreRegular2);
//        //成绩情况——end
//
//        //考勤
////        getKaoqin(model, kaoqinList, classIds);
//    }

//    private void showXuefeng2(Model model, int classIndex, List<Integer> classIds) {
//        //数据库获取同年级的成绩、考勤数据
//        List<StudentTranscripts> chengjiList = chengjiService.getAllChengjiFromClaIds(classIds);//保证了成绩信息一定在classId中，后面无需判断
//        List<Attendance> kaoqinList = kaoqinService.getAllChengjiFromClaIds(classIds);//同上
//
//        //成绩情况——start
//        //高二入学考试成绩（281）-----得到班级所有科目平均分
//        int avgScoreEnterExam[] = new int[10];//本班平均分
//        int avgClaScoreEnterExam[][] = new int[10][20];//同年级所有班级平均分
//
//
//        //成绩情况——end
//
//        //考勤
////        getKaoqin(model, kaoqinList, classIds);
//    }

//    private void showXuefeng3(Model model, int classIndex, List<Integer> classIds) {
//        //数据库获取同年级的成绩、考勤数据
//        List<StudentTranscripts> chengjiList = chengjiService.getAllChengjiFromClaIds(classIds);//保证了成绩信息一定在classId中，后面无需判断
//        List<Attendance> kaoqinList = kaoqinService.getAllChengjiFromClaIds(classIds);//同上
//
//        //成绩情况——start
//
//
//        //成绩情况——end
//
//        //考勤
//
////        getKaoqin(model, kaoqinList, classIds);
//    }

//    private void getKaoqin(Model model, List<Attendance> kaoqinList, List<Integer> classIds) {
//        //考勤情况——start
//        int chidao[] = new int[20];//各班迟到
//        int zaotui[] = new int[20];
//        int xiaofu[] = new int[20];
//
//        List<String> dates = new ArrayList<>();
//        List<Integer> datasChidao = new ArrayList<>();//本班迟到
//        List<Integer> datasZaotui = new ArrayList<>();
//        List<Integer> datasXiaofu = new ArrayList<>();
//
//        for(Attendance kaoqin : kaoqinList){
//            int index = classIds.indexOf(kaoqin.getBfClassid());
//            if(index < 0){
//                continue;
//            }
//            int temp = kaoqin.getControllerId();
//            //得到各班考勤情况
//            if (temp == 1001 || temp == 99001) {
//                chidao[index]++;
//            }
//            //早退
//            if (temp == 1002 || temp == 99003) {
//                zaotui[index]++;
//            }
//            //未穿校服
//            if (temp == 99002) {
//                xiaofu[index]++;
//            }
//
//            //得到本班所有考勤情况
//            String[] splitTemp = kaoqin.getAttendanceTime().split(" ");
//            String date = splitTemp[0];//拿出年/月/日
//            //初始化，增加第一条数据
//            if(dates.isEmpty()){
//                dates.add(date);
//                //迟到
//                if (temp == 1001 || temp == 99001) {
//                    datasChidao.add(1);
//                    datasZaotui.add(0);
//                    datasXiaofu.add(0);
//                }
//                //早退
//                if (temp == 1002 || temp == 99003) {
//                    datasChidao.add(0);
//                    datasZaotui.add(1);
//                    datasXiaofu.add(0);
//                }
//                //未穿校服
//                if (temp == 99002) {
//                    datasChidao.add(0);
//                    datasZaotui.add(0);
//                    datasXiaofu.add(1);
//                }
//                else {
//                    datasChidao.add(0);
//                    datasZaotui.add(0);
//                    datasXiaofu.add(0);
//                }
//            }
//            else{
//                String lastList = dates.get(dates.size() - 1);
//                Integer num1 = datasChidao.get(datasChidao.size() - 1);
//                Integer num2 = datasZaotui.get(datasZaotui.size() - 1);
//                Integer num3 = datasXiaofu.get(datasXiaofu.size() - 1);
//                if(lastList.equals(date)){
//                    //迟到
//                    if (temp == 1001 || temp == 99001) {
//                        datasChidao.set(datasChidao.size() - 1, ++num1);
//                    }
//                    //早退
//                    if (temp == 1002 || temp == 99003) {
//                        datasZaotui.set(datasZaotui.size() - 1, ++num2);
//                    }
//                    //未穿校服
//                    if (temp == 99002) {
//                        datasXiaofu.set(datasXiaofu.size() - 1, ++num3);
//                    }
//                }
//                else {
//                    dates.add(date);
//                    //迟到
//                    if (temp == 1001 || temp == 99001) {
//                        datasChidao.add(1);
//                        datasZaotui.add(0);
//                        datasXiaofu.add(0);
//                    }
//                    //早退
//                    if (temp == 1002 || temp == 99003) {
//                        datasChidao.add(0);
//                        datasZaotui.add(1);
//                        datasXiaofu.add(0);
//                    }
//                    //未穿校服
//                    if (temp == 99002) {
//                        datasChidao.add(0);
//                        datasZaotui.add(0);
//                        datasXiaofu.add(1);
//                    }
//                    else {
//                        datasChidao.add(0);
//                        datasZaotui.add(0);
//                        datasXiaofu.add(0);
//                    }
//                }
//            }
//        }
//
//        //学风报告——start
//        String kaoqinRank = "";
//        int cdRank = -1;//迟到排名
//        int ztRank = -1;//早退
//        int xfRank = -1;//校服
//        Integer temp1[] = new Integer[20];
//        Integer temp2[] = new Integer[20];
//        Integer temp3[] = new Integer[20];
//        for(int i = 0; i < 20; i++){
//            temp1[i]= new Integer(chidao[i]);
//            temp2[i]= new Integer(zaotui[i]);
//            temp3[i]= new Integer(xiaofu[i]);
//        }
//        Arrays.sort(temp1, Collections.reverseOrder());
//        Arrays.sort(temp2, Collections.reverseOrder());
//        Arrays.sort(temp3, Collections.reverseOrder());
//        for(int i = 0; i < classIds.size(); i++){
//            if(chidao[classIndex] == temp1[i] && temp1[0] != 0){
//                cdRank = i + 1;
//            }
//            if(zaotui[classIndex] == temp2[i] && temp2[0] != 0){
//                ztRank = i + 1;
//            }
//            if(xiaofu[classIndex] == temp3[i] && temp3[0] != 0){
//                xfRank = i + 1;
//            }
//        }
//
//        int kaoqinFinal = 0;
//        int count = 0;
//        if(cdRank < 0){
//            kaoqinRank += "该年级无迟到记录。";
//        }
//        else{
//            kaoqinRank += "全班共累计迟到" + chidao[classIndex] + "次，全年级排名第" + cdRank + "。";
//            kaoqinFinal += (cdRank * 100 / classIds.size());
//            count++;
//        }
//        if(ztRank < 0){
//            kaoqinRank += "该年级无早退记录。";
//        }
//        else{
//            kaoqinRank += "共累计早退" + zaotui[classIndex] + "次，全年级排名第" + ztRank + "。";
//            kaoqinFinal += (ztRank * 100 / classIds.size());
//            count++;
//        }
//        if(xfRank < 0){
//            kaoqinRank += "该年级无未穿校服记录。";
//        }
//        else{
//            kaoqinRank += "共累计未穿校服" + xiaofu[classIndex] + "次，全年级排名第" + xfRank + "。";
//            kaoqinFinal += (xfRank * 100 / classIds.size());
//            count++;
//        }
//        kaoqinFinal /= count;
//
//        model.addAttribute("kaoqinFinal", kaoqinFinal);
//        model.addAttribute("kaoqinRank", kaoqinRank);
//        //学风报告——end
//
//        //传递考勤数据
//        model.addAttribute("chidao", chidao);
//        model.addAttribute("zaotui", zaotui);
//        model.addAttribute("xiaofu", xiaofu);
//
//        model.addAttribute("dates", dates);
//        model.addAttribute("datasChidao", datasChidao);
//        model.addAttribute("datasZaotui", datasZaotui);
//        model.addAttribute("datasXiaofu", datasXiaofu);
//        //考勤情况——end
//    }


    @RequestMapping("/xtoIndex")
    public String xtoIndex(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/index";
    }
    @RequestMapping("/xtoCharts")
    public String xtoCharts(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/charts";
    }
    @RequestMapping("/xtoScore")
    public String xtoScore(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/score";
    }
    @RequestMapping("/xtoChoice")
    public String xtoChoice(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/choice";
    }
    @RequestMapping("/xtoProfile")
    public String xtoProfile(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/profile";
    }
    @RequestMapping("/xtoPianke")
    public String xtoPianke(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/pianke";
    }
    @RequestMapping("/xtoSubsidies")
    public String xtoSubsidies(RedirectAttributes attr, Model model){
        attr.addAttribute("studentId", studentId);
        return "redirect:/subsidies";
    }

}
