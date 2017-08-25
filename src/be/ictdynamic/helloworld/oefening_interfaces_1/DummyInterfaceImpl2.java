package be.ictdynamic.helloworld.oefening_interfaces_1;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DummyInterfaceImpl2 implements DummyInterface{
    @Override
    public String getCompleteName(String firstName, String lastName) {
        return firstName + ", " + lastName;
    }
}
