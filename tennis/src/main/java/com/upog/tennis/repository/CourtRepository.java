package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourtRepository extends JpaRepository<Court, Integer>{

}
