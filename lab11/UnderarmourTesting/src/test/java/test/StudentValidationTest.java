package test;

import model.StudentData;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.StudentValidationPage;
import service.StudentDataCreator;
import util.TestListener;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Listeners({TestListener.class})
public class StudentValidationTest extends CommonConditions {

    @Test
    public void checkValidDataInTextArea() {
        StudentData testUser = StudentDataCreator.withCredentialsFromProperty();
        StudentValidationPage trackAnOrderPage = new StudentValidationPage(driver)
                .openPage()
                .enteringOrderData(testUser);

        assertThat(trackAnOrderPage.getErrorMessage(), is(equalTo("Please enter a valid email address")));
    }
}
