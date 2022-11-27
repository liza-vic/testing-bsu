package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.TrackAnOrderPage;

public class TrackAnOrderTest extends CommonConditions {

    @Test
    public void checkValidDataInTextArea() throws InterruptedException {
        setup();
        String expectedMessage = "Sorry! We’re experiencing a system issue and cannot retrieve your order right now. Please try back later.";
        TrackAnOrderPage trackAnOrderPage = new TrackAnOrderPage(this.driver)
                .openPage().enterOrderNumbers("156432324")
                .inputInEmailFieldTrackOrder("a@gmail.com")
                .inputInEmailField("no")
                .closeWindow();
        String actualMessage = trackAnOrderPage.isContainsErrorElement();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        this.driver.quit();
    }
}
