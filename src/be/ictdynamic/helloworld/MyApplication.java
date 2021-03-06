package be.ictdynamic.helloworld;

import be.ictdynamic.helloworld.cursus_domain.*;
import be.ictdynamic.helloworld.domain.*;
import be.ictdynamic.helloworld.enums.Coin;
import be.ictdynamic.helloworld.enums.Country;
import be.ictdynamic.helloworld.enums.IPhoneType;
import be.ictdynamic.helloworld.enums.MonthEnumeration;
import be.ictdynamic.helloworld.exception.MyCustomizedException;
import be.ictdynamic.helloworld.oca.Programmer;
import be.ictdynamic.helloworld.oca.SubClass;
import be.ictdynamic.helloworld.oca.Writer;
import be.ictdynamic.helloworld.oefening_inner_class_6.CustomerDNAFile;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterface;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl1;
import be.ictdynamic.helloworld.oefening_interfaces_2.DummyInterfaceImpl2;
import be.ictdynamic.helloworld.utilities.BmiUtility;
import be.ictdynamic.helloworld.utilities.DateUtility;
import be.ictdynamic.helloworld.utilities.KeyboardUtility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class MyApplication {

    public final static String EMPTY_STRING_2_SPACES = "  ";
    public static final String EMPTY_STRING_1_SPACE = " ";

    // no getter and setter : hence this is a field
    private String Dummy;

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
//            } catch (InputMismatchException | NumberFormatException | IOException e) {
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Invalid value. Try again. Exception message = " + e.getMessage());
                return;
            } finally {
                System.out.println("Executing the finally block");
                numberOfTimesInputGiven++;
            }
        }

        switch (oefeningInteger) {
            case -1:
//                MyApplication.oefeningPrimitives__1();
                MyApplication.oefeningInheritanceHelperWithBirthDate_1B();
                break;
            case 0:
                MyApplication.oefeningInheritance_0();
//                MyApplication.oefeningInheritanceHelper_0A();
//                MyApplication.oefeningInheritanceHelperWithSquareAndRectangle_0B();
                break;
            case 2:
//                MyApplication.oefeningInterfaces_2A();
//                MyApplication.oefeningInterfaces_2B();
                MyApplication.oefeningInterfaces_2C();
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
//                myApplication.oefeningAbstractClass_OCA_A_6();
//                myApplication.oefeningAbstractClass_OCA_B_6();
                myApplication.oefeningConstructor_OCA_6();
//                MyApplication.oefeningInnerClass_6b();
                break;
            case 7:
//                MyApplication.oefeningWithAssert_7();
                MyApplication.oefeningWithVarArgList1_7();
                break;
            case 8:
//                MyApplication.oefeningPrintPiramide_8B();
//                MyApplication.oefeningParseStringWithBrackets_8A_V1();
                MyApplication.oefeningParseStringWithBracketsAndUsingAList_8A_V2();
                break;
            case 9:
//                MyApplication.oefeningEnum_9();
                MyApplication.oefeningInitializationBlock_9();
                break;
            case 999:
                MyApplication.oefeningPeriodDuration();
                break;
            case 10:
                MyApplication.oefeningException_10();
                break;
            case 11:
//                MyApplication.oefeningString_11A();
//                MyApplication.oefeningStringBuilder_11B();
                MyApplication.oefeningStringBuilder_11_OCA();
//                MyApplication.oefeningLargeListWithCapacity_11D();
//                MyApplication.oefeningLargeList_11C();
                break;
            case 12:
//                MyApplication.oefeningDate_12();
//                MyApplication.oefeningDate_instantVsDate_12();
//                MyApplication.oefeningDate_preJava8_12();
                MyApplication.oefeningDate_TimeZone_12();
                break;
            case 13:
                MyApplication.oefeningMap_13A();
//                MyApplication.oefeningMap_13B();
                break;
            case 14:
                MyApplication.oefeningList_14();
                break;
            case 15:
                MyApplication.oefeningHashSetAndLinkedHashSet_15();
                break;
            case 16:
                MyApplication.feedingSchedule_16_A();
//                MyApplication.feedingSchedule_16_B();
                break;
            case 18:
                oefeningBmiUtility_18();
                break;
            case 99:
                MyApplication.myCompany_99();
                break;
            default:
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

    private static void oefeningDate_instantVsDate_12() {
        Date now = new Date();
        Instant myInstant = now.toInstant();
        now = Date.from(myInstant);
    }

    private static void oefeningDate_preJava8_12() {
        Date myDeprecatedDate = new Date(118, 4, 31, 13, 20, 0);
        System.out.println("My date value = " + myDeprecatedDate);

        Instant myInstantBeforeTheEpoch = Instant.parse("1967-11-02T00:00:00.00Z");
        System.out.println("My date value = " + myInstantBeforeTheEpoch.toEpochMilli());

        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String string1 = "2001-07-04T12:08:56.235-0700";
        try {
            Date result1 = df1.parse(string1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void oefeningDate_TimeZone_12() {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime nowInLondon = ZonedDateTime.of(now, ZoneId.of("Europe/London"));
        ZonedDateTime nowInBrussels = ZonedDateTime.of(now, ZoneId.of("Europe/Brussels"));
        System.out.println("nowInLondon = " + nowInLondon);
        System.out.println("nowInBrussels = " + nowInBrussels);
        System.out.println("equals = " + nowInLondon.toLocalDateTime().equals(nowInBrussels.toLocalDateTime()));
    }

    private static void oefeningMap_13A() {
        Map<Coin, Integer> myPurse1 = new HashMap<>();
        Map<Coin, Integer> myPurse2 = new LinkedHashMap<>();

        createPurse(myPurse1);
        System.out.println("Usage of HashMap");
        myPurse1.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));

        createPurse(myPurse2);
        System.out.println("Usage of LinkedHashMap");
        myPurse2.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));

        SortedMap<String, Integer> myPurse3 = new TreeMap<>();
        createSortedPurse(myPurse3);
        System.out.println("Usage of TreeMap");
        myPurse3.forEach((coin, numberOf) -> System.out.println("coin : " + coin + " #: " + numberOf));
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
        employees.add(0, employee1);
        employees.add(2, employee2);

        employees.add(employee1);
        employees.add(employee2);

        System.out.println("size = " + employees.size());

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void oefeningHashSetAndLinkedHashSet_15() {
        List<Integer> integers0 = new ArrayList<>();
        integers0 = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);

        Set<Integer> myHashSet = new HashSet<Integer>(integers0);

        Set<Integer> myLinkedHashSet = new LinkedHashSet<Integer>(integers0);

        for (Integer integer : myHashSet) {
            System.out.println("HashSet : value = " + integer);
        }

        for (Integer integer : myLinkedHashSet) {
            System.out.println("LinkedHashSet : value = " + integer);
        }

    }

    private static void feedingSchedule_16_A() {
        String myString = "helloWorld";
        switch (myString) {
            default:
            case "value1":
                System.out.println("Value1");
                break;
            case "value2":
                System.out.println("Value2");
                break;
        }
    }

    private static void feedingSchedule_16_B() {
        boolean keepGoing = true;
        int count = 0;
        int x = 3;
        while (count++ < 3) {
            int y = (1 + 2 * count) % 3;
            switch (y) {
                default:
                case 0:
                    x -= 1;
                    break;
                case 1:
                    x += 5;
            }
        }
        System.out.println(x);
    }

    private static void createPurse(Map<Coin, Integer> myPurse) {
        myPurse.put(Coin.TEN_EURO_CENT, 3);
        myPurse.put(Coin.FIVE_EURO_CENT, 2);
        myPurse.put(Coin.TWENTY_EURO_CENT, 2);
        myPurse.put(Coin.ONE_EURO_CENT, 20);
        myPurse.put(Coin.FIFTY_EURO_CENT, 0);
    }

    private static void createSortedPurse(SortedMap<String, Integer> myPurse) {
        myPurse.put("TEN_EURO_CENT", 3);
        myPurse.put("FIVE_EURO_CENT", 2);
        myPurse.put("TWENTY_EURO_CENT", 2);
        myPurse.put("ONE_EURO_CENT", 20);
        myPurse.put("FIFTY_EURO_CENT", 0);
    }

    private static void oefeningPrimitives__1() {
        float myFloat = Integer.MAX_VALUE * 1.0F;
        System.out.format("Value float = %0,40.5f\n", myFloat);

        myFloat = Float.MAX_VALUE;
        System.out.format("Value float-max = %0,50.5f\n", myFloat);

        myFloat = 10 / 3F;
        System.out.format("Value float = %012.10f\n", myFloat);

        double myDouble = 10 / 3D;
        System.out.format("Value double = %030.28f\n", myDouble);

        BigDecimal myBigDecimal1 = new BigDecimal("123");
        BigDecimal myBigDecimal2 = new BigDecimal("123");
//        myBigDecimal1 / myBigDecimal2;

        BigDecimal myBigDecimal = new BigDecimal(10).divide(new BigDecimal(3), 50, RoundingMode.DOWN);
        System.out.format("Value myBigDecimal = %050.48f\n", myBigDecimal);

        // Dutch alphabet
        printRangeOfCharacters((short) 97, (short) 122);
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

        Square mySquare = new Square(10, null);
        Rectangle myRectangle = new Square(10, null);

        mySquare.setWidth(50);
        Rectangle rectangle = new Rectangle(10, 5, null);

        System.out.println("Minimum area of mySquare = " + mySquare.MINIMUM_AREA);
        System.out.println("Minimum area of myRectangle = " + myRectangle.MINIMUM_AREA);

        // an example of an inherited static method and an inherited static static property
        System.out.println("Number of rectangles: " + Square.getNumberOfAngles());
        System.out.println("Number of rectangles: " + Square.NUMBER_OF_ANGLES);

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

        Drawable2 drawable2 = new Rectangle2();

        // example of builder pattern when instantiating Rectangle2 (with UP CAST)
        Square aDifferentRectangle = new Rectangle2()
                .withCoordinates(new int[2])
                .withHeight(50)
                .withWidth(100);

        aDifferentRectangle.getWidth();

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

//        Worker worker = new Employee();
        Worker worker;

        Manager  manager = new Manager("my manager", 50, Worker.Gender.MALE, null);
        worker = manager;

        if (worker instanceof  Employee) {
            Employee employee = (Employee) worker;
        }
    }

    private static void oefeningInheritanceHelper_0A() {
        Employee employee = new Employee(null, "wim van den brande", 15, null, null);

        // every employee is a worker (upcasting doesn't require an explicit cast)
        Worker worker = employee;

        doSomethingWithWorker(worker);

        // we cannot make a worker an employee (downcasting requires an explicit cast)
//        employee = worker;

        // but we can cast to an Employee
        Employee workerCastedToEmployee = (Employee) worker;

        System.out.println("An employee is eligible for remuneration? : " + Employee.isEligibleForRemuneration);
    }

    private static void oefeningInheritanceHelperWithSquareAndRectangle_0B() {
        Rectangle rectangle = new Square();
        rectangle.setWidth(100);
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
        System.out.println(String.format("Period %s (days), %s (months)", +period.getDays(), period.getMonths()));
        System.out.println("Period " + period);

        System.out.println("Periode (in days) " + ChronoUnit.DAYS.between(localDateTime1, localDateTime2));
        System.out.println("Periode (in minutes) " + ChronoUnit.MINUTES.between(localDateTime1, localDateTime2));
    }

    private static void doSomethingWithWorker(Worker worker) {
        Employee employee = new Employee();
        Worker w = employee;
        Object o = employee;

        if (worker instanceof Employee) {
            System.out.println("we've got an Employee");
        }
        else if (worker instanceof Manager) {
            System.out.println("we've got a Manager");
        }
        else if (worker instanceof Director) {
            System.out.println("we've got a Director");
        }
        else {
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
        }
        else {
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

        myPig.dy();
    }

    public static void oefeningInterfaces_2C() {
        Son son = new Son();
        Rectangle rectangle = new Rectangle();
        son.canMakeNiceDinners();
        son.enjoysPlayingTennis();
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
        for (byte b = 1; b <= 3; b++) {
            System.out.println("Signed left shift: value has become: " + (val3 << b));
        }

        // prints ???
        for (byte b = 1; b <= 5; b++) {
            System.out.println("Signed right shift: value has become: " + (val3 >> b));
        }

        // exercise playDays
        int[] playDays = {20, 31, 3};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] playDaysx = {1, 2, 4, 8, 16, 32, 64};

        for (int playDay : playDays) {

            int index = 0;
            for (String day : days) {
                System.out.println("Player with playDay " + playDay + ", day " + day + ": " + ((playDay & playDaysx[index]) > 0 ? "plays" : "does not play"));
                index += 1;
            }
        }

        // exercise op conditional operator
        int[] years = {2016, 2017, 2100, 2000};

        int i = 5;
        double resultAsDouble = Math.pow(i, 4);

//        float  resultAsFloat1 = resultAsDouble;
        float resultAsFloat2 = 0F;
        resultAsDouble = resultAsFloat2;

        for (int year : years) {
            System.out.println("year " + year + " is a leap year? " + (isLeapYear(year) ? "This is correct" : "This is not correct"));
        }

    }

    static private void oefeningEquals_4B() {
        String canonicalString1 = "wim van den brande";
        String canonicalString2 = "wim van den brande";

        // works for string - doesn't work for stringbuilder
        // StringBuilder stringBuilder = "";

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
        if (string1.equals(string2)) {
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

        System.out.println("inital name of employee in exercisePassByValue5_1 = " + employee.getFirstName());

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
        int i = 0;
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

        for (int i = 0; i < myOutputIntegers.length; i++) {
            myOutputIntegers[i] = myInputIntegers[i] / 10;
        }
    }

    private void oefeningAbstractClass_6a() {
        // example of anonieme geneste klasse
        // we don't instantiate a worker but we instantiate an anonymous class !!!
        // useful since we can have CEOs and many more EmployeeTypes with each time a different setRemunerations()
        Worker ceo = new Worker("Elon Musk", 50, Worker.Gender.MALE, null) {
            public boolean isAllowedToBeFired() {
                return false;
            }

            @Override
            public Float calculateTotalIncentiveCost() {
                return 10000F;
            }

            @Override
            protected void setRemunerations(Set<Remuneration> remunerations) {

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

    private static void oefeningAbstractClass_OCA_A_6() {
        abstract class Writer {
            public void write() {
                System.out.println("writing");
            }
        }
        class Author extends Writer {
            public void write() {
                System.out.println("writing book");
            }
        }
        class Programmer extends Writer {
            public void write() {
                System.out.println("writing code");
            }
        }
        Writer w = new Programmer();
        w.write();
    }

    private static void oefeningAbstractClass_OCA_B_6() {
        Writer w = new Programmer();
        w.write();
    }

    private static void oefeningConstructor_OCA_6() {
        SubClass subClass = new SubClass();
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

        Department department1 = new Department.DepartmentBuilder().departmentAddress("example of an address").departmentName("example of a department").build();

        Department department2 = new Department.DepartmentBuilder().departmentAddress("example of an address").build();

        // example of a (normal) inner class : Addresses have been embedded within Employee

        Employee employee = new Employee(null, "wim van den brande", 49, null, null).withHireDate(Date.from(Instant.now())).withProjects(null).withCountry(Country.BELGIUM).withSocialSecurityNumber("671102-001.01");

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

        Employee.Address address1 = new Employee().new Address();
        Employee.Address address2A = employee.new Address();
        Employee.Address address2B = employee.new Address();
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

        System.out.println("oefening 7 completed");

        // alternative is an IllegalArgumentException
        // be aware of the
        // InvalidArgumentException !!!
    }

    private static void oefeningWithVarArgList1_7() {
//        howMany_7();
        howMany_7(true);
        howMany_7(true, true);
        howMany_7(true, true, true);
//        howMany_7(true, {true});

//        howMany_7(true, {true, true});
        boolean[] booleans = {true, true};
        howMany_7(true, booleans);

        howMany_7(true, new boolean[2]);
    }

    private static int howMany_7(boolean b1, boolean... booleans) {
        return booleans.length;
    }

    private static void oefeningParseStringWithBrackets_8A_V1() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a string with a combination of []{}()");
        String stringToParse = reader.nextLine();

        char[] chars = stringToParse.toCharArray();
        char[] charsToBeClosed = new char[20];

        int indexOfCharsToBeClosed = -1;
        boolean validString = true;

        for (char c : chars) {
            // if opening char, we add it to array of chars to be closed
            if (c == '{' || c == '(' || c == '[') {
                indexOfCharsToBeClosed += 1;
                charsToBeClosed[indexOfCharsToBeClosed] = c;
            }
            else {
                // if closing char and closing char matches an opening char
                // we remove it from the array
                if ((c == '}' && indexOfCharsToBeClosed >= 0 && charsToBeClosed[indexOfCharsToBeClosed] == '{') || (c == ')' && indexOfCharsToBeClosed >= 0 && charsToBeClosed[indexOfCharsToBeClosed] == '(') || (c == ']' && indexOfCharsToBeClosed >= 0 && charsToBeClosed[indexOfCharsToBeClosed] == '[')) {
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

        for (char c : chars) {
            // if opening char, we add it to array of chars to be closed
            if (c == '{' || c == '(' || c == '[') {
                charactersToBeClosed.add(c);
            }
            else {
                // if closing char and closing char matches an opening char
                // we remove it from the array
                if ((c == '}' && charactersToBeClosed.size() > 0 && charactersToBeClosed.get(charactersToBeClosed.size() - 1) == '{') || (c == ')' && charactersToBeClosed.size() > 0 && charactersToBeClosed.get(charactersToBeClosed.size() - 1) == '(') || (c == ']' && charactersToBeClosed.size() > 0 && charactersToBeClosed.get(charactersToBeClosed.size() - 1) == '[')) {
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

        for (int i = 1; i <= piramideMaxValue; i++) {
            piramideImpl_8(piramideMaxValue, i);

        }

        System.out.println("\nCreating a company with too much overhead.\n");

        for (int i = piramideMaxValue; i >= 1; i--) {
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

    public static void oefeningInitializationBlock_9() {
        TestClassWithInitializationBlock testClassWithInitializationBlock = new TestClassWithInitializationBlock();
        System.out.println(TestClassWithInitializationBlock.i);
        System.out.println(TestClassWithInitializationBlock.i);
    }

    private static void oefeningPeriodDuration() {
        Duration duration1 = Duration.between(Instant.now(), Instant.now().plusSeconds(3610));
        System.out.println("duration1 = " + duration1);

        Duration duration2 = Duration.between(Instant.now(), Instant.now().plusSeconds(3600 * 24 + 3600));
        System.out.println("duration2 = " + duration2);

        Period period = Period.between(LocalDate.now(), LocalDate.of(2019, 1, 10));
        System.out.println("period = " + period);

        Duration duration3 = Duration.parse("PT72H10S");
        System.out.println("duration3 = " + duration3.get(ChronoUnit.SECONDS));

        Period period1 = Period.parse("P4D");

        System.out.println("nu = " + ZonedDateTime.now());
    }

    private static void oefeningException_10() throws MyCustomizedException {
        Remuneration[] remunerations1 = {new MealVoucher("dag", 6), new Salary(1000.00)};
        Remuneration[] remunerations2 = {};

        Employee.calculateTotalIncentiveCost(remunerations1);
        Employee.calculateTotalIncentiveCost(remunerations2);
    }

    private static void oefeningString_11A() {
        long timeStart = System.currentTimeMillis();
        String initString = new String("this is a test");
        for (Integer i = 0; i <= 10_000_000; i++) {
            if (i % 1000 == 0) {
                System.out.println("(string) INDEX HAS BECOME " + i);
            }
//            initString = initString.concat(i.toString());
            initString = initString + i.toString();
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void oefeningStringBuilder_11_OCA() {
        String s1 = "Java";
        String s2 = "Java";
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(sb1.toString() == s1);
        System.out.println(sb1.toString().equals(s1));
    }

        private static void oefeningStringBuilder_11B() {
        long timeStart = System.currentTimeMillis();
        StringBuilder initString = new StringBuilder("dit is een 2de test");
        for (Integer i = 0; i <= 10_000_000; i++) {
            if (i % 1000 == 0) {
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
        for (Integer i = 1_000_001; i <= 2_000_000; i++) {
            if (i % 1000 == 0) {
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
        for (Integer i = 1; i <= 1_000_000; i++) {
            if (i % 1000 == 0) {
                System.out.println("INDEX HAS BECOME " + i);
            }
            integers.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("method took " + (timeEnd - timeStart) + " milliseconds");
    }

    private static void piramideImpl_8(int piramideMaxValue, int i) {
        // take care of printing spaces (if any)
        for (int j = 1; j <= piramideMaxValue - i; j++) {
            System.out.print((piramideMaxValue > 9) ? EMPTY_STRING_2_SPACES : EMPTY_STRING_1_SPACE);
        }

        // take care of printing actual digit
        for (int j = 1; j <= i; j++) {
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

            for (int j = i + 1; j < arrayOfWorkers.length && arrayOfWorkers[j] != null; j++) {
                if (arrayOfWorkers[i].getFirstName().equals(arrayOfWorkers[j].getFirstName()) && arrayOfWorkers[i].getMiddleName().equals(arrayOfWorkers[j].getMiddleName()) && arrayOfWorkers[i].getLastName().equals(arrayOfWorkers[j].getLastName())) {
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
        for (Worker worker : workers) {
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
            }
            else if (worker instanceof Manager) {
                Manager manager = (Manager) worker;
            }
            else {
                if (worker != null) {
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
