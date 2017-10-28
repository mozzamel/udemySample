package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

import static common.CommonApi.driver;

public class SignUp {
    @FindBy(how = How.XPATH, using = ".//*[@id='DrpDwnMn05label']")
    public static WebElement pracTicePage;
    @FindBy(how = How.ID, using = "signUpDialogemailInputinput")
    public static WebElement email;
    @FindBy(how = How.ID, using = "signUpDialogpasswordInputinput")

    public static WebElement passWord;
    @FindBy(how = How.XPATH, using = ".//*[@id='signUpDialogretypePasswordInputinput']")
    public static WebElement reTypePassWord;
    @FindBy(how = How.XPATH, using = ".//*[@id='signUpDialogoklink']")
    public static WebElement go;
    @FindBy(how = How.XPATH, using = ".//*[@id='comp-ihla5nr8label']")
    WebElement newWindow;
    @FindBy(how = How.CLASS_NAME, using = "s_qoGUsignUpDialogSkinNewswitchDialogLink")
    public static WebElement logIn;
    @FindBy(how = How.XPATH, using = ".//*[@id='memberLoginDialogemailInputinput']")
    public static WebElement inputEmail;
    @FindBy(how = How.XPATH,using = ".//*[@id='memberLoginDialogpasswordInputinput']")
    public static WebElement inputPass;
    @FindBy(how = How.ID,using = "memberLoginDialogoklink")
    public static WebElement clickGo;

    public void setSignUp(String Email, String password, String retypepassword) {
        pracTicePage.click();
        email.sendKeys(Email);
        passWord.sendKeys(password);
        reTypePassWord.sendKeys(retypepassword);
        go.click();
        newWindow.click();
    }

    public void SetLogIn(String inputemail, String inputpassword) throws Exception{
        pracTicePage.click();
        Thread.sleep(2000);
        logIn.click();
        Thread.sleep(3000);
        inputEmail.sendKeys(inputemail);
        Thread.sleep(2000);
        inputPass.sendKeys(inputpassword);
        clickGo.click();
        newWindow.click();
        Thread.sleep(2000);

    }

}
