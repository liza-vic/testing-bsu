package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TrackAnOrderPage;

public class TrackAnOrderTest {
    private WebDriver driver;


    @BeforeMethod(
            alwaysRun = true
    )
    public void browserSetUp() {
        this.driver = new ChromeDriver();
    }

    @Test
    public void checkValidDataInTextArea() throws InterruptedException {
        String expectedMessage = "Sorry! We’re experiencing a system issue and cannot retrieve your order right now. Please try back later.";
        TrackAnOrderPage trackAnOrderPage = (new TrackAnOrderPage(this.driver)).openPage().enterOrderNumbers("333333")
                .inputInEmailField("lw2@gmail.com").pressEnter();
        String actualMessage = trackAnOrderPage.isContainsErrorElement();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @AfterMethod(
            alwaysRun = true
    )
    public void browserTearDown() {
        this.driver.quit();
    }
}
