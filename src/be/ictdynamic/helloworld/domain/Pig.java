package be.ictdynamic.helloworld.domain;

/**
 * Created by admin on 30/09/2017.
 */
public interface Pig {
    void grunt();
    public default void fly() {
        System.out.println("Our pig is flying");
    }
}