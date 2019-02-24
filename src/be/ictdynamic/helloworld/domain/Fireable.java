package be.ictdynamic.helloworld.domain;

public interface Fireable {
    default void revokeAccess() {
    }
    default void terminateAssurances() {
    }
}
