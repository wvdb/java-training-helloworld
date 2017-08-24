package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.oefening_inheritance_0.DateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_0.EuropeanDateHelper;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterfaceImpl;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int number = reader.nextInt();

        switch (number) {
            case 0:
                Main.oefening_inheritance();
                break;
            case 1:
                Main.oefening_interfaces();
                break;
            default :
                System.out.println("geen oefening voorzien");
        }
    }

    private static void oefening_inheritance() {
        DateHelper dateHelper1 = new DateHelper();
        EuropeanDateHelper europeanDateHelper = new EuropeanDateHelper();
        DateHelper dateHelper2 = new EuropeanDateHelper();

        System.out.println("datum = " + dateHelper1.getCurrentDateAsString());
        System.out.println("datum = " + europeanDateHelper.getCurrentDateAsString());
        System.out.println("datum = " + dateHelper2.getCurrentDateAsString());

        System.out.println("datum verhoogd met 10 dagen = " + dateHelper1.addNumberOfDays(new Date(System.currentTimeMillis()), 10));
    }

    public static void oefening_interfaces () {
        DummyInterface.InnerInterface1.dummyMethod1("dit is een test");
        DummyInterface.InnerInterface2.printToUpperCase("dit is nog een test");

        DummyInterface dummyInterface = new DummyInterfaceImpl();
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", null));

        dummyInterface.move();
    }

}
