package hu.masterfield.pages;


public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/div[5]/div/div[3]/button[2]")
    WebElement acceptCookiesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://futar.bkk.hu");
        assertTrue(isLoaded(acceptCookiesButton));
        // assert
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }


}
