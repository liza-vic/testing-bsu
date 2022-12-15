package test;

import org.testng.annotations.Test;
import page.HomePage;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HomePageTest extends CommonConditions {
    public static final String TESTDATA_SEARCH_REQUEST = TestDataReader.getTestData("testdata.search.request");
    public static final String TESTDATA_USER_POPUP_EMAIL_FORM = TestDataReader.getTestData("testdata.user.popup.email.form");

    @Test
    public void checkValidDataInTextArea() {
        HomePage homePage = new HomePage(driver)
                .openPage()
                .clickInputBoxMainPage()
                .inputInBoxMainPage(TESTDATA_SEARCH_REQUEST)
                .pressEnter()
                .inputInPopupEmailField(TESTDATA_USER_POPUP_EMAIL_FORM)
                .closeWindow();

        assertThat(homePage.getErrorMessage(), is(equalTo("Sorry, no results for “---”")));
    }
}