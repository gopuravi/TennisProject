package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ScheduleLogicRepository extends JpaRepository<Schedule, Integer>{

}
