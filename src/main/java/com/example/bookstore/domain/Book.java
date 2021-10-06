package com.example.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private String isbn;
	private String author;
	private String title;
	private int year;
	private double price;
	@ManyToOne
	//@JsonIgnoreProperties - one way to avoid infinite loop during JSON serialization/deserialization with bidirectional relationships
    @JsonIgnoreProperties("books")
	@JoinColumn(name="categoryId")
	private Category category;
	
	public Book() {
		this.isbn = null;
		this.author = null;
		this.title = null;
		this.year = 0;
		this.price = 0.0;
		this.category = null;
	}
	
	public Book(String author, String title, int year, String isbn, double price, Category category) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Book(String author, String title, int year, String isbn, Category category) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.price = 0.0;
		this.category = category;
	}
	
	//------------------------getters start here----------------------------------------------------
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}
	//-------------------------------getters end here---------------------------------------
	
	//-------------------------------setters start here-------------------------------------
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	//-------------------------------------setters end here--------------------------------------------
	
	@Override
	public String toString() {
		return "Book{" +
				"author='" + author + '\'' +
				", title='" + title + '\'' +
				", year=" + year +
				", isbn='" + isbn + '\'' +
				", price=" + price +
				", category=" + category +
				'}';
	}
}
