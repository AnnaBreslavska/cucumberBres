package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectComputer extends BasePage {

    public PageObjectComputer(WebDriver driver) {
        super(driver);
    }

    private final By processor = By.cssSelector("option[value='2']");
    private final By RAM = By.cssSelector("option[value='5']");
    private final By HDD = By.cssSelector("#product_attribute_3_6");
    private final By OS = By.cssSelector("#product_attribute_4_8");
    private final By addToCard = By.cssSelector("#add-to-cart-button-1");
    private final By goToCart = By.cssSelector(".ico-cart");
    private final String HDDCorrect = "HDD: 320 GB";
    private final String RAMCorrect = "RAM: 8GB [+$60.00]";


    public void selectComputerParams() {
        clickOnWebElement(processor);
        clickOnWebElement(RAM);
        clickOnWebElement(HDD);
        clickOnWebElement(OS);
        scroll();
        clickOnWebElement(addToCard);
    }

    public boolean correctParamsAdded() {
        waitDriver(goToCart);
        clickOnWebElement(goToCart);
        return elementContainsText(RAMCorrect) && elementContainsText(HDDCorrect);
    }
}
