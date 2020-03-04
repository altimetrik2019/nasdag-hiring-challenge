package com.nasdaq.nasdaghiringchallenge.mapper;

import org.mapstruct.Mapper;

import com.nasdaq.nasdaghiringchallenge.model.BidEntity;
import com.nasdaq.nasdaghiringchallenge.model.BuyerEntity;
import com.nasdaq.nasdaghiringchallenge.model.dto.BidDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.BuyerDTO;

@Mapper(componentModel = "spring")
public interface BuyerMapper {
    BuyerEntity toEntity(BuyerDTO buyerDto);

    BuyerDTO fromEntity(BuyerEntity buyerEntity);

    BidEntity toEntity(BidDTO bidDto);

    BidDTO fromEntity(BidEntity bidEntity);
}
