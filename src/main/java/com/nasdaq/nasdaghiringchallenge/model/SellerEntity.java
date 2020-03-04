package com.nasdaq.nasdaghiringchallenge.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "seller")
public class SellerEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @Getter
    @Setter
    private ItemEntity item;

}   
