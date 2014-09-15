/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nishith.doc.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nisheeth Shah
 */
public class DateUtil {

    public static String getCurrentSystemDate() {
        Date date = new Date(System.currentTimeMillis());
        return date.toString();
    }

    public static String formatDate(long millis, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        if (dateFormat == null) {
            throw new NullPointerException("Date format cannot be null. Please provide valid date format.");
        }
        sdf.applyPattern(dateFormat);
        return sdf.format(new Date(millis));
    }
}
