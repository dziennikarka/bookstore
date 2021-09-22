package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	private String isbn;
	private String author;
	private String title;
	private int year;
	private double price;
	
	public Book() {
		this.isbn = null;
		this.author = null;
		this.title = null;
		this.year = 0;
		this.price = 0.0;
	}
	
	public Book(String author, String title, int year, String isbn, double price) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Book(String author, String title, int year, String isbn) {
		this.author = author;
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.price = 0.0;
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
	//-------------------------------------setters end here--------------------------------------------
	
	@Override
	public String toString() {
		return "Book{" +
				"author='" + author + '\'' +
				", title='" + title + '\'' +
				", year=" + year +
				", isbn='" + isbn + '\'' +
				", price=" + price +
				'}';
	}
}
