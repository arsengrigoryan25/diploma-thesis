package com.warehouse.controller;

import com.warehouse.domain.DictionaryContent;
import com.warehouse.domain.entity.ProductTypeEntity;
import com.warehouse.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductTypeController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @RequestMapping("/createProductTypePage")
    public ModelAndView createType() {
        List<ProductTypeEntity> typeProducts = productTypeRepository.findAll();
        ModelAndView model = new ModelAndView("createProductType");
        model.addObject("productType", typeProducts);
        return model;
    }

    @RequestMapping("/createProductType")
    public ModelAndView createProductType(@RequestParam String name
    ) {
        productTypeRepository.save(new ProductTypeEntity(name));
        return new ModelAndView("redirect:/createProductTypePage");
    }

    @RequestMapping("/updateProductTypePage")
    public @ModelAttribute("dictionaryContent")
    ModelAndView type() {
        List<ProductTypeEntity> productTypeEntities = productTypeRepository.findAll();
        ModelAndView model = new ModelAndView("updateProductType");
        model.addObject("productType", productTypeEntities);
        return model;
    }

    @RequestMapping(value = "/updateProductType", method = RequestMethod.POST)
    public ModelAndView typeProduct(@ModelAttribute("dictionaryContent") DictionaryContent dictionaryContent) throws IOException {
        productTypeRepository.saveAll(dictionaryContent.getProductTypeList());
        return new ModelAndView("redirect:/updateProductTypePage");
    }
}