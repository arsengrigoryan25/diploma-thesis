package com.warehouse.repository;

import com.warehouse.domain.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProductsRepository extends JpaRepository<ProductTypeEntity, Long> {

}
