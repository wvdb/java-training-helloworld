package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.oefening_interfaces.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces.DummyInterfaceImpl;

public class Main {

    public static void main(String[] args) {
        DummyInterface.InnerInterface1.dummyMethod1("dit is een test");
        DummyInterface.InnerInterface2.printToUpperCase("dit is nog een test");

        DummyInterface dummyInterface = new DummyInterfaceImpl();
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", null));
    }

}
