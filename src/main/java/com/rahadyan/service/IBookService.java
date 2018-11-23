package com.rahadyan.service;

import java.util.List;

import com.rahadyan.model.Book;
import com.rahadyan.model.Shelf;

public interface IBookService {

	List<Book> retriveAll();

	List<Book> retriveByStatus(String status);

	List<Book> retriveByTitleStatus(String title, String status);

	Book get(Integer id);

	Book doShelved(Book book, Shelf shelf, String command);
}
