package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterfaceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int number = reader.nextInt();

        switch (number) {
            case 1:
                Main.oefening_interfaces();
                break;
            default :
                System.out.println("geen oefening voorzien");
        }
    }

    public static void oefening_interfaces () {
        DummyInterface.InnerInterface1.dummyMethod1("dit is een test");
        DummyInterface.InnerInterface2.printToUpperCase("dit is nog een test");

        DummyInterface dummyInterface = new DummyInterfaceImpl();
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", null));
    }

}
