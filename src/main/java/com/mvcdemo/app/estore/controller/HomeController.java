package com.mvcdemo.app.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView homePage() {

        Map<String, String> model = new HashMap<>();
        model.put("firstName", "Vlad");

        ModelAndView modelAndView = new ModelAndView("home", model);
        return modelAndView;
    }


}
