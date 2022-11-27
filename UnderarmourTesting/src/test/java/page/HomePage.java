package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private static final String PAGE_URL = "https://www.underarmour.com/en-us/";
    private static final String FIND_INPUT_MAIN_PAGE_BOX_XPATH = "//*[@id='dt-standard-basic']";
    private static final String FIND_INPUT_EMAIL_BOX = "//*[@id='hpEmailSignUp']";
    private static final String ERROR_XPATH = "//*[@id='maincontent']/div/div/div[1]/div[1]/div[1]/div[1]/p";

    @FindBy(xpath = FIND_INPUT_MAIN_PAGE_BOX_XPATH)
    private WebElement inputBoxMainPage;

    @FindBy(xpath = FIND_INPUT_EMAIL_BOX)
    private WebElement inputEmailBox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(FIND_INPUT_MAIN_PAGE_BOX_XPATH)));
        return this;
    }

    public HomePage clickInputBoxMainPage() {
        inputBoxMainPage.click();
        return this;
    }

    public HomePage writeSomeWordsIntoInputBoxMainPage(String term) {
        inputBoxMainPage.sendKeys(term);
        return this;
    }

    public HomePage pressEnter() {
        inputBoxMainPage.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage inputInEmailField(String term) {
        inputEmailBox.sendKeys(term);
        return this;
    }

    public HomePage closeWindow() {
        inputEmailBox.sendKeys(Keys.ESCAPE);
        return this;
    }

    public String isContainsErrorElement() {
        return driver.findElement(By.xpath(ERROR_XPATH)).getText();
    }

}
