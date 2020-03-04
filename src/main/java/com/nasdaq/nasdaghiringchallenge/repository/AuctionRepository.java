package com.nasdaq.nasdaghiringchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasdaq.nasdaghiringchallenge.model.AuctionEntity;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, Integer> {

}
