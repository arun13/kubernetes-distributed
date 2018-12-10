package com.kubernetes.employee.repository;

import com.kubernetes.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Override
    void deleteById(Integer id);

    @Override
    Optional<Employee> findById(Integer integer);

    @Override
    Employee save(Employee employee);


}