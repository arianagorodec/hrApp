package com.hrproj.service.impl;

import com.hrproj.entity.Anketa;
import com.hrproj.entity.Candidate;
import com.hrproj.repository.AnketaRepository;
import com.hrproj.service.AnketaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnketaServiceImpl implements AnketaService {
    @Autowired
    private AnketaRepository anketaRepository;

    @Override
    public Anketa addAnketa(Anketa anketa) {
        return anketaRepository.saveAndFlush(anketa);
    }

    @Override
    public void deleteById(long id) {
        anketaRepository.deleteById(id);
    }

    @Override
    public Anketa getByIdCandidate(Long id_candidate) {
        return anketaRepository.findByIdCandidate(id_candidate);
    }

    @Override
    public Anketa editAnketa(Anketa allowance) {
        return anketaRepository.saveAndFlush(allowance);
    }

    @Override
    public List<Anketa> getAll() {
        return anketaRepository.findAll();
    }

    public Anketa updateAnketa(Anketa anketa) {
        return anketaRepository.save(anketa);
    }

    public Anketa updateAnketaFromForm(Anketa anketa) {
        anketa.setQuestion6DB(combineStr(anketa.getQuestion6()) );
        anketa.setQuestion7DB(combineStr(anketa.getQuestion7()) );
        anketa.setQuestion8DB(combineStr(anketa.getQuestion7()) );
        return anketaRepository.save(anketa);
    }

    public String combineStr (String[] strings){
            String q6 = "";
            for(String str:strings){
                q6+=str+".";
            }
            return q6;
    }

    public Anketa getByIdCandidateForForm(long id){
        Anketa anketa = getByIdCandidate(id);
        if(anketa!=null) {
            String delimeter = "\\."; // Разделитель
            anketa.setQuestion6(anketa.getQuestion6DB().split(delimeter));
            anketa.setQuestion7(anketa.getQuestion7DB().split(delimeter));
            anketa.setQuestion8(anketa.getQuestion8DB().split(delimeter));
        }
        return anketa;
    }
}
