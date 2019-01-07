package be.ictdynamic.helloworld.oefening_inheritance_1;

import be.ictdynamic.helloworld.utilities.DateUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class EuropeanDateHelper extends DateHelper{
//    @Override
    private String getCurrentDateAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(getCurrentDate());
    }

    @Override
    public Date addNumberOfDays(Date date, int numberOfDays) {
        return DateUtility.addNumberOfDaysToDate(date, numberOfDays);
    }

}
