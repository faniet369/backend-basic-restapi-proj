package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.FaEntity;

@Repository
public interface FaJPARepository extends JpaRepository<FaEntity, Long> {

}

