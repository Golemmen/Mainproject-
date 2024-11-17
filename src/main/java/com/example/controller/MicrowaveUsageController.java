package com.example.controller;

import com.example.entity.MicrowaveUsage;
import com.example.repository.MicrowaveUsageRepository;
import com.example.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage")
public class MicrowaveUsageController {

    private final MicrowaveUsageRepository repository;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public MicrowaveUsageController(MicrowaveUsageRepository repository, KafkaProducerService kafkaProducerService) {
        this.repository = repository;
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping
    public List<MicrowaveUsage> getUsageStats() {
        return repository.findAll();
    }

    @PostMapping
    public MicrowaveUsage addUsageStat(@RequestBody MicrowaveUsage usage) {
        kafkaProducerService.sendEvent("New usage stat added: " + usage.getProgramName());
        return repository.save(usage);
    }
}