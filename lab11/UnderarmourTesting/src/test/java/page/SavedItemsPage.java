package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.WaitsUtil;

public class SavedItemsPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.asos.com/saved-lists/?nlid=nav+header&sort=dateasc";
    private static final String FIND_FIRST_ITEM_PAGE = "https://www.asos.com/bershka/bershka-maxi-belted-coat-in-black/prd/203831276";
    private static final String FIND_SECOND_ITEM_PAGE = "https://www.asos.com/asos-design/asos-design-longline-trench-coat-in-stone/prd/201104221";
    private static final String FIND_THIRD_ITEM_PAGE = "https://www.asos.com/asos-design/asos-design-velour-look-belted-padded-coat-in-mink/prd/202185043";
    private static final String FIND_THIRD_ITEM = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol/li[3]/div/div/div/div[1]/a/div[2]/div/div";
    private static final String FIND_SECOND_ITEM = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol/li[2]/div/div/div/div[1]/a/div[2]/div/div";
    private static final String FIND_FIRST_ITEM = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol/li[1]/div/div/div/div[1]/a/div[2]/div/div";
    private static final String FIND_FIRST_ITEM_DELETE_BUTTON = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol/li[1]/div/div/div/button[1]";
    private static final String FIND_SECOND_ITEM_DELETE_BUTTON = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol/li[2]/div/div/div/button[1]";
    private static final String FIND_THIRD_ITEM_DELETE_BUTTON = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol/li[3]/div/div/div/button[1]";
    private static final String FIND_INFORMATION_ABOUT_NUMBER_OF_SAVED_ITEMS = "//*[@id=\"saved-lists-app\"]/main/div/div/h2";
    private static final String FIND_ADD_TO_FAVORITE_BUTTON_FIRST_ITEM = "//*[@id=\"save-for-later-portal-203831276\"]/button";
    private static final String FIND_ADD_TO_FAVORITE_BUTTON_SECOND_ITEM = "//*[@id=\"save-for-later-portal-201104221\"]/button";
    private static final String FIND_ADD_TO_FAVORITE_BUTTON_THIRD_ITEM = "//*[@id=\"save-for-later-portal-202185043\"]/button";
    private static final String FIND_ADD_TO_CART_BUTTON = "//*[@id=\"saved-lists-app\"]/main/div/div[1]/section/ol/li[3]/div/div/div/button[2]";
    @FindBy(xpath = FIND_ADD_TO_FAVORITE_BUTTON_FIRST_ITEM)
    private WebElement firstItemFavorite;

    @FindBy(xpath = FIND_ADD_TO_FAVORITE_BUTTON_SECOND_ITEM)
    private WebElement secondItemFavorite;

    @FindBy(xpath = FIND_ADD_TO_FAVORITE_BUTTON_THIRD_ITEM)
    private WebElement thirdItemFavorite;
    @FindBy(xpath = FIND_FIRST_ITEM)
    private WebElement firstItem;

    @FindBy(xpath = FIND_SECOND_ITEM)
    private WebElement secondItem;

    @FindBy(xpath = FIND_THIRD_ITEM)
    private WebElement thirdItem;

    @FindBy(xpath = FIND_FIRST_ITEM_DELETE_BUTTON)
    private WebElement firstItemDeleteButton;

    @FindBy(xpath = FIND_SECOND_ITEM_DELETE_BUTTON)
    private WebElement secondItemDeleteButton;

    @FindBy(xpath = FIND_THIRD_ITEM_DELETE_BUTTON)
    private WebElement thirdItemDeleteButton;

    @FindBy(xpath = FIND_INFORMATION_ABOUT_NUMBER_OF_SAVED_ITEMS)
    private WebElement informationAboutNumberOfSavedItems;

    @FindBy(xpath = FIND_ADD_TO_CART_BUTTON)
    private WebElement addTocartButton;


    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SavedItemsPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Saved Items Page open");
        return this;
    }

    public SavedItemsPage addItemsToFavorites() {
        addFirstItemToFavorite();
        addSecondItemToFavorite();
        addThirdItemToFavorite();
        return this;
    }

    public SavedItemsPage addFirstItemToFavorite() {
        driver.get(FIND_FIRST_ITEM_PAGE);
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_ADD_TO_FAVORITE_BUTTON_FIRST_ITEM, driver);
        scrollIntoView(firstItemFavorite);
        firstItemFavorite.click();
        logger.info("First item added to Saved Items");
        return this;
    }

    public SavedItemsPage addSecondItemToFavorite() {
        driver.get(FIND_SECOND_ITEM_PAGE);
        scrollIntoView(secondItemFavorite);
        secondItemFavorite.click();
        logger.info("Second item added to Saved Items");
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_ADD_TO_FAVORITE_BUTTON_SECOND_ITEM, driver);

        return this;
    }

    public SavedItemsPage addThirdItemToFavorite() {
        driver.get(FIND_THIRD_ITEM_PAGE);
        scrollIntoView(thirdItemFavorite);
        thirdItemFavorite.click();
        logger.info("Third item added to Saved Items");
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_ADD_TO_FAVORITE_BUTTON_THIRD_ITEM, driver);
        return this;
    }

    public String getFirstFavoriteItem() {
        return firstItem.getText();
    }

    public String getSecondFavoriteItem() {
        return secondItem.getText();
    }

    public String getThirdFavoriteItem() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_THIRD_ITEM, driver);
        return thirdItem.getText();
    }

    public SavedItemsPage removeAllFavoritesItem() {
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_THIRD_ITEM_DELETE_BUTTON, driver);
        thirdItemDeleteButton.click();
        logger.info("Third item removed from favorites");
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_SECOND_ITEM_DELETE_BUTTON, driver);
        secondItemDeleteButton.click();
        logger.info("Second item removed from favorites");
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_FIRST_ITEM_DELETE_BUTTON, driver);
        firstItemDeleteButton.click();
        logger.info("First item removed from favorites");
        return this;
    }



    public String getInformationAboutNumberOfSavedItems() {
        WaitsUtil.waitForVisibilityOfElementLocatedByXpath(FIND_INFORMATION_ABOUT_NUMBER_OF_SAVED_ITEMS, driver);
        return informationAboutNumberOfSavedItems.getText();
    }

    public void scrollIntoView(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
