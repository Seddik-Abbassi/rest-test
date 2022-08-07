package com.sdk.resttest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/save/{id}")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee, @PathVariable Long id){
        Employee employee1 = service.getEmployee(id).get();
        employee1.setAge(10);
        return new ResponseEntity<>(service.saveEmployee(employee1), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        Employee employee1 = service.getEmployee(id).get();
        employee1.setAge(12);
        return new ResponseEntity<>(service.saveEmployee(employee1), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) throws RuntimeException {
        Employee employee = service.getEmployeeByName(name).orElseThrow(()-> new RuntimeException("Employee not found"));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return new ResponseEntity<>("Deleted employee id : " + id, HttpStatus.OK);
    }
}
