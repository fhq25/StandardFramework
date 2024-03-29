package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        // Setting up the chrome browser.
        System.setProperty("webdriver.chrome.driver",
                "/Users/fahim/Documents/StandardFramework/Generic/src/main/java/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        // Close the chrome browser.
        driver.close();
    }

    public void waitForElementToBeClickable(WebElement element, int timeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnWebElement(WebElement element) {
        element.click();
    }
}
