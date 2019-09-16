package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SexRepository extends JpaRepository<Sex, Integer>{

}
