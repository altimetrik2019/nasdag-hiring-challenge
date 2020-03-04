package com.nasdaq.nasdaghiringchallenge.web;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nasdaq.nasdaghiringchallenge.model.dto.AuctionDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.BidDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.BuyerDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.ItemDTO;
import com.nasdaq.nasdaghiringchallenge.model.dto.SellerDTO;
import com.nasdaq.nasdaghiringchallenge.service.BuyerDAOService;
import com.nasdaq.nasdaghiringchallenge.service.SellerDAOService;

@RestController
public class AuctionController {

    @Autowired
    private SellerDAOService sellerDAOService;

    @Autowired
    private BuyerDAOService buyerDAOService;

    @PostMapping("/seller")
    // create a seller
    public SellerDTO createSeller(@Valid @RequestBody SellerDTO seller) {
        return sellerDAOService.createSeller(seller);
    }

    // create an item
    @PostMapping("/seller/{sellerId}/item")
    // create a seller
    public ItemDTO createItem(@PathVariable int sellerId, @RequestBody ItemDTO item) {
        SellerDTO seller = sellerDAOService.getSeller(sellerId);
        item.setSeller(seller);
        return sellerDAOService.createItem(item);
    }

    @GetMapping("/seller/{sellerId}")
    // create a seller
    public SellerDTO getSeller(@PathVariable int sellerId) {
        return sellerDAOService.getSeller(sellerId);
    }

    @PostMapping("/buyer")
    // create a buyer
    public BuyerDTO createBuyer(@Valid @RequestBody BuyerDTO buyer) {
        return buyerDAOService.createBuyer(buyer);
    }

    @GetMapping("/buyer/{buyerId}")
    // create a buyer
    public BuyerDTO getBuyer(@PathVariable int buyerId) {
        return buyerDAOService.getBuyer(buyerId);
    }

    @GetMapping("/buyer/{buyerId}/bids")
    // get a buyer bids
    public List<BidDTO> getBids(@PathVariable int buyerId) {
        return buyerDAOService.getBids(buyerId);
    }

    @PostMapping("/seller/{sellerId}/auction/item/{itemId}")
    // create a auction
    public AuctionDTO createAuction(@PathVariable int sellerId, @PathVariable int itemId) {
        AuctionDTO auction = AuctionDTO.of(sellerId, itemId);
        return sellerDAOService.createAuction(auction);
    }

    @GetMapping("/auction/{auctionId}")
    // get a auction
    public AuctionDTO getAuction(@PathVariable int auctionId) {
        return sellerDAOService.getAuction(auctionId);
    }

    @PostMapping("/buyer/{buyerId}/auction/{auctionId}")
    // create a auction
    public BidDTO bidAuction(@PathVariable int buyerId, @PathVariable int auctionId, @RequestBody BidDTO bid) {
        BuyerDTO buyerDTO = buyerDAOService.getBuyer(buyerId);
        AuctionDTO auction = AuctionDTO.of(auctionId);
        bid.setBuyer(buyerDTO);
        bid.setAuction(auction);
        return buyerDAOService.bidAuction(bid);
    }

    @PatchMapping("/buyer/{buyerId}/auction/{auctionId}/bids/{bidId}/value/{value}")
    // create a auction
    public BidDTO bidValueUpdate(@PathVariable int buyerId, @PathVariable int auctionId, @PathVariable int bidId,
            @PathVariable BigDecimal value) {
        BidDTO bid = BidDTO.of(bidId, value);
        BuyerDTO buyerDTO = buyerDAOService.getBuyer(buyerId);
        AuctionDTO auctionDTO = AuctionDTO.of(auctionId);
        bid.setBuyer(buyerDTO);
        bid.setAuction(auctionDTO);
        return buyerDAOService.bidValueUpdate(bid);
    }

    @PatchMapping("/seller/{sellerId}/auction/{auctionId}")
    // close an auction
    public AuctionDTO closeAuction(@PathVariable int sellerId, @PathVariable int auctionId) {
        AuctionDTO auctionDTO = AuctionDTO.of(auctionId);
        auctionDTO.setSellerId(sellerId);
        return sellerDAOService.closeAuction(auctionDTO);
    }

}
