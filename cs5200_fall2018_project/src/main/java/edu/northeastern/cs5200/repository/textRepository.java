package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.northeastern.cs5200.model.Fan;

public interface textRepository extends JpaRepository<Fan, Integer>{

}
