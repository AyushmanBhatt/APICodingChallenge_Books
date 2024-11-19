package com.hexaware.APICodingChallenge.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.APICodingChallenge.Entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Optional<Admin> findByUsername(String username);

}