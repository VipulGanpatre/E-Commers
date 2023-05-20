package com.finalEcommers.demo.repository;

import com.finalEcommers.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByuserId(int userId);

    public Optional<User> findByEmail(String email);

}
