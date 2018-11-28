package com.exemple;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import lombok.Data;


public class Function {
    
    @FunctionName("createemployee")
    public Employee create(@HttpTrigger(
    name = "createemployeerest",
    methods = {HttpMethod.POST},
    route = "employee"
    )Employee employee){
        return employee;
    }
    
    @FunctionName("reademployees")
    public List<Employee> read(@HttpTrigger(
    name = "reademployeerest",
    methods = {HttpMethod.GET},
    route = "employee"
    )String x){
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(
         new Long(1),
                "Camila",
                21,
                1000
        );
        Employee e2 = new Employee( new Long(2),
                "Vanderley",
                20,
                1000);
        employees.add(e1);
        employees.add(e2);
        return employees;
    }
    
    @FunctionName("updateemployee")
    public Employee update(@HttpTrigger(
    name = "updateemployeerest",
    methods = {HttpMethod.PUT},
    route = "employee"
    )Employee employee){
        employee.setName(employee.getName()+"-update");
        return employee;
    }
    
    @FunctionName("deleteemployee")
    public String delete(@HttpTrigger(
    name = "deleteemployeerest",
    methods = {HttpMethod.DELETE},
    route = "employee"
    )Long id){
        return "OK";
    }
}

@Data
class Employee{
    private Long id;
    private String name;
    private int age;
    private double salary;
    
     public Employee(Long id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
}
