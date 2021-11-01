package com.example.bookstore;

import com.example.bookstore.domain.*;
import org.apache.catalina.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository repository, BookRepository repo, UserRepository urepository){
		return(args) -> {
			log.info("save a couple of books");
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
			
			User user1 = new User("user", "$2a$10$lMNwvo1nDCz6q6Nq34q89uzHUfL15CJfqXhvBTOS/0kEaa0SV1xmy", "user@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$/xCvLodoNtedmynsPoxrOuABx2197QT9lKgrOfYO0otjCbpd4zRDm", "admin@gmail.com",  "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : repo.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
