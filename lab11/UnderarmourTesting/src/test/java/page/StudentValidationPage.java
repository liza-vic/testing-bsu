package page;

import model.StudentData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentValidationPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.asos.com/discover/students/asos-on-campus/student-validation/";
    private static final String FIND_FIRST_NAME_FORM = "//*[@id=\"firstName\"]";
    private static final String FIND_LAST_NAME_FORM = "//*[@id=\"lastName\"]";
    private static final String FIND_REGISTERED_ASOS_EMAIL_ADDRESS_FORM = "//*[@id=\"asosEmail\"]";
    private static final String FIND_STUDENT_EMAIL_ADDRESS_FORM = "//*[@id=\"studentEmail\"]";
    private static final String FIND_YEAR_GRADE_BUTTON = "//*[@id='2023']";
    private static final String FIND_SELECT_GENDER_BUTTON = "//*[@id='creative']/div[1]/div[2]/form/fieldset[2]/div[1]/label";
    private static final String FIND_SUBMIT_BUTTON = "//*[@id='submitButton']";
    private static final String ERROR_XPATH = "//*[@id=\"asosEmail-error\"]";

    @FindBy(xpath = FIND_FIRST_NAME_FORM)
    private WebElement inputFirstName;

    @FindBy(xpath = FIND_LAST_NAME_FORM)
    private WebElement inputLastName;

    @FindBy(xpath = FIND_REGISTERED_ASOS_EMAIL_ADDRESS_FORM)
    private WebElement inputRegisteredAsosEmailAddress;

    @FindBy(xpath = FIND_STUDENT_EMAIL_ADDRESS_FORM)
    private WebElement inputStudentEmailAddress;

    @FindBy(xpath = FIND_YEAR_GRADE_BUTTON)
    private WebElement yearGradeButton;
    @FindBy(xpath = FIND_SELECT_GENDER_BUTTON)
    private WebElement genderButton;

    @FindBy(xpath = FIND_SUBMIT_BUTTON)
    private WebElement submitButton;

    public StudentValidationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public StudentValidationPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Student Validation page opened");
        return this;
    }


    public StudentValidationPage enteringOrderData(StudentData userData) {
        inputFirstName.sendKeys(userData.getStudentFirstName());
        inputLastName.sendKeys(userData.getStudentLastName());
        inputRegisteredAsosEmailAddress.sendKeys(userData.getRegisteredAsosEmailAddress());
        inputStudentEmailAddress.sendKeys(userData.getStudentEmailAddress());
        yearGradeButton.click();
        genderButton.click();
        submitButton.click();
        logger.info("First name entered - [" + inputFirstName +
                "] last name: [" + inputLastName +
                "]. Registered asos and student email address entered - [" +
                inputRegisteredAsosEmailAddress + inputStudentEmailAddress + "]");
        return this;
    }

    public String getErrorMessage() {
        return By.xpath(ERROR_XPATH).findElement(driver).getText();
    }


}
