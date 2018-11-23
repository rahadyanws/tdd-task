package com.rahadyan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahadyan.model.Shelf;
import com.rahadyan.repo.ShelfRepository;

@Service
public class ShelfService implements IShelfService {

	private ShelfRepository shelfRepository;

	@Autowired
	public void setShelfRepository(ShelfRepository shelfRepository) {
		this.shelfRepository = shelfRepository;
	}

	@Override
	public List<Shelf> retriveAll() {
		return shelfRepository.findAll();
	}

	@Override
	public Shelf get(Integer id) {
		Shelf shelf = shelfRepository.findById(id).orElse(new Shelf());
		return shelf;
	}

	@Override
	public Shelf updateCapacity(String command, Shelf shelf) {
		if(command.equalsIgnoreCase("shelf")) {
			shelf.setCurrentCapacity(shelf.getCurrentCapacity()+1);
		}
		if(command.equalsIgnoreCase("unshelf")) {
			shelf.setCurrentCapacity(shelf.getCurrentCapacity()-1);
		}
		
		return shelfRepository.saveAndFlush(shelf);
	}

}
