package com.kelaskoding.demo_upload_csv.service;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kelaskoding.demo_upload_csv.entity.Book;
import com.kelaskoding.demo_upload_csv.repository.BookRepository;
import com.kelaskoding.demo_upload_csv.utility.CSVHelper;

import jakarta.transaction.Transactional;

@Service("BookService")
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> save(MultipartFile file){
        try {
            List<Book> csvToBooks = CSVHelper.csvToBooks(file.getInputStream());
            return bookRepository.saveAll(csvToBooks);
        } catch (IOException ex) {
            throw new RuntimeException("Fail to store csv data: " + ex.getMessage());
        }
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    
}
