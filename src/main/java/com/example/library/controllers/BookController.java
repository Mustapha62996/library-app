package com.example.library.controllers;

import com.example.library.model.Book;
import com.example.library.services.BookService;
import com.example.library.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

    private final BookService bookService;
    private final LoggedUserManagementService loggedUserManagementService;

    public BookController(BookService bookService,
                          LoggedUserManagementService loggedUserManagementService){
        this.bookService = bookService;
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @PostMapping("/books")
    public String addBook(Book book, Model model){
        bookService.addBook(book);
        var books = bookService.findAll();

        model.addAttribute("books", books);

        return "books";
    }

    @GetMapping("/books")
    public String viewBooks(@RequestParam(required = false) String logout, Model model){
        if(logout != null){
            loggedUserManagementService.setUsername(null);
        }
        String username = loggedUserManagementService.getUsername();

        if(username == null){
            return "redirect:/";
        }

        var books = bookService.findAll();

        model.addAttribute("username", username);
        model.addAttribute("books", books);

        return "books";
    }


}
