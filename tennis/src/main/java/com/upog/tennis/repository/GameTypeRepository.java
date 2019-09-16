package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.GameType;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GameTypeRepository extends JpaRepository<GameType, Integer>{

}
