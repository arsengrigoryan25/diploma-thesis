package com.warehouse.repository;

import com.warehouse.domain.entity.QuantityOfProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface QuantityOfProductRepository extends JpaRepository<QuantityOfProductEntity, Integer> {

}
