package businesslogic;

import java.math.BigDecimal;

/**
 * Created by Aziz on 9/1/2016.
 */
public class PayrollTaxCalculations {

    private BigDecimal grossPay;
    private double fedTax;

    public PayrollTaxCalculations(){}

    public void setGrossPay(BigDecimal pay, boolean isAnnualPay, String payFrequency){
        if(!isAnnualPay){
            grossPay=pay;
        }else{

            switch(payFrequency){
                case "Daily": grossPay=pay.divide(new BigDecimal(360), 2, BigDecimal.ROUND_HALF_UP); break;
                case "Weekly": grossPay=pay.divide(new BigDecimal(52), 2, BigDecimal.ROUND_HALF_UP); break;
                case "Bi-weekly": grossPay=pay.divide(new BigDecimal(26), 2, BigDecimal.ROUND_HALF_UP); break;
                case "Semi-monthly": grossPay=pay.divide(new BigDecimal(24), 2, BigDecimal.ROUND_HALF_UP); break;
                case "Monthly": grossPay=pay.divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP); break;
                case "Quarterly": grossPay=pay.divide(new BigDecimal(4), 2, BigDecimal.ROUND_HALF_UP); break;
                case "Semi-annually": grossPay=pay.divide(new BigDecimal(2), 2, BigDecimal.ROUND_HALF_UP); break;
                case "Annually": grossPay=pay.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP); break;
            }
        }
    }

    public BigDecimal getGrossPay(){
        return this.grossPay;
    }

    @Override
    public String toString() {
        return "PayrollTaxCalculations{" +
                "grossPay=" + grossPay +
                ", fedTax=" + fedTax +
                '}';
    }
}
