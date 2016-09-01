package businesslogic;

import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

/**
 * Created by Aziz on 9/1/2016.
 */
public class InputData {

    private String checkDate;
    private String state;
    private BigDecimal grossPay;
    private String grossPayType;
    private String payFrequency;
    private String federalFilingStatus="Single";
    private int numberOfAllowances=0;

    public InputData(String checkDate, String state, BigDecimal grossPay,
                     String grossPayType, String payFrequency,
                     String federalFilingStatus, int numberOfAllowances) {
        this.checkDate = checkDate;
        this.state = state;
        this.grossPay = grossPay;
        this.grossPayType = grossPayType;
        this.payFrequency = payFrequency;
        this.federalFilingStatus = federalFilingStatus;
        this.numberOfAllowances = numberOfAllowances;
    }


    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(BigDecimal grossPay) {
        this.grossPay = grossPay;
    }

    public String getGrossPayType() {
        return grossPayType;
    }

    public void setGrossPayType(String grossPayType) {
        this.grossPayType = grossPayType;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public String getFederalFilingStatus() {
        return federalFilingStatus;
    }

    public void setFederalFilingStatus(String federalFilingStatus) {
        this.federalFilingStatus = federalFilingStatus;
    }

    public int getNumberOfAllowances() {
        return numberOfAllowances;
    }

    public void setNumberOfAllowances(int numberOfAllowances) {
        this.numberOfAllowances = numberOfAllowances;
    }
}
