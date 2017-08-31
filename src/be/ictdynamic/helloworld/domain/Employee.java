package be.ictdynamic.helloworld.domain;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Employee extends Worker {
    public Employee(String name, Integer age) {
        super(name, age);
    }

    public Employee() {
    }

    //    @Override
    public static void testClassMethod() {
        System.out.println("The static method in Employee");
    }

    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Employee");
    }

}
