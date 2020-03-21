package com.hrproj.repository;

import com.hrproj.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    @Query("select t from Timetable t where t.employee.id = :id_employee")
    Timetable findByIdEmployee(@Param("id_employee") Long idEmployee);
    @Query("select t from Timetable t where t.candidate.id = :id_candidate")
    Timetable findByIdCandidate(@Param("id_candidate") Long idCandidate);
}
