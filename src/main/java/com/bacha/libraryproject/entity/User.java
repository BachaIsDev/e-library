package com.bacha.libraryproject.entity;

import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "readers")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @OneToMany(cascade = CascadeType.REMOVE)
    @Column(name = "book_id")
    private List<Book> books_id;

    @Column(name = "balance")
    private BigDecimal balance;
}
