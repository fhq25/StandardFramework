package practice;

import common.CommonAPI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class PracticePage extends CommonAPI {

    private String url = "https://learn.letskodeit.com/p/practice";

    @FindBy(id = "bmwradio")
    private WebElement bmwRadioBtn;

    @FindBy(id = "benzradio")
    private WebElement benzRadioBtn;

    @FindBy(id = "hondaradio")
    private WebElement hondaRadioBtn;

    @FindBy(id = "bmwcheck")
    private WebElement bmwCheckbox;

    @FindBy(id = "benzcheck")
    private WebElement benzCheckbox;

    @FindBy(id = "hondacheck")
    private WebElement hondaCheckbox;

    @FindBy(id = "openwindow")
    private WebElement openWindowBtn;

    @FindBy(id = "opentab")
    private WebElement openTabBtn;

    @FindBy(name = "enter-name")
    private WebElement enterNameField;

    @FindBy(id = "alertbtn")
    private WebElement alertBtn;

    @FindBy(id = "confirmbtn")
    private WebElement confirmBtn;

    @FindBy(id = "hide-textbox")
    private WebElement hideTextBoxBtn;

    @FindBy(id = "show-textbox")
    private WebElement showTextBoxBtn;

    @FindBy(id = "displayed-text")
    private WebElement displayTextField;

    @FindBy(id = "mousehover")
    private WebElement mouseHoverBtn;

    @FindBy(xpath = "//a[text()='Top']")
    private WebElement top;

    public void navigateToPracticePage() {
        driver.get(url);
    }

    // Method that selects a car radio button depending on the argument
    public void selectCarRadioBtn(String car) {
        if (car.equalsIgnoreCase("bmw")) {
            this.clickOnWebElement(bmwRadioBtn);
        } else if (car.equalsIgnoreCase("benz")) {
            this.clickOnWebElement(benzRadioBtn);
        } else if (car.equalsIgnoreCase("honda")) {
            this.clickOnWebElement(hondaRadioBtn);
        } else {
            System.out.println("Not valid! Please enter a valid car");
        }
    }

    public void okAlert(String name) throws Exception {
        enterNameField.sendKeys(name);
        Thread.sleep(2000);
        alertBtn.click();
        Thread.sleep(2000);
        // How to handle alerts
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
    }

    public void okConfirm(String name) throws Exception {
        enterNameField.sendKeys(name);
        Thread.sleep(2000);
        confirmBtn.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelConfirm(String name) throws Exception {
        driver.findElement(By.id("doesnt exist"));
//        enterNameField.sendKeys(name);
//        Thread.sleep(2000);
//        confirmBtn.click();
//        Thread.sleep(2000);
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();
    }

    public void selectTopFromMouseHover() throws Exception {
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(mouseHoverBtn).perform();
        Thread.sleep(3000);
        actions.moveToElement(top).perform();
        Thread.sleep(3000);
        actions.click().build().perform();
    }

    public void switchToWindow() throws Exception {
        openWindowBtn.click();
        Thread.sleep(5000);
        // Save the parent window
        String parentWindow = driver.getWindowHandle();
        // Grab all the windows
        Set<String> windows = driver.getWindowHandles();
        // Switch to the new window
        for (String wind : windows) {
            if (!wind.equals(parentWindow)) {
                driver.switchTo().window(wind);
                Thread.sleep(5000);
                driver.findElement(By.id("search-courses")).sendKeys("Python");
                driver.findElement(By.id("search-course-button")).click();
                Thread.sleep(5000);
            }
        }
        Thread.sleep(5000);
        driver.switchTo().window(parentWindow);
    }
}
