package com.kelaskoding.demo_upload_csv.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.web.multipart.MultipartFile;

import com.kelaskoding.demo_upload_csv.entity.Book;

public class CSVHelper {

    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        if(!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Book> csvToBooks(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            List<Book> books = new ArrayList<>();

            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
                                                    .withIgnoreHeaderCase().withTrim());
            
            csvParser.getRecords().forEach(record -> {
                Book book = new Book();
                book.setId(Long.parseLong(record.get("id")));
                book.setTitle(record.get("title"));
                book.setAuthor(record.get("author"));
                book.setIsbn(record.get("isbn"));
                books.add(book);
            });
            csvParser.close();
            return books;
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse CSV file: " + e.getMessage());
        }
    }


    
}
