package businesslogic;

import org.apache.poi.hssf.usermodel.*;
import testfixture.InputData;

import java.io.*;

public class PayrollTaxCalculations {

    private double grossPay;
    private double federalWithholding;
    private double socialSecurity;
    private double medicare;
    private double stateTax;
    private double netPay;

    private InputData in;
    private HSSFWorkbook wb;
    private double fedTaxRate;
    private double taxableIncome;
    private double ssnRate;
    private double medicareRate;


    public PayrollTaxCalculations(InputData in){

        this.in=in;

        String path="C:\\Users\\Aziz\\IdeaProjects\\" +
                "TeamE-webbapp\\Calculator\\data\\TaxRates.xls";
        try{
            wb=new HSSFWorkbook(new FileInputStream(new File(path)));
        }catch(IOException e){}

        HSSFSheet allowSheet=wb.getSheet("Allowances");
        HSSFRow row=null;
        for(int i=1; i<9; i++){

            row=allowSheet.getRow(i);
            String payFrequency=row.getCell(0).getStringCellValue();

            double singleAllowance=row.getCell(1).getNumericCellValue();

            if(payFrequency==in.getPayFrequency()){
                taxableIncome=in.getGrossPay()-singleAllowance*in.getNumberOfAllowances();
                break;
            }
        }

        //Initializing Socila security and medicare tax rates;

        HSSFSheet otherRates=wb.getSheet("SolicalAndMedicare");

        ssnRate=otherRates.getRow(1).getCell(4).getNumericCellValue();

        medicareRate=otherRates.getRow(2).getCell(4).getNumericCellValue();
    }

    public void getGrossPay(InputData in){

        double pay=in.getGrossPay();

        if(in.getGrossPayType()!="Annual"){
            grossPay=in.getGrossPay();
        }else{
            switch(in.getPayFrequency()){
                case "Daily": grossPay=pay/360; break;
                case "Weekly": grossPay=pay/52; break;
                case "Bi-weekly": grossPay=pay/26; break;
                case "Semi-monthly": grossPay=pay/24; break;
                case "Monthly": grossPay=pay/12; break;
                case "Quarterly": grossPay=pay/4; break;
                case "Semi-annually": grossPay=pay/2; break;
                case "Annually": grossPay=pay; break;
            }
        }
    }

    public double getFederalIncomeTax(String payFreq, String filingStat, int allowances) {

        double tax=0;

        HSSFSheet sheet=wb.getSheet("Rates");
        for(int i=1; i<113; i++){

            HSSFRow r=sheet.getRow(i);

            String freq=r.getCell(0).getStringCellValue();
            String status=r.getCell(1).getStringCellValue();
            double lower=r.getCell(2).getNumericCellValue();
            double upper=r.getCell(3).getNumericCellValue();
            double plus=r.getCell(4).getNumericCellValue();
            double rate=r.getCell(5).getNumericCellValue();

            if(freq==payFreq&&status==filingStat&&
                    lower<taxableIncome&&upper>=taxableIncome){
                tax=plus+(taxableIncome-lower)*rate/100;
                break;
            }
        }
        return tax;
    }

    public double getSocialSecurity() {
        return taxableIncome*ssnRate;
    }

    public double getMedicare() {
        return taxableIncome*medicareRate;
    }




}
