package be.ictdynamic.helloworld.oefening_interfaces_2;

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

    // example of consequences when an interface is being modified
//    void move2();

    default void move(){
        System.out.println("I am moving");
    }

}
