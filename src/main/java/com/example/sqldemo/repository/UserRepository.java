package com.example.sqldemo.repository;

import com.example.sqldemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndSoftDeleteIsFalse(Long id);

    @Procedure(procedureName = "getAllUsers")
    List<User> getAllUsers();
}
