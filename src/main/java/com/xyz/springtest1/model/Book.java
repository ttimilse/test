package com.xyz.springtest1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Book extends BaseModel {
    @NotNull(message = "Book name must not be empty.")
    private String bookname;
    @NotNull(message = "Book author must not be empty.")
    private String bookauthor;
    private String genra;
    @Column(unique = true)
    private String ISBN;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;
}
