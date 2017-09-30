package be.ictdynamic.helloworld.oefening_interfaces_2;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DummyInterfaceImpl2 implements DummyInterface{
    @Override
    public String getCompleteName(String firstName, String lastName) {
        // usage of StringBuilder
        StringBuilder stringBuilder = new StringBuilder(firstName);
        stringBuilder.append(", ");
        stringBuilder.append(lastName);
        return stringBuilder.toString();
    }
}
