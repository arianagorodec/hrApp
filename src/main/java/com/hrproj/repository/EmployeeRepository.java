package com.hrproj.repository;

import com.hrproj.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query("select e from Employee e where e.surname = :surname, e.name = :name, e.patronymic = :patronymic")
//    Employee findByFullName(@Param("surname") String surname, @Param("name") String name, @Param("patronymic") String patronymic);
    @Query("select e from Employee e where e.surname = :surname")
    Employee findBySurname(@Param("surname") String surname);
    @Query("select e from Employee e where e.name = :name")
    Employee findByName(@Param("name") String name);
    @Query("select e from Employee e where e.bankAccount = :bankAccount")
    Employee findByBankAccount(@Param("bankAccount") String bankAccount);
}
