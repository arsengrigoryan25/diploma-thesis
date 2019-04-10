package com.warehouse.controller;

import com.warehouse.domain.dto.DictionaryContent;
import com.warehouse.domain.dto.Product;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.entity.ProductTypeEntity;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.TypeProductsRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductsRepository typeProductsRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Inject
    private EntityManager em;


    @RequestMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @RequestMapping("/createProductPage")
    public ModelAndView create() {
        List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("createProduct");
        modelAndView.addObject("productType",typeProducts);
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
        } catch (Exception e) {
            List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
            modelAndView.addObject("productType",typeProducts);
            modelAndView.addObject("productEntity", entity);
            modelAndView.addObject("error", "Այս տվյալներով ապրանք արդեն գրանցված է");
            return modelAndView;
        }
        return new ModelAndView("redirect:createProductPage");
    }

    @RequestMapping("/addProductPage")
    public ModelAndView addProduct() {
        return new ModelAndView("addProduct");
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProductInWarehouse(@RequestParam String count,
                                        @RequestParam String productCode,
                                        @RequestParam String barcode,
                                        @RequestParam String addProductStatus
    ) {
        final String digitPattern = "^ \\d {0,9} $";
        Product product = new Product(new Integer(count), productCode, barcode);
        if(count.matches(digitPattern) && productCode.matches(digitPattern) && barcode.matches(digitPattern)){
            if(new Boolean(addProductStatus)){
                productService.updateProductsInWarehouse(product);
                return new ModelAndView("addProduct");
            }else{
                productService.updateProductsInShop(product);
                return new ModelAndView("addProduct");
            }
        } else{
            ModelAndView modelAndView = new ModelAndView("addProduct");
            modelAndView.addObject("error","Դաշտերը պետքե լինեն թվերր");
            return modelAndView;
        }
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

    @RequestMapping("/searchProductPage")
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

    @RequestMapping("/createProductTypePage")
    public ModelAndView createType() {
        List<ProductTypeEntity> typeProducts = typeProductsRepository.findAll();
        ModelAndView model = new ModelAndView("createProductType");
        model.addObject("productType", typeProducts);
        return model;
    }

    @RequestMapping("/createProductType")
    public ModelAndView createProductType(@RequestParam String name
    ) {
        typeProductsRepository.save(new ProductTypeEntity(name));
        return new ModelAndView("redirect:/createProductTypePage");
    }

    @RequestMapping("/updateProductTypePage")
    public @ModelAttribute("dictionaryContent") ModelAndView type() {
        List<ProductTypeEntity> productTypeEntities = typeProductsRepository.findAll();
        ModelAndView model = new ModelAndView("updateProductType");
        model.addObject("productType", productTypeEntities);
        return model;
    }

    @RequestMapping(value = "/updateProductType", method = RequestMethod.POST)
    public ModelAndView typeProduct(@ModelAttribute("dictionaryContent") DictionaryContent dictionaryContent) throws IOException {
        typeProductsRepository.saveAll(dictionaryContent.getTypeProductsList());
        return new ModelAndView("redirect:/updateProductTypePage");
    }


}