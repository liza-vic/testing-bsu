package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    public static final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public abstract AbstractPage openPage();

    public abstract AbstractPage inputInPopupEmailField(String term);

    public abstract AbstractPage closeWindow();
}
