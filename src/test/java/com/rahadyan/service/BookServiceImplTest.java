package com.rahadyan.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeastOnce;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.rahadyan.model.Book;
import com.rahadyan.repo.BookRepository;

public class BookServiceImplTest {

	@InjectMocks
	private BookService bookService;
	@Mock
	private BookRepository bookRepository;
	
	@Test
	public void retriveByStatusTest() {
		// Preparation
        Mockito.when(bookRepository.findAllBookByStatus(Book.Status.NOT_SHELVED)).thenReturn(Arrays.asList(
                new Book(1, "123", "Java", "Oracle", Book.Status.NOT_SHELVED),
                new Book(2, "456", "PHP", "Zend", Book.Status.NOT_SHELVED)
        ));

        // Action
        List<Book> items = bookService.retriveByStatus("SHELVED");

        // Assertion 
        assertEquals(2, items.size());
        assertEquals(Book.Status.NOT_SHELVED, items.get(0).getStatus());
        // Verification
        Mockito.verify(bookRepository, atLeastOnce()).findAllBookByStatus(Book.Status.NOT_SHELVED);
	}

}
