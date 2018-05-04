package com.cafe24.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join( @ModelAttribute User user ) {
	return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinOK(@ModelAttribute User user) {
	userService.save(user);
	return "redirect:/";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
	return "user/login";
    }

    @RequestMapping("/joinsuccess")
    public String joinsuccess() {
	return "user/joinsuccess";
    }
}
