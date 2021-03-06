package com.nasdaq.nasdaghiringchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasdaq.nasdaghiringchallenge.model.BidEntity;

@Repository
public interface BidRepository extends JpaRepository<BidEntity, Integer> {

}
