package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.AccessType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccessTypeRepository extends JpaRepository<AccessType, Integer>{

}
