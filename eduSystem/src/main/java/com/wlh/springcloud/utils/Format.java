package com.wlh.springcloud.utils;

public class Format {
    public static int formatSubId(int subId) {
        int ans = -1;
        switch (subId){
            case 1:
                ans = 0;break;
            case 2:
                ans = 1;break;
            case 3:
                ans = 2;break;
            case 4:
                ans = 3;break;
            case 5:
                ans = 4;break;
            case 6:
                ans = 5;break;
            case 7:
                ans = 6;break;
            case 8:
                ans = 7;break;
            case 17:
                ans = 8;break;
            case 59:
                ans = 9;break;
        }
        return ans;
    }
}

