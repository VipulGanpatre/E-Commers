package com.finalEcommers.demo.repository;

import com.finalEcommers.demo.model.Cart;

import com.finalEcommers.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {


    Optional<Object> findByUser(User user);

}
