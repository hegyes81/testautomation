package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")
    WebElement acceptCookiesButton;

    @FindBy(xpath = "//*[@id=\"utility-header-language-switch-link\"]/span/span")
    WebElement languageButton;


    @FindBy(xpath = "//*[@id=\"search-input\"]")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"search-form\"]/button")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"product-list\"]/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/strong[2]")
    WebElement searchResult;

    /**   WebElement languageButton = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")));
     if (lang.equals("Magyar")) {
     languageButton.click();
     }
     */

    /**
     *         WebElement searchField = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"search-input\"]")));
     *         searchField.sendKeys(product);
     *         WebElement searchIcon = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"search-form\"]/button")));
     *         searchIcon.click();
     *
     */
    /**
     * WebElement searchResult = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/strong[2]")));
     * assertEquals(numberOfProduct, searchResult.getText().substring(0, searchResult.getText().indexOf(" ")));
     */

    public void getURL() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public void setLanguage(String lang) {
        if (lang.equals("Magyar")) {
            languageButton.click();
        }
    }

    public void fillSearchField(String product) {
        searchField.sendKeys(product);

    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public validateSearchResult() {
        return assertEquals(numberOfProduct, searchResult.getText().substring(0, searchResult.getText().indexOf(" ")));

    }
    public HomePage(WebDriver driver) {
        super(driver);
    }


}


