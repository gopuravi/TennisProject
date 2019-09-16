package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.ScheduleLogic;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleLogic, Integer>{

}
