package testfixture;

/**
 * Created by Aziz on 9/1/2016.
 */
public class OutputData {

    private double grossPay;
    private double federalWithholding;
    private double socialSecurity;
    private double medicare;
    private double stateTax;
    private double netPay;

    public OutputData(double grossPay,
                      double federalWithholding,
                      double socialSecurity,
                      double medicare,
                      double stateTax,
                      double netPay) {

        this.grossPay = grossPay;
        this.federalWithholding = federalWithholding;
        this.socialSecurity = socialSecurity;
        this.medicare = medicare;
        this.stateTax = stateTax;
        this.netPay = netPay;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getFederalWithholding() {
        return federalWithholding;
    }

    public void setFederalWithholding(double federalWithholding) {
        this.federalWithholding = federalWithholding;
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(double socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public double getMedicare() {
        return medicare;
    }

    public void setMedicare(double medicare) {
        this.medicare = medicare;
    }

    public double getStateTax() {
        return stateTax;
    }

    public void setStateTax(double stateTax) {
        this.stateTax = stateTax;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
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
