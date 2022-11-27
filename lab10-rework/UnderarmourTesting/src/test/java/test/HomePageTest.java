package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.HomePage;

public class HomePageTest extends CommonConditions{

    @Test
    public void checkValidDataInTextArea() throws InterruptedException {
        setup();
        String expectedMessage1 = "Sorry, no results for “---”";
        HomePage homePage = new HomePage(this.driver)
                .openPage().clickInputBoxMainPage()
                .writeSomeWordsIntoInputBoxMainPage("---")
                .pressEnter().inputInEmailField("no").closeWindow();
        String actualMessage = homePage.isContainsErrorElement();
        Assert.assertEquals(expectedMessage1, actualMessage);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        this.driver.quit();
    }
}