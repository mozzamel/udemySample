package common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import extendReport.ExtentFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonApi {
    public  static ExtentReports extent;
    public  static ExtentTest test;
    public static WebDriver driver = null;

    private String saucelabs_UserName = "";
    private String saucelabs_accesskey = "";
    private String browserstack_username = "mdmhossain1";
    private String browserstack_accesskey = "pS2NT6eb2HqKz5xPd56v";

    @Parameters({"useCloudEnv", "cloudEnvName", "os", "os_Version", "browser_name", "browser_version", "url", "path"})
    @BeforeMethod
    public void setUp(@Optional boolean useCloudEnv, @Optional String cloudEnvName, @Optional String  os,@Optional String os_version,@Optional String browser_name, @Optional String browser_version, @Optional String url,@Optional String path) throws IOException {
        if (useCloudEnv == true) {
            if (cloudEnvName.equalsIgnoreCase("browser")) {
                getCloudDriver(cloudEnvName, browserstack_username, browserstack_accesskey, os, os_version, browser_name, browser_version,path);
            } else if (cloudEnvName.equalsIgnoreCase("saucelabs")) {
                getCloudDriver(cloudEnvName, saucelabs_UserName, saucelabs_accesskey, os, os_version, browser_name, browser_version,path);
            }
        } else {
            getLocalDirver(os, browser_name,path);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDirver(String os, String browser_name,String path) {
        extent = ExtentFactory.getInstance(path);
        test =extent.startTest("testing");
        os = os.toLowerCase();
        if (browser_name.equalsIgnoreCase("chrome")) {
            if (os.contains("win")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (os.contains("mac")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
                driver = new ChromeDriver();
            }
        } else if (browser_name.equalsIgnoreCase("fireFox")) {
            if (os.contains("win")) {
                System.setProperty("webdriver.gecko.drover", "Generic/driver/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (os.contains("mac")) {
                System.setProperty("webdriver.gecko.driver", "Generic/driver/geckodriver");
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public WebDriver getCloudDriver(String envName, String envUserName, String envAccessKey, String os, String os_version, String browser_name, String browser_version, String path) throws IOException {
        extent = ExtentFactory.getInstance(path);
        test =extent.startTest("testing");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browser_name);
        cap.setCapability("browser_version", browser_version);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if (envName.equalsIgnoreCase("browserstack")) {
            driver = new RemoteWebDriver(new URL("https://www.amazon.com/" + envUserName + envAccessKey + "i dont know what will be"), cap);
        } else if (envName.equalsIgnoreCase("sacucelabs")) {
            driver = new RemoteWebDriver(new URL("https://www.amazon.com/" + envUserName + envAccessKey + "i dont know how to use this "), cap);
        }
        return driver;

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.endTest(test);
        extent.flush();

    }

}





