package com.example.claim_service.service;

import com.example.claim_service.dto.ClaimRequestDto;
import com.example.claim_service.entity.Claim;
import com.example.claim_service.enums.ClaimStatus;
import com.example.claim_service.kafka.Producer;
import com.example.claim_service.mapper.ClaimMapper;
import com.example.claim_service.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClaimService {
    private final ClaimRepository claimRepository;
    private final ClaimMapper claimMapper;
    private final Producer kafkaProducerService;

    public Claim createClaim(ClaimRequestDto claimRequestDto) {
        Claim claim = claimMapper.toClaim(claimRequestDto);
        claim.setStatus(ClaimStatus.PENDING);
        Claim savedClaim = claimRepository.save(claim);
        // Send event to Kafka
        kafkaProducerService.sendMessage("claim-created-topic", claimRequestDto);
       // kafkaProducerService.sendMessage("audit-log-topic", savedClaim);
        return savedClaim;
    }
}
