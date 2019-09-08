package com.citi.report.repository;

import org.springframework.stereotype.Repository;

import com.citi.report.model.Connection;



import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Integer>{
	
	Connection findByConnectionId(int connectionId);
	Connection findByConnectionName(String connectionName);


}
