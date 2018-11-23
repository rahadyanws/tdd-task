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

import com.rahadyan.model.Shelf;
import com.rahadyan.service.BookService;
import com.rahadyan.service.LibraryService;
import com.rahadyan.service.ShelfService;

@RunWith(SpringRunner.class)
@WebMvcTest(ShelfController.class)
public class ShelfControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private ShelfService shelfService;
	@MockBean
	private BookService bookService;
	@MockBean
	private LibraryService libraryService;

	@Test
	public void retriveAllTest() throws Exception {
		// PREPARATION
        when(shelfService.retriveAll()).thenReturn(Arrays.asList(
        		new Shelf(1,5, 0),
        		new Shelf(2,10, 0)
        ));

        // Call GET /all-items return status 200, content json array
        RequestBuilder request = MockMvcRequestBuilders.get("/shelf");

        // ACTION & ASSERTION
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}]"));
	}

}
