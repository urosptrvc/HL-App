package com.lekarskaOrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lekarskaOrd.entity.Pacijent;
import com.lekarskaOrd.repository.PacijentRepository;

@Service
public class PacijentService {
	
	
	@Autowired
	private PacijentRepository bRepo;
	public void save(Pacijent p) {
		bRepo.save(p);
	}
	
	public List<Pacijent> getAllPacijent(){
		return bRepo.findAll();
	}
	
	public Pacijent getPacijentById(int id) {
		return bRepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
