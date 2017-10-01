package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.cursus_domain.Rectangle;
import be.ictdynamic.helloworld.cursus_domain.Square;
import be.ictdynamic.helloworld.domain.*;
import be.ictdynamic.helloworld.enums.Coin;
import be.ictdynamic.helloworld.enums.MonthEnumeration;
import be.ictdynamic.helloworld.oefening_inner_class_6.CustomerDNAFile;
import be.ictdynamic.helloworld.oefening_inheritance_1.DateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_1.EuropeanDateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_1.IDateHelper;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl1;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl2;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MyApplication {

    public static final String EMPTY_STRING_2_SPACES = "  ";
    public static final String EMPTY_STRING_1_SPACE = " ";

    public static int numberOfEmployees = 0;
    public static int numberOfManagers = 0;
    public static int numberOfDirectors = 0;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter identifier of the exercise: ");
        int oefeningInteger = reader.nextInt();

        switch (oefeningInteger) {
            case 0:
                MyApplication.oefeningInheritance_0();
                break;
            case 1:
                MyApplication.oefeningInheritance_1();
                break;
            case 2:
//                MyApplication.oefeningInterfaces_2A();
                MyApplication.oefeningInterfaces_2B();
                break;
            case 3:
                MyApplication.oefeningStaticMethodAndInstanceMethod_3();
                break;
            case 4:
                MyApplication.oefeningConditionalOperatorAndShiftOperator_4A();
//                MyApplication.oefeningEquals_4B();
                break;
            case 5:
                MyApplication.exercisePassByValue5_00();
//                MyApplication.exercisePassByValue5_0();
//                MyApplication.exercisePassByValue5_1();
//                MyApplication.exercisePassByValue5_2();
//                MyApplication.exercisePassByValue5_3();
                break;
            case 6:
//                MyApplication.oefeningAbstractClass_6a();
                MyApplication.oefeningInnerClass_6b();
                break;
            case 7:
                Employee employee = new Employee(null, "wim van den brande", 49, null, null);
                MyApplication.oefeningWithAssert_7(employee);
                break;
            case 8:
                MyApplication.oefeningPrintPiramide_8();
                break;
            case 9:
                MyApplication.oefeningEnum_9();
                break;
            case 10:
                MyApplication.oefeningException_10();
                break;
            case 11:
                MyApplication.oefeningString_11A();
//                MyApplication.oefeningStringBuilder_11B();
                break;
            case 12:
                MyApplication.oefeningDate_12();
                break;
            case 13:
                MyApplication.oefeningMap_13();
                break;
            case 99:
                MyApplication.myCompany_99();
                break;
            default :
                System.err.println("!!!No exercise supported. ");
        }

        reader.close();

        System.exit(0);
    }

    private static void oefeningDate_12() {
        long long1 = System.currentTimeMillis();
        long long2 = Instant.now().toEpochMilli();

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a date in dd/mm/yyyy format");
        String myDate = reader.nextLine();

        DateTimeFormatter ddMMyyyyFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter oracleDateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        LocalDate localDate = LocalDate.parse(myDate, ddMMyyyyFormatter);

        System.out.println("My localDate = " + localDate);
//        System.out.println("My localDate = " + (new Year(localDate.getYear())).isLeap());
        System.out.println("Leap Year? " + (Year.parse(myDate, ddMMyyyyFormatter)).isLeap());
        System.out.println("My localDate = " + localDate.format(oracleDateFormatter));
    }

    private static void oefeningMap_13() {
        Map<Coin, Integer> myPurse1 = new HashMap<>();
        Map<Coin, Integer> myPurse2 = new LinkedHashMap<>();

        createPurse(myPurse1);
        myPurse1.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));

        createPurse(myPurse2);
        myPurse2.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));
    }

    private static void createPurse(Map<Coin, Integer> myPurse1) {
        myPurse1.put(Coin.TEN_EURO_CENT, 3);
        myPurse1.put(Coin.FIVE_EURO_CENT, 2);
        myPurse1.put(Coin.TWENTY_EURO_CENT, 2);
        myPurse1.put(Coin.ONE_EURO_CENT, 20);
    }

    private static void oefeningInheritance_0() {
        Rectangle rectangle = new Rectangle(10, 5);
        System.out.println("Rectangle = " + rectangle);

        // The constructor of a square has only ONE argument (side)
//        Square square = new Square(10, 5);
        Square square = new Square(25);
        System.out.println("Square = " + square);

        // we make our square smaller
//        square.setHeight(10);
        System.out.println("Square = " + square);

        // we make our square larger
//        square.setWidth(50);
        System.out.println("Square = " + square);

        // TODO : change impl of Square -> stackoverflow

        // we use change format
        square.changeFormat(50);

//        square.setHeight(10);
//        square.setWidth(10);

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
        System.out.println("date = " + dateHelper1.getCurrentDateAsString());
        System.out.println("date = " + dateHelper2.getCurrentDateAsString());
        System.out.println("date = " + dateHelper3.getCurrentDateAsString());

        System.out.println("date increased with 10 days (EuropeanDateHelper)= " + dateHelper2.addNumberOfDays(new Date(System.currentTimeMillis()), 10));
        System.out.println("date increased with 10 days (DangerousUSDateHelper)= " + dateHelper1.addNumberOfDays(new Date(System.currentTimeMillis()), 10));

        Employee employee = new Employee(null, "wim van den brande", 15, null, null);

        // every employee is a worker
        Worker worker = employee;

        doSomethingWithWorker(worker);

        // we cannot make a worker an employee
//        employee = worker;

        // but we can cast to an Employee
        Employee workerCastedToEmployee = (Employee) worker;

        // now we cannot retrieve the hire date anymore (compilation error)
//        workerCastedToEmployee.getHireDate();

        // Employee inherits the static properties as well
        System.out.println("An employee is eligible for remuneration? : " + Employee.isEligibleForRemuneration);
    }

    private static void doSomethingWithWorker(Worker worker) {
        if (worker instanceof Employee) {
            System.out.println("we've got an Employee");
        } else if (worker instanceof Manager) {
            System.out.println("we've got a Manager");
        } else if (worker instanceof Director) {
            System.out.println("we've got a Director");
        } else {
            System.out.println("we've got a problem");
        }
    }

    public static void oefeningInterfaces_2A() {
        DummyInterface.InnerInterface1.dummyMethod1("dit is een test");
        DummyInterface.InnerInterface2.printToUpperCase("dit is nog een test");

//        DummyInterface dummyInterface2 = new DummyInterface();

        // example of design by interface
        DummyInterface dummyInterface;

        // concatenating 2 strings (using StringBuilder/StringBuffer)
        // go to impl and read https://stackoverflow.com/questions/42855964/how-to-prevent-notice-stringbuilder-sb-can-be-replaced-with-string-in-int

        // IDE is actually very smart here,
        // it suggests you to change it for better code readability since internally compiler
        // will generate exactly the same bytecode and your code
        // will have the same performance and the same memory usage, but it will be easier to read.
        dummyInterface = new DummyInterfaceImpl2();
        System.out.println("name = " + dummyInterface.getCompleteName("wim", "van den brande"));

        // concatenating 2 strings (using + operator)
        // example of Design By Interface
        dummyInterface = new DummyInterfaceImpl1();
        System.out.println("name = " + dummyInterface.getCompleteName("wim", "van den brande"));

        oefeningInterfaces_2_gebruik_InstanceOf(dummyInterface);
//        oefeningInterfaces_2_gebruik_InstanceOf(null);

        // concatenating 2 strings with Java 8 - remember : a method should do one thing only and it should do it properly
        List<String> valuesList1 = Arrays.asList("wim", "van den brande");
        System.out.println("name = " + String.join(" ", valuesList1));

        // example of a NPE (join method does not accept a null value as an argument)
        System.out.println("name = " + String.join(null, valuesList1));

        // example of a default method
        dummyInterface.move();

        // example of interfaces (HP)
        // remark 1: duplication (interface and impl)
        // remark 2: JavaDoc
        // remark 3: naamgeving
    }

    private static void oefeningInterfaces_2_gebruik_InstanceOf(DummyInterface dummyInterface) {
        if (dummyInterface instanceof Object) {
            System.out.println("This makes sense. However... ");
        }

        // REMARK : this should be avoided - loose coupling
        if (dummyInterface instanceof DummyInterfaceImpl2) {
            System.out.println("We use the DummyInterfaceImpl2");
        } else {
            System.out.println("We use the DummyInterfaceImpl1");
        }

        // correct example :
        System.out.println("Result of  = " + dummyInterface.getCompleteName("wim", "van den brande"));
    }
    public static void oefeningInterfaces_2B() {
        Pig pig = new MyPig();
        pig.grunt();
        pig.fly();
    }
    static private void oefeningConditionalOperatorAndShiftOperator_4A() {
        int i1 = 20;
        int i2 = 20;

        // DOES THIS COMPILE ???

//         if (i1 = i2) {
//
//         }

        // exercise bitwise OR operator
        int val1 = 16;
        int val2 = 8;
        // prints "24"
        System.out.println("Bitwise or gives us: " + (val1 | val2));

        // exercise op bitwise AND operator
        int[] intValues = {3, 11, 14};
        // prints "2"
        System.out.println("Bitwise and gives us: " + (intValues[0] & intValues[1] & intValues[2]));

        // exercise op Signed left shift
        int val3 = 16;
        // prints ???
        for (byte b = 1; b<=3; b ++) {
            System.out.println("Signed left shift: value has become: " + (val3 << b));
        }

        // prints ???
        for (byte b = 1; b<=5; b ++) {
            System.out.println("Signed right shift: value has become: " + (val3 >> b));
        }

        // exercise playDays
        int[] playDays = {20, 31, 3} ;
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] playDaysx = {1, 2, 4, 8, 16, 32, 64} ;

        for (int playDay: playDays) {

            int index = 0;
            for (String day: days) {
                System.out.println("Player with playDay " + playDay + ", day " + day + ": " + ((playDay & playDaysx[index]) > 0 ? "plays" : "does not play") );
                index += 1;
            }
        }

        // exercise op conditional operator
        int[] years = {2016, 2017, 2100, 2000};

        double i = 5.0;
        double j = Math.pow(i, 4.0);

        for (int year : years) {
            System.out.println("year " + year + " is a leap year? " + (isLeapYear(year) ? "This is correct" : "This is not correct"));
        }
    }

    static private void oefeningEquals_4B() {
        String canonicalString1 = "wim van den brande";
        String canonicalString2 = "wim van den brande";

        if (canonicalString1 == canonicalString2) {
            System.out.println("The references are identical. All hail to the string constant pool.");
        }

        // this was asked in an interview once ...

        String string1 = new String("wim van den brande");
        String string2 = new String("wim van den brande");

        if (string1 != string2) {
            System.out.println("The references are not identical. We instantiated 2 different objects and allocated memory twice!");
        }

        // Maak gebruik van debug in String equals
        if (canonicalString1.equals(canonicalString2)) {
            System.out.println("Everything fine ...");
        }

        // Maak gebruik van debug in String equals
        if (string1.equals(string2))  {
            System.out.println("Everything fine ...");
        }
    }

    private static boolean isLeapYear(int year) {
        // example of conditional operator
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    static private void exercisePassByValue5_00() {
        int myInteger = 5;

        doSomething00(myInteger);

        // has myInteger changed ???

        // do not try to LOG the actual reference since the JVM is free to move references over time

        System.out.println("value of myInteger in oefeningPassByValue5_0 = " + myInteger);
    }

    private static void doSomething00(int myInteger) {
        // ho ho ho ... altering input parameters should be avoided!!!
        // this is not an anti-pattern, it's a bad practice.

        myInteger = 100;

        System.out.println("value of myInteger in doSomething00 = " + myInteger);
    }


    static private void exercisePassByValue5_0() {
        Integer myInteger = new Integer(5);
//        Integer myInteger = 5;

        doSomething0(myInteger);

        // has myInteger changed ???

        // do not try to LOG the actual reference since the JVM is free to move references over time

        System.out.println("value of myInteger in oefeningPassByValue5_0 = " + myInteger);
    }

    private static void doSomething0(Integer myInteger) {
        // ho ho ho ... altering input parameters should be avoided!!!
        // this is not an anti-pattern, it's a bad practice.

        // ALL JAVA.LANG WRAPPER TYPES ARE IMMUTABLE !!!

        myInteger = new Integer(100);

        // explain advantage of final

        System.out.println("value of myInteger in doSomething0 = " + myInteger);
    }

    static private void exercisePassByValue5_1() {
        Employee employee = new Employee(null, "wim van den brande", 49, null, null);

        doSomething1(employee);

        // has employee changed ???
        // what will be the name of employee ???

        // do not try to LOG the actual reference since the JVM is free to move references over time

        System.out.println("name of employee in exercisePassByValue5_1 = " + employee.getFirstName());
    }

    private static void doSomething1(final Employee employee) {
        // ho ho ho ... altering input parameters should be avoided!!!
//        employee.setFirstName("wim van den brande - bis");

//        employee = new Employee(1, "Donald Tttttt....", 71, null, null);
        System.out.println("name of employee in doSomething1 = " + employee.getFirstName());
    }

    static private void exercisePassByValue5_2() {
        Integer[] myIntegers = {10, 20, 30, 40};

        doSomething2(myIntegers);

        // has myIntegers changed ???

        for (Integer myInteger : myIntegers) {
            System.out.println("myInteger in exercisePassByValue5_2 = " + myInteger);
        }

    }

    private static void doSomething2(Integer[] myIntegers) {
        // ho ho ho ... altering input parameters should be avoided!!!
        myIntegers[0] /= 10;
        myIntegers[1] /= 10;
        myIntegers[2] /= 10;
        myIntegers[3] /= 10;

//        myIntegers = new Integer[]{100, 200, 300, 400};

        for (Integer myInteger : myIntegers) {
            System.out.println("myInteger = " + myInteger);
        }

        Integer[] myIntegersBis1 = new Integer[4];
        System.arraycopy(myIntegers, 0, myIntegersBis1, 0, 4);

        Integer[] myIntegersBis2 = myIntegersBis1;

        // breakpoint
        int i=0;
    }

    static private void exercisePassByValue5_3() {
        Integer[] myInputIntegers = {10, 20, 30, 40};
        Integer[] myOutputIntegers = new Integer[myInputIntegers.length];

        doSomething3(myInputIntegers, myOutputIntegers);

        for (Integer myOutputInteger : myOutputIntegers) {
            System.out.println("myOutputInteger in exercisePassByValue5_3 = " + myOutputInteger);
        }

    }

    private static void doSomething3(Integer[] myInputIntegers, Integer[] myOutputIntegers) {
        // DO NOT !!!
        // REMEMBER .... PASSED BY VALUE BUT THE VALUE IS THE REFERENCE !!!

//        myOutputIntegers = myInputIntegers;

        // CORRECT SOLUTION !!!

        System.arraycopy(myInputIntegers, 0, myOutputIntegers, 0, myInputIntegers.length);

        for (int i=0; i<myOutputIntegers.length; i++) {
            myOutputIntegers[i] = myInputIntegers[i] / 10;
        }
    }

    private static void oefeningAbstractClass_6a() {
//        Worker worker1 = new Worker();

        Worker worker2 = new Worker() {
            @Override
            public Float calculateTotalIncentiveCost() {
                return null;
            }

            @Override
            protected void setRemunerations(Remuneration[] remunerations) {
            }
        };
    }

    private static void oefeningInnerClass_6b() {
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

        Department department1 = new Department.DepartmentBuilder()
                .departmentAddress("example of an address")
                .departmentName("example of a department")
                .build();

        Department department2 = new Department.DepartmentBuilder()
                .departmentAddress("example of an address")
                .build();

        // example of a (normal) inner class : Addresses have been embedded within Employee

        Employee employee = new Employee(null, "wim van den brande", 49, null, null);
        Employee.Address address1 = employee.new Address("home", "street 1", "house no 1", "zip 1", "commune 1");
        Employee.Address address2 = employee.new Address("office", "street 2", "house no2", "zip 2", "commune 2");
        Employee.Address address3 = employee.new Address("office", "street 2", "house no2", "zip 2", "commune 2");

        Set<Employee.Address> addresses = new HashSet<>();
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);

        // use breakpoint
        System.out.println("Number of addresses in set = " + addresses.size());
    }

    private static void oefeningStaticMethodAndInstanceMethod_3() {
        Employee employee = new Employee();
        Worker worker = employee;

        Worker.testClassMethod();
        Employee.testClassMethod();

        // CTRL click method and ask which method will be invoked
        // use debugger

        // refer to late
        worker.testInstanceMethod();
    }

    private static void oefeningWithAssert_7(Employee employee) {
        // assert facilitates the idea of validation / pre-condition
        // assert throws AssertionError (inherits from Error) !!!

        // assert ONLY works when running when passing JAVA the -ea (enable assert) option
//        assert employee.getFirstName().length() > 0;
        assert employee.getHireDate() != null : "Oepsie... hireDate is null";
        assert employee.getMiddleName() != null && employee.getMiddleName().length() > 0 : "Oepsie... middleName is unknown";

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
            piramideImpl_8(piramideMaxValue, i);

        }

        System.out.println("\nCreating a company with too much overhead.\n");

        for (int i=piramideMaxValue; i>=1; i--) {
            piramideImpl_8(piramideMaxValue, i);
        }

    }

    private static void oefeningEnum_9() {
        for (MonthEnumeration monthEnumeration : MonthEnumeration.values()) {
            System.out.println("month " + monthEnumeration + " has an index of " + monthEnumeration.getIndex() + ". The ordinal value = " + monthEnumeration.ordinal() + ", numDays = " + monthEnumeration.getDaysInMonth());
            for (String monthAsString : monthEnumeration.getMonthLanguages()) {
                System.out.println("month " + monthEnumeration + " is written as " + monthAsString);
            }
        }
    }

    private static void oefeningException_10() {
        Remuneration[] remunerations1 = {new MealVoucher("dag", 6), new Salary(1000.00)};
        Remuneration[] remunerations2 = {};

        Employee.calculateTotalIncentiveCost(remunerations1);
        Employee.calculateTotalIncentiveCost(remunerations2);
    }

    private static void oefeningString_11A() {
        long timeStart = System.currentTimeMillis();
        String initString = new String("this is a test");
//        for (Integer i=0; i<=Integer.MAX_VALUE; i++) {
        for (Integer i=0; i<=10_000_000; i++) {
            if (i%1000 == 0) {
//                System.out.println("INDEX HAS BECOME " + i);
            }
            initString = initString.concat(i.toString());
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void oefeningStringBuilder_11B() {
        long timeStart = System.currentTimeMillis();
        StringBuilder initString = new StringBuilder("dit is een 2de test");
//        for (Integer i=0; i<=Integer.MAX_VALUE; i++) {
        for (Integer i=0; i<=10_000_000; i++) {
            if (i%1000 == 0) {
                System.out.println("INDEX HAS BECOME " + i);
            }
            StringBuilder dummy = initString.append(i.toString());
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void piramideImpl_8(int piramideMaxValue, int i) {
        // take care of printing spaces (if any)
        for (int j=1; j <= piramideMaxValue -i; j++ ) {
            // TODO : 2 spaces should become a constant
            System.out.print((piramideMaxValue > 9) ? EMPTY_STRING_2_SPACES : EMPTY_STRING_1_SPACE);
        }
        // take care of printing actual digit
        for (int j=1; j <= i; j++ ) {
            // TODO : to refactor validation method

            if (piramideMaxValue > 9) {
                System.out.print(String.format("%02d", i) + EMPTY_STRING_2_SPACES);
            }
            else {
                System.out.print(String.format("%d", i) + EMPTY_STRING_1_SPACE);
            }
        }
        // take care of printing newline
        System.out.println();
    }

    private static void myCompany_99() {
        Worker[] workers = new Worker[10];
        int index = 0;

        Employee employee1 = new Employee(null, "employee 1", 49, Worker.Gender.MALE, Date.from(Instant.now()));
        employee1.setRemunerations(getCorrectNumberOfRemunerationsForEmployee(1000));
        System.out.println("Total cost of employee1 " +  employee1.calculateTotalIncentiveCost());
        workers[index++] = employee1;

        Employee employee2 = new Employee(null, "employee 2", 49, Worker.Gender.MALE, Date.from(Instant.now()));
        employee2.setRemunerations(getInCorrectNumberOfRemunerationsForEmployee(2000));
        workers[index++] = employee2;

        Employee employee3 = new Employee(null, "employee 3", 49, Worker.Gender.MALE, Date.from(Instant.now()));
        employee3.setRemunerations(getCorrectNumberOfRemunerationsForEmployee(3000));
        workers[index++] = employee3;

        Employee employee4 = new Employee(null, "employee 4", 49, Worker.Gender.MALE, Date.from(Instant.now()));
        employee4.setRemunerations(getCorrectNumberOfRemunerationsForEmployee(4000));
        workers[index++] = employee4;

        Employee employee5 = new Employee(null, "employee 5", 49, Worker.Gender.MALE, Date.from(Instant.now()));
        employee5.setRemunerations(getCorrectNumberOfRemunerationsForEmployee(5000));
        workers[index++] = employee5;

        Employee employee6 = new Employee(null, "employee 6", 49, Worker.Gender.MALE, Date.from(Instant.now()));
        employee6.setRemunerations(getCorrectNumberOfRemunerationsForEmployee(6000));
        workers[index++] = employee6;

        Employee employee7 = new Employee(null, "employee 6", 49, null, Date.from(Instant.now()));
        employee7.setRemunerations(getCorrectNumberOfRemunerationsForEmployee(6000));
        workers[index++] = employee7;

        Employee employee8 = new Employee(null, "employee 5", 49, Worker.Gender.MALE, Date.from(Instant.now()));
        employee8.setRemunerations(getCorrectNumberOfRemunerationsForEmployee(5000));
        workers[index++] = employee8;

        countWorkerTypes(workers);
        System.out.println("Number of valid Employees = " + numberOfEmployees);
        System.out.println("Number of valid Managers = " + numberOfManagers);
        System.out.println("Number of valid Director = " + numberOfDirectors);
        
        exampleOfStreams1(workers);

        System.out.println("Number of unique workers = " + getListWithUniqueEmployees(workers).size());
    }


    private static void exampleOfStreams1(Worker[] workers) {
        List<Worker> workersWithGenderUnknown = Arrays.stream(workers).filter(worker -> worker != null && worker.getGender() == null).collect(Collectors.toList());
        System.out.println("Number with gender unknown = " + workersWithGenderUnknown.size());
    }

    private static Remuneration[] getCorrectNumberOfRemunerationsForEmployee(float salary) {
        Remuneration[] remunerations = new Remuneration[2];
        remunerations[0] = new MealVoucher("dagelijkse maaltijdcheque", 7.00);
        remunerations[1] = new Salary(salary);
        return remunerations;
    }

    private static Remuneration[] getInCorrectNumberOfRemunerationsForEmployee(float salary) {
        Remuneration[] remunerations = new Remuneration[3];
        remunerations[0] = getCorrectNumberOfRemunerationsForEmployee(salary)[0];
        remunerations[1] = getCorrectNumberOfRemunerationsForEmployee(salary)[1];
        remunerations[2] = new Mobile("I-phone", "0485717182", 1000.00);
        return remunerations;
    }

    private static List<Worker> getListWithUniqueEmployees(Worker[] arrayOfWorkers) {
        List<Worker> workers = new ArrayList<>();

        for (int i = 0; i < arrayOfWorkers.length && arrayOfWorkers[i] != null; i++) {
            boolean workerIsUnique = true;

            for(int j = i+1; j < arrayOfWorkers.length && arrayOfWorkers[j] != null; j++) {
                if (arrayOfWorkers[i].getFirstName().equals(arrayOfWorkers[j].getFirstName()) &&
                    arrayOfWorkers[i].getMiddleName().equals(arrayOfWorkers[j].getMiddleName()) &&
                    arrayOfWorkers[i].getLastName().equals(arrayOfWorkers[j].getLastName())) {
                    // worker is not unique -- we ignore this worker
                    workerIsUnique = false;
                }
            }

            if (workerIsUnique) {
                // we've got a unique worker - let's add it to our list
                workers.add(arrayOfWorkers[i]);
            }
        }

        return workers;
    }

    private static void countWorkerTypes(Worker[] workers) {
        for(Worker worker: workers) {
            if (worker instanceof Employee) {
                Employee employee = (Employee) worker;
                // option 1
//                if (isEligibleForHRSystem(employee.getRemunerations(), Employee.MAX_NUMBER_OF_REMUNERATIONS_FOR_EMPLOYEE)) {
//                    if (employee.isValidEmployee()) {
//                        numberOfEmployees++;
//                    }
//                }

                // option 2
                if (employee.isValidEmployee()) {
                    numberOfEmployees++;
                }
            } else if (worker instanceof  Manager) {
                Manager manager = (Manager) worker;
                if (isEligibleForHRSystem(manager.getRemunerations(), Manager.MAX_NUMBER_OF_REMUNERATIONS_FOR_MANAGER)) {
                    numberOfManagers++;
                }
            } else {
                if (worker != null ) {
                    Director director = (Director) worker;
                    if (isEligibleForHRSystem(director.getRemunerations(), Director.MAX_NUMBER_OF_REMUNERATIONS_FOR_DIRECTOR)) {
                        numberOfDirectors++;
                    }
                }
            }
        }

    }

    private static boolean isEligibleForHRSystem(Remuneration[] remunerations, int maxNumberOfRemunerationsAllowed) {
        return remunerations != null && remunerations.length <= maxNumberOfRemunerationsAllowed;
    }


}
