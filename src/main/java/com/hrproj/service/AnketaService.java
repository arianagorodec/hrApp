package com.hrproj.service;

import com.hrproj.entity.Anketa;

import java.util.List;

public interface AnketaService {
    Anketa addAnketa(Anketa anketa);
    void deleteById(long id);
    Anketa getByIdCandidate(Long id_candidate);
    Anketa editAnketa(Anketa anketa);
    List<Anketa> getAll();
}
