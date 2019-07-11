package com.hcl.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.banking.entity.Transcation;

@Repository
public interface TranscationRepository extends JpaRepository<Transcation, Long> {
  
}
