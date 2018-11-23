package com.rahadyan.service;

import java.util.List;

import com.rahadyan.model.Shelf;

public interface IShelfService {

	List<Shelf> retriveAll();

	Shelf get(Integer id);

	Shelf updateCapacity(String command, Shelf shelf);
}
