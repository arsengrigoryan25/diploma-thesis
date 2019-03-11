package com.warehouse.controller;

import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.entity.ProductInWarehouseEntity;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.ProductInWarehouseRepository;
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

//    private final ProductInWarehouseRepository productInWarehouseRepository;
//    private final ProductInShopRepository productInShopRepository;
//    private final AddProductService addProductService;
//
//    public AddProductController(ProductInWarehouseRepository productInWarehouseRepository, ProductInShopRepository productInShopRepository, AddProductService addProductService) {
//        this.productInWarehouseRepository = productInWarehouseRepository;
//        this.productInShopRepository = productInShopRepository;
//        this.addProductService = addProductService;
//    }

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

    @GetMapping("/updateProduct/warehouse")
    public String main() {
        return "updateProductInWarehouse";
    }

    @PostMapping("/updateProduct/warehouse")
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

        return "updateProductInWarehouse";
    }

    @GetMapping("/addProduct/shop")
    public String main1() {
        return "addProductInShop";
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



    @GetMapping("/editProduct")
    public String edit() {
        return "editProduct";
    }

    @PostMapping("/editProduct")
    public String editProduct(@RequestParam String name,
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
        productRepository.exists(entity);

        return "editProduct";
    }
}