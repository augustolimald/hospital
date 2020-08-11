package utils;

import java.time.LocalDate;

public abstract class DateManipulator {
    public static String dateToString(LocalDate date) {
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }
    
    public static LocalDate stringToDate(String date) throws RuntimeException {
        String[] params = date.split("/");
        if (params.length != 3) {
            throw new RuntimeException("Invalid data format");
        }
        
        int day = Integer.parseInt(params[0]);
        int month = Integer.parseInt(params[1]);
        int year = Integer.parseInt(params[2]);
        
        return LocalDate.of(year, month, day);
    }
}
