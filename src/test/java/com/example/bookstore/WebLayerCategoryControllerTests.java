package com.example.bookstore;

import com.example.bookstore.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerCategoryControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCategorylist() throws Exception {
        this.mockMvc.perform(get("/categorylist")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Categories in the Database")));
    }

    @Test
    public void testAddcategory() throws Exception {
        this.mockMvc.perform(get("/addcategory")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Add category")));
    }

}
