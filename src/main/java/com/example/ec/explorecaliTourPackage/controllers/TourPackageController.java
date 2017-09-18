package com.example.ec.explorecaliTourPackage.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.example.ec.explorecaliTourPackage.domain.TourPackage;
import com.example.ec.explorecaliTourPackage.repository.TourPackageRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping(path="/tours/packages")
public class TourPackageController {
	TourPackageRepository tourPackageRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	public TourPackageController(TourPackageRepository tourPackageRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
		
	}
	@HystrixCommand(fallbackMethod="fallback1")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createTourPackage(@RequestBody @Validated TourPackage tourPkgDto)
	{
		String code,name;
		code=tourPkgDto.getCode();
		name=tourPkgDto.getName();
		String url="http://explorecaliTour/tours/packages/"+code+"/"+name;
		String url1="http://explorecali/tours/packages/"+code+"/"+name;
	String abc,pqr;
	abc= restTemplate.getForObject(url,String.class);
	pqr=restTemplate.getForObject(url1,String.class);
	if(abc.equals("saved") && pqr.equals("saved"))
		{tourPackageRepository.save(new TourPackage(tourPkgDto.getCode(),tourPkgDto.getName()));
		//tourRatingService.createTourPkg(tour,tourId,ratingDto,tourRatingRepository);
	return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	else
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	public ResponseEntity<String> fallback1(TourPackage tourPkgDto)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
