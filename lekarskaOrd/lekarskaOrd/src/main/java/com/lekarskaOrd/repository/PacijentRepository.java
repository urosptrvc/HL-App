package com.lekarskaOrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekarskaOrd.entity.Pacijent;

@Repository
public interface PacijentRepository extends JpaRepository<Pacijent,Integer>{

}
