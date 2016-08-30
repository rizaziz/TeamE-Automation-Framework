package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    enum Browsers{IE,CHROME,FIREFOX,OPERA}

    @Parameters({"useCloudEnv","userName","accessKey","os","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv,
                      @Optional("rahmanww") String userName,
                      @Optional("") String accessKey,
                      @Optional("Windows 8") String os,
                      @Optional("firefox") String browser,
                      @Optional("34") String browserVersion,
                      @Optional("http://www.cnn.com") String url) throws IOException{

        if(useCloudEnv){


        }else{
            getLocalDriver(Browsers.valueOf(browser));
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    public WebDriver getLocalDriver(Browsers browser){
        switch(browser){
            case IE :
                System.setProperty("webdriver.ie.driver", "./Generic/drivers/IEDriverServer.exe");
                driver=new InternetExplorerDriver(); break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "./Generic/drivers/chromedriver.exe");
                driver=new ChromeDriver(); break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "./Generic/drivers/geckodriver.exe");
                driver=new FirefoxDriver(); break;
            case OPERA:
                System.setProperty("webdriver.opera.driver", "./Generic/drivers/operadriver.exe");
                driver=new OperaDriver(); break;
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
