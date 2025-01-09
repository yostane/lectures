package com.cours.jee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.cours.jee.model.Message;

public class DemoApiIntegrationTest {
  String url = "http://localhost:8080";

  @Test
  public void testPing() {
    Client client = ClientBuilder.newClient();

    WebTarget target = client.target(url + "/api/ping");
    Response response = target.request().get();

    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
        "Incorrect response code from " + url);

    Message json = response.readEntity(Message.class);

    org.assertj.core.api.Assertions.assertThat(json.getValue()).isEqualTo("Rest API is running");
    response.close();
    client.close();
  }
}
