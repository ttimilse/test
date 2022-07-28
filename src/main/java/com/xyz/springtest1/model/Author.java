package com.xyz.springtest1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Author extends BaseModel {
    String name;
    String address;
    @OneToMany(mappedBy = "author")
    List<Book> bookList;

}
