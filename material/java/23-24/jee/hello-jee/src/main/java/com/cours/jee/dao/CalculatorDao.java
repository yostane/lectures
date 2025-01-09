package com.cours.jee.dao;

import java.util.ArrayList;
import java.util.List;

import com.cours.jee.model.CalculatorResult;

// DAO: Data Access Object
public class CalculatorDao {
    // Mock (ou bouchon) d'une base de données
    private static List<CalculatorResult> results = new ArrayList<>();

    public void add(CalculatorResult calculatorResult) {
        results.add(calculatorResult);
    }

    public List<CalculatorResult> getAll() {
        return results;
    }
}
