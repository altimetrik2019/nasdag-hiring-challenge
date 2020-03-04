package com.nasdaq.nasdaghiringchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasdaq.nasdaghiringchallenge.model.BuyerEntity;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Integer> {

}
