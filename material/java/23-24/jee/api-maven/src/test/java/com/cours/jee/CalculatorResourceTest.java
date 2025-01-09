package com.cours.jee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.cours.jee.model.CalculatorResult;
import com.cours.jee.model.Message;

public class CalculatorResourceTest {
  String url = "http://localhost:8080";

  @Test
  public void testGetAll() {
    Client client = ClientBuilder.newClient();

    WebTarget target = client.target(url + "/api/calculator");
    Response response = target.request().get();

    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
        "Incorrect response code from " + url);

    var results = response.readEntity(new GenericType<List<CalculatorResult>>() {
    });

    org.assertj.core.api.Assertions.assertThat(results).isEmpty();
    response.close();
    client.close();
  }
}
