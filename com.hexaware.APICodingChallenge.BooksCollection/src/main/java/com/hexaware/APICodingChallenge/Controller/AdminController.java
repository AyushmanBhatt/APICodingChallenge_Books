package com.hexaware.APICodingChallenge.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hexaware.APICodingChallenge.Entities.Admin;

import com.hexaware.APICodingChallenge.Service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/addadmin")
    public ResponseEntity<Admin> addadmin(@RequestBody Admin admin) {
		admin.setPassword(adminService.encodePassword(admin.getPassword()));
        Admin admin2 = adminService.addadmin(admin);
        
        return ResponseEntity.status(201).body(admin2);
    }
}
