package com.hrproj.repository;

import com.hrproj.entity.Allowance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowance,Long> {
    @Query("select a from Allowance a where a.employee.id = :id_employee")
    Allowance findByIdEmployee(@Param("id_employee") Long id_employee);
    @Query("select a from Allowance a where a.month = :month")
    Allowance findByMonth(@Param("month") int month);
    @Query("select a from Allowance a where a.year = :year")
    Allowance findByYear(@Param("year") int year);
}
