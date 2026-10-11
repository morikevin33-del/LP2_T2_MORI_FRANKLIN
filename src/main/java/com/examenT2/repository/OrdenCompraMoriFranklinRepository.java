package com.examenT2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.entity.OrdenCompraMoriFranklin;

@Repository
public interface OrdenCompraMoriFranklinRepository extends JpaRepository<OrdenCompraMoriFranklin, Integer> {

	List<OrdenCompraMoriFranklin> findAllByOrderByNroOrdenDesc();
}
