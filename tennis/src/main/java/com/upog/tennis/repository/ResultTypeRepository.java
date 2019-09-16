package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.ResultType;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResultTypeRepository extends JpaRepository<ResultType, Integer>{

}
