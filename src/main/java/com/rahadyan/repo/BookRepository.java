package com.rahadyan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rahadyan.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query("SELECT b FROM Book b WHERE b.status = :status")
    List<Book> findBookByStatus(Book book);
}
