package hellocucumber;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

class IsItFraidy {
  static String check(String day) {
    return null;
  }
}

public class StepDefinitions {

  private String today;
  private String actualAnswer;

  @Given("today is Sunday")
  public void today_is_sunday() {
    this.today = "Sunday";
  }

  @When("I ask whether it's Friday yet")
  public void i_ask_whether_it_s_friday_yet() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("I should be told {string}")
  public void i_should_be_told(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

}
