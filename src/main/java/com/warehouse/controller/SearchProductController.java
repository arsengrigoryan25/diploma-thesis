package com.warehouse.controller;

import com.warehouse.repository.ProductInWarehouseRepository;
import jdk.nashorn.internal.objects.annotations.Setter;
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
        return "addProductInShop";
    }

    @PostMapping("/Product")
    public String addProduct(@RequestParam String name,
                             @RequestParam String count,
                             @RequestParam String productCode,
                             @RequestParam String barcode
    ) {

        return "addProductInShop";
    }
}