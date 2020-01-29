package practice;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTest extends CommonAPI {

    public PracticePage practicePage;

    @BeforeMethod
    public void setUpPracticePage() {
        this.practicePage = PageFactory.initElements(driver, PracticePage.class);
        practicePage.navigateToPracticePage();
    }

    @Test(priority = -1)
    public void testSelectHondaRadioBtn() {
        practicePage.selectCarRadioBtn("honda");
    }

    @Test(priority = 2)
    public void testOkAlert() throws Exception {
        practicePage.okAlert("Joe");
    }

    @Test(priority = 0)
    public void testMouseHoverTop() throws Exception {
        practicePage.selectTopFromMouseHover();
    }

    @Test(priority = 3)
    public void testSwitchWindow() throws Exception {
        practicePage.switchToWindow();
    }

    @Test(enabled = false)
    public void testFail() throws Exception {
        practicePage.cancelConfirm("fail");
    }
}
