package com.warehouse.repository;


import com.warehouse.domain.entity.ProductInWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInWarehouseRepository extends JpaRepository<ProductInWarehouse, Long> {

}
