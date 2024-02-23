package com.ali.kidslearing.adapter;


public class ExcriseModel {

    private int no1;
    private  int no2;
    private  int symbol;
    private  Ans ans;

    public ExcriseModel(int no1, int symbol,int no2,Ans ans) {
        this.no1 = no1;
        this.symbol = symbol;
        this.no2 = no2;
        this.ans = ans;
    }

    public int getNo1() {
        return no1;
    }

    public void setNo1(int no1) {
        this.no1 = no1;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public Ans getAns() {
        return ans;
    }

    public void setAns(Ans ans) {
        this.ans = ans;
    }


}

