package com.lekarskaOrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekarskaOrd.entity.TerminiList;

@Repository
public interface TerminiRepository extends JpaRepository<TerminiList, Integer>{

}
