package be.ictdynamic.helloworld.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by admin on 15/10/2017.
 */
public final class DateUtility {
    // this is a utility class with class-methods only, we don't want this class to be instantiated
    private DateUtility() {
    }

    public final static String convertLocalDateTimeToDateAsString(LocalDateTime localDateTime) {
        return String.format("%td/%tm/%tY", localDateTime, localDateTime, localDateTime);
    }

    public final static String convertLocalDateTimeToDateTimeAsString(LocalDateTime localDateTime) {
        return String.format("%td/%tm/%tY %tH:%tM:%tS", localDateTime, localDateTime, localDateTime, localDateTime, localDateTime, localDateTime);
    }

    public final static Date addNumberOfDaysToDate(Date date, int numberOfDays) {
        LocalDateTime localDateTime = convertDateToLocalDateTime(date);
        localDateTime = localDateTime.plusDays(numberOfDays);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public final static LocalDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public final static LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public final static long convertLocalDateToEpoch(LocalDate date) {
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        return date.atStartOfDay(zoneId).toEpochSecond();
    }

}
