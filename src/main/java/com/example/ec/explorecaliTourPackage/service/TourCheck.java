package com.example.ec.explorecaliTourPackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.explorecaliTourPackage.domain.TourPackage;
import com.example.ec.explorecaliTourPackage.repository.TourPackageRepository;
import com.example.ec.explorecaliTourPackage.service.TourPackageService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(path="/tourChk/{tourPkgCode}")
public class TourCheck {
	/*@Autowired
	private TourPackageService tourPackageService;
	@Autowired
	private TourService tourService;*/
	@Autowired
	private TourPackageRepository tourPackageRepository;
	
	
	@GetMapping
	public String chkTour(@PathVariable(value="tourPkgCode") String tourId)
	{
		TourPackage tp=tourPackageRepository.findByCode(tourId);
		String namee=tp.getName();
		String codee=tp.getCode();
		System.out.println("nameeeeeee"+namee);
		if(namee.equals(null))
			return null;
		
			return namee;
	}

	
	
	
}
