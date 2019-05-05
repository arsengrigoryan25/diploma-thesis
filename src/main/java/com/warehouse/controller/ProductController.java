package com.warehouse.controller;

import com.warehouse.domain.dto.*;
import com.warehouse.domain.entity.*;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.InfoRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.TypeProductsRepository;
import com.warehouse.repository.UserRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@Controller
public class ProductController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductsRepository typeProductsRepository;

    private final List<Role> roles = new ArrayList<>();

    {
        roles.add(new Role(0,"Ադմինիստրատոր"));
        roles.add(new Role(1, "Օգտատեր"));
    }

    @RequestMapping("/")
    public String main() {
        return "main";
    }
//    ================================================================================================================================================

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
//    ================================================================================================================================================

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
//    ================================================================================================================================================

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
//    ================================================================================================================================================

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
        typeProductsRepository.saveAll(dictionaryContent.getProductTypeList());
        return new ModelAndView("redirect:/updateProductTypePage");
    }

//    ================================================================================================================================================


    @RequestMapping("/createUserPage")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView("createUser");
        modelAndView.addObject("userRoles", roles);
        return modelAndView;
    }

    @RequestMapping("/createUser")
    public ModelAndView createUser(@RequestParam String name,
                                   @RequestParam String lastName,
                                   @RequestParam String userRoles,
                                   @RequestParam String active,
                                   @RequestParam String username,
                                   @RequestParam String password
    ) {
        boolean flag = new Boolean(active);
        UserEntity userEntity = new UserEntity(name, lastName, userRoles, flag, username, password);

        ModelAndView modelAndView = new ModelAndView("createUser");
        modelAndView.addObject("userRoles", roles);
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            modelAndView.addObject("userInfo", userEntity);
            modelAndView.addObject("error", "Այս տվյալներով օգտատեր արդեն գրանցված է");
        }
        return modelAndView;
    }

    @RequestMapping("/updateUserPage")
    public @ModelAttribute("userContent")
    ModelAndView user() {
        List<UserEntity> userEntities = userRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("updateUser");
        modelAndView.addObject("userRoles", roles);
        modelAndView.addObject("users", userEntities);
        return modelAndView;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("userContent") UserContent userContent) throws IOException {
        ModelAndView modelAndView;
        try {
            userRepository.saveAll(userContent.getUserList());
            modelAndView =  new ModelAndView("redirect:/updateUserPage");
        } catch (Exception e) {
            modelAndView =  new ModelAndView("updateUser");
            modelAndView.addObject("error", "Հ/Հ, օգտատերի անունը և գախտնաբառը չի կարող կրկնվել");
        }
        return modelAndView;
    }
}