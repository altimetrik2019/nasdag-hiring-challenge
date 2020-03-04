package com.nasdaq.nasdaghiringchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasdaq.nasdaghiringchallenge.model.SellerEntity;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {

}
