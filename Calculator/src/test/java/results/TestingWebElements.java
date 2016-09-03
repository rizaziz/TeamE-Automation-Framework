package results;


import common.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static testfixture.FieldNames.*;

public class TestingWebElements extends Base {


    @BeforeMethod
    public void SetUpPage(){
        clickOnButton(getWebElement("xpath", btn_PAGE));
    }

    @DataProvider(name="valid arguments")
    public Object[][] getArguments(){
        return new Object[][]{{"01/01/2016"},{"02/01/2016"},{"03/01/2016"},{"04/01/2016"},{"07/01/2016"}};
    }

    @Test(dataProvider = "valid arguments")
    public void checkDateInputFieldAcceptsCertainFormat(String str){
        fillInputField(getWebElement("id", in_DATE), str);
    }

    @DataProvider(name="invalid arguments")
    public Object[][] getInvalidArguments(){
        return new Object[][]{{"01012016"},{"01.01.2016"},{"Jan 01 2016"},{"-10"}};
    }

    @Test(dataProvider = "invalid arguments")
    public void checkDataInputFieldDoesntAcceptInvalidArguments(String str){
        fillInputField(getWebElement("id", in_DATE),str);
    }
}
