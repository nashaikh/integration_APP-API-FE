package Pages;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.loginPage;


public class TestSessions {
    loginPage objloginPage;
    String driverPath = "C:\\geckodriver.exe";
    WebDriver driver;


    @BeforeTest
    public void setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gis.goinstore.com/gistore/");
//        objloginPage.openBrowser();
        //APPSession.openSession();
    }

    @AfterTest
    public void exit() throws MalformedURLException {
        APPSession.APPdriver.quit();
        //objloginPage.driver1.quit();
    }

    @Test(priority = 1)
    public void StartCall() throws MalformedURLException {
        //startBrowserSession.driver
        //startBrowserSession.InitiateBrowser();

//        objloginPage.AcceptCookie();
//        objloginPage.clickOnCTA();
//        objloginPage.startCall();
        APPSession.appLogin();
        APPSession.appUpdate();
        APPSession.goAvailable();


    }
}