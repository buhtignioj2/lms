package com.cafe24.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reservation;
import com.cafe24.lms.service.AdminService;
import com.example.security.Auth;

@Auth(value=Auth.Role.ADMIN)
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @RequestMapping({ "", "/rent", "/main" })
    public String main(Model model) {
	List<Rent> list = adminService.findAllRent();
	model.addAttribute( "list", list );
	return "admin/rent";
    }

    @RequestMapping("/reserve")
    public String board(Model model) {
	List<Reservation> list = adminService.findAllReserve();
	model.addAttribute( "list", list );
	return "admin/reserve";
    }

}
