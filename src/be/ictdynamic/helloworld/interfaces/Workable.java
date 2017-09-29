package be.ictdynamic.helloworld.interfaces;

import be.ictdynamic.helloworld.domain.Worker;

import java.util.Map;

/**
 * Created by admin on 27/09/2017.
 */
public interface Workable {
    Map<String, Object> getRemunerations();

    // modifier abstract is redundant for interface methods
    abstract Object calculateSalary(Object... objects);

    void dummyMethod();

    default int getNumberOfYearsToWork(Worker worker) {
        return 67 - worker.getAge();
    }
}
