package com.nasdaq.nasdaghiringchallenge.model.dto;

import java.math.BigDecimal;

import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ItemDTO {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private BigDecimal lowBid;

    @Getter
    @Setter
    private BigDecimal highestBid;

    @OneToOne(mappedBy = "item")
    @Getter
    @Setter
    private SellerDTO seller;

}
