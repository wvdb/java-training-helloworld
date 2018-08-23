package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.oefening_inheritance_1.DateHelper;

import java.util.Date;

/**
 * Created by admin on 23/08/2018.
 */
public class Dummy extends DateHelper{
    public void dummy() {
        Dummy dummy = new Dummy();
        Date currentDate = dummy.currentDate;
    }
}
