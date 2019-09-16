package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer>{

}
