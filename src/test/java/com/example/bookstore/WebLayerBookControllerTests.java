package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * WebLayerTests only for endpoints that do not require authentication
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerBookControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws Exception {
        this.mockMvc.perform(get("/index")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("coming soon")));
    }

    @Test
    public void testBooklist() throws Exception {
        this.mockMvc.perform(get("/booklist")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Books available at the moment")));
    }

    @Test
    public void testAddbook() throws Exception {
        this.mockMvc.perform(get("/addbook")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Add book")));
    }


}
