package com.example.ec.explorecaliTourPackage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ec.explorecaliTourPackage.domain.TourPackage;


public interface TourPackageRepository extends CrudRepository<TourPackage,String> {
	TourPackage findByName(@Param("name")String name);
	TourPackage findByCode(@Param("code")String code);
}
