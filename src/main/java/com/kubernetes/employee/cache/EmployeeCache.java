package com.kubernetes.employee.cache;

import com.kubernetes.employee.model.Employee;
import com.kubernetes.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCache {

    @Autowired
    EmployeeRepository employeeRepository;

    @Cacheable(value="employeeCache", key="#id")
    public Employee getEmployee(int id){
        System.out.println("In EmployeeCache Component..");
        Employee employee = null;
        try{
            Thread.sleep(2000);
            employee = employeeRepository.findById(id).get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @CacheEvict(value="employeeCache",key = "#id")
    public void deleteEmployee(int id){
        System.out.println("In EmployeeCache Component..");
        employeeRepository.deleteById(id);
    }

    @CachePut(value="employeeCache")
    public void updateEmployee(Employee employee){
        System.out.println("In EmployeeCache Component..");
        employeeRepository.save(employee);
    }
}