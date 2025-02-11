package com.example.claim_service.controller;

import com.example.claim_service.dto.ClaimRequestDto;
import com.example.claim_service.dto.EmployerResponseDto;
import com.example.claim_service.entity.Claim;
import com.example.claim_service.kafka.Producer;
import com.example.claim_service.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claims")
@RequiredArgsConstructor
public class ClaimController {

    private final Producer kafkaProducerService;
    private final ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody ClaimRequestDto claimRequestDto) {
        Claim savedClaim = claimService.createClaim(claimRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClaim);
    }
//    @PostMapping("/send-response")
//    public ResponseEntity<String> sendResponse(@RequestBody EmployerResponseDto responseDto) {
//        kafkaProducerService.sendMessage(responseDto);
//        return ResponseEntity.ok("Claim event sent to employer service.");
//    }
}
