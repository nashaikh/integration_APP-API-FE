package browserStackPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.*;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class appSession {

    static AppiumDriver<MobileElement> APPdriver;

    public appSession(AppiumDriver APPdriver) {
        this.APPdriver = APPdriver;
    }

    public static void main (String[] arg) throws MalformedURLException {

        try {
//            openSession();
//            appLogin();
//            appUpdate();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



    public static void appLogin(){

        APPdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        MobileElement userName = APPdriver.findElement(By.id("net.sym_sys.android.m100:id/LoginFragment_EditText_usernameField"));
        userName.sendKeys("clerk1");
        APPdriver.hideKeyboard();
        MobileElement password = APPdriver.findElement(By.id("net.sym_sys.android.m100:id/LoginFragment_EditText_passwordField"));
        password.click();
        //MobileElement element = (MobileDriver) (new MobileDriver<MobileElement>(APPdriver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("net.sym_sys.android.m100:id/LoginFragment_EditText_passwordField")));
        APPdriver.hideKeyboard();
        //APPdriver.
        APPdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        long timeLimitInSeconds = 10;
        WebDriverWait wait = new WebDriverWait(APPdriver, timeLimitInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(password));

        //MobileElement password = APPdriver.findElement(By.id("net.sym_sys.android.m100:id/LoginFragment_EditText_passwordField"));
        password.sendKeys("1001");
        APPdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement submit = APPdriver.findElement(By.id("net.sym_sys.android.m100:id/LoginFragment_button_signInButton"));
        submit.click();


    }

    public static void goAvailable(){
        MobileElement goOnline = APPdriver.findElement(By.id("net.sym_sys.android.m100:id/DashboardFragment_GISAvaillabilituButton_togglebutton"));
        if (goOnline.equals(false)) {
            goOnline.click();
        }

    }
    public static void appUpdate() {
        MobileElement updatePopUp = (MobileElement) (new WebDriverWait(APPdriver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("net.sym_sys.android.m100:id/AppUpdateAlertDialog_TextView_updateMessage")));

        MobileElement AcceptButton = APPdriver.findElement( By.id("net.sym_sys.android.m100:id/AppUpdateAlertDialog_Textview_accept"));

        if (updatePopUp.isDisplayed()){
            int screenWidth = APPdriver.manage().window().getSize().getWidth();
            int screenHeight = APPdriver.manage().window().getSize().getHeight();
            int tapX = screenWidth / 2; // X-coordinate in the middle of the screen
            int tapY = screenHeight - 10; // Y-coordinate near the bottom of the screen
            TouchAction touchAction = new TouchAction(APPdriver);
            touchAction.tap(ElementOption.point(tapX, tapY)).perform();
            MobileElement goOnline = APPdriver.findElement(By.id("net.sym_sys.android.m100:id/DashboardFragment_GISAvaillabilituButton_togglebutton"));
            goOnline.click();
            System.out.println("updates available");


        } else {

            System.out.println("no updates available");
        }

    }
    public static void openSession() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("deviceName", "Galaxy A31");
//            desiredCapabilities.setCapability("platformVersion", "7");
//            desiredCapabilities.setCapability("deviceName", "Honor 8");
        desiredCapabilities.setCapability("app", "C:\\Emplifi\\Meeting with Pablo" +
                "\\Live Commerce-2.7.10.apk");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setAcceptInsecureCerts(true);
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        URL url = new URL("http://127.0.0.1:5000/wd/hub");
        APPdriver = new AppiumDriver<MobileElement>(desiredCapabilities);


    }
}
