package com.rahadyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rahadyan.model.Book;
import com.rahadyan.service.IBookService;

@RestController
public class BookController {
	private IBookService bookService;

	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/book")
	public List<Book> retriveAll() {
		return bookService.retriveAll();
	}
	
	@GetMapping(value="/book", params= {"status", "title"})
	public List<Book> retriveBooksByTitleAndStatus(@RequestParam String status, @RequestParam String title) {
		return bookService.retriveByTitleStatus(status, title);
	}
	@RequestMapping("/book/{status}/{title}")
//	@GetMapping(value="/book", params="status")
	public List<Book> retriveNotShelvedBook(@RequestParam String status) {
		System.out.println(status);
		return bookService.retriveByStatus(status);
	}
}
