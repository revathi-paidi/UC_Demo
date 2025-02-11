package com.example.claim_service.mapper;

import com.example.claim_service.dto.ClaimRequestDto;
import com.example.claim_service.entity.Claim;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaimMapper {

    Claim toClaim(ClaimRequestDto claimRequestDto);
}
