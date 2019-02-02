package be.ictdynamic.helloworld.cursus_domain;

/**
 * Created by admin on 30/09/2017.
 */
public interface PigWithExtraMethod {
    default void bye() {
        System.out.println("Our pig has been sold");
    }
}
