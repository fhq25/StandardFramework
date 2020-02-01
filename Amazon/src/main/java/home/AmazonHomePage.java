package home;

import common.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage extends CommonAPI {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@class='nav-input' and @type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"nav-signin-tooltip\"]/a/span")
    private WebElement signInButton;

    public void navigateToAmazonHomePage() {
        driver.get("https://www.amazon.com/");
    }

    public void searchItem(String item) {
        this.searchBar.sendKeys(item, Keys.ENTER);
    }

    public void clearItem() {
        this.searchBar.clear();
    }

    public void clickOnSignInButton() {
        this.waitForElementToBeClickable(signInButton, 15);
        this.signInButton.click();
    }

}
