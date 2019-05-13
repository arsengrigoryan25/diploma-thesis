package com.warehouse.controller;

import com.warehouse.domain.Role;
import com.warehouse.domain.UserContent;
import com.warehouse.domain.entity.UserEntity;
import com.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final List<Role> roles = new ArrayList<>();
    private List<UserEntity> userEntities = new ArrayList<>();

    {
        roles.add(new Role(0,"Ադմինիստրատոր"));
        roles.add(new Role(1, "Օգտատեր"));
    }

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
        userEntities = userRepository.findAll();
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
            userEntities = userRepository.findAll();
            modelAndView = new ModelAndView("updateUser");
            modelAndView.addObject("userRoles", roles);
            modelAndView.addObject("users", userEntities);
            modelAndView.addObject("error", "Հ/Հ, օգտատերի անունը և գաղտնաբառը չի կարող կրկնվել");
        }
        return modelAndView;
    }
}