package be.ictdynamic.helloworld.oefening_interfaces_2;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class DummyInterfaceImpl2 implements DummyInterface{
    @Override
    public String getCompleteName(String firstName, String lastName) {
        // usage of StringBuilder

        // IDE is actually very smart here,
        // it suggests you to change it for better code readability since internally compiler
        // will generate exactly the same bytecode and your code
        // will have the same performance and the same memory usage, but it will be easier to read.

        StringBuilder stringBuilder = new StringBuilder(firstName);
        stringBuilder.append(", ");
        stringBuilder.append(lastName);
        return stringBuilder.toString();
    }
}
