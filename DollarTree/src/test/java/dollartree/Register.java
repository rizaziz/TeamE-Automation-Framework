package dollartree;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

/**
 * Created by asus on 9/3/2016.
 */
public class Register extends Base {
    DBFacacde dbFacacde=new DBFacacde();
    public void regiter(){

        Map<String,String>record=dbFacacde.getValuesAsList();
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\asus\\Downloads\\geckodriver-v0.10.0-win64 (1)\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://mailing.dollartree.com/signup.jsp");
        driver.findElement(By.xpath(".//*[@id='emailAddress']")).sendKeys(record.get("emailadress"));
        driver.findElement(By.xpath(".//*[@id='zipCode']")).sendKeys(record.get("zipcode"));
        driver.findElement(By.xpath(".//*[@id='firstName']")).sendKeys(record.get("firstname"));
        driver.findElement(By.xpath(".//*[@id='lastName']")).sendKeys(record.get("lastname"));
        driver.findElement(By.xpath(".//*[@id='subscribeForm']/div[2]/input[3]")).click();
        driver.findElement(By.xpath(".//*[@id='subscribeForm']/div[3]/input[2]")).click();

    }

    public static void main(String[] args) {
        Register register=new Register();
        register.regiter();
    }

    }
