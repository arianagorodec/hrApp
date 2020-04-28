package com.hrproj.service.impl;

import com.hrproj.entity.Payroll;
import com.hrproj.repository.PayrollRepository;
import com.hrproj.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

    @Override
    public Payroll addPayroll(Payroll payroll) {
        return payrollRepository.saveAndFlush(payroll);
    }

    @Override
    public void deleteById(long id) {
        payrollRepository.deleteById(id);
    }

    @Override
    public List<Payroll> getByIdEmployee(Long id_employee) {
        return payrollRepository.findByIdEmployee(id_employee);
    }

    @Override
    public Payroll getByDate(Date date) {
        return payrollRepository.findByDate(date);
    }

    @Override
    public Payroll editPayroll(Payroll payroll) {
        return payrollRepository.saveAndFlush(payroll);
    }

    @Override
    public List<Payroll> getAll() {
        return payrollRepository.findAll();
    }


}
