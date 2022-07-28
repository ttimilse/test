package com.xyz.springtest1.service;

import com.xyz.springtest1.model.Book;
import com.xyz.springtest1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
       List <Book> bookList = bookRepository.findAll();
        return bookList;
    }
    public void updateBooks(Book book, Long id){
        Book bookToUpdate = bookRepository.findById(id).orElse(null);
        if(bookToUpdate == null){
            throw new ResourceNotFoundException("ID" + id + "Not found");
        }
        book.setId(id);
        bookRepository.save(book);
    }

    public void deleteBooks(Long id){
        Book bookToDelete = bookRepository.findById(id).orElse(null);
        if(bookToDelete == null){
            throw new ResourceNotFoundException("ID" + id + "Not found");
        }
        bookRepository.delete(bookToDelete);
    }
}
