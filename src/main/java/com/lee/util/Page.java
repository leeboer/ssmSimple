package com.lee.util;

/**
 * 一个分页要使用的实体类
 */
public class Page {
    //初始位置
    private int start = 0;
    //每页显示几个
    private int count = 5;
    //最后一页的位置
    private int last = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
    //计算最后一页的位置
    //total表示总数
    public void caculateLast(int total) {
        if(0 == total%count){
            last = total-count;
        }else{
            last = total-total%count;
        }
    }
}
