package com.rahadyan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Shelf {
	@Id
	private Integer shelfId;
	private int maxCapacity;
	private int currentCapacity;

	@JsonIgnore
	@OneToMany(mappedBy = "shelf")
	private List<Book> books = new ArrayList<>();

	public Shelf() {
		
	}

	public Shelf(Integer shelfId, int maxCapacity, int currentCapacity) {
		super();
		this.shelfId = shelfId;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = currentCapacity;
	}

	public Integer getShelfId() {
		return shelfId;
	}

	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
