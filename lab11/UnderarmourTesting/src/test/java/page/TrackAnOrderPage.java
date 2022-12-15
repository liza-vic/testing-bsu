package page;

import model.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackAnOrderPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.underarmour.com/en-us/guest-login/?country=US&currency=USD";
    private static final String FIND_TRACK_ORDER_FORM_NUMBER = "//*[@id='trackorder-form-number']";
    private static final String FIND_TRACK_ORDER_FORM_EMAIL = "//*[@id='trackorder-form-email']";
    private static final String ERROR_XPATH = "//*[@id='maincontent']/div/div/div/div[1]/form/div[2]/div[1]/div/strong";
    private static final String FIND_FORE_FORM = "//*[@id='welcome-mat-modal']";

    @FindBy(xpath = FIND_TRACK_ORDER_FORM_NUMBER)
    private WebElement inputFormOderNumber;

    @FindBy(xpath = FIND_TRACK_ORDER_FORM_EMAIL)
    private WebElement inputEmailBoxTrackOrder;

    @FindBy(xpath = FIND_FORE_FORM)
    private WebElement foreForm;

    public TrackAnOrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TrackAnOrderPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Track An Order page opened");
        return this;
    }

    public TrackAnOrderPage clickForeForm() {
        foreForm.click();
        return this;
    }

    public TrackAnOrderPage enteringOrderData(UserData userData) {
        inputFormOderNumber.sendKeys(userData.getOrderNumber());
        inputEmailBoxTrackOrder.sendKeys(userData.getEmail(), Keys.ENTER);
        logger.info("Order number entered - [" + inputFormOderNumber +
                "[ and email: [" + inputEmailBoxTrackOrder + "]");
        return this;
    }

    @Override
    public TrackAnOrderPage inputInPopupEmailField(String term) {
        return this;
    }

    @Override
    public TrackAnOrderPage closeWindow() {
        return this;
    }

    public String getErrorMessage() {
        return By.xpath(ERROR_XPATH).findElement(driver).getText();
    }


}
