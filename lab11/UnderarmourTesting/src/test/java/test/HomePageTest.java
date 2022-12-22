package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.HomePage;
import service.TestDataReader;
import util.TestListener;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Listeners({TestListener.class})
public class HomePageTest extends CommonConditions {
    public static final String TESTDATA_SEARCH_REQUEST = TestDataReader.getTestData("testdata.search.request");

    @Test
    public void checkValidDataInTextArea() {
        HomePage homePage = new HomePage(driver)
                .openPage()
                .clickInputBoxMainPage()
                .inputInBoxMainPage(TESTDATA_SEARCH_REQUEST)
                .pressEnter();

        assertThat(homePage.getErrorMessage(), is(equalTo("NOTHING MATCHES YOUR SEARCH")));
    }
}
