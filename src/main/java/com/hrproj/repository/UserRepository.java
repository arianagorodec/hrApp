package com.hrproj.repository;

import com.hrproj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from User u where u.username = :username")
//    User findByLogin(@Param("username") String name);

    User findByUsername(String username);
    User findById(long id);

    User findByActivationCode(String activationCode);
}