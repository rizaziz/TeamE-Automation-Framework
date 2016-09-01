package results;

import static businesslogic.FieldNames.*;
import businesslogic.InputData;
import businesslogic.OutputData;
import businesslogic.PayrollTaxCalculations;
import common.*;
import org.junit.Assert;
import org.testng.annotations.*;
import util.Converter;
import java.math.*;
import java.text.*;

public class TestingSimleCalculator extends Base {



    /*public static InputData data=new InputData("09/01/2016", "Pennsylvania",
            new BigDecimal(100000), "Annual", "Bi-weekly","Married",4);*/

    public static OutputData out=null;

    public static PayrollTaxCalculations calc=new PayrollTaxCalculations();

    @DataProvider(name="instance")
    public Object[][] getData() {
        return new Object[][]{
            {new InputData("09/01/2016", "Arizona", new BigDecimal(100000), "Annual", "Bi-weekly", "Married", 4)},
            {new InputData("09/01/2016", "Ohio", new BigDecimal(50000), "Annual", "Bi-weekly", "Married", 2)}
        };
    }

    @Test(dataProvider = "instance")
    public void loadSalaryTaxCalculationPage(InputData data){

        clickOnButton(getWebElement("xpath", btn_PAGE));

        fillInputField(getWebElement("id",in_DATE), data.getCheckDate());

        fillInputField(getWebElement("id",in_STATE), data.getState());

        fillInputField(getWebElement("id",in_GROSS), data.getGrossPay().toString());

        fillInputField(getWebElement("id",in_FREQUENCY), data.getPayFrequency());

        fillInputField(getWebElement("id",in_STATUS), data.getFederalFilingStatus());

        fillInputField(getWebElement("id",in_ALLOWANCES), String.valueOf(data.getNumberOfAllowances()));

        clickOnButton(getWebElement("id", btn_CALCULATE));

        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){}

        NumberFormat nf=NumberFormat.getCurrencyInstance();

        BigDecimal pay= Converter.convert(getWebElement("xpath",out_GROSS_PAY).getText());
        BigDecimal fed= Converter.convert(getWebElement("xpath",out_FED_TAX).getText());
        BigDecimal soc= Converter.convert(getWebElement("xpath",out_SOC_SEC).getText());
        BigDecimal med= Converter.convert(getWebElement("xpath",out_MEDCARE).getText());
        BigDecimal state= Converter.convert(getWebElement("xpath",out_STATE).getText());
        BigDecimal net= Converter.convert(getWebElement("xpath",out_NET_PAY).getText());

        out=new OutputData(pay, fed, soc, med, state,net);

        calc.setGrossPay(data.getGrossPay(),true,"Bi-weekly");

        Assert.assertEquals(calc.getGrossPay(), out.getGrossPay());

    }
}
