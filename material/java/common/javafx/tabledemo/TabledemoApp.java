///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.openjfx:javafx-controls:23
//DEPS org.openjfx:javafx-graphics:23:${os.detected.jfxname}
//DEPS org.openjfx:javafx-fxml:23
//DEPS com.google.guava:guava:33.1.0-jre
//DEPS org.kordamp.bootstrapfx:bootstrapfx-core:0.4.0

//SOURCES Person.java
//SOURCES AppController.java
//SOURCES HealthStatus.java

//FILES tabledemo.fxml

import java.io.IOException;
import java.net.URL;

import org.kordamp.bootstrapfx.BootstrapFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TabledemoApp extends Application {
  private Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    try {
      final URL url = getClass().getResource("tabledemo.fxml");
      final FXMLLoader fxmlLoader = new FXMLLoader(url);
      final AnchorPane root = (AnchorPane) fxmlLoader.load();
      scene = new Scene(root, 500, 300);
      scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
      stage.setScene(scene);
    } catch (IOException ex) {
      System.err.println("Erreur au chargement: " + ex);
      ex.printStackTrace();
      System.exit(1);
    }
    stage.setTitle("Test FXML");
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
