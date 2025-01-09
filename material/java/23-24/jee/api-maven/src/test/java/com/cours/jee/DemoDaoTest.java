package com.cours.jee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cours.jee.dao.CalculatorDao;
import com.cours.jee.model.CalculatorResult;

public class DemoDaoTest {
  CalculatorDao calculatorDao = new CalculatorDao();

  @Test
  void testCalculatorDaoExists() {
    org.junit.jupiter.api.Assertions.assertNotNull(calculatorDao);
  }

  @Test
  void testAdd() {
    calculatorDao.add(new CalculatorResult(10, 1));
    var results = calculatorDao.getAll();
    Assertions.assertThat(results).containsExactlyInAnyOrder(new CalculatorResult(10, 1));
  }
}
