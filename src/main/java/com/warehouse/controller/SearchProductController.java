package com.warehouse.controller;

import com.warehouse.domain.entity.ProductInWarehouse;
import com.warehouse.repository.ProductInWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchProductController {

    @Autowired
    private ProductInWarehouseRepository productInWarehouseRepository;

    @GetMapping("/Product")
    public String main() {
        return "product";
    }

    @PostMapping("/Product")
    public String addProduct(@RequestParam String name,
                             @RequestParam String count,
                             @RequestParam String productCode,
                             @RequestParam String barcode
    ) {
        ProductInWarehouse productInShop = new ProductInWarehouse();
        productInWarehouseRepository.save(productInShop);

        return "product";
    }
}