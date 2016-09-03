package news;

import common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Aziz on 8/29/2016.
 */
public class NavigationOnNews extends Base {

    @DataProvider(name="items")
    public Object[][] data(){
        return new String[][]{{"lenova"},{"dell"},{"hp"}};
    }

    @Test(dataProvider="items")
    public void navigateNews(String data) {


        driver.findElement(By.id("uh-search-box")).sendKeys(data, Keys.ENTER);

        for(int i=0; i<10; i++){
            driver.findElement(By.id("77f"+i)).click();
            driver.navigate().back();
        }



    }
}
