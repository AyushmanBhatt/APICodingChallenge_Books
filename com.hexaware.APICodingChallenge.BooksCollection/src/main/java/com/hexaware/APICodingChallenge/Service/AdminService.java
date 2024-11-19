package com.hexaware.APICodingChallenge.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.APICodingChallenge.Entities.Admin;
import com.hexaware.APICodingChallenge.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Admin addadmin(Admin admin) {
		
		return adminRepository.save(admin);
	}
	
	public String encodePassword(String password) {
        
        return passwordEncoder.encode(password);
    }

}
