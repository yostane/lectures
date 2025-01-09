package com.cours.jee.dao;

import java.util.ArrayList;
import java.util.List;

import com.cours.jee.model.CalculatorResult;

import jakarta.enterprise.context.RequestScoped;

// DAO: Data Access Object
// RequestScoped + named: ajoute la classe dans CDI
@RequestScoped
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
