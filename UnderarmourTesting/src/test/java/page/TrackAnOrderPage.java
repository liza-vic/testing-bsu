package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackAnOrderPage extends AbstractPage{
    private static final String PAGE_URL = "https://www.underarmour.com/en-us/guest-login/";
    private static final String PAGE_FINITE_URL = "https://www.underarmour.com/on/demandware.store/Sites-US-Site/en_US/Order-Track/";
    private static final String FIND_TRACK_ORDER_FORM_NUMBER = "//*[@id='trackorder-form-number']";
    private static final String FIND_TRACK_ORDER_FORM_EMAIL = "//*[@id='trackorder-form-email']";
    private static final String ERROR_XPATH = "//*[@id='maincontent']/div/div/div/div[1]/form/div[2]/div[1]/div/strong";

    @FindBy(xpath = FIND_TRACK_ORDER_FORM_NUMBER)
    private WebElement inputFormOderNumber;

    @FindBy(xpath = FIND_TRACK_ORDER_FORM_EMAIL)
    private WebElement inputEmailBox;

    public TrackAnOrderPage(WebDriver driver) {
        super(driver);
    }

    public TrackAnOrderPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public TrackAnOrderPage enterOrderNumbers(String term) {
        inputFormOderNumber.sendKeys(term);
        return this;
    }

    public TrackAnOrderPage inputInEmailField(String term) {
        inputEmailBox.sendKeys(term);
        return this;
    }
    public TrackAnOrderPage pressEnter() {
        inputEmailBox.sendKeys(Keys.ENTER);
        return this;
    }
    public String isContainsErrorElement() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(PAGE_FINITE_URL)));
        return driver.findElement(By.xpath(ERROR_XPATH)).getText();
    }


}
