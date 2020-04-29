package com.hrproj.repository;

import com.hrproj.entity.Anketa;
import com.hrproj.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log,Long> {
    @Query("select a from Log a where a.user.id_user = :id")
    Log findByIdUser(@Param("id") Long id);
    @Query("select a from Log a where a.user.username = :email")
    Log findByEmailUser(@Param("email") String email);
    @Query("select a from Log a where a.date = :date")
    List<Log> findByDate(@Param("date") Date date);
    @Query("select a from Log a where a.time = :time")
    List<Log> findByTime(@Param("time") LocalDateTime time);
}
