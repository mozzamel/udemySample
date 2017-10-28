package testPageObject;

import common.CommonApi;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.PracticePage;

public class TestPracticePage extends CommonApi {

    //@Test
    public void letsPractice() throws Exception {
        PracticePage obj = PageFactory.initElements(driver, PracticePage.class);
        obj.setNameInput("md hossain");
    }

   // @Test
    public void testOpenTab() throws Exception {
        PracticePage obj = PageFactory.initElements(driver, PracticePage.class);
        obj.setOpenTab();
    }
}