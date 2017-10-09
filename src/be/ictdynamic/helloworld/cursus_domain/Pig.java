package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 30/09/2017.
 */
public interface Pig {
    void grunt();

    default void fly() {
        System.out.println("Our pig is flying");
    }
}
