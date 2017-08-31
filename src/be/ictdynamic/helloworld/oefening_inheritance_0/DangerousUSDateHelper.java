package be.ictdynamic.helloworld.oefening_inheritance_0;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DangerousUSDateHelper extends DateHelper {
//public class DangerousUSDateHelper {

    // override is missing -> probleem bij HP
    public Date addNumberOfDays(Date date, int numberOfDays) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(numberOfDays);
        squareRoot(10);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    // override is missing -> probleem bij HP
    private int squareRoot(int i) {
        System.out.println("this is the correct impl of squareRoot");
        return i*i;
    }

}
