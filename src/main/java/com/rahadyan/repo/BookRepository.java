package com.rahadyan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahadyan.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllBookByStatus(Book.Status status);

	List<Book> findAllBookByStatusAndTitleLikeIgnoreCase(Book.Status status, String title);
	
}
