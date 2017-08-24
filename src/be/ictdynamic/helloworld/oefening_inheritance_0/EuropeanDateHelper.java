package be.ictdynamic.helloworld.oefening_inheritance_0;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class EuropeanDateHelper extends DateHelper{
    @Override
    public String getCurrentDateAsString() {
        return currentDate.toString();
    }
}
