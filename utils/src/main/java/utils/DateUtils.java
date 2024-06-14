package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import net.datafaker.Faker;

public class DateUtils {
    private static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
    private static final String DD_MM_YYYY_FORMAT = "dd-MM-yyyy";
    private static final Faker FAKER = new Faker();

    public static String generateDate(String dateFormat, int numberOfDaysToAdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, numberOfDaysToAdd);
        Date newDate = calendar.getTime();

        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        return dateFormatter.format(newDate);
    }

    public static String generateDateInThePast(String dateFormat, int numberOfYearsToMinus) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -numberOfYearsToMinus);
        Date generatedDate = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(generatedDate);
    }

    public static String generateFutureDateYYYYMMDD(int numberOfDaysToAdd) {
        return generateDate(YYYY_MM_DD_FORMAT, numberOfDaysToAdd);
    }

    public static String generateFutureDateDDMMYYYY(int numberOfDaysToAdd) {
        return generateDate(DD_MM_YYYY_FORMAT, numberOfDaysToAdd);
    }

    public static String generatePastDateYYYYMMDD(int numberOfYearsToMinus) {
        return generateDateInThePast(YYYY_MM_DD_FORMAT, numberOfYearsToMinus);
    }

    public static String generatePastDateDDMMYYYY(int numberOfYearsToMinus) {
        return generateDateInThePast(DD_MM_YYYY_FORMAT, numberOfYearsToMinus);
    }

    public static String getRandomPastDate() {
        long pastDays = FAKER.number().numberBetween(1, 365 * 100); // Generate a date within the past 100 years
        LocalDate randomDate = LocalDate.now().minusDays(pastDays);

        java.sql.Date date = java.sql.Date.valueOf(randomDate);
        return new SimpleDateFormat(DD_MM_YYYY_FORMAT).format(date);
    }

    public static String getRandomFutureDate() {
        long futureDays = FAKER.number().numberBetween(1, 365 * 100); // Generate a date within the future 100 years
        LocalDate randomDate = LocalDate.now().plusDays(futureDays);

        java.sql.Date date = java.sql.Date.valueOf(randomDate);
        return new SimpleDateFormat(DD_MM_YYYY_FORMAT).format(date);
    }
}
