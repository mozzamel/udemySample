package testPageObject;

import common.CommonApi;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.SignUp;

import java.io.IOException;



public class TestSignUp extends CommonApi{

   //@Test
    public void practiceAndSignUp()throws Exception{
        SignUp sign = PageFactory.initElements(driver,SignUp.class);
        sign.setSignUp("pntselenium@gmail.com","6537151","6537151");
    }
//@Test
    public void testLoginPage()throws Exception{
    SignUp sign = PageFactory.initElements(driver,SignUp.class);
    sign.SetLogIn("pntselenium@gmail.com","6537151");
    }
}
