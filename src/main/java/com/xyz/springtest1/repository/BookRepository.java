package com.xyz.springtest1.repository;

import com.xyz.springtest1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository <Book,Long >{
}
