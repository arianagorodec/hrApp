package com.hrproj.service;

import com.hrproj.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    Candidate addCandidate(Candidate candidate);
    void deleteById(long id);
    Optional<Candidate> getById(Long id);
    Candidate getBySurname(String surname);
    Candidate getByName(String name);
    //Candidate getByFullName(String surname, String name, String patronymic);
    Candidate getByEmail(String email);
    Candidate editCandidate(Candidate candidate);
    List<Candidate> getAll();
}
