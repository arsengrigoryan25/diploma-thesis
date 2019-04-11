package com.warehouse.controller;

import com.warehouse.domain.dto.DictionaryContent;
import com.warehouse.domain.dto.Product;
import com.warehouse.domain.dto.ProductView;
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

    @GetMapping
    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/createProductPage")
    public ModelAndView create() {
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
    public ModelAndView addProductFirst() {
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
                modelAndView.addObject("error", "Ապրանքը ավելացված է");
            } else {
                product = new Product(new Integer(count), new Integer(count), productCode, barcode);
                productService.updateProductsInShop(product);
                modelAndView.addObject("error", "Ապրանքը ավելացված է");
            }
            return modelAndView;
        } else {
            modelAndView.addObject("error", "Դաշտերը պետքե լինեն թվերր");
            return modelAndView;
        }

    }

    @RequestMapping("/searchProductPage")
    public ModelAndView search() {
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
    public @ModelAttribute("dictionaryContent")
    ModelAndView type() {
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