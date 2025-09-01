package com.example.library.services;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, List<Book>> userBooks = new HashMap<>();

    public void addBook(String username, Book b){
        userBooks.computeIfAbsent(username, k -> new ArrayList<>()).add(b);
    }
    public List<Book> findAll(String username){
        return userBooks.getOrDefault(username, new ArrayList<>());
    }

}
