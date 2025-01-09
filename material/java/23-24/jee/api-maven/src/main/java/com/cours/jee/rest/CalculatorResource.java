package com.cours.jee.rest;

import java.util.List;
import com.cours.jee.ejb.CalculatorBean;
import com.cours.jee.model.CalculatorResult;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

  // Injection de dépendance avec CDI (API JEE pour faire du DI)
  @Inject
  CalculatorBean calculatorBean;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<CalculatorResult> getAll() {
    return calculatorBean.getAll();
  }
}
