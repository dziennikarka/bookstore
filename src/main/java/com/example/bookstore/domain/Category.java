package com.example.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long categoryId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    //@JsonIgnore
	@JsonIgnoreProperties("category")
    private List<Book> books;

    public Category() {
        this.categoryId = null;
        this.name = null;
        this.books = new ArrayList<>();

    }

    public Category(String name) {
        this.categoryId = null;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setCategoryId(Long id) {
        this.categoryId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
