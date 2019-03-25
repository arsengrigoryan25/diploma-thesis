package com.warehouse.controller;

import com.warehouse.domain.dto.Product;
import com.warehouse.domain.dto.TypeProducts;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.TypeProductsRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private static final String DATE_FORMATTER = "yyyy-MM-dd";

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductsRepository typeProductsRepository;

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
                                @RequestParam String typeId,
                                @RequestParam String description,
                                @RequestParam String countInWarehouse,
                                @RequestParam String purchasePrice,
                                @RequestParam String salePrice,
                                @RequestParam String productCode,
                                @RequestParam String barcode
    ) {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        ProductEntity entity = new ProductEntity(name, typeId, description, new Integer(countInWarehouse), 0,
                purchasePrice, salePrice, productCode, barcode);
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
                                @RequestParam String productCode,
                                @RequestParam String barcode
    ) {
        List<Product> productEntity = productService.searchProducts(
                new ProductFilter(name, type, productCode, barcode));
        ModelAndView modelAndView = new ModelAndView("searchProduct");
        modelAndView.addObject("product", productEntity);
        return "searchProduct";
    }

    @GetMapping("/createTypePage")
    public ModelAndView createType() {
        List<TypeProducts> typeProducts = typeProductsRepository.findAll();

        ModelAndView model = new ModelAndView("createTypePage");
        model.addObject("typeProducts", typeProducts);
        return model;
    }

    @GetMapping("/createTypeProduct")
    public ModelAndView createTypeProduct(@RequestParam String id,
                                          @RequestParam String name
    ) {
        typeProductsRepository.save(new TypeProducts(new Integer(id), name));
        return new ModelAndView("redirect:/createTypePage");
    }

    @GetMapping("/updateTypePage")
    public ModelAndView type() {
        List<TypeProducts> typeProducts = typeProductsRepository.findAll();

        ModelAndView model = new ModelAndView("updateTypeProducts");
        model.addObject("typeProducts", typeProducts);
        return model;
    }

    @GetMapping("/updateTypeProduct")
    public ModelAndView typeProduct(@RequestParam String id,
                                    @RequestParam String name
    ) {
//        typeProductsRepository.
        return new ModelAndView("redirect:/createTypePage");
    }


}