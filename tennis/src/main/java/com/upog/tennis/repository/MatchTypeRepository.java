package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.MatchType;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MatchTypeRepository extends JpaRepository<MatchType, Integer>{

}
