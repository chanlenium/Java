package shapes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
    public static String[] getSliceOfArray(String[] arr, int start, int end) {
        // Get the slice of the Array with size [end - start]
        String[] slice = new String[end - start];
        // Copy elements of arr to slice
        if (slice.length >= 0) System.arraycopy(arr, start, slice, 0, slice.length);
        return slice;
    }

    public static boolean isAllPositive(double[] slice) {
        boolean result = true;
        for(int i = 0; i < slice.length && result; i ++)
            result = !(slice[i] <= 0);
        return result;
    }

    public static NumberFormat displayFormat(double perimeter) {
        NumberFormat df;
        if(perimeter > 0.01){
            if((int)perimeter == 0){
                // When the Integer Part is zero, set the length of Decimal Part is 6
                df = new DecimalFormat("0.000000");
                df.setMaximumFractionDigits(7-String.valueOf((int)perimeter).length());
            }else{
                // When the Integer Part is not zero, set the length of Decimal Part is up to 5
                df = new DecimalFormat("0.00000");
                df.setMaximumFractionDigits(6-String.valueOf((int)perimeter).length());
            }
        }else {
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.US);
            symbols.setExponentSeparator("e");
            df = new DecimalFormat("0.00000E00", symbols);
        }
        return df;
    }
}
