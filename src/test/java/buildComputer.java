import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.PageObjectComputer;

import java.util.concurrent.TimeUnit;

public class buildComputer {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        setDriver(driver);
    }

    @Given("I am user on Building Computer page")
    public void iAmUserOnBuildingComputerPage() {
        getDriver().get("https://demo.nopcommerce.com/build-your-own-computer");
    }

    @When("I try to build computer with definite params")
    public void iTryToBuildComputerWithDefiniteParams() {
        PageObjectComputer pageObjectComputer = new PageObjectComputer(getDriver());
        pageObjectComputer.selectComputerParams();
    }

    @Then("I've added product with correct parameters to the Cart")
    public void iVeAddedProductWithCorrectParametersToTheCart() {
        PageObjectComputer pageObjectComputer = new PageObjectComputer(getDriver());
        Assert.assertTrue(pageObjectComputer.correctParamsAdded());
    }

    @After
    public void driverQuit() {
        getDriver().manage().deleteAllCookies();
        getDriver().quit();
    }
}
