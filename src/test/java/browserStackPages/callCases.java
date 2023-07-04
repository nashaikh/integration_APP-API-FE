package browserStackPages;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import browserStackPages.webSession;
import browserStackPages.appSession;

import static browserStackPages.appSession.APPdriver;

public class callCases {
    String driverPath = "C:\\geckodriver.exe";
    WebDriver driver;
    webSession objBrowserStackHomePage;
    appSession objBrowserStackSignUpPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://gis.goinstore.com/gistore/");
        appSession.openSession();
    }

    @AfterTest
    public  void finishTest(){
objBrowserStackHomePage.driver.quit();
APPdriver.quit();
    }

    @Test(priority = 1)
    public void navigate_to_homepage_click_on_getstarted() {

        objBrowserStackHomePage = new webSession(driver);
        objBrowserStackSignUpPage.appLogin();
        objBrowserStackSignUpPage.appUpdate();
        objBrowserStackSignUpPage.goAvailable();
        objBrowserStackHomePage.openBrowser();
        objBrowserStackHomePage.AcceptCookie();
        objBrowserStackHomePage.clickOnCTA();
        objBrowserStackHomePage.startCall();
        objBrowserStackHomePage.CallPooling();

    }
}