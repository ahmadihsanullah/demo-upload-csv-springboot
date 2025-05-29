package com.kelaskoding.demo_upload_csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kelaskoding.demo_upload_csv.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}