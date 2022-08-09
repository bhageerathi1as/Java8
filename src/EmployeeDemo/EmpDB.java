package EmployeeDemo;

import java.util.*;
import java.util.stream.Collectors;

public class EmpDB {
    public static void main(String[] args) {
        List<Employee> emplist = new ArrayList<Employee>();
        emplist.add(new Employee("Shanthi", 24, "Female", "HR", 20000));
        emplist.add(new Employee("Aru", 37, "Male", "IT", 40000));
        emplist.add(new Employee("Rajee", 25, "Female", "HR", 60000));
        emplist.add(new Employee("Bhagee", 32, "Female", "IT", 50000));
        emplist.add(new Employee("Suman", 36, "Female", "HR", 45000));
        emplist.add(new Employee("Aru", 38, "Male", "IT", 34000));

        //print distinct departments
        System.out.println("Print distinct departments:");
        emplist.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //count of employees from each department
        System.out.println("Count of employee in each departments:");

        Map<String,Long> empcount=emplist.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(empcount);

        //count of employees from each department
        System.out.println("Count of employee in each departments:");
        Map<String,Long>empdeptcount=emplist.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(empdeptcount);

        //Average of all employees
        System.out.println("Average count of employees based on Gender:");
        Map<String,Double>empavg=emplist.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
        System.out.println(empavg);

        //Group employees based on department
        System.out.println("Group employees based on Department:");
        Map<String,List<Employee>> empdept=  emplist.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(empdept);

        //Highest salary of employee in each department
        System.out.println("Highest Salary of employees based on Department:");
        Map<String,Employee>empsalary=emplist.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
        System.out.println(empsalary);
    }
}
