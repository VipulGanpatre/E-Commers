package com.finalEcommers.demo.repository;

import com.finalEcommers.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categoryrepo extends JpaRepository<Category, Integer> {
}
