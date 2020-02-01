package home;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAmazonHomePage extends CommonAPI {

    @Test
    public void testSignUp() {
        AmazonHomePage hp = PageFactory.initElements(driver, AmazonHomePage.class);
        hp.navigateToAmazonHomePage();
        hp.clickOnSignInButton();
        String expectedTitle = "Amazon Sign-In";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testSearchMultipleItems() {
        AmazonHomePage hp = PageFactory.initElements(driver, AmazonHomePage.class);
        hp.navigateToAmazonHomePage();
        List<String> items = new ArrayList<>();
        items.add("mouse");
        items.add("keyboard");
        items.add("monitor");
        items.add("pc");
        for (String item : items) {
            hp.searchItem(item);
            hp.clearItem();
        }
    }
}
