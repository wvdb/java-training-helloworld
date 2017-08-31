package be.ictdynamic.helloworld.oefening_inheritance_0;

import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DateHelper implements IDateHelper {
    protected Date currentDate = new Date(System.currentTimeMillis());

    @Override
    public Date getCurrentDate() {
        return currentDate;
    }

    @Override
    public String getCurrentDateAsString() {
        return currentDate.toString();
    }

    @Override
    public Date addNumberOfDays(Date date, int numberOfDays) {
        // this is obviously wrong but done on purpose
        return date;
    }

    private int squareRoot(int i) {
        System.out.println("this is the bad impl of squareRoot");
        return i*i;
    }

}
