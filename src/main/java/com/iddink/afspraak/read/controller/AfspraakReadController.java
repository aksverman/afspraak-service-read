package com.iddink.afspraak.read.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iddink.afspraak.read.entity.Afspraak;
import com.iddink.afspraak.read.repository.AfspraakRepository;

@RestController("/afspraak")
public class AfspraakReadController {
	
	@Autowired
	private AfspraakRepository afspraakRepository;
	
	@GetMapping("/getAllAfsfpraak")
	public Iterable<Afspraak> getAfspraaken() {
		
		Iterable<Afspraak> afspraaken = afspraakRepository.findAll();
		
		return afspraaken;
	}
}
