package com.rahadyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rahadyan.model.Book;
import com.rahadyan.model.Shelf;
import com.rahadyan.service.IBookService;
import com.rahadyan.service.ILibraryService;
import com.rahadyan.service.IShelfService;

@RestController
public class ShelfController {
	private IShelfService shelfService;
	private IBookService bookServive;
	private ILibraryService libraryService;
	
	@Autowired
	public void setShelfService(IShelfService shelfService) {
		this.shelfService = shelfService;
	}
	
	@Autowired
	public void setBookServive(IBookService bookServive) {
		this.bookServive = bookServive;
	}
	
	@Autowired
	public void setLibraryService(ILibraryService libraryService) {
		this.libraryService = libraryService;
	}

	@GetMapping("/shelf")
	public List<Shelf> retriveAll() {
		return shelfService.retriveAll();
	}
	
	@GetMapping("/shelf/{id}")
	public Shelf retriveById(@PathVariable String id) {
		return shelfService.get(Integer.parseInt(id));
	}
	
	@GetMapping("/borrow/{shelf_id}/book/{book_id}/{command}")
	public String borrow(@PathVariable Integer shelf_id, @PathVariable Integer book_id, @PathVariable String command) {
		return libraryService.borrow(shelf_id, book_id, command);
	}
}
