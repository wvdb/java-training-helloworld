package be.ictdynamic.helloworld.utilities;

import java.time.LocalDateTime;

/**
 * Created by admin on 15/10/2017.
 */
public final class DateUtility {
    public DateUtility() {
    }

    public static String localDateTimeToDateString(LocalDateTime localDateTime) {
        return String.format("%td/%tm/%tY", localDateTime, localDateTime, localDateTime);
    }

    public static String localDateTimeToDateTimeString(LocalDateTime localDateTime) {
        return String.format("%td/%tm/%tY %tH:%tM:%tS", localDateTime, localDateTime, localDateTime, localDateTime, localDateTime, localDateTime);
    }
}
