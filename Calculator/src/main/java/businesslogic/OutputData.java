package businesslogic;

import java.math.BigDecimal;

/**
 * Created by Aziz on 9/1/2016.
 */
public class OutputData {

    private BigDecimal grossPay;
    private BigDecimal federalWithholding;
    private BigDecimal socialSecurity;
    private BigDecimal medicare;
    private BigDecimal stateTax;
    private BigDecimal netPay;

    public OutputData(BigDecimal grossPay, BigDecimal federalWithholding, BigDecimal socialSecurity, BigDecimal medicare, BigDecimal stateTax, BigDecimal netPay) {
        this.grossPay = grossPay;
        this.federalWithholding = federalWithholding;
        this.socialSecurity = socialSecurity;
        this.medicare = medicare;
        this.stateTax = stateTax;
        this.netPay = netPay;
    }

    public BigDecimal getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(BigDecimal grossPay) {
        this.grossPay = grossPay;
    }

    public BigDecimal getFederalWithholding() {
        return federalWithholding;
    }

    public void setFederalWithholding(BigDecimal federalWithholding) {
        this.federalWithholding = federalWithholding;
    }

    public BigDecimal getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(BigDecimal socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public BigDecimal getMedicare() {
        return medicare;
    }

    public void setMedicare(BigDecimal medicare) {
        this.medicare = medicare;
    }

    public BigDecimal getStateTax() {
        return stateTax;
    }

    public void setStateTax(BigDecimal stateTax) {
        this.stateTax = stateTax;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public void setNetPay(BigDecimal netPay) {
        this.netPay = netPay;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "grossPay=" + grossPay +
                ", federalWithholding=" + federalWithholding +
                ", socialSecurity=" + socialSecurity +
                ", medicare=" + medicare +
                ", stateTax=" + stateTax +
                ", netPay=" + netPay +
                '}';
    }
}
