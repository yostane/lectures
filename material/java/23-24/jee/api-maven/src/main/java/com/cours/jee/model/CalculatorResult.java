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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + sum;
        result = prime * result + difference;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CalculatorResult other = (CalculatorResult) obj;
        if (sum != other.sum)
            return false;
        if (difference != other.difference)
            return false;
        return true;
    }

}
