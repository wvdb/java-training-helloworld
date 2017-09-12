package be.ictdynamic.helloworld.oefening_interfaces_2;

import java.util.Date;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public interface DummyInterface extends DummyInterface1, DummyInterface2, DummyInterface3 {
    interface InnerInterface1 {
        static void dummyMethod1(String dummyArg) {
            System.out.println(dummyArg);
        }
    }

    interface InnerInterface2 {
        static void printToUpperCase(String dummyArg) {
            System.out.println(dummyArg == null ? "onbekend" : dummyArg.toUpperCase());
        }
    }

    default void move(){
        System.out.println("I am moving");
    }

    static Date getCurrentDate() {
        return new Date();
    }
}
