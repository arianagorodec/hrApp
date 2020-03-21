package com.hrproj.repository;

import com.hrproj.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
//    @Query("select e from Candidate e where e.surname = :surname, e.name = :name, e.patronymic = :patronymic")
//    Candidate findByFullName(@Param("surname") String surname, @Param("name") String name, @Param("patronymic") String patronymic);
    @Query("select e from Candidate e where e.surname = :surname")
    Candidate findBySurname(@Param("surname") String surname);
    @Query("select e from Candidate e where e.name = :name")
    Candidate findByName(@Param("name") String name);
    @Query("select e from Candidate e where e.email = :email")
    Candidate findByEmail(@Param("email") String email);
}
