package home;

import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonAPI {

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(css = "input[value='Log In']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[text()='The email you’ve entered doesn’t match any account. ']")
    WebElement logInErrorMessage;

    public void navigateToFacebook() {
        driver.get("https://facebook.com");
    }

    public void logInFacebook(String email, String password) {
        this.navigateToFacebook();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

}
