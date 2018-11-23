package com.rahadyan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahadyan.model.Book;
import com.rahadyan.model.Shelf;
@Service
public class LibraryService implements ILibraryService {

	private IShelfService shelfService;
	private IBookService bookServive;
	
	@Autowired
	public void setShelfService(IShelfService shelfService) {
		this.shelfService = shelfService;
	}
	
	@Autowired
	public void setBookServive(IBookService bookServive) {
		this.bookServive = bookServive;
	}
	
	@Override
	public String borrow(Integer shelf_id, Integer book_id, String command) {
		
		Shelf shelf = shelfService.get(shelf_id);
		Book book = bookServive.get(book_id);

		bookServive.doShelved(book, shelf, command);
		shelfService.updateCapacity(command,shelf);
		
		return "Thank you for borrow our book";
	}

}
