package com.warehouse.controller;

import com.warehouse.domain.dto.InfoDTO;
import com.warehouse.domain.dto.ProductDTOView;
import com.warehouse.domain.ProductState;
import com.warehouse.domain.entity.InfoEntity;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.filter.ProductInfoFilter;
import com.warehouse.repository.InfoRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InfoRepository infoRepository;

    private final List<ProductState> productStateLIst = new ArrayList<>();

    {
        productStateLIst.add(new ProductState(1, "Պահեստում"));
        productStateLIst.add(new ProductState(2, "Խանութում"));
        productStateLIst.add(new ProductState(3, "Վաճառված"));
    }

    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/searchHistoryPage")
    public ModelAndView searchHistoryPage() {
        ModelAndView modelAndView = new ModelAndView("searchHistory");
        modelAndView.addObject("productState", productStateLIst);
        return modelAndView;
    }

    @RequestMapping("/searchHistory")
    public ModelAndView searchHistoryByDate(@RequestParam String barcode,
                                            @RequestParam String startDate,
                                            @RequestParam String endDate,
                                            @RequestParam String productState
    ) {
        ProductInfoFilter productInfoFilter = new ProductInfoFilter(barcode, startDate, endDate, productState);
        List<InfoDTO> infoDTOList = productService.getProductInfo(productInfoFilter);

        ModelAndView modelAndView = new ModelAndView("searchHistory");
        modelAndView.addObject("searchInfo", infoDTOList);
        modelAndView.addObject("productState", productStateLIst);
        modelAndView.addObject("filterValue", productInfoFilter);
        return modelAndView;
    }

    @RequestMapping("/sellProductPage")
    public ModelAndView sellProductPage() {
        ModelAndView modelAndView = new ModelAndView("sellProduct");
        modelAndView.addObject("productState", productStateLIst);
        return modelAndView;
    }

    @RequestMapping("/searchProductByBarcode")
    public ModelAndView searchProductByBarcode(@RequestParam String barcode
    ) {
        ModelAndView modelAndView = new ModelAndView("sellProduct");
        ProductEntity productEntity = productRepository.findByBarcode(barcode);

        modelAndView.addObject("productEntity", productEntity);
        return modelAndView;
    }

    @RequestMapping("/sellProduct")
    public ModelAndView sellProduct(@RequestParam String barcode,
                                    @RequestParam String count
    ) {
        int countOfSell;
        int countOfSellInDB;
        int countInShop;
        if (!count.trim().isEmpty()) {
            countOfSell = new Integer(count);
            productService.updateProductsSell(new ProductDTOView("", barcode, 0, 0, countOfSell));

            countOfSellInDB = productService.getCountProductOfSellByBarcode(barcode);
            infoRepository.save(new InfoEntity(new Date(), barcode, true, 0, 0, countOfSell, countOfSellInDB,
                    "Vacharvel e " + countOfSell + " hat apranq, vori  shtrix code - " + barcode));

            countInShop = productService.getCountProductInShopByBarcode(barcode);
            infoRepository.save(new InfoEntity(new Date(), barcode, false, 0, countOfSell, 0, countInShop,
                    "Hanvel e xanutic " + countOfSell + " hat apranq, vori  shtrix code - " + barcode));
        }

        return new ModelAndView("redirect:/sellProductPage");
    }
}










