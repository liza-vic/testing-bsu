import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.UnderarmourHomePage;

    public class WebDriverUnderarmour {
        private WebDriver driver;

        public WebDriverUnderarmour() {
        }

    @BeforeMethod(
            alwaysRun = true
    )
    public void browserSetUp() {
        this.driver = new ChromeDriver();
    }

    @Test
    public void checkValidDataInTextArea() throws InterruptedException {
        String expectedMessage1 = "Sorry, no results for “---”";
        UnderarmourHomePage homePage = (new UnderarmourHomePage(this.driver)).openPage().clickInputBoxMainPage()
                .writeSomeWordsIntoInputBoxMainPage()
                .pressEnter().writeSomeWordsIntoInputEmailBox().closeWindow();
        String actualMessage = homePage.isContainsErrorElement();
        Assert.assertEquals(expectedMessage1, actualMessage);
    }

    @AfterMethod(
            alwaysRun = true
    )
    public void browserTearDown() {
        this.driver.quit();
    }
}
