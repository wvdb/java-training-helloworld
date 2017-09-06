package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.domain.Employee;
import be.ictdynamic.helloworld.domain.Worker;
import be.ictdynamic.helloworld.oefening_function_10.ExampleOfAFunction;
import be.ictdynamic.helloworld.oefening_inheritance_0.DateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_0.EuropeanDateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_0.IDateHelper;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterfaceImpl1;
import be.ictdynamic.helloworld.oefening_interfaces_1.DummyInterfaceImpl2;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Geef identifier van de oefening: ");
        int oefeningInteger = reader.nextInt();

        switch (oefeningInteger) {
            case 0:
                MyApplication.oefeningInheritance();
                break;
            case 1:
                MyApplication.oefeningInterfaces();
                break;
            case 2:
                MyApplication.oefeningStaticMethod();
                break;
            case 3:
                MyApplication.oefeningEquals();
                break;
            case 4:
                MyApplication myApplication = new MyApplication();
                myApplication.oefeningPassByValue();
                break;
            case 10:
                MyApplication.oefeningFunction();
                break;
            default :
                System.out.println("geen oefening voorzien");
        }

        reader.close();
    }

    private static void oefeningInheritance() {
        IDateHelper dateHelper1 = new DateHelper();

        EuropeanDateHelper europeanDateHelper = new EuropeanDateHelper();

        // nog een voorbeeld van design by interface
        IDateHelper dateHelper2 = new EuropeanDateHelper();

        if (dateHelper2 instanceof EuropeanDateHelper) {
            System.out.println("dateHelper2 is an instance of EuropeanDateHelper");
        } else {
            System.out.println("Houston we have a problem.");
        }

        if (dateHelper2 instanceof DateHelper) {
            System.out.println("dateHelper2 is an instance of DateHelper");
        } else {
            System.out.println("Houston we have a problem.");
        }

        EuropeanDateHelper dateHelper4 = new EuropeanDateHelper();

        oefeningInheritanceHelper(dateHelper1, europeanDateHelper, dateHelper2, dateHelper4);
    }

    // IntelliJ geeft aan dat 4de argument niet wordt gebruikt
    private static void oefeningInheritanceHelper(IDateHelper dateHelper1, IDateHelper dateHelper2, IDateHelper dateHelper3, IDateHelper dateHelper4) {
        System.out.println("datum = " + dateHelper1.getCurrentDateAsString());
        System.out.println("datum = " + dateHelper2.getCurrentDateAsString());
        System.out.println("datum = " + dateHelper3.getCurrentDateAsString());

        System.out.println("datum verhoogd met 10 dagen (EuropeanDateHelper)= " + dateHelper2.addNumberOfDays(new Date(System.currentTimeMillis()), 10));
        System.out.println("datum verhoogd met 10 dagen (DangerousUSDateHelper)= " + dateHelper1.addNumberOfDays(new Date(System.currentTimeMillis()), 10));

        Employee employee = new Employee("wim van den brande", 15);

        // every employee is a worker
        Worker worker = employee;

        // we cannot make a worker an employee
//        employee = worker;

        // but we can cast to an Employee
        Employee workerGecastToEmployee = (Employee) worker;

        // now we cannot retrieve the hire date anymore (compilation error)
//        worker.getHireDate();
    }

    public static void oefeningInterfaces() {
        DummyInterface.InnerInterface1.dummyMethod1("dit is een test");
        DummyInterface.InnerInterface2.printToUpperCase("dit is nog een test");

        // voorbeeld van design by interface
        DummyInterface dummyInterface;

        // concatenating van 2 strings (using StringBuilder/StringBuffer)
        dummyInterface = new DummyInterfaceImpl2();
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory());

        // concatenating van 2 strings (using + operator)
        dummyInterface = new DummyInterfaceImpl1();
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory());

        // concatenating van 2 strings met Java 8 - remember : a method should do one thing only and it should do it properly
        List<String> valuesList1 = Arrays.asList("wim", "van den brande");
        System.out.println("naam = " + String.join(" ", valuesList1));

        // voorbeeld van een NPE (join method does not accept a null value as an argument)
        System.out.println("naam = " + String.join(null, valuesList1));

        // voorbeeld van een default method
        dummyInterface.move();
    }

    private static void oefeningEquals() {
        String canoniekeString1 = "wim van den brande";
        String canoniekeString2 = "wim van den brande";

        if (canoniekeString1 == canoniekeString2) {
            System.out.println("The references are identical. All hail to the string connection pool.");
        }

        // this was asked in an interview once ...

        String string1 = new String("wim van den brande");
        String string2 = new String("wim van den brande");

        if (string1 != string2) {
            System.out.println("The references are not identical. We instantiated 2 different objects and allocated memory twice!");
        }

        // Maak gebruik van debug in String equals
        if (canoniekeString1.equals(canoniekeString2)) {
            System.out.println("Alles ok. Er zijn nog zekerheden ...");
        }

        // Maak gebruik van debug in String equals
        if (string1.equals(string2))  {
            System.out.println("Alles ok. Er zijn nog zekerheden ...");
        }

        // oefening op OR operator
        int val1 = 16;
        int val2 = 8;
        // prints "24"
        System.out.println(val1 | val2);

        // oefening op AND operator
        int[] intValues = {3, 11, 15};
        // prints "3"
        System.out.println(intValues[0] & intValues[1] & intValues[2]);

        // oefening op Signed left shift
        int val3 = 16;
        // prints ???
        for (byte b = 1; b<=3; b ++) {
            System.out.println(val3 << b);
        }

        // prints ???
        for (byte b = 1; b<=5; b ++) {
            System.out.println(val3 >> b);
        }

    }

    private void oefeningPassByValue() {
        Employee employee = new Employee("wim van den brande", 49);

        doSomething(employee);

        // has employee changed ???
        // what will be the name of employee ???

        // do not try to LOG the actual refence since the JVM is free to move references over time

        System.out.println("name of employee in oefeningPassByValue = " + employee.getName());
    }

    private void doSomething(Employee employee) {
        // ho ho ... altering input parameters should be avoid
        employee.setName("wim van den brande - bis");

        employee = new Employee("Donald Trump --- way too old", 75);
        System.out.println("name of employee in doSomething = " + employee.getName());
    }

    private static void doSomethingBis(final Employee employee) {
        employee.setName("wim van den brande - bis");

//        employee = new Employee("Donald Trump --- way too old", 75);
    }

    private static void oefeningStaticMethod() {
        Employee employee = new Employee();
        Worker worker = employee;
        Worker.testClassMethod();
        worker.testInstanceMethod();
        Employee.testClassMethod();
    }

    public static void oefeningFunction() {
        ExampleOfAFunction exampleOfAFunction = new ExampleOfAFunction();
        exampleOfAFunction.gettingNameOfTheEmployeeVeryFancy();
        exampleOfAFunction.gettingNameOfTheEmployeeRegular();
    }

}
