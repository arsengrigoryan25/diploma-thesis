package com.warehouse.controller;

//import com.shop.service.UserService;
import com.warehouse.domain.entity.Product;
import com.warehouse.domain.entity.User;
import com.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/addProduct")
    public String main(Map<String, Object> model) {
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String login(@RequestParam String name,
                        @RequestParam String description,
                        @RequestParam int countInWarehouse,
                        @RequestParam int purchasePrice,
                        @RequestParam int salePrice,
                        @RequestParam String expirationDate,
                        @RequestParam int productCode,
                        @RequestParam int barcode,
                        Map<String, Object> model) {

        Product product = new Product( name, description, countInWarehouse, purchasePrice, salePrice, expirationDate, productCode, barcode);
        productRepository.save(product);

        return "addProduct";
    }


//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model
//    ) {
//        model.put("name", name);
//        return "greeting";
//    }

//    @PostMapping
//    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
//        Message message = new Message(text, tag);
//
//        messageRepo.save(message);
//
//        Iterable<Message> messages = messageRepo.findAll();
//
//        model.put("messages", messages);
//
//        return "main";
//    }

//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model) {
//        Iterable<Message> messages;
//
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//
//        model.put("messages", messages);
//
//        return "main";
//    }

//    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//    public ModelAndView login() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }


//    @RequestMapping(value = "admin/changeLogin", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, @RequestParam(name = "files")MultipartFile multipartFiles) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByEmail(user.getEmail());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            userService.saveUser(user,multipartFiles);
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new User());
//            modelAndView.setViewName("registration");
//
//        }
//        return modelAndView;
//    }

//    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        modelAndView.addObject("userName", user.getName() + " " + user.getLastName());
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }
}
