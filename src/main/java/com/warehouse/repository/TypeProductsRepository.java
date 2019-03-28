package com.warehouse.repository;

import com.warehouse.domain.dto.TypeProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProductsRepository extends JpaRepository<TypeProducts, Long> {

}