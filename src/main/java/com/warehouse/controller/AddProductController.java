package com.warehouse.controller;

import com.warehouse.domain.entity.Product;
import com.warehouse.domain.entity.User;
import com.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AddProductController {

    @Autowired
    private ProductRepository productRepository;

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

        Product product = new Product( name, description, countInWarehouse, purchasePrice, salePrice, expirationDate, productCode, barcode);
        productRepository.save(product);

        return "addProduct";
    }
}