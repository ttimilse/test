package com.xyz.springtest1.controller;

import com.xyz.springtest1.model.Author;
import com.xyz.springtest1.model.Book;
import com.xyz.springtest1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/{id}/books")
    public ResponseEntity getAllBooksOfAuthor(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            throw new ResourceNotFoundException("Author id NOT found" + id);
        }
        List<Book> listOfBookOfAuthor = new ArrayList<>();
        listOfBookOfAuthor = author.getBookList();
        return new ResponseEntity(listOfBookOfAuthor, HttpStatus.OK);
    }
}
