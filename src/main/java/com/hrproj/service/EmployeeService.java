package com.hrproj.service;

import com.hrproj.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    void deleteById(long id);
    Optional<Employee> getById(Long id);
    Employee getByBankAccount(String bankAccount);
    Employee getBySurname(String surname);
    //Employee getByFullName(String surname, String name, String patronymic);
    Employee getByName(String name);
    Employee editEmployee(Employee employee);
    List<Employee> getAll();
}
