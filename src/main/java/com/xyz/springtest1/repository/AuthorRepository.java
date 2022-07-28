package com.xyz.springtest1.repository;

import com.xyz.springtest1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author,Long>{
}
