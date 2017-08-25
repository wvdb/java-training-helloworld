package be.ictdynamic.helloworld.oefening_inheritance_0;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DangerousUSDateHelper extends DateHelper{
    // override is missing -> probleem bij HP
    public Date addNumberOfDays(Date date, int numberOfDays) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(numberOfDays);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
