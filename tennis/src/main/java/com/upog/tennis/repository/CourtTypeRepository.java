package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.CourtType;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourtTypeRepository extends JpaRepository<CourtType, Integer>{

}
