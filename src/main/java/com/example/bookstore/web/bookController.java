package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
public class bookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository categoryRepo;

	@RequestMapping(value="/index", method= RequestMethod.GET)
	public String getBook(){
		return "books";
	}

	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String getBookList(Model model){
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
