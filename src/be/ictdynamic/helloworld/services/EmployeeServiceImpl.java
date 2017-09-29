package be.ictdynamic.helloworld.services;

import be.ictdynamic.helloworld.domain.Employee;
import be.ictdynamic.helloworld.domain.Manager;
import be.ictdynamic.helloworld.domain.Worker;

import java.util.Date;

/**
 * Created by admin on 29/09/2017.
 */
public class EmployeeServiceImpl implements EmployeeService {
    // hier zouden we bvb typisch een JSON of XML request als parameter hebben
    @Override
    public Employee createEmployee(Manager manager, String name, Integer age, Worker.Gender gender, Date hireDate) {
        if (this.employeeIsValid()) {
           Employee employee = new Employee();
        }
        return null;
    }

    @Override
    public boolean employeeIsValid() {
//        this.manager = manager;
//        numberOfEmployees+= 1;
//        if (Worker.Gender.FEMALE == gender) {
//            numberOfFemaleEmployees += 1;
//        }
//        if (numberOfEmployees > 5 && (numberOfFemaleEmployees < numberOfEmployees / 2) && Worker.Gender.MALE == gender) {
//            System.err.println("We are getting too many male employees. Employee " + this + " should be rejected.");
//            this.validEmployee = false;
//        }
        return false;
    }

}
