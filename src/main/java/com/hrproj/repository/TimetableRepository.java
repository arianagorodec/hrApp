package com.hrproj.repository;

import com.hrproj.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    @Query("select t from Timetable t where t.employee.id = :id_employee")
    List<Timetable> findByIdEmployee(@Param("id_employee") Long idEmployee);
    @Query("select t from Timetable t where t.candidate.id = :id_candidate")
    Timetable findByIdCandidate(@Param("id_candidate") Long idCandidate);
    @Query("select t from Timetable t where t.type = :type")
    List<Timetable> findByType(@Param("type") String type);
    @Query("select t from Timetable t where t.type = :type and t.employee.id = :id_employee")
    List<Timetable> findByTypeAndIdEmployee(String type, long id_employee);
    @Query("select t from Timetable t where t.type = :type and t.candidate.id = :id_candidate")
    List<Timetable> findByTypeAndIdCandidate(String type, long id_candidate);
}
