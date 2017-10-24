package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.cursus_domain.*;
import be.ictdynamic.helloworld.domain.*;
import be.ictdynamic.helloworld.enums.Coin;
import be.ictdynamic.helloworld.enums.Country;
import be.ictdynamic.helloworld.enums.IPhoneType;
import be.ictdynamic.helloworld.enums.MonthEnumeration;
import be.ictdynamic.helloworld.exception.MyCustomizedException;
import be.ictdynamic.helloworld.oefening_inheritance_1.DateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_1.EuropeanDateHelper;
import be.ictdynamic.helloworld.oefening_inheritance_1.IDateHelper;
import be.ictdynamic.helloworld.oefening_inner_class_6.CustomerDNAFile;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl1;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl2;
import be.ictdynamic.helloworld.utilities.BmiUtility;
import be.ictdynamic.helloworld.utilities.DateUtility;
import be.ictdynamic.helloworld.utilities.KeyboardUtility;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class MyApplication {

    public static final String EMPTY_STRING_2_SPACES = "  ";
    public static final String EMPTY_STRING_1_SPACE = " ";

    public static int numberOfEmployees = 0;
    public static int numberOfManagers = 0;
    public static int numberOfDirectors = 0;
    private static int numberOfTimesInputGiven = 0;

    public static void main(String[] args) throws MyCustomizedException {

        int oefeningInteger = Integer.MIN_VALUE;

        while (oefeningInteger <= Integer.MIN_VALUE) {
            System.out.println("Enter identifier of the exercise: ");
            Scanner reader = new Scanner(System.in);
            try {
                oefeningInteger = reader.nextInt();
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Invalid value. Try again. Exception message = " + e.getMessage());
            }
            finally {
                numberOfTimesInputGiven++;
            }
        }

        switch (oefeningInteger) {
            case -1:
                MyApplication.oefeningPrimitives__1();
                break;
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
//                MyApplication.oefeningConditionalOperatorAndShiftOperator_4A();
                MyApplication.oefeningEquals_4B();
                break;
            case 5:
//                MyApplication.exercisePassByValue5_00();
//                MyApplication.exercisePassByValue5_0();
                MyApplication.exercisePassByValue5_1();
//                MyApplication.exercisePassByValue5_2();
//                MyApplication.exercisePassByValue5_3();
                break;
            case 6:
                MyApplication myApplication = new MyApplication();
//                myApplication.oefeningAbstractClass_6a();
                MyApplication.oefeningInnerClass_6b();
                break;
            case 7:
                MyApplication.oefeningWithAssert_7();
                break;
            case 8:
//                MyApplication.oefeningPrintPiramide_8B();
//                MyApplication.oefeningParseStringWithBrackets_8A_V1();
                MyApplication.oefeningParseStringWithBracketsAndUsingAList_8A_V2();
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
//                MyApplication.oefeningLargeListWithCapacity_11D();
//                MyApplication.oefeningLargeList_11C();
                break;
            case 12:
                MyApplication.oefeningDate_12();
                break;
            case 13:
                // TODO : sorting of a MAP ???
                MyApplication.oefeningMap_13A();
                MyApplication.oefeningMap_13B();
                break;
            case 14:
                MyApplication.oefeningList_14();
                break;
            case 15:
                MyApplication.oefeningHashSetAndLinkedHashSet_15();
                break;
            case 18:
                oefeningBmiUtility_18();
                break;
            case 99:
                MyApplication.myCompany_99();
                break;
            default :
                System.err.println("!!!No exercise supported. ");
        }

        System.out.println(String.format("we hebben %05d keer input gegeven", numberOfTimesInputGiven));
        System.exit(0);
    }

    private static void oefeningBmiUtility_18() {
        System.out.println("Voer gewicht in");
        int gewicht = KeyboardUtility.readInt();

        System.out.println("Voer lengte in");
        int lengte = KeyboardUtility.readInt();

        System.out.println("Mijn bmi  = " + BmiUtility.calculateBmi((float) lengte / 100, gewicht));
    }

    private static void oefeningDate_12() {
        //example of 2 identical Java 8 methods
        long long1 = System.currentTimeMillis();
        long long2 = Instant.now().toEpochMilli();

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a date in dd/mm/yyyy format");
        String myDate = reader.nextLine();

        DateTimeFormatter ddMMyyyyFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter oracleDateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        LocalDate localDate = LocalDate.parse(myDate, ddMMyyyyFormatter);

        System.out.println("My localDate = " + localDate);
        System.out.println("My localDateTime (string-date format) = " + DateUtility.convertLocalDateTimeToEuropeanDateAsString(LocalDateTime.now()));
        System.out.println("My localDateTime (string-date-time format) = " + DateUtility.convertLocalDateTimeToEuropeanDateTimeAsString(LocalDateTime.now()));

        System.out.println("Leap Year of the date you entered? " + (Year.parse(myDate, ddMMyyyyFormatter)).isLeap());
        System.out.println("My localDate = " + localDate.format(oracleDateFormatter));
    }

    private static void oefeningMap_13A() {
        Map<Coin, Integer> myPurse1 = new HashMap<>();
        Map<Coin, Integer> myPurse2 = new LinkedHashMap<>();
        SortedMap<Coin, Integer> myPurse3 = new TreeMap<>();

        createPurse(myPurse1);
        System.out.println("Usage of HashMap");
        myPurse1.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));

        createPurse(myPurse2);
        System.out.println("Usage of LinkedHashMap");
        myPurse2.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));

        // TODO : sorting
        createSortedPurse(myPurse3);
        System.out.println("Usage of TreeMap");
        myPurse3.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));
    }

    private static void oefeningMap_13B() {
        Map<String, Map<String, Integer>> olympicMedalsPerYearPerCountry = new HashMap<>();

        Map<String, Integer> mapOfMedals2016 = new HashMap<>();
        mapOfMedals2016.put("NL", 12);
        mapOfMedals2016.put("BE", 4);
        mapOfMedals2016.put("US", 22);
        mapOfMedals2016.put("RUS", 1);

        olympicMedalsPerYearPerCountry.put("2016", mapOfMedals2016);

        Map<String, Integer> mapOfMedals2020 = new HashMap<>();
        mapOfMedals2020.put("NL", 6);
        mapOfMedals2020.put("BE", 40);
        mapOfMedals2020.put("US", 5);
        mapOfMedals2020.put("RUS", 0);

        olympicMedalsPerYearPerCountry.put("2020", mapOfMedals2020);
    }

    private static void oefeningList_14() {
        // name convention (employees and employee in iteration)
        // list : no quick searching

        // example of initial capacity

//      List<Employee> employees = new ArrayList<>(1);
        List<Employee> employees = new ArrayList<>(10);

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        // evilish and to be avoided
//        employees.add(0, employee1);
//        employees.add(2, employee2);

        employees.add(employee1);
        employees.add(employee2);

        System.out.println("size = " + employees.size());

        for (Employee employee : employees) {
            System.out.println( employee );
        }
    }

    private static void oefeningHashSetAndLinkedHashSet_15() {
        List<Integer> integers0 = new ArrayList<>();
        integers0 = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

        Set<Integer> myHashSet = new HashSet<Integer>(integers0);

        Set<Integer> myLinkedHashSet= new LinkedHashSet<Integer>(integers0);

        for (Integer integer : myHashSet) {
            System.out.println("HashSet : value = " + integer);
        }

        for (Integer integer : myLinkedHashSet) {
            System.out.println("LinkedHashSet : value = " + integer);
        }

    }

    private static void createPurse(Map<Coin, Integer> myPurse) {
        myPurse.put(Coin.TEN_EURO_CENT, 3);
        myPurse.put(Coin.FIVE_EURO_CENT, 2);
        myPurse.put(Coin.TWENTY_EURO_CENT, 2);
        myPurse.put(Coin.ONE_EURO_CENT, 20);
        myPurse.put(Coin.FIFTY_EURO_CENT, 0);
    }

    private static void createSortedPurse(SortedMap<Coin, Integer> myPurse) {
        myPurse.put(Coin.TEN_EURO_CENT, 3);
        myPurse.put(Coin.FIVE_EURO_CENT, 2);
        myPurse.put(Coin.TWENTY_EURO_CENT, 2);
        myPurse.put(Coin.ONE_EURO_CENT, 20);
        myPurse.put(Coin.FIFTY_EURO_CENT, 0);
    }

    private static void oefeningPrimitives__1() {
        float myFloat = Integer.MAX_VALUE * 1.0F;
        System.out.format("Value float = %0,40.5f\n", myFloat);

        myFloat = Float.MAX_VALUE;
        System.out.format("Value float-max = %0,50.5f\n", myFloat);

        myFloat = 10/3F;
        System.out.format("Value float = %012.10f\n", myFloat);

        double myDouble = 10/3D;
        System.out.format("Value double = %012.10f\n", myDouble);

        // Dutch alphabet
        printRangeOfCharacters((short)97, (short)122);
        System.out.println();

        // Greek Capital Letter : https://en.wikipedia.org/wiki/List_of_Unicode_characters#Latin-1_Supplement
        // Go to Settings -> Editor -> File Encodings -> Project Encoding and set it to "UTF-8".

        printRangeOfCharacters((short) 913, (short) 937);
        System.out.println();
    }

    private static void printRangeOfCharacters(short fromShort, short toShort) {
        for (short s = fromShort; s <= toShort; s++) {
            char c = (char) s;
            System.out.print(c);
        }
    }

    private static void oefeningInheritance_0() {
        Object o = new Square(10, null);

        Square s = new Square(10, null);
        System.out.println("Minimum area = " + Square.MINIMUM_AREA);
        System.out.println("Aantal: " + s.getNumberOfAngles());
        s.setWidth(50);

        Rectangle r = new Rectangle();

        // generic method
        outputObjectWithPrefixAndSuffix(o);
        outputObjectWithPrefixAndSuffix(s);

        // specific method (accepts only squares)
        outputSquareWithPrefixAndSuffix(s);

        // specific method (accepts only squares)
//        outputSquareWithPrefixAndSuffix(r);

        Rectangle rectangle = new Rectangle(10, 5, null);

        // constructors worden niet overgeërfd
//        Square square = new Square(10, 5, null);

        System.out.println("Rectangle = " + rectangle + " Area = " + rectangle.getArea() + ", Perimeter = " + rectangle.getPerimeter());

        Rectangle rectangle2 = new Rectangle(10, 5, null);

        if (rectangle.equals(rectangle2)) {
            System.out.println("mijn vierkanten zijn gelijk");
        }
        else {
            System.out.println("mijn vierkanten zijn niet gelijk");
        }

        // example of builder pattern when instantiating Rectangle2
        Rectangle2 aDifferentRectangle = new Rectangle2()
                .withCoordinates(new int[2])
                .withHeight(50)
                .withWidth(100);

        // The constructor of a square has only ONE argument (side)
//        Square square = new Square(10, 5);
        Square square = new Square(25, null);

        square.getNumberOfAngles();

        System.out.println("Square = " + square + ". A square has " + Square.NUMBER_OF_ANGLES + " angles. Number of rectangles constructed = " + Rectangle.numberORectanglesConstructed);
        System.out.println("Square = " + square + ". A square has " + Square.getNumberOfAngles() + " angles. Number of rectangles constructed = " + Rectangle.numberORectanglesConstructed);

        // we make our square larger
//        square.setWidth(50);
        System.out.println("Square = " + square);

        // TODO : change impl of Square -> stackoverflow

        // we use change format
        square.setSide(50);

//        square.setHeight(10);
//        square.setWidth(10);

        System.out.println("Square = " + square);

        System.out.println("A square is always an instance of a rectangle? " + (square instanceof Rectangle));
        System.out.println("Is this rectangle an instance of a square?" + (rectangle instanceof Square));
    }

    private static void outputObjectWithPrefixAndSuffix(Object o) {
        System.out.println(">>>" + o + "<<<");
    }

    private static void outputSquareWithPrefixAndSuffix(Square s) {
        System.out.println(">>>" + s + "<<<");
    }

    private static void oefeningInheritance_1() {
        IDateHelper dateHelper1 = new DateHelper();

        EuropeanDateHelper europeanDateHelper = new EuropeanDateHelper();

        // another example of design by interface
        IDateHelper dateHelper2 = new EuropeanDateHelper();

        // this interface is an instance of particular Class
        if (dateHelper2 instanceof EuropeanDateHelper) {
            System.out.println("dateHelper2 is an instance of EuropeanDateHelper");
        } else {
            System.out.println("Houston we have a problem.");
        }

        // this interface is an instance of particular super Class
        if (dateHelper2 instanceof DateHelper) {
            System.out.println("dateHelper2 is an instance of DateHelper");
        } else {
            System.out.println("Houston we have a problem.");
        }

        EuropeanDateHelper dateHelper4 = new EuropeanDateHelper();

//        oefeningInheritanceHelper_1A(dateHelper1, europeanDateHelper, dateHelper2, dateHelper4);

        oefeningInheritanceHelperWithBirthDate_1B();
    }

    // IntelliJ geeft aan dat 4de argument niet wordt gebruikt
    private static void oefeningInheritanceHelper_1A(IDateHelper dateHelper1,
                                                    IDateHelper dateHelper2,
                                                    IDateHelper dateHelper3,
                                                    IDateHelper dateHelper4) {
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

    static private void oefeningInheritanceHelperWithBirthDate_1B() {
        // BE CAREFUL BECAUSE OF NOTATION !!!
        LocalDate localDate = LocalDate.of(1967, 11, 011);
        System.out.println("localDate = " + localDate);

        localDate = LocalDate.of(0x7AF, 0XB, 0xB);
        System.out.println("localDate = " + localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("localDateTime = " + zonedDateTime);
        System.out.println("localDateTime zone = " + zonedDateTime.getZone());

        System.out.println("localDate dayOfYear = " + localDate.getDayOfYear());
        System.out.println("localDate dayOfWeek = " + localDate.getDayOfWeek());
        System.out.println("localDate is leap year? = " + localDate.isLeapYear());
        System.out.println("2000 is leap year? = " + Year.isLeap(2000));
        System.out.println("localDate epoch = " + DateUtility.convertLocalDateToEpoch(localDate));

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            System.out.println(String.format("Dag van de week = %s, ordinal = %02d", dayOfWeek.name(), dayOfWeek.ordinal()));
//            Locale locale = new Locale("bg-BG");
//            System.out.println(String.format("Dag van de week = %s, ordinal = %02d", dayOfWeek.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ITALIAN), dayOfWeek.ordinal()));
//            System.out.println(String.format("Dag van de week = %s, ordinal = %02d", dayOfWeek.getDisplayName(TextStyle.FULL_STANDALONE, locale), dayOfWeek.ordinal()));
        }

        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 10, 20, 13, 33, 11);
        LocalDateTime localDateTime2 = LocalDateTime.of(2017, 12, 31, 23, 59, 59);
        Period period = Period.between(localDateTime1.toLocalDate(), localDateTime2.toLocalDate());

        // question asked - certificate
        System.out.println(String.format("Period %s (days), %s (months)", + period.getDays(), period.getMonths()));
        System.out.println("Period " + period);

        System.out.println("Periode (in days) " + ChronoUnit.DAYS.between(localDateTime1, localDateTime2));
        System.out.println("Periode (in minutes) " + ChronoUnit.MINUTES.between(localDateTime1, localDateTime2));
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
        DummyInterfaceImpl2 dummyInterfaceImpl2 = new DummyInterfaceImpl2();
        dummyInterfaceImpl2.move();

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
        // design by interface
        Pig pigAsAnInterface = new MyPig();
        pigAsAnInterface.grunt();
        pigAsAnInterface.fly();

        MyPig myPig = new MyPig();
        // our class MyPig has only one method!!!
        myPig.grunt();
        // MyPig get access to the default interface method as well !!!
        myPig.fly();
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

        int i = 5;
        double resultAsDouble = Math.pow(i, 4);

//        float  resultAsFloat1 = resultAsDouble;
        float  resultAsFloat2 = 0F;
        resultAsDouble = resultAsFloat2;

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

        System.out.println("name of employee in exercisePassByValue5_1 = " + employee.getFirstName());
    }

    private static void doSomething1(final Employee employee) {
        // ho ho ho ... altering input parameters should be avoided!!!
        employee.setFirstName("wim van den brande - bis");

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

    private void oefeningAbstractClass_6a() {
        // example of anonieme geneste klasse
        // we don't instantiate a worker but we instantiate an anonymous class !!!
        // useful since we can have CEOs and many more EmployeeTypes with each time a different setRemunerations()
        Worker ceo = new Worker("Elon Musk", 50, Worker.Gender.MALE, null) {
            // property is not available outside the inner class !!!
            public Date fireDateOfTheCeo;

            @Override
            public Float calculateTotalIncentiveCost() {
                if (fireDateOfTheCeo != null) {
                    // dosomething
                }
                else {
                    // dosomethingelse
                }
                return null;
            }

            @Override
            public void setRemunerations(Set<Remuneration> remunerations) {
                for (Remuneration remuneration : remunerations) {
                    if (remuneration instanceof Salary) {
                        System.err.println("A CEO cannot have a salary.");
                    }
                }
            }
        };

        // we can get access to the overridden method
        ceo.calculateTotalIncentiveCost();

        // we cannot get access to the added field (compiler error)
//        ceo.fireDateOfTheCeo;

        // or alternative 1
        Ceo ceo1 = new Ceo();
        ceo1.calculateTotalIncentiveCost();
        ceo1.setRemunerations(null);

        // or alternative 2
        class Ceo extends Worker {
            public Date fireDateOfTheCeo;

            public Ceo(String firstName, Integer age, Gender gender, Date hireDate, Date fireDateOfTheCeo) {
                super(firstName, age, gender, hireDate);
                this.fireDateOfTheCeo = fireDateOfTheCeo;
            }

            @Override
            public Float calculateTotalIncentiveCost() {
                return null;
            }

            @Override
            protected void setRemunerations(Set<Remuneration> remunerations) {
            }

            public Date getFireDateOfTheCeo() {
                return fireDateOfTheCeo;
            }
        }

        Ceo ceo2 = new Ceo("Elon Musk", 50, Worker.Gender.MALE, null, null);
        System.out.println("The fireDate of this CEO = " + ceo2.getFireDateOfTheCeo());

        // example 2
        Remuneration companyCar = new Remuneration(25000D) {
            @Override
            public double getCost() {
                return super.getCost();
            }

            @Override
            public void setCost(double cost) {
                super.setCost(cost);
            }
        };

        System.out.println("cost of a company-car = " + companyCar.getCost() + " €.");

        // example 3 - inner class in local method
        MobilePhone iPhone = new MobilePhone("private", "", 1000D) {
            public IPhoneType iPhoneType = IPhoneType.IPHONE_10;
        };

//      not available
//        System.out.println("My type of my Iphone = " + iPhone.);
    }

    private static void oefeningInnerClass_6b() {
//        CustomerDNAFile customerDNAFile = new CustomerDNAFile();

        // Preference is (normal) inner class
        // CustomerDnaSource is static inner class

//        CustomerDNAFile.Preference preference = customerDNAFile.new Preference(Date.from(Instant.now()));
//        // use breakpoint
//        preference = customerDNAFile.new Preference(Date.from(Instant.now()));

//        CustomerDNAFile.CustomerDnaSource attribute = customerDNAFile.new CustomerDnaSource();
//        CustomerDNAFile.CustomerDnaSource customerDnaSource = new CustomerDNAFile.CustomerDnaSource("Facebook", false);
        // use breakpoint
//        customerDnaSource = new CustomerDNAFile.CustomerDnaSource("Twitter", false);

        // example of Local inner classes
        CustomerDNAFile.exampleOfLocalInnerClassMethod();

        // example of a static inner class when using the builder design pattern

        Department department1 = new Department.DepartmentBuilder()
                .departmentAddress("example of an address")
                .departmentName("example of a department")
                .build();

        Department department2 = new Department.DepartmentBuilder()
                .departmentAddress("example of an address")
                .build();

        // example of a (normal) inner class : Addresses have been embedded within Employee

        Employee employee = new Employee(null, "wim van den brande", 49, null, null)
                .withHireDate(Date.from(Instant.now()))
                .withProjects(null)
                .withCountry(Country.BELGIUM)
                .withSocialSecurityNumber("671102-001.01");

        Employee.Address address1 = employee.new Address("street 1", "house no 1", "zip 1", "commune 1");
        Employee.Address address2 = employee.new Address("street 2", "house no 2", "2650", "Edegem");
        Employee.Address address3 = employee.new Address("street 2", "house no 2", "2650", "Edegem");

        Set<Employee.Address> addresses = new HashSet<>();
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);

        // use breakpoint
        // TODO : to ask how many entries my list will contain
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

    private static void oefeningWithAssert_7() {
        // assert facilitates the idea of validation / pre-condition
        // assert throws AssertionError (inherits from Error) !!!

        // assert ONLY works when running when passing JAVA the -ea (enable assert) option
//        assert employee.getFirstName().length() > 0;

        Employee employee = new Employee(null, "wim van den brande", 49, null, null);

        try {
            assert employee.getHireDate() != null : "Oepsie... hireDate is null";
            assert employee.getMiddleName() != null && employee.getMiddleName().length() > 0 : "Oepsie... middleName is unknown";
        }
//        catch (Exception e) {
        catch (Throwable e) {
            System.out.println("Foutje ....");
        }

        // alternative is an IllegalArgumentException
        // be aware of the
        // InvalidArgumentException !!!
    }

    private static void oefeningParseStringWithBrackets_8A_V1() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a string with a combination of []{}()");
        String stringToParse = reader.nextLine();

        char[] chars = stringToParse.toCharArray();
        char[] charsToBeClosed = new char[20];

        int indexOfCharsToBeClosed = -1;
        boolean validString = true;

        for (char c: chars) {
            // if opening char, we add it to array of chars to be closed
            if (c == '{' || c == '(' || c == '[') {
                indexOfCharsToBeClosed += 1;
                charsToBeClosed[indexOfCharsToBeClosed] = c;
            }
            else {
                // if closing char and closing char matches an opening char
                // we remove it from the array
                if ((c == '}' && indexOfCharsToBeClosed >= 0 && charsToBeClosed[indexOfCharsToBeClosed] == '{') ||
                    (c == ')' && indexOfCharsToBeClosed >= 0 && charsToBeClosed[indexOfCharsToBeClosed] == '(') ||
                    (c == ']' && indexOfCharsToBeClosed >= 0 &&  charsToBeClosed[indexOfCharsToBeClosed] == '[') )  {
                    if (indexOfCharsToBeClosed >= 0) {
                        charsToBeClosed[indexOfCharsToBeClosed--] = '\u0000';
                    }
                }
                else {
                    // closing tag does not match so we have an error
                    validString = false;
                }
            }
        }

        // if charsToBeClosed contains the initial value, everything went fine
        if (charsToBeClosed[0] != '\u0000' || !validString) {
            System.err.println("invalid string");
        }
        else {
            System.out.println("valid string");
        }

    }

    private static void oefeningParseStringWithBracketsAndUsingAList_8A_V2() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a string with a combination of []{}()");
        String stringToParse = reader.nextLine();

        char[] chars = stringToParse.toCharArray();
        List<Character> charactersToBeClosed = new ArrayList<>();

        boolean validString = true;

        for (char c: chars) {
            // if opening char, we add it to array of chars to be closed
            if (c == '{' || c == '(' || c == '[') {
                charactersToBeClosed.add(c);
            }
            else {
                // if closing char and closing char matches an opening char
                // we remove it from the array
                if ((c == '}' && charactersToBeClosed.size() > 0 && charactersToBeClosed.get(charactersToBeClosed.size() -1) == '{') ||
                        (c == ')' && charactersToBeClosed.size() > 0 && charactersToBeClosed.get(charactersToBeClosed.size() -1) == '(') ||
                        (c == ']' && charactersToBeClosed.size() > 0 && charactersToBeClosed.get(charactersToBeClosed.size() -1) == '[') )  {
                    // closing tag matches, let's remove it from the list
                    if (charactersToBeClosed.size() > 0) {
                        charactersToBeClosed.remove(charactersToBeClosed.size() - 1);
                    }
                }
                else {
                    // closing tag does not match so we have an error
                    validString = false;
                }
            }
        }

        // if charsToBeClosed contains the initial value, everything went fine
        if (charactersToBeClosed.size() > 0 || !validString) {
            System.err.println("invalid string");
        }
        else {
            System.out.println("valid string");
        }

    }

    private static void oefeningPrintPiramide_8B() {
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
        MonthEnumeration[] months = MonthEnumeration.values();
        for (MonthEnumeration month : months) {
            System.out.println("month " + month + " has an index of " + month.getIndex() + ". The ordinal value = " + month.ordinal() + ", numDays = " + month.getDaysInMonth());
            for (String monthAsString : month.getMonthLanguages()) {
                System.out.println("month " + month + " is written as " + monthAsString);
            }
        }

        for (MonthEnumeration monthEnumeration : MonthEnumeration.values()) {
            System.out.println("month " + monthEnumeration + " has an index of " + monthEnumeration.getIndex() + ". The ordinal value = " + monthEnumeration.ordinal() + ", numDays = " + monthEnumeration.getDaysInMonth());
            for (String monthAsString : monthEnumeration.getMonthLanguages()) {
                System.out.println("month " + monthEnumeration + " is written as " + monthAsString);
            }
        }
    }

    private static void oefeningException_10() throws MyCustomizedException {
        Remuneration[] remunerations1 = {new MealVoucher("dag", 6), new Salary(1000.00)};
        Remuneration[] remunerations2 = {};

        Employee.calculateTotalIncentiveCost(remunerations1);
        Employee.calculateTotalIncentiveCost(remunerations2);

        Customer customer = new Customer();
        customer.setFirstName(null);
    }

    private static void oefeningString_11A() {
        long timeStart = System.currentTimeMillis();
        String initString = new String("this is a test");
        for (Integer i=0; i<=10_000_000; i++) {
            if (i%1000 == 0) {
                System.out.println("(string) INDEX HAS BECOME " + i);
            }
//            initString = initString.concat(i.toString());
            initString = initString + i.toString();
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void oefeningStringBuilder_11B() {
        long timeStart = System.currentTimeMillis();
        StringBuilder initString = new StringBuilder("dit is een 2de test");
        for (Integer i=0; i<=10_000_000; i++) {
            if (i%1000 == 0) {
                System.out.println("(stringbuilder) INDEX HAS BECOME " + i);
            }
            StringBuilder dummy = initString.append(i.toString());
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void oefeningLargeList_11C() {
        long timeStart = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        for (Integer i=1_000_001; i<=2_000_000; i++) {
            if (i%1000 == 0) {
//                System.out.println("INDEX HAS BECOME " + i);
            }
            integers.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void oefeningLargeListWithCapacity_11D() {
        long timeStart = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>(1_000_000);
        for (Integer i=1; i<=1_000_000; i++) {
            if (i%1000 == 0) {
                System.out.println("INDEX HAS BECOME " + i);
            }
            integers.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void piramideImpl_8(int piramideMaxValue, int i) {
        // take care of printing spaces (if any)
        for (int j=1; j <= piramideMaxValue -i; j++ ) {
            System.out.print((piramideMaxValue > 9) ? EMPTY_STRING_2_SPACES : EMPTY_STRING_1_SPACE);
        }

        // take care of printing actual digit
        for (int j=1; j <= i; j++ ) {
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
        LocalDate myBirthDate = LocalDate.of(1967, 11, 02);
        employee1.setBirthDate(Date.from(myBirthDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        System.out.println("Total cost of employee1 " + employee1.calculateTotalIncentiveCost());
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

    private static Set<Remuneration> getCorrectNumberOfRemunerationsForEmployee(float salary) {
        Remuneration[] remunerations = new Remuneration[2];
        remunerations[0] = new MealVoucher("dagelijkse maaltijdcheque", 7.00);
        remunerations[1] = new Salary(salary);

        return new HashSet<>(Arrays.asList(remunerations));
    }

    private static Set<Remuneration> getInCorrectNumberOfRemunerationsForEmployee(float salary) {
        Remuneration[] remunerations = new Remuneration[3];
        remunerations[0] = getCorrectNumberOfRemunerationsForEmployee(salary).stream().findFirst().get();
        // TODO : second
        remunerations[1] = getCorrectNumberOfRemunerationsForEmployee(salary).stream().findFirst().get();
        remunerations[2] = new MobilePhone("I-phone", "0485717182", 1000.00);
        return new HashSet<>(Arrays.asList(remunerations));
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

    private static boolean isEligibleForHRSystem(Set<Remuneration> remunerations, int maxNumberOfRemunerationsAllowed) {
        return remunerations != null && remunerations.size() <= maxNumberOfRemunerationsAllowed;
    }

    public class Ceo extends Worker {

        @Override
        public Float calculateTotalIncentiveCost() {
            return null;
        }

        @Override
        protected void setRemunerations(Set<Remuneration> remunerations) {

        }
    }
}
