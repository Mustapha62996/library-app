package com.example.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    private final BookService bookService;

    public MainController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public String addBook(Book book, Model model){
        bookService.addBook(book);
        var books = bookService.findAll();

        model.addAttribute("books", books);

        return "books";
    }

    @GetMapping("/books")
    public String viewBooks(Model model){
        var books = bookService.findAll();
        model.addAttribute("books", books);

        return "books";
    }


}
