package pageObject;

import common.CommonApi;
import dataDriven.DataReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExcelReader extends CommonApi{
@FindBy(how = How.XPATH,using = ".//*[@id='custom-wrapping']/div/div/div/div/div/ul/li[2]/div/div/a/span")
    WebElement searchButton;
public void test()throws Exception{
    String[]value = DataReader.getDataFromExcelFile("C:\\Users\\Hm Rupon\\IdeaProjects\\udemyAutomation\\Spectrum\\src\\test\\resources\\ExelReader.xlsx",0);
    for (int i=1;i<value.length;i++){
        Thread.sleep(2000);
        searchButton.sendKeys(value[i]);
        Thread.sleep(2000);
        searchButton.clear();
        Thread.sleep(1000);

    }
}
}
