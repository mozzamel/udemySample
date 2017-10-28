package pageObject;

import common.CommonApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticePage extends CommonApi {
@FindBy(how = How.CSS,using = "#name")
    public static WebElement nameInput;
@FindBy(how = How.CSS,using = ".btn-style.class1.class2")
public static WebElement openTab;
public void setNameInput(String yourName)throws Exception {
    nameInput.sendKeys(yourName);
    Thread.sleep(2000);

}
public void setOpenTab()throws Exception{
    openTab.click();
    Thread.sleep(3000);
}

}
