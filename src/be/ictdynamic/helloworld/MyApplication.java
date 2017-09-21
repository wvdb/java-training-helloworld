package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.cursus_domain.Rectangle;
import be.ictdynamic.helloworld.cursus_domain.Square;
import be.ictdynamic.helloworld.domain.Department;
import be.ictdynamic.helloworld.domain.Employee;
import be.ictdynamic.helloworld.domain.Worker;
import be.ictdynamic.helloworld.oefening_abstract_class_6.CustomerDNAFile;
import be.ictdynamic.helloworld.oefening_inheritance_1.DateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_1.EuropeanDateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_1.IDateHelper;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl1;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl2;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter identifier of the exercise: ");
        int oefeningInteger = reader.nextInt();

        // TODO : explain case 4 and case 5 first
        // TODO : piramide : oefening 8

        switch (oefeningInteger) {
            case 0:
                MyApplication.oefeningInheritance_0();
                break;
            case 1:
                MyApplication.oefeningInheritance_1();
                break;
            case 2:
                MyApplication.oefeningInterfaces_2();
                break;
            case 3:
                MyApplication.oefeningStaticMethod_3();
                break;
            case 4:
                MyApplication.oefeningEquals_4();
                break;
            case 5:
                MyApplication.oefeningPassByValue0();
                MyApplication.oefeningPassByValue1();
                MyApplication.oefeningPassByValue2();
                break;
            case 6:
                MyApplication.oefeningInnerClass_6();
                break;
            case 7:
                Employee employee = new Employee(1, "wim van den brande", 49, null, null);
                MyApplication.oefeningWithAssert_7(employee);
                break;
            case 8:
                MyApplication.oefeningPrintPiramide_8();
                break;
            default :
                System.err.println("!!!No exercise supported. ");
        }

        reader.close();
    }

    private static void oefeningInheritance_0() {
        Rectangle rectangle = new Rectangle(10, 5);
        System.out.println("Rectangle = " + rectangle);

        // The constructor of a square has only ONE argument (side)
//        Square square = new Square(10, 5);
        Square square = new Square(25);
        System.out.println("Square = " + square);

        // we make our square smaller
        square.setHeight(10);
        System.out.println("Square = " + square);

        // we make our square larger
        square.setWidth(50);
        System.out.println("Square = " + square);

        // TODO : change impl of Square -> stackoverflow

        // we use change format
        square.changeFormat(50);
        System.out.println("Square = " + square);

        System.out.println(square instanceof Rectangle);
        System.out.println(rectangle instanceof Square);
    }

    private static void oefeningInheritance_1() {
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

        Employee employee = new Employee(1, "wim van den brande", 15, null, null);

        // every employee is a worker
        Worker worker = employee;

        // we cannot make a worker an employee
//        employee = worker;

        // but we can cast to an Employee
        Employee workerCastedToEmployee = (Employee) worker;

        // now we cannot retrieve the hire date anymore (compilation error)
//        workerCastedToEmployee.getHireDate();

        // Employee inherits the static properties as well
        System.out.println("An employee is eligible for remuneration? : " + employee.isEligibleForRemuneration);
    }

    public static void oefeningInterfaces_2() {
        DummyInterface.InnerInterface1.dummyMethod1("dit is een test");
        DummyInterface.InnerInterface2.printToUpperCase("dit is nog een test");

        // voorbeeld van design by interface
        DummyInterface dummyInterface;

        // concatenating van 2 strings (using StringBuilder/StringBuffer)
        dummyInterface = new DummyInterfaceImpl2();
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));

        // concatenating van 2 strings (using + operator)
        dummyInterface = new DummyInterfaceImpl1();
        System.out.println("naam = " + dummyInterface.getCompleteName("wim", "van den brande"));

        // concatenating van 2 strings met Java 8 - remember : a method should do one thing only and it should do it properly
        List<String> valuesList1 = Arrays.asList("wim", "van den brande");
        System.out.println("naam = " + String.join(" ", valuesList1));

        // voorbeeld van een NPE (join method does not accept a null value as an argument)
        System.out.println("naam = " + String.join(null, valuesList1));

        // voorbeeld van een default method
        dummyInterface.move();
    }

    static private void oefeningEquals_4() {
        int i1 = 10;
        int i2 = 20;

        // DOES THIS COMPILE ???

        // if (i1 = i2)

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

        // oefening op bitwise OR operator
        int val1 = 16;
        int val2 = 8;
        // prints "24"
        System.out.println("Bitwise or gives us: " + (val1 | val2));

        // oefening op bitwise AND operator
        int[] intValues = {3, 11, 15};
        // prints "3"
        System.out.println("Bitwise and gives us: " + (intValues[0] & intValues[1] & intValues[2]));

        // oefening op Signed left shift
        int val3 = 16;
        // prints ???
        for (byte b = 1; b<=3; b ++) {
            System.out.println("Signed left shift: value has become: " + (val3 << b));
        }

        // prints ???
        for (byte b = 1; b<=5; b ++) {
            System.out.println("Signed right shift: value has become: " + (val3 >> b));
        }

        // oefening op conditional operator
        int[] years = {2016, 2017, 2100, 2000};

        for (int year : years) {
            System.out.println("year " + year + " is a leap year? " + (isLeapYear(year) ? "This is correct" : "This is not correct"));
        }
    }

    private static boolean isLeapYear(int year) {
        // example of conditional operator
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    static private void oefeningPassByValue0() {
        Integer myInteger = new Integer(5);

        doSomething0(myInteger);

        // has myInteger changed ???
        // what will be the name of myInteger ???

        // do not try to LOG the actual reference since the JVM is free to move references over time

        System.out.println("value of myInteger in oefeningPassByValue0 = " + myInteger);
    }

    private static void doSomething0(Integer myInteger) {
        // ho ho ho ... altering input parameters should be avoided!!!
        myInteger *= myInteger;

        myInteger = new Integer(100);

        System.out.println("value of myInteger in doSomething0 = " + myInteger);
    }

    static private void oefeningPassByValue1() {
        MyApplication myApplication = new MyApplication();

        Employee employee = new Employee(1, "wim van den brande", 49, null, null);

        myApplication.doSomething1(employee);

        // has employee changed ???
        // what will be the name of employee ???

        // do not try to LOG the actual reference since the JVM is free to move references over time

        System.out.println("name of employee in oefeningPassByValue1 = " + employee.getName());
    }

    private void doSomething1(Employee employee) {
        // ho ho ho ... altering input parameters should be avoided!!!
        employee.setName("wim van den brande - bis");

        employee = new Employee(1, "Donald Tttttt....", 71, null, null);
        System.out.println("name of employee in doSomething1 = " + employee.getName());
    }

    static private void oefeningPassByValue2() {
        Integer[] myIntegers = {10, 20, 30, 40};

        doSomething2(myIntegers);

        // has myArray  changed ???
        // what will be the name of employee ???

        for (Integer myInteger : myIntegers) {
            System.out.println("myInteger in oefeningPassByValue2 = " + myInteger);
        }

    }

    private static void doSomething2(Integer[] myIntegers) {
        // ho ho ho ... altering input parameters should be avoided!!!
        myIntegers[0] /= 10;
        myIntegers[1] /= 10;
        myIntegers[2] /= 10;
        myIntegers[3] /= 10;

        myIntegers = new Integer[]{100, 200, 300, 400};

        for (Integer myInteger : myIntegers) {
            System.out.println("myInteger = " + myInteger);
        }

        Integer[] myIntegersBis1 = new Integer[4];
        System.arraycopy(myIntegers, 0, myIntegersBis1, 0, 4);

        Integer[] myIntegersBis2 = myIntegersBis1;
        int i=0;
    }

    private static void oefeningInnerClass_6() {
        CustomerDNAFile customerDNAFile = new CustomerDNAFile();

        // Preference is (normal) inner class
        // CustomerDnaSource is static inner class

        CustomerDNAFile.Preference preference = customerDNAFile.new Preference(Date.from(Instant.now()));
        // use breakpoint
        preference = customerDNAFile.new Preference(Date.from(Instant.now()));

//        CustomerDNAFile.CustomerDnaSource attribute = customerDNAFile.new CustomerDnaSource();
        CustomerDNAFile.CustomerDnaSource customerDnaSource = new CustomerDNAFile.CustomerDnaSource("Facebook", false);
        // use breakpoint
        customerDnaSource = new CustomerDNAFile.CustomerDnaSource("Twitter", false);

        CustomerDNAFile.exampleOfLocalInnnerClassMethod();

        // example of a static inner class when using the builder design pattern

        Department department = new Department.DepartmentBuilder()
                .departmentAddress("example of an address")
                .departmentName("example of a department")
                .build();

        // example of a (normal) inner class : Addresses have been embedded within Employee

        Employee employee = new Employee(1, "wim van den brande", 49, null, null);
        Employee.Address address1 = employee.new Address(1, "home", "street 1", "house no1", "zip 1", "commune 1");
        Employee.Address address2 = employee.new Address(2, "office", "street 2", "house no2", "zip 2", "commune 2");

    }

    private static void oefeningStaticMethod_3() {
        Employee employee = new Employee();
        Worker worker = employee;

        Worker.testClassMethod();
        // CTRL click method and ask which method will be invoked
        worker.testInstanceMethod();

        Employee.testClassMethod();
    }

    private static void oefeningWithAssert_7(Employee employee) {
        // assert facilitates the idea of validation / pre-condition
        // assert throws AssertionError (inherits from Error) !!!

        // assert ONLY works when running when passing JAVA the -ea (enable assert) option
        assert employee.getId() >= 0;
//        assert employee.getName().length() > 0;
        assert employee.getName() != null && employee.getName().length() > 0;
        assert employee.getHireDate() != null ;

        // alternative is an IllegalArgumentException
        // be aware of the
        // InvalidArgumentException !!!
    }

    private static void oefeningPrintPiramide_8() {
        Scanner reader = new Scanner(System.in);
        int piramideMaxValue = 0;

        while (piramideMaxValue <= 0 || piramideMaxValue > 99) {
            System.out.println("Enter maximal value of the pyramid:");
            piramideMaxValue = reader.nextInt();
        }

        System.out.println("\nCreating a pyramid as we know it.\n");

        for (int i=1; i<=piramideMaxValue; i++) {
            piramideImpl(piramideMaxValue, i);

        }

        System.out.println("\nCreating a company with too much overhead.\n");

        for (int i=piramideMaxValue; i>=1; i--) {
            piramideImpl(piramideMaxValue, i);
        }

    }

    private static void piramideImpl(int piramideMaxValue, int i) {
        // take care of printing spaces (if any)
        for (int j=1; j <= piramideMaxValue -i; j++ ) {
            // TODO : 2 spaces should become a constant
            System.out.print("  ");
        }
        // take care of printing actual digit
        for (int j=1; j <= i; j++ ) {
            System.out.print(String.format("%02d", i) + "  ");
        }
        // take care of printing newline
        System.out.println();
    }


}
