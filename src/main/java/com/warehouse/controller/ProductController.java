package com.warehouse.controller;

import com.warehouse.domain.dto.*;
import com.warehouse.domain.entity.*;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.InfoRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.QuantityOfProductRepository;
import com.warehouse.repository.ProductTypeRepository;
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
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private QuantityOfProductRepository quantityOfProductRepository;

    private static final String DIGITAL_PATTERN = "^\\d{0,13}$";

    @RequestMapping("/createProductPage")
    public ModelAndView getPageCreateProduct() {
        List<ProductTypeEntity> typeProducts = productTypeRepository.findAll();
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

        if (productCode.trim().matches(DIGITAL_PATTERN) && productCode.trim().isEmpty() && barcode.trim().matches(DIGITAL_PATTERN)) {
            ProductEntity entity = new ProductEntity(name, productType, description, purchasePrice, salePrice, productCode, barcode);
            QuantityOfProductEntity productEntity = new QuantityOfProductEntity(barcode, new Integer(countInWarehouse), 0, 0);
            try {
                productRepository.save(entity);
                quantityOfProductRepository.save(productEntity);
                infoRepository.save(new InfoEntity(new Date(), productCode, barcode, "Stextsvel e apranq," + name));
            } catch (Exception e) {
                List<ProductTypeEntity> typeProducts = productTypeRepository.findAll();
                modelAndView.addObject("productType", typeProducts);
                modelAndView.addObject("productEntity", entity);
                modelAndView.addObject("error", "Այս տվյալներով ապրանք արդեն գրանցված է");
                return modelAndView;
            }
            return new ModelAndView("redirect:createProductPage");
        } else {
            modelAndView.addObject("error", "ապրանքի կոդը կամ շտրիխ կոդը պետք ե լինի միայն թիվ");
            return modelAndView;
        }
    }

    @RequestMapping("/addProductPage")
    public ModelAndView getPageAddProduct() {
        return new ModelAndView("addProduct");
    }

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(@RequestParam String count,
                                   @RequestParam String productCode,
                                   @RequestParam String barcode,
                                   @RequestParam String addProductStatus
    ) {
        ModelAndView modelAndView = new ModelAndView("searchProduct");
        Integer countInWarehouse;
        Integer countInShop;
        Integer countProduct;

        if (count.trim().matches(DIGITAL_PATTERN) && barcode.trim().matches(DIGITAL_PATTERN) &&
                ( productCode.trim().matches(DIGITAL_PATTERN) || productCode.trim().isEmpty() )
        ) {

            countProduct = new Integer(count);
            countInWarehouse = productService.getCountProductInWarehouseByBarcode(barcode);

            if (new Boolean(addProductStatus)) {
                productService.updateProductsInWarehouse(new ProductDTOView(productCode, barcode, countProduct, 0, 0));
                infoRepository.save(new InfoEntity(new Date(), barcode, true, countProduct, 0, 0, countInWarehouse,
                        "Avelacvel e " + count + " hat apranq pahestum, apranqicode - " + productCode + " shtrixcode - " + barcode));

                modelAndView.addObject("error", "Ապրանքը ավելացված է");
            } else {
                countInShop = productService.getCountProductInShopByBarcode(barcode);

                if (countInWarehouse > countProduct) {
                    productService.updateProductsInShop(new ProductDTOView(productCode, barcode, 0, countProduct, 0));

                    infoRepository.save(new InfoEntity(new Date(), barcode, true, 0, countProduct, 0, countInShop,
                            "Avelacvel e " + count + " hat apranq xanutum, apranqicode - " + productCode + " shtrixcode - " + barcode));
                    infoRepository.save(new InfoEntity(new Date(), barcode, false, countProduct, 0, 0, countInWarehouse,
                            "Hanvel e " + count + " hat apranq pahestic, apranqicode - " + productCode + " shtrixcode - " + barcode));

                    modelAndView.addObject("error", "Ապրանքը ավելացված է");
                } else {
                    modelAndView.addObject("error", "Պահեստում չկա այդքան ապրանք");
                }
            }

            return modelAndView;
        } else {
            modelAndView.addObject("error", "Դաշտերը պետք է լինեն թվերր");

            return modelAndView;
        }
    }

    @RequestMapping("/searchOrAddProductPage")
    public ModelAndView getPageSearchProduct() {
        List<ProductTypeEntity> productType = productTypeRepository.findAll();
        ModelAndView model = new ModelAndView("searchProduct");
        model.addObject("productType", productType);
        return model;
    }

    @RequestMapping("/searchProduct")
    public ModelAndView searchProduct(@RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "productType", defaultValue = "1") String productType,
                                      @RequestParam(value = "productCode", defaultValue = "") String productCode,
                                      @RequestParam(value = "barcode", defaultValue = "") String barcode
    ) {
        ProductDTO filterValue = new ProductDTO(name, productType, productCode, barcode);
        List<ProductDTOView> productDTOList = productService.searchProducts(new ProductFilter(name, productType, productCode, barcode));
        List<ProductTypeEntity> productTypeEntities = productTypeRepository.findAll();

        ModelAndView model = new ModelAndView("searchProduct");
        model.addObject("filterValue", filterValue);
        model.addObject("productDTOList", productDTOList);
        model.addObject("productType", productTypeEntities);
        return model;
    }

    @RequestMapping("/deleteProduct/{code}")
    public ModelAndView deleteProductInWarehouse(@PathVariable(name = "code") String barcode//    code -" + productCode + "
    ) {
        productService.deleteProducts(new ProductFilter("", "", "", barcode));
        infoRepository.save(new InfoEntity(new Date(), "Jnjvel e apranq, vori  shtrix code - " + barcode));
        return new ModelAndView("redirect:/searchProduct");
    }
}