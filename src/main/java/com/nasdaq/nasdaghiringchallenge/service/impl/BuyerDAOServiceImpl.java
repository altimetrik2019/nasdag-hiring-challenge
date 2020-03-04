package com.nasdaq.nasdaghiringchallenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasdaq.nasdaghiringchallenge.exception.BidNotFoundException;
import com.nasdaq.nasdaghiringchallenge.exception.BuyerNotFoundException;
import com.nasdaq.nasdaghiringchallenge.mapper.BuyerMapper;
import com.nasdaq.nasdaghiringchallenge.model.BidEntity;
import com.nasdaq.nasdaghiringchallenge.model.BuyerEntity;
import com.nasdaq.nasdaghiringchallenge.model.dto.AuctionDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.BidDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.BuyerDTO;
import com.nasdaq.nasdaghiringchallenge.repository.BidRepository;
import com.nasdaq.nasdaghiringchallenge.repository.BuyerRepository;
import com.nasdaq.nasdaghiringchallenge.service.BuyerDAOService;
import com.nasdaq.nasdaghiringchallenge.service.SellerDAOService;

@Service
public class BuyerDAOServiceImpl implements BuyerDAOService {

    @Autowired
    private BuyerMapper buyerMapper;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private SellerDAOService sellerDAOService;

    @Override
    public BuyerDTO createBuyer(BuyerDTO buyer) {
        BuyerEntity entity = buyerMapper.toEntity(buyer);
        entity = buyerRepository.save(entity);
        return buyerMapper.fromEntity(entity);
    }

    @Override
    public BuyerDTO getBuyer(int id) {
        Optional<BuyerEntity> entities = buyerRepository.findById(id);
        if (entities.isPresent()) {
            return buyerMapper.fromEntity(entities.get());
        } else {
            throw new BuyerNotFoundException("Buyer Not Found");
        }

    }

    @Override
    public BidDTO bidAuction(BidDTO bid) {
        AuctionDTO auction = sellerDAOService.getAuction(bid.getAuction().getId());
        bid.setAuction(auction);
        BidEntity entity = buyerMapper.toEntity(bid);
        entity = bidRepository.save(entity);
        return buyerMapper.fromEntity(entity);
    }

    @Override
    public List<BidDTO> getBids(int id) {
        BuyerDTO b = getBuyer(id);
        return b.getBids();
    }

    @Override
    public BidDTO bidValueUpdate(BidDTO bid) {
        AuctionDTO auction = sellerDAOService.getAuction(bid.getAuction().getId());
        bid.setAuction(auction);
        Optional<BidEntity> entity = bidRepository.findById(bid.getId());
        if (entity.isPresent()) {
            return buyerMapper.fromEntity(entity.get());
        }
        throw new BidNotFoundException("Bid Not Found");
    }

}
