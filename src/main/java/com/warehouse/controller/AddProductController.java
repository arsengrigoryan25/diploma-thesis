package com.warehouse.controller;

import com.warehouse.domain.entity.ProductInWarehouse;
import com.warehouse.repository.ProductInWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AddProductController {

    @Autowired
    private ProductInWarehouseRepository productInWarehouseRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/addProduct")
    public String main() {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam String countInWarehouse,
                             @RequestParam String purchasePrice,
                             @RequestParam String salePrice,
                             @RequestParam String expirationDate,
                             @RequestParam String productCode,
                             @RequestParam String barcode
    ) {

        ProductInWarehouse productInWarehouse = new ProductInWarehouse(name, description, countInWarehouse, purchasePrice, salePrice, expirationDate, productCode, barcode);
        productInWarehouseRepository.save(productInWarehouse);

        return "addProduct";
    }
}