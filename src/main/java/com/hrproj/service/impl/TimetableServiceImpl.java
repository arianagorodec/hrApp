package com.hrproj.service.impl;

import com.hrproj.entity.Timetable;
import com.hrproj.repository.TimetableRepository;
import com.hrproj.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TimetableServiceImpl implements TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    @Override
    public Timetable addTimetable(Timetable timetable) {
        return timetableRepository.saveAndFlush(timetable);
    }

    @Override
    public void deleteById(long id) {
        timetableRepository.deleteById(id);
    }

    @Override
    public Timetable getByIdEmployee(Long idEmployee) {
        return timetableRepository.findByIdEmployee(idEmployee);
    }

    @Override
    public Timetable getByIdCandidate(Long idCandidate) {
        return timetableRepository.findByIdCandidate(idCandidate);
    }

    @Override
    public Timetable editTimetable(Timetable timetable) {
        return timetableRepository.saveAndFlush(timetable);
    }

    @Override
    public List<Timetable> getAll() {
        return timetableRepository.findAll();
    }
}
