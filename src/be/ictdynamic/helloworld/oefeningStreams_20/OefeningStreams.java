package be.ictdynamic.helloworld.oefeningStreams_20;

import be.ictdynamic.helloworld.domain.Employee;
import be.ictdynamic.helloworld.domain.Worker;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by wvdbrand on 8/09/2017.
 */
public class OefeningStreams {

    private Set<Employee> employees = new LinkedHashSet<>(10);

    public OefeningStreams() {
        Employee employee = new Employee(1, "wim van den brande", 50, Worker.Gender.MALE, null);
        employees.add(employee);

        employee = new Employee(2, "kris van den brande", 48, null, null);
        employees.add(employee);

        employee = new Employee(3 ,"jan van den brande", 52, Worker.Gender.MALE, null);
        employees.add(employee);

        employee = new Employee(4, "hilary clinton", 72, Worker.Gender.FEMALE, null);
        employees.add(employee);

        employee = new Employee(5, "donald trump", 71, Worker.Gender.MALE, null);
        employees.add(employee);

        employee = new Employee(6, "michelle obama", 55, Worker.Gender.FEMALE, null);
        employees.add(employee);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void exec() {
        // possible NPE !!!
        List<Employee> vdbEmployees1 = getEmployees().stream().filter(employee -> employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0).collect(Collectors.toList());
        System.out.println("number of employees = " + vdbEmployees1.size() + ", : " + vdbEmployees1);
        List<Employee> vdbEmployees2 = getEmployees().stream().filter((employee) -> employee.getName() != null && employee.getName().toLowerCase().lastIndexOf("van den brande") >= 0).collect(Collectors.toList());
        System.out.println("number of employees = " + vdbEmployees2.size() + ", : " + vdbEmployees2);

        // filter, sorted, and map, which can be connected together to form a pipeline
        // collect closes the pipeline and returns a result

        List<Employee> femaleEmployees = getEmployees().stream().filter(employee -> employee.getGender() == Worker.Gender.FEMALE).collect(Collectors.toList());
        System.out.println("number of employees = " + femaleEmployees.size() + ", : " + femaleEmployees);

        List<Integer> ages = getEmployees().stream().map(employee -> employee.getAge()).collect(Collectors.toList());
        System.out.println("number of ages = " + femaleEmployees.size() + ", : " + ages);

        // be aware - sorting is expensive
        List<Employee> employeesSortedByAge = getEmployees().stream().sorted(comparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("employeesSortedByAge: " + employeesSortedByAge);
    }
}
