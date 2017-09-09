package be.ictdynamic.helloworld.oefening_inheritance_1;

import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public interface IDateHelper {
    Date getCurrentDate();

    String getCurrentDateAsString();

    Date addNumberOfDays(Date date, int numberOfDays);
}
