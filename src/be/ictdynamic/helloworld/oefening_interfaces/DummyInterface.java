package be.ictdynamic.helloworld.oefening_interfaces;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public interface DummyInterface {
    interface DummyInterface1 {
        static void dummyMethod1(String dummyArg) {
            System.out.println(dummyArg);
        }
    }

    interface DummyInterface2 {
        static void printToUpperCase(String dummyArg) {
            System.out.println(dummyArg == null ? "onbekend" : dummyArg.toUpperCase());
        }
    }
}
