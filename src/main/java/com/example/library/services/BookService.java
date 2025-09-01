package com.example.library.services;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b){
        books.add(b);
    }
    public List<Book> findAll(){
        return books;
    }

}
