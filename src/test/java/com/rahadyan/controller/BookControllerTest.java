package com.rahadyan.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rahadyan.model.Book;
import com.rahadyan.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private BookService bookService;

	@Test
	public void retriveAll() throws Exception {
		// PREPARATION
        when(bookService.retriveAll()).thenReturn(Arrays.asList(
        		new Book(1, "1001", "Spring beginner", "Josh", Book.Status.SHELVED),
                new Book(2, "1002", "Java Fundamental", "Budiman", Book.Status.NOT_SHELVED)
        ));

        // Call GET /all-items return status 200, content json array
        RequestBuilder request = MockMvcRequestBuilders.get("/book");

        // ACTION & ASSERTION
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
	}

}
