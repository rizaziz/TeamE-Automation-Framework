package results;

import static testfixture.FieldNames.*;
import testfixture.InputData;
import testfixture.OutputData;
import businesslogic.PayrollTaxCalculations;
import common.*;
import org.junit.Assert;
import org.testng.annotations.*;
import utilities.Converter;
import java.text.*;

public class TestingSimleCalculator extends Base {



    /*public static InputData data=new InputData("09/01/2016", "Pennsylvania",
            new BigDecimal(100000), "Annual", "Bi-weekly","Married",4);*/

    public static OutputData out=null;

    @DataProvider(name="instance")
    public Object[][] getData() {
        return new Object[][]{
            {new InputData("09/01/2016", "Arizona", 100000, "Annual", "Bi-weekly", "Married", 4)},
            {new InputData("09/01/2016", "Ohio", 50000, "Annual", "Bi-weekly", "Married", 2)}
        };
    }

    @Test(dataProvider = "instance")
    public void loadSalaryTaxCalculationPage(InputData data){

        clickOnButton(getWebElement("xpath", btn_PAGE));

        fillInputField(getWebElement("id",in_DATE), data.getCheckDate());

        fillInputField(getWebElement("id",in_STATE), data.getState());

        fillInputField(getWebElement("id",in_GROSS), String.valueOf(data.getGrossPay()));

        fillInputField(getWebElement("id",in_FREQUENCY), data.getPayFrequency());

        fillInputField(getWebElement("id",in_STATUS), data.getFederalFilingStatus());

        fillInputField(getWebElement("id",in_ALLOWANCES), String.valueOf(data.getNumberOfAllowances()));

        clickOnButton(getWebElement("id", btn_CALCULATE));

        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){}

        NumberFormat nf=NumberFormat.getCurrencyInstance();

        double pay = Converter.convert(getWebElement("xpath",out_GROSS_PAY).getText());
        double fed= Converter.convert(getWebElement("xpath",out_FED_TAX).getText());
        double soc= Converter.convert(getWebElement("xpath",out_SOC_SEC).getText());
        double med= Converter.convert(getWebElement("xpath",out_MEDCARE).getText());
        double state= Converter.convert(getWebElement("xpath",out_STATE).getText());
        double net= Converter.convert(getWebElement("xpath",out_NET_PAY).getText());

        out=new OutputData(pay, fed, soc, med, state,net);

        //calc.setGrossPay(data.getGrossPay(),true,"Bi-weekly");

        //Assert.assertEquals(calc.getGrossPay(), out.getGrossPay(), 0.01);

    }
}
