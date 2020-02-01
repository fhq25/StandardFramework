package home;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeTest extends CommonAPI {

    @Test
    public void testUserCannotLogInToFacebookWithInvalidCredentials() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.logInFacebook("fahim1993+SHOULDNTWORK@gmail.com", "abc123!");
        boolean errorMessageIsDisplayed = homePage.logInErrorMessage.isDisplayed();
        Assert.assertEquals(errorMessageIsDisplayed, true);
    }

    @Test(dataProvider = "validLogins")
    public void testUserCanLogInSuccessfully(String email, String password) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.navigateToFacebook();
        homePage.logInFacebook(email, password);
    }

    @DataProvider(name = "validLogins")
    public Object[][] validLoginsData() {
    return new Object[][] {{"abc123@gmail.com", "abc123!"},
                           {"efg456@gmail.com", "efg456!"}};
    }

}
