package org.test2;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ParseDate {
    public static Date parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return  Date.from(LocalDate.parse(date, formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
