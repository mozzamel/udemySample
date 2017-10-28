package pageObject;

import common.CommonApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EnrollNow extends CommonApi{
    @FindBy(how = How.XPATH,using = "//a[@id='i90scv3glink']")
    public static WebElement enroll;
public void setEnroll()throws Exception{
    enroll.click();
}
}
