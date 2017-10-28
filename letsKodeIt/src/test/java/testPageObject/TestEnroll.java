package testPageObject;

import common.CommonApi;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.EnrollNow;
import pageObject.PracticePage;

public class TestEnroll extends CommonApi {
    @Test
    public void letsPractice() throws Exception {
        EnrollNow enroll = PageFactory.initElements(driver, EnrollNow.class);
enroll.setEnroll();
    }
}
