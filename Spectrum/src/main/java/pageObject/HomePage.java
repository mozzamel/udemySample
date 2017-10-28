package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy (how= How.XPATH,using = ".//*[@id='custom-wrapping']/div/div/div/div/div/ul/li[2]/div/div/a/span")
    WebElement business;
    public void businessClick(){
        business.click();
    }
}
