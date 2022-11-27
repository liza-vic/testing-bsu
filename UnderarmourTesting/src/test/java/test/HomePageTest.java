package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

    public class HomePageTest {
        private WebDriver driver;



    @BeforeMethod(
            alwaysRun = true
    )
    public void browserSetUp() {
        this.driver = new ChromeDriver();
    }

    @Test
    public void checkValidDataInTextArea() {
        String expectedMessage = "Sorry, no results for “---”";
        HomePage homePage = (new HomePage(this.driver)).openPage().clickInputBoxMainPage()
                .writeSomeWordsIntoInputBoxMainPage("---")
                .pressEnter().inputInEmailField("no").closeWindow();
        String actualMessage = homePage.isContainsErrorElement();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @AfterMethod(
            alwaysRun = true
    )
    public void browserTearDown() {
        this.driver.quit();
    }
}
