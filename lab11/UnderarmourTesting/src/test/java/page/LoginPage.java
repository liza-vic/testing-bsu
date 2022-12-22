package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WaitsUtil;


public class LoginPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.asos.com/bag?nlid=nav%20header";
    private static final String FIND_MY_ACCOUNT_BUTTON = "//*[@id=\"bagApp\"]/div[1]/div/div/div/p[3]";
    private static final String FIND_INPUT_BOX_EMAIL = "//*[@id=\"EmailAddress\"]";
    private static final String FIND_INPUT_BOX_PASSWORD = "//*[@id=\"Password\"]";
    private static final String FIND_SIGN_IN_BUTTON = "//*[@id=\"signin\"]";

    @FindBy(xpath = FIND_INPUT_BOX_EMAIL)
    private WebElement inputBoxEmail;

    @FindBy(xpath = FIND_INPUT_BOX_PASSWORD)
    private WebElement inputBoxPassword;

    @FindBy(xpath = FIND_SIGN_IN_BUTTON)
    private WebElement signInButton;

    @FindBy(xpath = FIND_MY_ACCOUNT_BUTTON)
    private WebElement myAccountButton;

    @FindBy(xpath = "/html/body/h1")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
       driver.get(PAGE_URL);
       return this;
    }

    public LoginPage getLoggedInUserName(User user) {
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_MY_ACCOUNT_BUTTON, driver);
        myAccountButton.click();
        logger.info("Login page opened");
        inputBoxEmail.sendKeys(user.getUsername());
        logger.info("Username entered");
        inputBoxPassword.sendKeys(user.getPassword());
        signInButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
