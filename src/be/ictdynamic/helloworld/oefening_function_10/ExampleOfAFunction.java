package be.ictdynamic.helloworld.oefening_function_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class ExampleOfAFunction {
    public void gettingNameOfTheEmployeeVeryFancy() {
        Function<Employee, String> getNameOfEmployeeFunction = Employee::getName;

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
        return Arrays.asList(new Employee("Tom Jones", 45),
                new Employee("Harry Major", 25),
                new Employee("Ethan Hardy", 65),
                new Employee("Nancy Smith", 15),
                new Employee("Deborah Sprightly", 29));
    }

    public List<String> convertEmpListToNamesList1(List<Employee> employees, Function<Employee, String> funcEmpToString){
        List<String> empNameList=new ArrayList<>();
        for (Employee employee:employees){
            empNameList.add(funcEmpToString.apply(employee));
        }
        return empNameList;
    }

    public List<String> convertEmpListToNamesList2(List<Employee> employees){
        List<String> empNameList=new ArrayList<>();
        for (Employee employee:employees){
            empNameList.add(getNameOfEmployee(employee));
        }
        return empNameList;
    }

    private String getNameOfEmployee(Employee employee) {
        return employee.getName();
    }
}
