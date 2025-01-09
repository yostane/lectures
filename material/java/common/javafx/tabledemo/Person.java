import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
  /**
   * Wrapper (surcouche) de la classe String qui est compatible avec les
   * TableView. Cette propriété peut être associée à une colonne.
   * new SimpleStringProperty("") le "" veut dire que la propriété est initialisée
   * avec une chaîne vide.
   * Le StringProperty va de paire avec les balises cellValueFactory et
   * PropertyValueFactory
   */
  private final StringProperty name = new SimpleStringProperty("");
  /**
   * Dans le jargon POO name et job sont appelées des backing fields. i.e ce sont
   * les variables qui stockent ou permettent de gérer la valeur de la propriété
   */
  private final StringProperty job = new SimpleStringProperty("");
  private final StringProperty healthStatus = new SimpleStringProperty(HealthStatus.healthy.toString());
  private final StringProperty missions = new SimpleStringProperty("");

  public Person(String name, String job, HealthStatus healthStatus, List<String> missions) {
    setName(name);
    setJob(job);
    setMissions(missions);
    setHealthStatus(healthStatus);
  }

  @Override
  public String toString() {
    return "Person [name=" + getName() + ", job=" + getJob() + ", missions:" + Joiner.on(",").join(getMissions()) + "]";
  }

  /**
   * "Hello,world".split(",") -> ["Hello", "world"]
   * 3 Familles de collections qui n'ont pas la même API: List, Stream, Arrays
   * (avec les [])
   */
  public List<String> getMissions() {
    return Arrays.asList(missions.get().split(","));
  }

  public void setMissions(List<String> missions) {
    String missionAsString = Joiner.on(",").join(missions);
    this.missions.set(missionAsString);
  }

  /**
   * Pour revenir à l'enum à partir d'une String, on utilise
   * EnumType.valueOf("valeur en String l'enum")
   * 
   * @return
   */
  public HealthStatus getHealthStatus() {
    return HealthStatus.valueOf(this.healthStatus.get());
  }

  /**
   * Pour trasformer une enum en String, on utilise toString
   * 
   * @param healthStatus
   */
  public void setHealthStatus(HealthStatus healthStatus) {
    this.healthStatus.set(healthStatus.toString());
  }

  public String getName() {
    return name.get();
  }

  public void setName(String name) {
    this.name.set(name);
    ;
  }

  public String getJob() {
    return job.get();
  }

  public void setJob(String job) {
    this.job.set(job);
  }
}
