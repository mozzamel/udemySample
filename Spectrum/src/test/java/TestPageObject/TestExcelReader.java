package TestPageObject;

import common.CommonApi;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.ExcelReader;

public class TestExcelReader extends CommonApi {
   // @Test
    public void searchexcel()throws Exception {
        ExcelReader obj1 = PageFactory.initElements(driver, ExcelReader.class);
        obj1.test();
    }
}