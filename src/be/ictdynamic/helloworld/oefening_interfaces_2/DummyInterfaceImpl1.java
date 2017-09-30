package be.ictdynamic.helloworld.oefening_interfaces_2;

import java.util.Objects;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DummyInterfaceImpl1 implements DummyInterface{
    @Override
    public String getCompleteName(String firstName, String lastName) {
        // no usage of StringBuilder
        return firstName + " " + lastName;
    }

//    @Override
//    public void move2() {
//    }
}
