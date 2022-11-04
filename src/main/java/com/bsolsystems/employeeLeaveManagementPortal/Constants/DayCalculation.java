package com.bsolsystems.employeeLeaveManagementPortal.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DayCalculation {

    public static long dayCalculation(Date startDate, Date endDate) {
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMM dd yyyy").toFormatter(Locale.ENGLISH);
//        Fetching a particular data from object
        String startDateString = String.valueOf(startDate);
        String endDateString = String.valueOf(endDate);
//        Filtering string to get only useful string
        String newStartDate = startDateString.substring(4, 10);
        startDateString = newStartDate.concat(startDateString.substring(23));
        String newEndDate = endDateString.substring(4, 10);
        endDateString = newEndDate.concat(endDateString.substring(23));
//        Using LocalDate to represent date
        final LocalDate firstDate = LocalDate.parse(startDateString, formatter);
        final LocalDate lastDate = LocalDate.parse(endDateString, formatter);
        long days = ChronoUnit.DAYS.between(firstDate, lastDate);
        days = ++days; // As ChronoUnit will return one less count
        return days;
    }
}
