package com.ali.kidslearing.adapter;

public class Ans{
        private  int ans1;
        private  int ans2;
        private  int ans3;
        private  int correct;

        public Ans(int ans1, int ans2, int ans3, int correct) {
            this.ans1 = ans1;
            this.ans2 = ans2;
            this.ans3 = ans3;
            this.correct = correct;
        }

        public int getAns1() {
            return ans1;
        }

        public void setAns1(int ans1) {
            this.ans1 = ans1;
        }

        public int getAns2() {
            return ans2;
        }

        public void setAns2(int ans2) {
            this.ans2 = ans2;
        }

        public int getAns3() {
            return ans3;
        }

        public void setAns3(int ans3) {
            this.ans3 = ans3;
        }

        public int getCorrect() {
            return correct;
        }

        public void setCorrect(int correct) {
            this.correct = correct;
        }
    }
