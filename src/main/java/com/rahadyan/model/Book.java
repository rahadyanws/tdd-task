package com.rahadyan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	@Id
	private Integer id;
	private String isbn;
	private String title;
	private String author;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "shelf_id")
	private Shelf shelf;

	public enum Status {
		SHELVED, NOT_SHELVED
	}

	public Book() {

	}

	public Book(Integer id, String isbn, String title, String author, Status status) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.status = status;
	}
	
	public Book(Integer id, String isbn, String title, String author, Status status, Shelf shelf) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.status = status;
		this.shelf = shelf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

}
