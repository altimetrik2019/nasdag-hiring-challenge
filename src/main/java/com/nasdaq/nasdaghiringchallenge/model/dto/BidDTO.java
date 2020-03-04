package com.nasdaq.nasdaghiringchallenge.model.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class BidDTO {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private BigDecimal value;

    @Getter
    @Setter
    private BigDecimal participationCost;

    @Getter
    @Setter
    private AuctionDTO auction;

    @Getter
    @Setter
    private BuyerDTO buyer;

    public static BidDTO of(int id, BigDecimal value) {
        BidDTO bid = new BidDTO();
        bid.setId(id);
        bid.setValue(value);
        return bid;
    }
}
