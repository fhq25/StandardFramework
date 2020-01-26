package home;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends CommonAPI {

    @Test
    public void testUserCannotLogInToFacebookWithInvalidCredentials() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.logInFacebook("fahim1993+SHOULDNTWORK@gmail.com", "abc123!");
        boolean errorMessageIsDisplayed = homePage.logInErrorMessage.isDisplayed();
        Assert.assertEquals(errorMessageIsDisplayed, true);
    }

}
