package com.warehouse.controller;

import com.warehouse.domain.dto.*;
import com.warehouse.domain.entity.*;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.InfoRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.TypeProductsRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductsRepository typeProductsRepository;

    @RequestMapping("/createProductPage")
    public ModelAndView getPageCreateProduct() {
        List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("createProduct");
        modelAndView.addObject("productType", typeProducts);
        return modelAndView;
    }

    @RequestMapping("/createProduct")
    public ModelAndView createProduct(@RequestParam String name,
                                      @RequestParam String productType,
                                      @RequestParam String description,
                                      @RequestParam String countInWarehouse,
                                      @RequestParam String purchasePrice,
                                      @RequestParam String salePrice,
                                      @RequestParam String productCode,
                                      @RequestParam String barcode

    ) {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        ProductEntity entity = new ProductEntity(name, productType, description, new Integer(countInWarehouse), 0,
                purchasePrice, salePrice, productCode, barcode);

        try {
            productRepository.save(entity);
            infoRepository.save(new InfoEntity(new Date(), "Stextsvel e apranq, anwun - " + name + "code -" + productCode + " shtrix code - " + barcode));
        } catch (Exception e) {
            List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
            modelAndView.addObject("productType", typeProducts);
            modelAndView.addObject("productEntity", entity);
            modelAndView.addObject("error", "Այս տվյալներով ապրանք արդեն գրանցված է");
            return modelAndView;
        }
        return new ModelAndView("redirect:createProductPage");
    }

    @RequestMapping("/addProductPage")
    public ModelAndView getPageAddProduct() {
        return new ModelAndView("addProduct");
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProductInWarehouse(@RequestParam String count,
                                              @RequestParam String productCode,
                                              @RequestParam String barcode,
                                              @RequestParam String addProductStatus
    ) {
        //TODO check product count in warehouse

        final String digitPattern = "^\\d{0,13}|[ ]$";
        Product product;
        ModelAndView modelAndView = new ModelAndView("searchProduct");
        if (count.trim().matches(digitPattern) && productCode.trim().matches(digitPattern) && barcode.trim().matches(digitPattern)) {
            if (new Boolean(addProductStatus)) {
                product = new Product(new Integer(count), 0, productCode, barcode);
                productService.updateProductsInWarehouse(product);
                infoRepository.save(new InfoEntity(new Date(), "Avelacvel e " + count + "hat apranq pahestum, code -" + productCode + " shtrix code - " + barcode));

                modelAndView.addObject("error", "Ապրանքը ավելացված է");
            } else {
                product = new Product(new Integer(count), new Integer(count), productCode, barcode);
                productService.updateProductsInShop(product);
                infoRepository.save(new InfoEntity(new Date(), "Avelacvel e " + count + "hat apranq xanutum, code -" + productCode + " shtrix code - " + barcode));

                modelAndView.addObject("error", "Ապրանքը ավելացված է");
            }
            return modelAndView;
        } else {
            modelAndView.addObject("error", "Դաշտերը պետքե լինեն թվերր");
            return modelAndView;
        }

    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public ModelAndView deleteProductInWarehouse( @RequestParam String barcode
    ) {
        productService.deleteProducts(new ProductFilter("","",barcode,""));
        infoRepository.save(new InfoEntity(new Date(), "Jnjvel e apranq, vori  shtrix code - " + barcode));
        return new ModelAndView("redirect:/searchProduct");
    }
//    code -" + productCode + "
    @RequestMapping("/searchProductPage")
    public ModelAndView getPageSearchProduct() {
        List<ProductTypeEntity> productType = typeProductsRepository.findAll();
        ModelAndView model = new ModelAndView("searchProduct");
        model.addObject("productType", productType);
        return model;
    }

    @RequestMapping("/searchProduct")
    public ModelAndView searchProduct(@RequestParam String name,
                                      @RequestParam String productType,
                                      @RequestParam String productCode,
                                      @RequestParam String barcode
    ) {
        Product filterValue = new Product(name, productType, productCode, barcode);
        List<Product> productList = productService.searchProducts(new ProductFilter(name, productType, productCode, barcode));
        List<ProductTypeEntity> productTypeEntities = typeProductsRepository.findAll();

        ModelAndView model = new ModelAndView("searchProduct");
        model.addObject("filterValue", filterValue);
        model.addObject("productList", productList);
        model.addObject("productType", productTypeEntities);
        return model;
    }
}