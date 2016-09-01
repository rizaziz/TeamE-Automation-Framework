package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Aziz on 8/29/2016.
 */
public class Base {

    public WebDriver driver=null;

    enum Browsers{HTMLUNIT,IE,CHROME,FIREFOX,OPERA}

    @Parameters({"useCloudEnv","userName","accessKey","os","browserName","browserVersion","url"})
    @BeforeClass
    public void setUp(@Optional("false") boolean useCloudEnv,
                      @Optional("riz_aziz2002") String userName,
                      @Optional("") String accessKey,
                      @Optional("Windows 8") String os,
                      @Optional("htmlunit") String browserName,
                      @Optional("34") String browserVersion,
                      @Optional("http://www.cnn.com") String url) throws IOException{

        if(useCloudEnv){

            getCloudDriver(userName, accessKey, os, browserName, browserVersion);

        }else{
            getLocalDriver(browserName);
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }

    public WebDriver getLocalDriver(String browser){
        switch(browser){
            case  "internet explorer" :
                System.setProperty("webdriver.ie.driver", "C:\\Users\\Aziz\\IdeaProjects\\TeamE-webbapp\\Generic\\drivers\\IEDriverServer.exe");
                driver=new InternetExplorerDriver(); break;
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aziz\\IdeaProjects\\TeamE-webbapp\\Generic\\drivers\\chromedriver.exe");
                driver=new ChromeDriver(); break;
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aziz\\IdeaProjects\\TeamE-webbapp\\Generic\\drivers\\geckodriver.exe");
                driver=new FirefoxDriver(); break;
            case "opera" :
                System.setProperty("webdriver.opera.driver", "C:\\Users\\Aziz\\IdeaProjects\\TeamE-webbapp\\Generic\\drivers\\operadriver.exe");
                driver=new OperaDriver(); break;
            case "htmlunit" : driver=new HtmlUnitDriver();
        }
        return driver;
    }

    public WebDriver getCloudDriver(String userName,
                                    String accessKey,
                                    String os,
                                    String browserName,
                                    String browserVersion) throws IOException{

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setCapability("version", browserVersion);
        cap.setBrowserName(browserName);

        driver=new RemoteWebDriver(new URL("http://"+userName+":"+accessKey+
                "@ondemand.saucelabs.com:80/wd/hub"), cap);

        return driver;
    }

    public WebElement getWebElement(String locatorType, String locator){

        WebElement elem=null;
        switch(locatorType){
            case "id": elem=driver.findElement(By.id(locator)); break;
            case "class": elem=driver.findElement(By.className(locator)); break;
            case "name": elem=driver.findElement(By.name(locator)); break;
            case "xpath": elem=driver.findElement(By.xpath(locator)); break;
            case "css": elem=driver.findElement(By.cssSelector(locator)); break;
        }

        return elem;
    }

    public void fillInputField(WebElement elem, String value){
        //WebElement elem=driver.findElement(By.id(locator));
        elem.clear();
        elem.sendKeys(value);
    }

    public void clickOnButton(WebElement elem){
       elem.click();
    }

    public String getText(WebElement elem){
        return elem.getText();
    }

    public static void main(String[] args) throws Exception{

        /*Base b=new Base();

        WebDriver driver=b.getLocalDriver(Browsers.IE);*/

        DesiredCapabilities cap=new DesiredCapabilities();
        RemoteWebDriver driver=null;
        cap.setBrowserName("firefox");
        try{
            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
            driver.get("http://www.google.com");

        }catch(MalformedURLException e){
            e.fillInStackTrace();
        }
    }
}
