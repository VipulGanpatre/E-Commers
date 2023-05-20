package com.finalEcommers.demo.repository;

import com.finalEcommers.demo.model.Category;
import com.finalEcommers.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//  List<Product> findbycategory(Category category);
}
