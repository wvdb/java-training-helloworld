package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.oefening_interfaces.DummyInterface;

public class Main {

    public static void main(String[] args) {
        DummyInterface.DummyInterface1.dummyMethod1("dit is een test");
        DummyInterface.DummyInterface2.printToUpperCase("dit is nog een test");
    }

}
