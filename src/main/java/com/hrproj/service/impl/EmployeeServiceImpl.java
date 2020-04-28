package com.hrproj.service.impl;

import com.hrproj.entity.Candidate;
import com.hrproj.entity.Employee;
import com.hrproj.repository.EmployeeRepository;
import com.hrproj.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

//    @Override
//    public Employee getByFullName(String surname, String name, String patronymic) {
//        return employeeRepository.findByFullName(surname, name, patronymic);
//    }
    @Override
    public Employee getBySurname(String surname) {
        return employeeRepository.findBySurname(surname);
    }
    @Override
    public Employee getByName(String name) {
        return employeeRepository.findByName(name);
    }
    @Override
    public Employee getByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    @Override
    public Employee editEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllHr() {
        return employeeRepository.findAllHr();
    }

    public Employee getInfoEmployee() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = getByEmail(auth.getName());
        return employee;
    }
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
