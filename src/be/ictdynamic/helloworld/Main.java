package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.oefening_function_10.ExampleOfAFunction;
import be.ictdynamic.helloworld.oefening_inheritance_0.DateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_0.EuropeanDateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_0.IDateHelper;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterfaceImpl1;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int number = reader.nextInt();

        switch (number) {
            case 0:
                Main.oefeningInheritance();
                break;
            case 1:
                Main.oefeningInterfaces();
                break;
            case 10:
                Main.oefeningFunction();
                break;
            default :
                System.out.println("geen oefening voorzien");
        }
    }

    private static void oefeningInheritance() {
        IDateHelper dateHelper1 = new DateHelper();

        EuropeanDateHelper europeanDateHelper = new EuropeanDateHelper();

        // nog een voorbeeld van design by interface
        IDateHelper dateHelper2 = new EuropeanDateHelper();

        EuropeanDateHelper dateHelper4 = new EuropeanDateHelper();

        oefeningInheritanceHelper(dateHelper1, europeanDateHelper, dateHelper2, dateHelper4);
    }

    private static void oefeningInheritanceHelper(IDateHelper dateHelper1, IDateHelper dateHelper2, IDateHelper dateHelper3, IDateHelper dateHelper4) {
        System.out.println("datum = " + dateHelper1.getCurrentDateAsString());
        System.out.println("datum = " + dateHelper2.getCurrentDateAsString());
        System.out.println("datum = " + dateHelper3.getCurrentDateAsString());

        System.out.println("datum verhoogd met 10 dagen (EuropeanDateHelper)= " + dateHelper2.addNumberOfDays(new Date(System.currentTimeMillis()), 10));
        System.out.println("datum verhoogd met 10 dagen (DangerousUSDateHelper)= " + dateHelper1.addNumberOfDays(new Date(System.currentTimeMillis()), 10));
    }

    public static void oefeningInterfaces() {
        DummyInterface.InnerInterface1.dummyMethod1("dit is een test");
        DummyInterface.InnerInterface2.printToUpperCase("dit is nog een test");

        // voorbeeld van design by interface
        DummyInterface dummyInterface = new DummyInterfaceImpl1();
//        Object dummyInterface = new DummyInterfaceImpl1();

        // concatenating van 2 strings met Java 8 - remember : a method should do one thing only and it should do it properly
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", null));

        // concatenating van 2 strings met Java 8 - remember : a method should do one thing only and it should do it properly
        List<String> valuesList1 = Arrays.asList("wim", "van den brande");
        System.out.println("naam = " + String.join(" ", valuesList1));

        // voorbeeld van een NPE (join method does not accept a null value as an argument)
        System.out.println("naam = " + String.join(null, valuesList1));

        // voorbeeld van een default method
        dummyInterface.move();
    }

    public static void oefeningFunction() {
        ExampleOfAFunction exampleOfAFunction = new ExampleOfAFunction();
        exampleOfAFunction.gettingNameOfTheEmployeeVeryFancy();
        exampleOfAFunction.gettingNameOfTheEmployeeRegular();
    }

}
