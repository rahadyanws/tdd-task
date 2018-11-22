package com.rahadyan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahadyan.model.Shelf;

public interface ShelfRepository extends JpaRepository<Shelf, Integer> {

}
