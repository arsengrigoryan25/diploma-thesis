package com.warehouse.controller;

import com.warehouse.domain.entity.ProductInShop;
import com.warehouse.domain.entity.ProductInWarehouse;
import com.warehouse.repository.ProductInShopRepository;
import com.warehouse.repository.ProductInWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AddProductController {

    @Autowired
    private ProductInWarehouseRepository productInWarehouseRepository;

    @Autowired
    private ProductInShopRepository productInShopRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/addProduct/warehouse")
    public String main() {
        return "addProductInWarehouse";
    }

    @PostMapping("/addProduct/warehouse")
    public String addProductInWarehouse(@RequestParam String name,
                             @RequestParam String type,
                             @RequestParam String description,
                             @RequestParam String countInWarehouse,
                             @RequestParam String purchasePrice,
                             @RequestParam String salePrice,
                             @RequestParam String expirationDate,
                             @RequestParam String productCode,
                             @RequestParam String barcode
    ) {
        ProductInWarehouse productInWarehouse = new ProductInWarehouse(name,type, description, countInWarehouse, purchasePrice, salePrice, expirationDate, productCode, barcode);
        productInWarehouseRepository.save(productInWarehouse);

        return "addProduct";
    }

    @GetMapping("/addProduct/shop")
    public String main1() {
        return "addProductInShop";
    }

    @PostMapping("/addProduct/shop")
    public String addProductInShop(@RequestParam String name,
                                   @RequestParam String type,
                                   @RequestParam String description,
                                   @RequestParam String countInWarehouse,
                                   @RequestParam String purchasePrice,
                                   @RequestParam String salePrice,
                                   @RequestParam String expirationDate,
                                   @RequestParam String productCode,
                                   @RequestParam String barcode
    ) {
        ProductInShop productInShop = new ProductInShop(name,type, description, countInWarehouse, purchasePrice, salePrice, expirationDate, productCode, barcode);
        productInShopRepository.save(productInShop);

        return "addProductInShop";
    }
}