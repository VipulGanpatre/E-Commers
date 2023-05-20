package com.finalEcommers.demo.repository;

import com.finalEcommers.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {


}
