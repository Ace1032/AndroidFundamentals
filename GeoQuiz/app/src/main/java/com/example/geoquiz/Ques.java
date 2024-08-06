package com.example.geoquiz;

public class Ques {
    private String q;

    public Ques(String q, boolean ans) {
        this.q = q;
        this.ans = ans;
    }

    private boolean ans;
    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }



}
