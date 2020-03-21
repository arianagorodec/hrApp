package com.hrproj.service;

import com.hrproj.entity.Allowance;

import java.util.List;

public interface AllowanceService {
    Allowance addAllowance(Allowance allowance);
    void deleteById(long id);
    Allowance getByIdEmployee(Long id_employee);
    Allowance getByMonth(int month);
    Allowance getByYear(int year);
    Allowance editAllowance(Allowance allowance);
    List<Allowance> getAll();
}
