module org.cours.java.projet3al {
  requires javafx.controls;
  requires javafx.fxml;


  opens org.cours.java.projet3al to javafx.fxml;
  exports org.cours.java.projet3al;
}