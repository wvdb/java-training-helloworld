package be.ictdynamic.helloworld.oefening_function_10;

import be.ictdynamic.helloworld.domain.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class ExampleOfAFunction {
    public void gettingNameOfTheEmployeeVeryFancy() {
        Function<Employee, String> getNameOfEmployeeFunction = Employee::getFirstName;

        List<Employee> employees = getEmployees();

        List<String> empNameList = this.convertEmpListToNamesList1(employees, getNameOfEmployeeFunction);

        empNameList.forEach(System.out::println);
    }

    public void gettingNameOfTheEmployeeRegular() {
        List<Employee> employees = getEmployees();

        List<String> empNameList = this.convertEmpListToNamesList2(employees);

        empNameList.forEach(System.out::println);
    }

    private List<Employee> getEmployees() {
        return Arrays.asList(new Employee(null, "Tom Jones", 45, null, null),
                new Employee(null, "Harry Major", 25, null, null),
                new Employee(null, "Ethan Hardy", 65, null, null),
                new Employee(null, "Nancy Smith", 15, null, null),
                new Employee(null, "Deborah Sprightly", 29, null, null));
    }

    public List<String> convertEmpListToNamesList1(List<Employee> employees, Function<Employee, String> funcEmpToString){
        List<String> employeeNames = new ArrayList<>();
        for (Employee employee: employees){
            // apply the actual function on the employee
            employeeNames.add(funcEmpToString.apply(employee));
        }
        return employeeNames;
    }

    public List<String> convertEmpListToNamesList2(List<Employee> employees){
        List<String> employeeNames = new ArrayList<>();
        for (Employee employee:employees){
            employeeNames.add(getNameOfEmployee(employee));
        }
        return employeeNames;
    }

    private String getNameOfEmployee(Employee employee) {
        return employee.getFirstName();
    }
}
