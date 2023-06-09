package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")
    WebElement acceptCookiesButton;





    public void getURL() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }
    public void acceptCookies() {
        acceptCookiesButton.click();
    }



    public HomePage(WebDriver driver) {
        super(driver);
    }


}


