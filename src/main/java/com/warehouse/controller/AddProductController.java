package com.warehouse.controller;

import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.repository.ProductRepository;
import com.warehouse.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class AddProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AddProductService addProductService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/createProduct")
    public String create() {
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@RequestParam String name,
                                @RequestParam String type,
                                @RequestParam String description,
                                @RequestParam String countInWarehouse,
                                @RequestParam String countInShop,
                                @RequestParam String purchasePrice,
                                @RequestParam String salePrice,
                                @RequestParam String expirationDate,
                                @RequestParam String productCode,
                                @RequestParam String barcode
    ) {
        ProductEntity entity = new ProductEntity(name, type, description, countInWarehouse, countInShop,
                purchasePrice, salePrice, expirationDate, productCode, barcode);
        productRepository.save(entity);
        return "createProduct";
    }

    @GetMapping("/addProduct/warehouse")
    public String addProduct() {
        return "addProductInWarehouse";
    }

    @PostMapping("/addProduct/warehouse")
    public String addProductInWarehouse(@RequestParam String name,
                                        @RequestParam String type,
                                        @RequestParam String description,
                                        @RequestParam String countInWarehouse,
                                        @RequestParam String countInShop,
                                        @RequestParam String purchasePrice,
                                        @RequestParam String salePrice,
                                        @RequestParam String expirationDate,
                                        @RequestParam String productCode,
                                        @RequestParam String barcode
    ) {
        ProductEntity entity = new ProductEntity(name, type, description, countInWarehouse, countInShop, purchasePrice, salePrice,
                expirationDate, productCode, barcode);
        productRepository.save(entity);

        return "addProductInWarehouse";
    }

    @PostMapping("/addProduct/shop")
    public String addProductInShop(@RequestParam String name,
                                   @RequestParam String type,
                                   @RequestParam String count,
                                   @RequestParam String salePrice,
                                   @RequestParam String expirationDate,
                                   @RequestParam String productCode,
                                   @RequestParam String barcode
    ) {


        return "addProductInShop";
    }


//    @GetMapping("/editProduct")
//    public String edit() {
//        return "editProduct";
//    }
//
//    @PostMapping("/editProduct")
//    public String editProduct(@RequestParam String name,
//                              @RequestParam String type,
//                              @RequestParam String description,
//                              @RequestParam String countInWarehouse,
//                              @RequestParam String countInShop,
//                              @RequestParam String purchasePrice,
//                              @RequestParam String salePrice,
//                              @RequestParam String expirationDate,
//                              @RequestParam String productCode,
//                              @RequestParam String barcode
//    ) {
//        ProductEntity entity = new ProductEntity(name, type, description, countInWarehouse, countInShop, purchasePrice, salePrice,
//                expirationDate, productCode, barcode);
//        productRepository.exists(entity);
//
//        return "editProduct";
//    }
}