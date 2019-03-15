package com.warehouse.controller;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.repository.ProductRepository;

import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/createPage")
    public String create() {
        return "createProduct";
    }

    @GetMapping("/createProduct")
    public String createProduct(@RequestParam String name,
                                @RequestParam String type,
                                @RequestParam String description,
                                @RequestParam String countInWarehouse,
                                @RequestParam String purchasePrice,
                                @RequestParam String salePrice,
                                @RequestParam String expirationDate,
                                @RequestParam String productCode,
                                @RequestParam String barcode
    ) {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        ProductEntity entity = new ProductEntity(name, type, description, new Integer(countInWarehouse), 0,
                purchasePrice, salePrice, expirationDate, productCode, barcode);
        try {
            productRepository.save(entity);
        } catch (Exception e) {
            modelAndView.addObject("error", "Այս տվյալներով ապրանք արդեն գրանցված է");
        }
        return "createProduct";
    }

    @GetMapping("/addPage")
    public String addProduct() {
        productRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("nameProduct", );
        modelAndView.addObject("productCodeProduct", );
        modelAndView.addObject("barcodeProduct", );
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductInWarehouse(@RequestParam String countInWarehouse,
                                        @RequestParam String countInShop,
                                        @RequestParam String productCode,
                                        @RequestParam String barcode
    ) {
        Product product = new Product(new Integer(countInWarehouse), new Integer(countInShop), productCode, barcode);
        productService.updateProducts(product);

        return "addProduct";
    }

    @GetMapping("/searchPage")
    public String main() {
        return "searchProduct";
    }

    @GetMapping("/searchProduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam String count,
                             @RequestParam String productCode,
                             @RequestParam String barcode
    ) {

        return "addProduct";
    }
}


//
//    @PostMapping("/addProduct/shop")
//    public String addProductInShop(@RequestParam String name,
//                                   @RequestParam String type,
//                                   @RequestParam String count,
//                                   @RequestParam String salePrice,
//                                   @RequestParam String expirationDate,
//                                   @RequestParam String productCode,
//                                   @RequestParam String barcode
//    ) {
//
//
//        return "addProduct";
//    }
//

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