package com.example.bookstore;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
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
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByName() throws Exception {
        List<Category>categories = categoryRepository.findByName("novel");
        assertThat(categories).hasSize(1);
    }

    @Test
    public void createNewCategory(){
        Category category = new Category("short story");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategory(){
        Category category = categoryRepository.findByName("novel").get(0);
        categoryRepository.delete(category);
        Optional<Category> deleteCategory = categoryRepository.findById(category.getCategoryId());
        assertThat(deleteCategory).isEmpty();
    }
}
