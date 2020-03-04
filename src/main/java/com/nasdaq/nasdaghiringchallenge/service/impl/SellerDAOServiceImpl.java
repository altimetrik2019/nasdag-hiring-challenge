package com.nasdaq.nasdaghiringchallenge.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasdaq.nasdaghiringchallenge.exception.AuctionNotFoundException;
import com.nasdaq.nasdaghiringchallenge.exception.SellerNotFoundException;
import com.nasdaq.nasdaghiringchallenge.mapper.SellerMapper;
import com.nasdaq.nasdaghiringchallenge.model.AuctionEntity;
import com.nasdaq.nasdaghiringchallenge.model.ItemEntity;
import com.nasdaq.nasdaghiringchallenge.model.SellerEntity;
import com.nasdaq.nasdaghiringchallenge.model.dto.AuctionDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.BidDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.ItemDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.SellerDTO;
import com.nasdaq.nasdaghiringchallenge.repository.AuctionRepository;
import com.nasdaq.nasdaghiringchallenge.repository.ItemRepository;
import com.nasdaq.nasdaghiringchallenge.repository.SellerRepository;
import com.nasdaq.nasdaghiringchallenge.service.SellerDAOService;

@Service
public class SellerDAOServiceImpl implements SellerDAOService {

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public SellerDTO createSeller(SellerDTO seller) {
        SellerEntity entity = sellerMapper.toEntity(seller);
        entity = sellerRepository.save(entity);
        return sellerMapper.fromEntity(entity);
    }

    @Override
    public AuctionDTO createAuction(AuctionDTO auction) {
        AuctionEntity entity = sellerMapper.toEntity(auction);
        entity = auctionRepository.save(entity);
        return sellerMapper.fromEntity(entity);
    }

    @Override
    public SellerDTO getSeller(int sellerId) {
        Optional<SellerEntity> entity = sellerRepository.findById(sellerId);
        if (entity.isPresent()) {
            return sellerMapper.fromEntity(entity.get());
        }
        throw new SellerNotFoundException("Seller Not Found");
    }

    @Override
    public ItemDTO createItem(ItemDTO item) {
        ItemEntity entity = sellerMapper.toEntity(item);
        entity = itemRepository.save(entity);
        return sellerMapper.fromEntity(entity);
    }

    @Override
    public AuctionDTO getAuction(int auctionId) {
        Optional<AuctionEntity> entity = auctionRepository.findById(auctionId);
        if (entity.isPresent()) {
            return sellerMapper.fromEntity(entity.get());
        }
        throw new AuctionNotFoundException("Auction Not present");
    }

    @Override
    public AuctionDTO closeAuction(AuctionDTO auctionDTO) {
        auctionDTO = getAuction(auctionDTO.getId());
        Map<BigDecimal, List<BidDTO>> bidList = new HashMap<>();
        for (BidDTO bid : auctionDTO.getBids()) {
            List<BidDTO> filteredList = bidList.get(bid.getValue());
            if (filteredList == null) {
                filteredList = new ArrayList<>();
            }
            filteredList.add(bid);
            bidList.put(bid.getValue(), filteredList);
        }
        for (Map.Entry<BigDecimal, List<BidDTO>> entry : bidList.entrySet()) {
            if (entry.getValue().size() == 1) {
                auctionDTO.setWinnerId(entry.getValue().get(0).getBuyer().getId());
            }
        }
        return auctionDTO;
    }

}
