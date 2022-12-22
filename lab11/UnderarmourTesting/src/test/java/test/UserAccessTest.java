package test;

import model.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.LoginPage;
import service.UserCreator;
import util.TestListener;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Listeners({TestListener.class})
public class UserAccessTest extends CommonConditions {
    @Test
    public void checkingTheAbilityToLogin() {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage shoppingBagPage = new LoginPage(driver)
                .openPage()
                .getLoggedInUserName(testUser);

        assertThat(shoppingBagPage.getErrorMessage(), is(equalTo("Access Denied")));
    }
}
