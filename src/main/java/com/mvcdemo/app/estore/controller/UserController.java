package com.mvcdemo.app.estore.controller;

import com.mvcdemo.app.estore.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping(path = "/users/{userId}/albums/{albumId}")
    public ModelAndView getAlbum(@PathVariable("userId") String userId,
                                @PathVariable("albumId") String albumId) {

        ModelAndView modelAndView = new ModelAndView("album");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("albumId", albumId);

        return modelAndView;
    }

    @GetMapping(path = "/users")
    public ModelAndView getUsers(@RequestParam(name = "limit", defaultValue = "30") int limit) {

        ModelAndView modelAndView = new ModelAndView("users");
        return modelAndView;
    }

    @PostMapping(path = "/users")
    public String signupFormSubmit(@ModelAttribute User user) {
        return "signup-result";
    }

    @GetMapping(path = "/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping(path = "/users")
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user) {
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
