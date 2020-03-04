package com.nasdaq.nasdaghiringchallenge.mapper;

import org.mapstruct.Mapper;

import com.nasdaq.nasdaghiringchallenge.model.AuctionEntity;
import com.nasdaq.nasdaghiringchallenge.model.ItemEntity;
import com.nasdaq.nasdaghiringchallenge.model.SellerEntity;
import com.nasdaq.nasdaghiringchallenge.model.dto.AuctionDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.ItemDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.SellerDTO;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    SellerEntity toEntity(SellerDTO sellerDto);

    SellerDTO fromEntity(SellerEntity sellerEntity);

    AuctionEntity toEntity(AuctionDTO auctionDto);

    AuctionDTO fromEntity(AuctionEntity auctionEntity);

    ItemEntity toEntity(ItemDTO itemDto);

    ItemDTO fromEntity(ItemEntity itemEntity);

}
