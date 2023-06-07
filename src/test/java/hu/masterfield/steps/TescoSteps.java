package hu.masterfield.steps;

import hu.masterfield.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TescoSteps extends BasePage {
    @Given("customer is on the home page")
    public void customerIsOnTheHomePage() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    @And("all cookies are accepted")
    public void allCookiesAreAccepted() {

        // #sticky-bar-cookie-wrapper > span > div > div > div.base-components__BaseElement-sc-1mosoyj-0.styled__ButtonContainer-sc-1vnc1v2-4.oznwo.ksIudk.beans-cookies-notification__buttons-container > form:nth-child(1) > button

        WebElement acceptCookiesButton = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")));
        acceptCookiesButton.click();
    }

    @And("language is set to {string}")
    public void languageIsSetTo(String arg0) {
    }

    @When("searching for existing {string}")
    public void searchingForExisting(String product) {
        areDisplayed(product);
    }

    /**@When("change the language to {string}")
   // public void changeTheLanguageTo(String newLang) {
        languageIsSetTo(newLang);
    }
    **/

    @Then("{string} are displayed")
    public void areDisplayed(String arg0) {
    }

    @When("when searching for unavailable {string}")
    public void whenSearchingForUnavailable(String arg0) {
    }

    @Then("message is displayed with {string}")
    public void messageIsDisplayedWith(String arg0) {
    }
}
