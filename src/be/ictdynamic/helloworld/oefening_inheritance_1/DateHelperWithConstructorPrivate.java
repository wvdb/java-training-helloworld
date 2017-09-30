package be.ictdynamic.helloworld.oefening_inheritance_1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public final class DateHelperWithConstructorPrivate {
    /**
     * Private constructor to prevent this static class from being instantiated.
     */
    private DateHelperWithConstructorPrivate() {
    }

    public static Date addNumberOfDays(Date date, int numberOfDays) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(numberOfDays);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
