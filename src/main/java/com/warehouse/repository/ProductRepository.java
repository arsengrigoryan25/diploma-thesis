package com.warehouse.repository;

import com.warehouse.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where p.barcode = :barcode")
    ProductEntity findByBarcode(@Param("barcode") String barcode);
}
