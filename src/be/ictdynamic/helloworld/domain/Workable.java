package be.ictdynamic.helloworld.domain;

/**
 * Created by admin on 27/09/2017.
 */
public interface Workable {
    String getFullName(String firstName, String middleName, String lastName);

    // modifier abstract is redundant for interface methods
    abstract Float calculateTotalIncentiveCost();
}
