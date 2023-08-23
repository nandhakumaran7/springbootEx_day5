package com.classwork5.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classwork5.demo.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
