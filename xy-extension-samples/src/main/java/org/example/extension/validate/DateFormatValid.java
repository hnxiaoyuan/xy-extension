package org.example.extension.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author DM
 */
public class DateFormatValid implements CustomizeValidation<String>{
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public boolean validate(String value) {
        try {
            new SimpleDateFormat(pattern).parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
