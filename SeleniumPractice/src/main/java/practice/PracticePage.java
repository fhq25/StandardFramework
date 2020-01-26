package practice;

import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage extends CommonAPI {

    private String url = "https://learn.letskodeit.com/p/practice";

    @FindBy(id = "bmwradio")
    WebElement bmwRadioBtn;

    @FindBy(id = "benzradio")
    WebElement benzRadioBtn;

    @FindBy(id = "hondaradio")
    WebElement hondaRadioBtn;

    @FindBy(id = "bmwcheck")
    WebElement bmwCheckbox;

    @FindBy(id = "benzcheck")
    WebElement benzCheckbox;

    @FindBy(id = "hondacheck")
    WebElement hondaCheckbox;

    @FindBy(id = "openwindow")
    WebElement openWindowBtn;

    @FindBy(id = "opentab")
    WebElement openTabBtn;

    @FindBy(name = "enter-name")
    WebElement enterNameField;

    @FindBy(id = "alertbtn")
    WebElement alertBtn;

    @FindBy(id = "confirmbtn")
    WebElement confirmBtn;

}
