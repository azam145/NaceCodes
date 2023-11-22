package com.example.hclexercise.repository;

import com.example.hclexercise.entity.NaceCodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaceRepository extends JpaRepository<NaceCodes, Long>{
}
