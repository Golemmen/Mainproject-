package com.example.repository;

import com.example.entity.MicrowaveUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrowaveUsageRepository extends JpaRepository<MicrowaveUsage, Long> {
}