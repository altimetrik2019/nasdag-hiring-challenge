package com.nasdaq.nasdaghiringchallenge.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "bid")
public class BidEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private BigDecimal value;

    @Getter
    @Setter
    private BigDecimal participationCost;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private AuctionEntity auction;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private BuyerEntity buyer;
}
