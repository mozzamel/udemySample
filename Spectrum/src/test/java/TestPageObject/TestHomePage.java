package TestPageObject;

import common.CommonApi;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.HomePage;

public class TestHomePage extends CommonApi {
   @Test
    public void homeObj(){
        HomePage obj = PageFactory.initElements(driver, HomePage.class);
        obj.businessClick();
    }
}
