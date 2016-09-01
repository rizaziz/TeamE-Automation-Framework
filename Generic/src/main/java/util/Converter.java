package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by Aziz on 9/1/2016.
 */
public class Converter {

    public static BigDecimal convert(String currency){
        BigDecimal out=null;
        NumberFormat format=NumberFormat.getCurrencyInstance();
        try{
            out=new BigDecimal((Double)format.parse(currency))
                    .setScale(2, RoundingMode.HALF_UP);
        }catch(ParseException e){
            e.printStackTrace();
        }

        return out;

    }
}
