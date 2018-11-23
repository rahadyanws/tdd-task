package com.rahadyan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahadyan.model.Book;
import com.rahadyan.model.Shelf;
import com.rahadyan.repo.BookRepository;

@Service
public class BookService implements IBookService {

	private BookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public List<Book> retriveByStatus(String status) {
		Book.Status statusEnum; // SHELVED / NOT_SHELVED
		try {
			statusEnum = Book.Status.valueOf(status.toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println("Status " + status + " Not Found");
			return new ArrayList<Book>();
		}
		List<Book> books = bookRepository.findAllBookByStatus(statusEnum);
		return books;
	}

	@Override
	public List<Book> retriveAll() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public List<Book> retriveByTitleStatus(String status, String title) {
		Book.Status statusEnum; // SHELVED / NOT_SHELVED
		try {
			statusEnum = Book.Status.valueOf(status.toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println("Status " + status + " Not Found");
			return new ArrayList<Book>();
		}
		List<Book> books = bookRepository.findAllBookByStatusAndTitleLikeIgnoreCase(statusEnum, "%"+title+"%");
		return books;
	}

	@Override
	public Book get(Integer id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book doShelved(Book book, Shelf shelf, String command) {
		if(command.equalsIgnoreCase("shelf")) {
			book.setShelf(shelf);
			book.setStatus(Book.Status.SHELVED);
		}
		if(command.equalsIgnoreCase("unshelf")) {
			book.setStatus(Book.Status.NOT_SHELVED);
		}
		return bookRepository.saveAndFlush(book);
	}

}
