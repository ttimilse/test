package com.xyz.springtest1.controller;

import com.xyz.springtest1.model.Book;
import com.xyz.springtest1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RepositoryRestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity createBook(@RequestBody @Valid Book book) {
        bookService.save(book);
        return new ResponseEntity("Book Created", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity(bookList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBooks(@RequestBody @Valid Book book, @PathVariable Long id) {
        bookService.updateBooks(book, id);
        return new ResponseEntity("Book Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookService.deleteBooks(id);
        return new ResponseEntity("Book deleted", HttpStatus.OK);
    }
}
