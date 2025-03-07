package hellocucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

  WebDriver driver = null;

  @Given("Open Browser")
  public void open_browser() {
    driver = new ChromeDriver();
    System.out.println("Chrome Browser is open");
  }

  @When("navigate to google.com")
  public void navigate_to_google_com() {
    driver.get("https://www.google.com/");
    System.out.println("Navigate to Google");
  }

  @Then("Validate the Google page is open")
  public void validate_the_google_page_is_open() {
    String actualTitle = driver.getTitle();
    String expected = "Google";
    assertEquals(expected, actualTitle);
    System.out.println("Validating the title of the webpage which is " + actualTitle);
  }

  @Then("Close the browser")
  public void close_the_browser() {
    driver.close();
    System.out.println("Closing Browser");
  }

  @Given("Flipkart is open")
  public void flipkart_is_open() {
    driver.get("https://www.flipkart.com/");
  }

  @When("I enter a product name in the search box")
  public void i_enter_a_product_name_in_the_search_box() {
    driver.findElement(By.name("q")).sendKeys("Samsung mobiles", Keys.ESCAPE);
  }

  @When("I click on the search icon")
  public void i_click_on_the_search_icon() {
    driver.findElement(By.xpath(
        "//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[1]/div[1]/header/div[1]/div[2]/form/div/button"))
      .click();
  }

  @Then("I should see the list of products related to the search")
  public void i_should_see_the_list_of_products_related_to_the_search() {
    String actualTitle = driver.getTitle();
    String expectedTitle = "Samsung Mobiles- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
    assertEquals(expectedTitle, actualTitle);
  }
}
