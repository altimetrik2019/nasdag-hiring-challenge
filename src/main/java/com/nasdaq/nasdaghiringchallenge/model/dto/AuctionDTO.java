package com.nasdaq.nasdaghiringchallenge.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class AuctionDTO {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int sellerId;

    @Getter
    @Setter
    private int itemId;

    @Getter
    @Setter
    private int winnerId;

    @Getter
    @Setter
    private BigDecimal profitOrLoss;

    @Getter
    @Setter
    private List<BidDTO> bids;

    public static AuctionDTO of(int sellerId, int itemId) {
        AuctionDTO auctionDTO = new AuctionDTO();
        auctionDTO.setItemId(itemId);
        auctionDTO.setSellerId(sellerId);
        return auctionDTO;
    }

    public static AuctionDTO of(int id) {
        AuctionDTO auctionDTO = new AuctionDTO();
        auctionDTO.setId(id);
        return auctionDTO;
    }
}
