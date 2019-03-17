package com.warehouse.controller;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.ProductRepository;
import com.warehouse.service.ProductService;
import com.warehouse.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private static final String DATE_FORMATTER = "yyyy-MM-dd";

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @Inject
    private EntityManager em;

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
                                @RequestParam String expirationDateString,
                                @RequestParam String productCode,
                                @RequestParam String barcode
    ) {
        Date expirationDate =  DateUtils.stringToDateMy(expirationDateString,DATE_FORMATTER );
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
        List<ProductEntity> productEntity = productRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("product", productEntity);
        return "addProduct";
    }

    @GetMapping("/addProductInWarehouse")
    public String addProductInWarehouse(@RequestParam String count,
                                        @RequestParam String productCode,
                                        @RequestParam String barcode
    ) {
        Product product = new Product(new Integer(count), productCode, barcode);
        productService.updateProductsInWarehouse(product);
        return "addProductInWarehouse";
    }

    @GetMapping("/addProductInShop")
    public String addProductInShop(@RequestParam String count,
                                   @RequestParam String productCode,
                                   @RequestParam String barcode
    ) {
        Product product = new Product(new Integer(count), productCode, barcode);
        productService.updateProductsInShop(product);
        return "addProductInShop";
    }

    @GetMapping("/searchPage")
    public String search() {
        return "searchProduct";
    }

    @GetMapping("/searchProduct")
    public String searchProduct(@RequestParam String name,
                                @RequestParam String type,
                                @RequestParam String afterDateString,
                                @RequestParam String beforeDateString,
                                @RequestParam String productCode,
                                @RequestParam String barcode
    ) {

        Date afterDate =  DateUtils.stringToDateMy(afterDateString,DATE_FORMATTER );
        Date beforeDate =  DateUtils.stringToDateMy(beforeDateString,DATE_FORMATTER );
        List<Product> productEntity = productService.searchProducts(
                new ProductFilter(name,type,afterDate,beforeDate,productCode,barcode));
        ModelAndView modelAndView = new ModelAndView("searchProduct");
        modelAndView.addObject("product", productEntity);
        return "searchProduct";
    }
}