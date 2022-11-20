package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnderarmourHomePage extends AbstractPage {
    private static final String PAGE_URL = "https://www.underarmour.com/en-us/";
    private static final String FIND_INPUT_MAIN_PAGE_BOX_XPATH = "//*[@id='dt-standard-basic']";
    private static final String FIND_INPUT_EMAIL_BOX = "//*[@id='hpEmailSignUp']";
    private static final String ERROR_XPATH = "//*[@id='maincontent']/div/div/div[1]/div[1]/div[1]/div[1]/p";

    @FindBy(xpath = FIND_INPUT_MAIN_PAGE_BOX_XPATH)
    private WebElement inputBoxMainPage;

    @FindBy(xpath = FIND_INPUT_EMAIL_BOX)
    private WebElement inputEmailBox;

    public UnderarmourHomePage(WebDriver driver) {
        super(driver);
    }

    public UnderarmourHomePage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(FIND_INPUT_MAIN_PAGE_BOX_XPATH)));
        return this;

    }

    public UnderarmourHomePage clickInputBoxMainPage() {
        inputBoxMainPage.click();
        return this;
    }

    public UnderarmourHomePage writeSomeWordsIntoInputBoxMainPage() {
        inputBoxMainPage.sendKeys("---");
        return this;
    }

    public UnderarmourHomePage pressEnter() {
        inputBoxMainPage.sendKeys(Keys.ENTER);
        return this;
    }

    public UnderarmourHomePage writeSomeWordsIntoInputEmailBox() {
        inputEmailBox.sendKeys("no");
        return this;
    }

    public UnderarmourHomePage closeWindow() {
        inputEmailBox.sendKeys(Keys.ESCAPE);
        return this;
    }

    public String isContainsErrorElement() {
        return driver.findElement(By.xpath(ERROR_XPATH)).getText();
    }

}
