package com.warehouse.repository;


import com.warehouse.domain.entity.Product;
import com.warehouse.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
