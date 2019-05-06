package com.warehouse.controller;

import com.warehouse.domain.dto.DictionaryContent;
import com.warehouse.domain.dto.Product;
import com.warehouse.domain.dto.Role;
import com.warehouse.domain.dto.UserContent;
import com.warehouse.domain.entity.InfoEntity;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.entity.ProductTypeEntity;
import com.warehouse.domain.entity.UserEntity;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.repository.InfoRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.repository.TypeProductsRepository;
import com.warehouse.repository.UserRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main() {
        return "main";
    }

}