package com.nasdaq.nasdaghiringchallenge.service;

import com.nasdaq.nasdaghiringchallenge.model.dto.AuctionDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.ItemDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.SellerDTO;

public interface SellerDAOService {

    SellerDTO createSeller(SellerDTO seller);

    SellerDTO getSeller(int sellerId);

    AuctionDTO createAuction(AuctionDTO auction);

    AuctionDTO getAuction(int auctionId);

    ItemDTO createItem(ItemDTO item);

    AuctionDTO closeAuction(AuctionDTO auctionDTO);

}
