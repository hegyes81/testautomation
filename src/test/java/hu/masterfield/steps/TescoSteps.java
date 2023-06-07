package hu.masterfield.steps;

import hu.masterfield.pages.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TescoSteps extends BasePage {

    @Given("customer is on the home page")
    public void customerIsOnTheHomePage() {
    }

    @And("all cookies are accepted")
    public void allCookiesAreAccepted() {
    }

    @And("language is set to Magyar")
    public void languageIsSetToMagyar() {
    }

    @When("searching for existing <product>")
    public void searchingForExistingProduct() {
    }

    @Then("products containing <product> name are displayed")
    public void productsContainingProductNameAreDisplayed() {
    }


    /**
    @Then("message is displayed with {string}")
    public void messageIsDisplayedWith(String arg0) {
    }

    @Then("products containing <PRODUCT_FIRST PRODUCT_SECOND> or <PRODUCT_FIRST product_second> or <product_first product_second> name are displayed")
    public void productsContainingPRODUCT_FIRSTPRODUCT_SECONDOrPRODUCT_FIRSTProduct_secondOrProduct_firstProduct_secondNameAreDisplayed() {
    }

    @When("searching with {string}")
    public void searchingWith(String arg0) {
    }

    @Then("message is displayed saying {string}")
    public void messageIsDisplayedSaying(String arg0) {
    }
    **/
}
