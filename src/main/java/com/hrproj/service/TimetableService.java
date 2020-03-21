package com.hrproj.service;

import com.hrproj.entity.Timetable;

import java.util.List;

public interface TimetableService {
    Timetable addTimetable(Timetable timetable);
    void deleteById(long id);
    Timetable getByIdEmployee(Long idEmployee);
    Timetable getByIdCandidate(Long idCandidate);
    Timetable editTimetable(Timetable timetable);
    List<Timetable> getAll();
}
