package com.example.bookstore;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findByName(){
        List<Book>books = bookRepository.findByTitle("7 veljestä");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor().equals("Aleksis Kivi"));
    }

    @Test
    public void createNewBook(){
        Book book = new Book("Viktor Pelevin", "Generation P", 1999, "19990102", 50.0, new Category("novel"));
        bookRepository.save(book);
        assertThat(book.getIsbn()).isNotNull();
        assertThat(book.getAuthor().equals("Viktor Pelevin"));
    }

    @Test
    public void deleteBook(){
        Book book = bookRepository.findByTitle("7 veljestä").get(0);
        bookRepository.delete(book);
        Optional<Book> deleteBook = bookRepository.findById(book.getIsbn());
        assertThat(deleteBook).isEmpty();
    }


}
