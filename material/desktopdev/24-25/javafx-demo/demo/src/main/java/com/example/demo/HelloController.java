package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.random.RandomGenerator;

public class HelloController {
  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    var rng = RandomGenerator.getDefault();
    welcomeText.setText("Welcome to JavaFX Application!" + rng.nextInt(100));
  }
}