
///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.openjfx:javafx-controls:23
//DEPS org.openjfx:javafx-graphics:23:${os.detected.jfxname}
//DEPS org.openjfx:javafx-fxml:23

//FILES JavaFX_Logo.png

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HellojfxApp extends Application {
  private Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    String javaInfoString = String.format("Java: %s, %s , %s",
        System.getProperty("java.version"),
        System.getProperty("java.vendor"),
        System.getProperty("java.vm.version"));
    String jfxInfoString = String.format("JavaFX: %s", System.getProperty("javafx.version"));

    URL imageURL = getClass().getResource("JavaFX_Logo.png");
    ImageView imageView = new ImageView(new Image(imageURL.openStream()));
    imageView.setPreserveRatio(true);
    imageView.setFitWidth(300);

    VBox holder = new VBox();
    holder.setFillWidth(true);
    holder.setAlignment(Pos.TOP_CENTER);
    holder.setSpacing(5);
    holder.getChildren().addAll(
        new Label(javaInfoString),
        new Label(jfxInfoString),
        imageView);

    scene = new Scene(holder, 400, 300);
    stage.setTitle("JavaFX Demo");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
