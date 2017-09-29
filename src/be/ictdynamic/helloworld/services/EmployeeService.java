package be.ictdynamic.helloworld.services;

import be.ictdynamic.helloworld.domain.Employee;
import be.ictdynamic.helloworld.domain.Manager;
import be.ictdynamic.helloworld.domain.Worker;

import java.util.Date;

/**
 * Created by admin on 29/09/2017.
 */
public interface EmployeeService extends WorkerService {
    Employee createEmployee(Manager manager, String name, Integer age, Worker.Gender gender, Date hireDate);
    boolean employeeIsValid();
}
