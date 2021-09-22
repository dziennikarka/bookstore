package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class bookController {

	@Autowired
	private BookRepository repository;

	@RequestMapping(value="/index", method= RequestMethod.GET)
	public String getBook(){
		return "books";
	}

	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String getBookList(Model model){
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") String isbn, Model model){
		repository.deleteById(isbn);
		return "redirect:/booklist";
	}

	//Add new book
	@RequestMapping(value="/addbook", method = RequestMethod.GET)
	public String addBook(Model model){
		model.addAttribute("book",new Book());
		return "addbook";
	}

	//Save book
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveBook(Book book){
		repository.save(book);
		return "redirect:/booklist";
	}
}
