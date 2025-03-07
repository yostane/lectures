package hellocucumber;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

  private String today;
  private String actualAnswer;

  @Given("today is {string}")
  public void today_is_sunday(String day) {
    this.today = day;
  }

  @When("I ask whether it's Friday yet")
  public void i_ask_whether_it_s_friday_yet() {
    this.actualAnswer = IsItFraidy.check(this.today);
  }

  @Then("I should be told {string}")
  public void i_should_be_told(String expectedAnwser) {
    assertThat(actualAnswer).isEqualTo(expectedAnwser);
  }

}
