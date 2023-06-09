package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"product-list\"]/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/strong[2]")
    WebElement searchResult;

    // //*[@id="search-input"]
    // //*[@id="search-input"]
    // //*[@id="product-list"]/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/strong[2]
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void validateSearchResult(String numberOfProduct) {
        assertTrue(searchResult.getText().contains(numberOfProduct));
    }
}
