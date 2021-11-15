package com.example.bookstore.web;

import com.example.bookstore.BookstoreApplication;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class bookController {
	private static final Logger log = LoggerFactory.getLogger(bookController.class);

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository categoryRepo;

	@RequestMapping(value="/index", method= RequestMethod.GET)
	public String getBook(){
		return "books";
	}

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String getPage(){return "login";}

	//login page controller
	@RequestMapping(value="/login")
    public String login() {
        return "login";
    }

	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String getBookList(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("Roles:{}",authentication.getAuthorities());
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	// RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody
	List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

	// RESTful service to get book by isbn
    @RequestMapping(value="/books/{isbn}", method = RequestMethod.GET)
    public @ResponseBody
	Optional<Book> findBookRest(@PathVariable("isbn") String bookIsbn) {
    	return repository.findById(bookIsbn);
    }

    // RESTful service to save new book
    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
    	return repository.save(book);
    }

	//Delete book
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") String isbn, Model model){
		repository.deleteById(isbn);
		return "redirect:/booklist";
	}

	//Add new book
	@RequestMapping(value="/addbook", method = RequestMethod.GET)
	public String addBook(Model model){
		model.addAttribute("book",new Book());
		model.addAttribute("categories",categoryRepo.findAll());
		return "addbook";
	}

	//Save book
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveBook(Book book){
		repository.save(book);
		return "redirect:/booklist";
	}

	//editing book
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") String isbn, Model model){
		model.addAttribute("book", repository.findById(isbn));
		return "addbook";
	}
}
