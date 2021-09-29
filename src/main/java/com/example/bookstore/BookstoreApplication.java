package com.example.bookstore;

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
	public CommandLineRunner demo(CategoryRepository repository){
		return(args) -> {
			Category first = new Category("scifi");
			Category second = new Category ("drama");
			Category third = new Category ("comic");

			repository.save(first);
			repository.save(second);
			repository.save(third);
		};
	}

}
