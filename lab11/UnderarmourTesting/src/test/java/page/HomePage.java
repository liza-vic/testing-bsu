package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.underarmour.com/en-us/";
    private static final String FIND_INPUT_MAIN_PAGE_BOX_XPATH = "//*[@id='dt-standard-basic']";
    private static final String FIND_INPUT_POPUP_EMAIL_BOX = "//*[@id='hpEmailSignUp']";
    private static final String ERROR_XPATH = "//*[@id='maincontent']/div/div/div[1]/div[1]/div[1]/div[1]/p";

    @FindBy(xpath = FIND_INPUT_MAIN_PAGE_BOX_XPATH)
    private WebElement inputBoxMainPage;

    @FindBy(xpath = FIND_INPUT_POPUP_EMAIL_BOX)
    private WebElement inputPopupEmailBox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public HomePage clickInputBoxMainPage() {
        inputBoxMainPage.click();
        logger.info("Found an input field located on the Home page");
        return this;
    }

    public HomePage inputInBoxMainPage(String term) {
        inputBoxMainPage.sendKeys(term);
        return this;
    }

    public HomePage pressEnter() {
        inputBoxMainPage.sendKeys(Keys.ENTER);
        return this;
    }

    @Override
    public HomePage inputInPopupEmailField(String term) {
        inputPopupEmailBox.sendKeys(term);
        logger.info("Email form found");
        return this;
    }

    @Override
    public HomePage closeWindow() {
        inputPopupEmailBox.sendKeys(Keys.ESCAPE);
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath(ERROR_XPATH)).getText();
    }

}
