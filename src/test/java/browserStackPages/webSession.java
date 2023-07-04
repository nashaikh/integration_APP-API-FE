package browserStackPages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webSession {

    WebDriver driver;
    By CookieAccept =By.xpath("//button[normalize-space()='Accept']");
    By CTALocator=By.xpath("//div[@id='gis-cta-advisor-image']");
    // ScheduleCall
    By scheduleCall = By.xpath("//span[@id='gis-v3-button-label']");

    //SelectService
    By selectService = By.xpath("/html[1]/body[1]/span[1]/ap-booking-app[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ap-booking-app-step-services[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

    //SelectDate

    By selectDate = By.xpath("//div[@class='ap-ba-well-single ng-scope']']");

    //Add Message

    By addMessage = By.xpath("//textarea[@id='question0']");

    //ClickNext

    By cliCKNext = By.xpath("//button[@class='ap-button btn-medium flr ng-binding']");

    By SwicthToIframe = By.xpath("//div[@class='ap-ba-services-list ap-ba-step']");

    By StartCall = By.xpath("//div[6]//span[1]");

    By continueCall = By.xpath("//body/div[@id='gis-outer-panel2']/div[@id='gis-inner-panel']/aside[@id='gis-modal']/div[@id='gis-modal-container']/div[@id='gis-modal-content']/div[@id='gis-splitLayout']/div[@id='gis-splitLayout-2']/div[@id='gis-connectv3-content-container']/div[@id='gis-ms-buttons-container']/div[1]");

    By endCall = By.xpath("//div[@id='gis-end-call']//*[name()='svg']");


    public webSession(WebDriver driver) {
        this.driver=driver;
    }

    public void AcceptCookie() {

        //driver.manage().logs().
        driver.findElement(CookieAccept).click();
    }
    public void clickOnCTA() {
        driver.findElement(CTALocator).click();
    }

    public void setScheduleCall() {
        driver.findElement(scheduleCall).click();
    }

    public void selectService() {
        driver.findElement(selectService).click();
    }

    public void setSelectDate() {
        List<WebElement> Service = driver.findElements(selectService);
        Service.listIterator(1);

    }

    public void AddMessage() {
        driver.findElement(addMessage).clear();
        driver.findElement(addMessage).sendKeys("Tesing");

    }

    public void setCliCKNext() {
        driver.findElement(cliCKNext).click();
    }

    public  void setToIframe(){

        driver.switchTo().frame("//div[@class='ap-ba-services-list ap-ba-step']");


    }


    public void startCall(){

        //driver.findElement(StartCall).click();
        WebElement startCallButton = (WebElement) (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(StartCall));
        startCallButton.click();
        WebElement ContinueCallButton = (WebElement) (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(continueCall));
        ContinueCallButton.click();
    }

    public void openBrowser(){

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("use-fake-ui-for-media-stream");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://gis.goinstore.com/gistore/");
    }

    public void CallPooling() {

        WebElement EndCallButton = (WebElement) (new WebDriverWait(driver, 2000)).until(ExpectedConditions.presenceOfElementLocated(endCall));
        EndCallButton.click();
    }
}