package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/div[5]/div/div[3]/button[2]")
    WebElement acceptCookiesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://futar.bkk.hu");
        assertTrue(isLoaded(acceptCookiesButton));
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

}
