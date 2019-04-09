package com.warehouse.controller;

import com.warehouse.domain.dto.DictionaryContent;
import com.warehouse.domain.dto.Product;
import com.warehouse.domain.dto.TypeProducts;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.entity.TypeProductsEntity;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.TypeProductsRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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

    private final JdbcTemplate jdbcTemplate;

    public ProductController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @RequestMapping("/createPage")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        modelAndView.addObject("product_typr",);
        return modelAndView;
    }

    @RequestMapping("/createProduct")
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

    @RequestMapping("/addPage")
    public String addProduct() {
        List<ProductEntity> productEntity = productRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("product", productEntity);
        return "addProduct";
    }

    @RequestMapping("/addProductInWarehouse")
    public String addProductInWarehouse(@RequestParam String count,
                                        @RequestParam String productCode,
                                        @RequestParam String barcode
    ) {
        Product product = new Product(new Integer(count), productCode, barcode);
        productService.updateProductsInWarehouse(product);
        return "addProductInWarehouse";
    }

    @RequestMapping("/addProductInShop")
    public String addProductInShop(@RequestParam String count,
                                   @RequestParam String productCode,
                                   @RequestParam String barcode
    ) {
        Product product = new Product(new Integer(count), productCode, barcode);
        productService.updateProductsInShop(product);
        return "addProductInShop";
    }

    @RequestMapping("/searchPage")
    public String search() {
        return "searchProduct";
    }

    @RequestMapping("/searchProduct")
    public String searchProduct(@RequestParam String name,
                                @RequestParam String type,
                                @RequestParam String productCode,
                                @RequestParam String barcode
    ) {
        List<Product> productEntity = productService.searchProducts(new ProductFilter(name, type, productCode, barcode));
        ModelAndView modelAndView = new ModelAndView("searchProduct");
        modelAndView.addObject("product", productEntity);
        return "searchProduct";
    }

    @RequestMapping("/createTypePage")
    public ModelAndView createType() {
        List<TypeProductsEntity> typeProducts = typeProductsRepository.findAll();
        ModelAndView model = new ModelAndView("createProductType");
        model.addObject("typeProducts", typeProducts);
        return model;
    }

    @RequestMapping("/createTypeProduct")
    public ModelAndView createTypeProduct(@RequestParam String name
    ) {
        typeProductsRepository.save(new TypeProductsEntity(name));
        return new ModelAndView("redirect:/createTypePage");
    }

    @RequestMapping("/updateTypePage")
    public @ModelAttribute("dictionaryContent") ModelAndView type() {
        List<TypeProductsEntity> typeProducts = typeProductsRepository.findAll();
        ModelAndView model = new ModelAndView("updateTypeProducts");
        model.addObject("typeProducts", typeProducts);
        return model;
    }

    @RequestMapping(value = "/updateTypeProduct", method = RequestMethod.POST)
    public ModelAndView typeProduct(@ModelAttribute("dictionaryContent") DictionaryContent dictionaryContent) throws IOException {
        typeProductsRepository.saveAll(dictionaryContent.getTypeProductsList());
        return new ModelAndView("redirect:/updateTypePage");
    }


}