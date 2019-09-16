package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.TournamentPlayerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TournamentPlayerDetailsRepository extends JpaRepository<TournamentPlayerDetails, Integer>{

}
