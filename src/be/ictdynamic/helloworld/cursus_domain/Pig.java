package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 30/09/2017.
 */
public interface Pig {
    void grunt();

    default void fly() {
        System.out.println("Our pig is flying");
    }

    default void dy() {
        System.out.println("Psssssssssssssssss...");
    }

    default void dummyMethod() {
        System.out.println("Pig -> dummyMethod");
    }
}
