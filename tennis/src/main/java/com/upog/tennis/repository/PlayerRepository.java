package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
