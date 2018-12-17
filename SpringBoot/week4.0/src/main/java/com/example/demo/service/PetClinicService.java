package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Owner;

public interface PetClinicService {
	List<Owner> findOwners();
	List<Owner> findOwners(String lastName);
	void createOwner(Owner owner);
	void updateOwner(Owner owner);
	void deleteOwner(Long id);


}
