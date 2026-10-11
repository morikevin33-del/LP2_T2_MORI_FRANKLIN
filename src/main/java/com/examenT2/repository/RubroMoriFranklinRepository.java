package com.examenT2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.entity.RubroMoriFranklin;

@Repository
public interface RubroMoriFranklinRepository extends JpaRepository<RubroMoriFranklin, Integer> {
}
