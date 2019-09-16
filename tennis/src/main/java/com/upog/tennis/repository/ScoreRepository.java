package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer>{

}
