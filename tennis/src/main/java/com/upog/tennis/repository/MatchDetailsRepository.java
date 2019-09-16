package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.MatchDetails;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MatchDetailsRepository extends JpaRepository<MatchDetails, Integer>{

}
