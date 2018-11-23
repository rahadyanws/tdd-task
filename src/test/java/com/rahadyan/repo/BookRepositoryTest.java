package com.rahadyan.repo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rahadyan.model.Book;
import com.rahadyan.repo.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void getBooksByStatusTest() {
		List<Book> books = bookRepository.findAllBookByStatus(Book.Status.NOT_SHELVED);
		
		assertEquals(Book.Status.NOT_SHELVED, books.get(0).getStatus());
	}
	
	@Test
	public void getBooksByTitleStatusTest() {
		List<Book> books = bookRepository.findAllBookByStatusAndTitleLikeIgnoreCase(Book.Status.NOT_SHELVED,"JPA");
		
		assertEquals("JPA", books.get(0).getTitle());
		assertEquals(Book.Status.NOT_SHELVED, books.get(0).getStatus());
	}
}