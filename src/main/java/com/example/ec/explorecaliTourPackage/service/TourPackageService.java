package com.example.ec.explorecaliTourPackage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.explorecaliTourPackage.domain.TourPackage;
import com.example.ec.explorecaliTourPackage.repository.TourPackageRepository;
import com.example.ec.explorecaliTourPackage.service.TourPackageService;
@Service
public class TourPackageService {
	private TourPackageRepository tourPackageRepository;
	 private Logger logger = LoggerFactory.getLogger(TourPackageService.class);

	  public void service(){
	    logger.debug("Message at DEBUG level from TourPackageService()");
	     }
	  
	  
	
	 public TourPackageService() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Autowired
	public TourPackageService(TourPackageRepository tourPackageRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
	}
public TourPackage createTourPackage(String code , String name)
{
	 logger.debug("Log message at create tour package"+code);

	if(!tourPackageRepository.exists(code))
	{
		tourPackageRepository.save(new TourPackage(code,name));
	}
	return null;
}
public Iterable<TourPackage> lookup()
{
	return tourPackageRepository.findAll();
}
	public long total()
	{
		return tourPackageRepository.count();
	}

}
