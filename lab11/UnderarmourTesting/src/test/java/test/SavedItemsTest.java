package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.SavedItemsPage;
import service.TestDataReader;
import util.TestListener;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Listeners({TestListener.class})
public class SavedItemsTest extends CommonConditions {
    public static final String TESTDATA_FIRST_FAVORITE_ITEM = TestDataReader.getTestData("testdata.favorite.item.first");
    public static final String TESTDATA_SECOND_FAVORITE_ITEM = TestDataReader.getTestData("testdata.favorite.item.second");
    public static final String TESTDATA_THIRD_FAVORITE_ITEM = TestDataReader.getTestData("testdata.favorite.item.third");

    @Test
    public void addingItemsToSavedItems() {
        SavedItemsPage savedItemsPage = new SavedItemsPage(driver)
                .addItemsToFavorites()
                .openPage();

        assertThat(savedItemsPage.getThirdFavoriteItem(), is(equalTo(TESTDATA_THIRD_FAVORITE_ITEM)));
        assertThat(savedItemsPage.getSecondFavoriteItem(), is(equalTo(TESTDATA_SECOND_FAVORITE_ITEM)));
        assertThat(savedItemsPage.getFirstFavoriteItem(), is(equalTo(TESTDATA_FIRST_FAVORITE_ITEM)));
    }

    @Test
    public void checkValidDataInTextArea() {
        SavedItemsPage savedItemsPage = new SavedItemsPage(driver)
                .addItemsToFavorites()
                .openPage()
                .removeAllFavoritesItem();
        assertThat(savedItemsPage.getInformationAboutNumberOfSavedItems(),
                is(equalTo("You have no Saved Items")));
    }
}
