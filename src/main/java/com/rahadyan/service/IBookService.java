package com.rahadyan.service;

import java.util.List;

import com.rahadyan.model.Book;

public interface IBookService {

    List<Book> retriveByStatus(Book book);
}
