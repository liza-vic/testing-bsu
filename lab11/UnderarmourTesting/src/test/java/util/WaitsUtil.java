package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class WaitsUtil {
    public static void waitForVisibilityOfElementLocatedByXpath(String webElementXpath, WebDriver driver) {
        new WebDriverWait(driver, AbstractPage.WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXpath)));
    }

    public static void waitForElementToBeSelected(String webElementXpath, WebDriver driver) {
        new WebDriverWait(driver, AbstractPage.WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeSelected(By.xpath(webElementXpath)));
    }
}
