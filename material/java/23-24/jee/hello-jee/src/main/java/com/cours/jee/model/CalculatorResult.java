package com.cours.jee.model;

import java.io.Serializable;

public class CalculatorResult implements Serializable {
    private int sum;
    private int difference;

    public CalculatorResult() {
    }

    public CalculatorResult(int sum, int difference) {
        this.sum = sum;
        this.difference = difference;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

}
