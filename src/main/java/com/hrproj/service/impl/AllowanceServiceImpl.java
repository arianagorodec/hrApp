package com.hrproj.service.impl;

import com.hrproj.entity.Allowance;
import com.hrproj.repository.AllowanceRepository;
import com.hrproj.service.AllowanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AllowanceServiceImpl implements AllowanceService {
    @Autowired
    private AllowanceRepository allowanceRepository;

    @Override
    public Allowance addAllowance(Allowance allowance) {
        return allowanceRepository.saveAndFlush(allowance);
    }

    @Override
    public void deleteById(long id) {
        allowanceRepository.deleteById(id);
    }

    @Override
    public Allowance getByIdEmployee(Long id_employee) {
        return allowanceRepository.findByIdEmployee(id_employee);
    }

    @Override
    public Allowance getByMonth(int month) {
        return allowanceRepository.findByMonth(month);
    }

    @Override
    public Allowance getByYear(int year) {
        return allowanceRepository.findByYear(year);
    }

    @Override
    public Allowance editAllowance(Allowance allowance) {
        return allowanceRepository.saveAndFlush(allowance);
    }

    @Override
    public List<Allowance> getAll() {
        return allowanceRepository.findAll();
    }
}
