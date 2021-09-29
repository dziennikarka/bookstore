package com.example.bookstore;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository repository, BookRepository repo){
		return(args) -> {
			Category first = new Category("scifi");
			Category second = new Category ("novel");
			Category third = new Category ("children books");

			repository.save(first);
			repository.save(second);
			repository.save(third);

			Book firstBook = new Book("Aleksis Kivi", "7 veljestä", 1850, "111222333", 15.6, second);
			Book secondBook = new Book("Astrid Lindgren", "Peppi Pitkätossu", 1945, "11223344", 45.0, third);

			repo.save(firstBook);
			repo.save(secondBook);
		};
	}

}
