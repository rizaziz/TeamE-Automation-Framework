package utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by Aziz on 9/1/2016.
 */
public class Converter {

    public static double convert(String currency){
        double out=0;
        NumberFormat format=NumberFormat.getCurrencyInstance();
        try{
            out=(Double)format.parse(currency);
        }catch(ParseException e){
            e.printStackTrace();
        }

        return out;

    }
}
