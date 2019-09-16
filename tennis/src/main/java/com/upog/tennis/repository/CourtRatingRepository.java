package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.CourtRating;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourtRatingRepository extends JpaRepository<CourtRating, Integer>{

}
