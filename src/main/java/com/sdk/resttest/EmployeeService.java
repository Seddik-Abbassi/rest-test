package com.sdk.resttest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeByName(String name){
        return repository.findByName(name);
    }

    public Optional<Employee> getEmployee(Long id){
        return repository.findById(id);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
