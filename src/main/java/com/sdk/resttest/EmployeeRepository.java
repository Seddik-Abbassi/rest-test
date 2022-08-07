package com.sdk.resttest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Optional<Employee> findByName(String name);
}
