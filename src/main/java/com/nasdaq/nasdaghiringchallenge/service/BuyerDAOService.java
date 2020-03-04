package com.nasdaq.nasdaghiringchallenge.service;

import java.util.List;

import com.nasdaq.nasdaghiringchallenge.model.dto.BidDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.BuyerDTO;

public interface BuyerDAOService {

    BuyerDTO createBuyer(BuyerDTO buyer);

    BuyerDTO getBuyer(int id);

    BidDTO bidAuction(BidDTO bid);

    List<BidDTO> getBids(int id);

    BidDTO bidValueUpdate(BidDTO bid);

}
