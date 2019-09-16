package com.upog.tennis.repository;

import org.springframework.stereotype.Repository;

import com.upog.tennis.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
