package com.cours.jee.ejb;

import java.util.ArrayList;
import java.util.List;

import com.cours.jee.dao.CalculatorDao;
import com.cours.jee.model.CalculatorResult;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class CalculatorBean {
  @Inject
  CalculatorDao calculatorDao;

  public List<CalculatorResult> getAll() {
    return new ArrayList<>();
  }
}
