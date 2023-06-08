package hu.masterfield.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    @Before // cucumber annotáció
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();

        // loading arguments, properties
        Properties props = new Properties(); // java.util
        InputStream is = TescoSteps.class.getResourceAsStream("/browser.properties");
        props.load(is);

        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        // chromeOptions.setHeadless(true);

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900)); // ...selenium.Dimension
    }

    @After /* cucumber-es */
    public static void cleanup() {
        driver.quit();
    }

    @Given("customer is on the home page")
    public void customerIsOnTheHomePage() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    @And("all cookies are accepted")
    public void allCookiesAreAccepted() {
        WebElement acceptCookiesButton =
                wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")));
        acceptCookiesButton.click();
    }

    @And("language is set to {string}")
    public void languageIsSetTo(String lang) {

        WebElement languageButton = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")));

        /*  ide nem kell semmilyen ellenőrzés
            csak rá kell kattintani a gombra, hogy átálljon magyarra
        *  */
        if (lang.equals("magyar")) {
            languageButton.click();
        }
    }

    /**
     * WebElement languageButton = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"utility-header-language-switch-link\"]/span/span")));
     * <p>
     * if (languageButton.getText().equals("English")) {
     * assertEquals("magyar", languageButton.getText());
     * }
     **/


    @When("searching for existing {string}")
    public void searchingForExisting(String product) {

        WebElement searchField = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"search-input\"]")));
        searchField.sendKeys(product);
        WebElement searchIcon = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"search-form\"]/button")));
        searchIcon.click();

        /* megkeresed a keresés beviteli mezőt
         * kitöltöd (sendkeys) a product változóval
         * nagyító ikonra kattintás */
    }

    @Then("{string} are displayed")
    public void areDisplayed(String numOfProducts) {

        WebElement searhResult = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/strong[2]")));
        searhResult.getText();
        System.out.println(searhResult);

        /* "190 termékből" -> //*[@id="product-list"]/div[2]/div[3]/div[1]/div/div[1]/div[1]/div[1]/strong[2] */
        /* getText(); */
        /* indexOf(numOfProducts) String.indexOf() -1 ??? assertEquals(numOfProducts, )
         * System.out.println(); -- debuggolásra
         * */
    }

    @When("when searching for unavailable {string}")
    public void whenSearchingForUnavailable(String arg0) {
    }

    @Then("message is displayed with {string}")
    public void messageIsDisplayedWith(String arg0) {
    }
}
