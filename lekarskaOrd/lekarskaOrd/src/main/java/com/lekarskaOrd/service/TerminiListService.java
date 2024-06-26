package com.lekarskaOrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lekarskaOrd.entity.TerminiList;
import com.lekarskaOrd.repository.TerminiRepository;

@Service
public class TerminiListService {
	
	
	@Autowired
	private TerminiRepository t;
	
	public void saveTermini(TerminiList termin) {
		t.save(termin);
	}
	
	public List<TerminiList> getAllTermini(){
		return t.findAll();
	}
	
	public void deleteById(int id) {
		t.deleteById(id);
	}
	
	public TerminiList getTerminById(int id) {
		return t.findById(id).get();
	}
}
