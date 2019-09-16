package com.upog.tennis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.upog.tennis.repository.AddressRepository;


@Component
public class AddressDaoImpl {
	
	@Autowired
	private AddressRepository addressRepository;
	
}
