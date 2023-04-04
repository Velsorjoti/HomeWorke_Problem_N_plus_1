package com.example.homework_problems_n_plus_1.repository;

import com.example.homework_problems_n_plus_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
