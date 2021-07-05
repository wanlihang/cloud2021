package com.wlh.springcloud.entities;

public class Score  implements Comparable<Score>{
    private String sub; //学科
    private int score; // 分数

    public Score(String sub, int score) {
        this.sub = sub;
        this.score = score;
    }

    public String getSub() {
        return sub;
    }

    public int getScore() {
        return score;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Score score) {           //重写Comparable接口的compareTo方法，
        return  score.getScore() - this.score;    // 根据年龄升序排列，降序修改相减顺序即可
    }
}
