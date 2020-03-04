package com.nasdaq.nasdaghiringchallenge.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Size(min = 2, message = "Name should have atleast 2 characters")
    @Column(name = "name")
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
    private SellerEntity seller;

}
