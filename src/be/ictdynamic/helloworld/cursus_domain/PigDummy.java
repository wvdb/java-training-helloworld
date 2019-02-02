package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 30/09/2017.
 */
public interface PigDummy {
    default void dummyMethod() {
        System.out.println("Pig -> dummyMethod");
    }
}
