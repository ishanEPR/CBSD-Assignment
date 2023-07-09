package com.example.assetservice.repository;

import com.example.assetservice.model.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends MongoRepository<Asset,Integer> {
   // List<Asset> findByUserId(int id);
}

