/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparatorsAndDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Tomáš
 */
public class Datum {
    private static DateFormat formatovanyCas = new SimpleDateFormat("d.M.yyyy");
    
    public static Calendar parseDatum(String datum) throws ParseException {
        Calendar d = null;
        try {
            d = Calendar.getInstance();
            d.setTime(formatovanyCas.parse(datum));
        } catch (ParseException e) {
            throw e;
        }
        return d;
    }
    
    public static String formatDatum(Calendar datum) {
        String d = formatovanyCas.format(datum.getTime());
        return d;
    }
}
