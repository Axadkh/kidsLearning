package com.ali.kidslearing.adapter;

public class MathModel {

    private int no1;
   private  int no2;

    private int no1f;
    private  int no2f;

   private  int symbol;

   private  int ans;
   private  int ansf;

    public MathModel(int no1, int no1f, int symbol,int no2, int no2f, int ans, int ansf) {
        this.no1 = no1;
        this.no2 = no2;
        this.no1f = no1f;
        this.no2f = no2f;
        this.symbol = symbol;
        this.ans = ans;
        this.ansf = ansf;
    }

    public int getNo1f() {
        return no1f;
    }

    public void setNo1f(int no1f) {
        this.no1f = no1f;
    }

    public int getNo2f() {
        return no2f;
    }

    public void setNo2f(int no2f) {
        this.no2f = no2f;
    }

    public int getAnsf() {
        return ansf;
    }

    public void setAnsf(int ansf) {
        this.ansf = ansf;
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

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }
}
