package com.hexaware.APICodingChallenge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.APICodingChallenge.Entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
