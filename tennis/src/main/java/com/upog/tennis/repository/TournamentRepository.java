package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer>{

}
