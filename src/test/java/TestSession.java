import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.sql.Driver;

public class TestSession {
    public static void main(String[] args) throws InterruptedException {


        FirefoxOptions options = new FirefoxOptions();

        // Enable cookies
        options.setAcceptInsecureCerts(true);
        FirefoxProfile profile = new FirefoxProfile();

        // Set media permissions to allow microphone access
        profile.setPreference("media.navigator.permission.disabled", true);

        // Add the profile to the options
        options.setProfile(profile);

        FirefoxDriver driver=new FirefoxDriver(options);

        driver.get("https://dev.goinstore.com/gistore/");

        WebElement CookieAccept = driver.findElement(By.xpath("//button[normalize-space()='Accept']"));
        CookieAccept.click();
        driver.getSessionId();
        System.out.println("Alpha");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        WebElement CTA=driver.findElement(By.xpath("//div[@id='gis-cta-advisor-image']"));
//        CTA.click();
        //Pages.loginPage.
        WebElement StartCall=driver.findElement(By.xpath("//div[6]//span[1]"));
        StartCall.click();
        Thread.sleep(5000);
        WebElement AllowMic=driver.findElement(By.id("gis-v3-button"));
        AllowMic.click();



//        element.sendKeys("abc@gmail.com");
//
//        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
//        button.click();
       driver.quit();
    }
}