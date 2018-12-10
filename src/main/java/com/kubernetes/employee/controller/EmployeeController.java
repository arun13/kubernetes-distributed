package com.kubernetes.employee.controller;

import com.kubernetes.employee.cache.EmployeeCache;
import com.kubernetes.employee.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    EmployeeCache employeeCache;

    @GetMapping("/employee/{employeeId}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        try{
        InetAddress ip = InetAddress.getLocalHost();
            System.out.println("RestController.."+ip);
    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("RestController..");
        long start = System.currentTimeMillis();
        Employee Employee = employeeCache.getEmployee(employeeId);
        long end = System.currentTimeMillis();
        System.out.println("Took : " + ((end - start) / 1000+" sec."));
        return new ResponseEntity<Employee>(Employee, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    @ResponseBody
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee Employee){
        if(Employee != null){
            employeeCache.updateEmployee(Employee);
        }
        return new ResponseEntity<Employee>(Employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        employeeCache.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}