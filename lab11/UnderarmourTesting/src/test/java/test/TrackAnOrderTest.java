package test;

import model.UserData;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.TrackAnOrderPage;
import service.UserDataCreator;
import util.TestListener;

import static test.HomePageTest.TESTDATA_USER_POPUP_EMAIL_FORM;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Listeners({TestListener.class})
public class TrackAnOrderTest extends CommonConditions {

    @Test
    public void checkValidDataInTextArea() {
        UserData testUser = UserDataCreator.withCredentialsFromProperty();
        TrackAnOrderPage trackAnOrderPage = new TrackAnOrderPage(driver)
                .openPage()
                .enteringOrderData(testUser).clickForeForm()
                .inputInPopupEmailField(TESTDATA_USER_POPUP_EMAIL_FORM)
                .closeWindow();

        assertThat(trackAnOrderPage.getErrorMessage(), is(equalTo("Sorry! We’re experiencing a system issue and" +
                " cannot retrieve your order right now. Please try back later.")));
    }
}
