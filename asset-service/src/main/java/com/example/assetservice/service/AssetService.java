package com.example.assetservice.service;

import com.example.assetservice.DTO.RequiredResponse;
import com.example.assetservice.DTO.User;
import com.example.assetservice.model.Asset;
import com.example.assetservice.repository.AssetRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AssetService {

    private RestTemplate restTemplate;
    private AssetRepository assetRepository;


    public AssetService(AssetRepository assetRepository,RestTemplate restTemplate)
    {
        this.assetRepository=assetRepository;
        this.restTemplate=restTemplate;
    }
    public Asset saveAsset(Asset asset) {
        log.info("saveAsset method in AssetService(save the Asset Data)");
        return assetRepository.save(asset);
    }

    public List<Asset> displayAssetData() {
        log.info("displayAssetData method in AssetService (display the all the list of assets)");
        return assetRepository.findAll();
    }

    public Optional<Asset> getAssetData(int id) {
        log.info("getAssetData method in AssetService (display the a asset data)");
        return assetRepository.findById(id);
    }

    //call to microservice (user service)
   // @HystrixCommand(fallbackMethod ="handleUserServiceDown")
    public RequiredResponse displayResponseData(Integer id) {
        log.info("displayResponseData method in AssetService (call the micro service user service");
        RequiredResponse requiredResponse=new RequiredResponse();

        //get the asset data
        Asset response=assetRepository.findById(id).get();
        requiredResponse.setAsset(response);

        //call the user microservices
        List<User> userList=restTemplate.getForObject("http://USER-SERVICE/user/id/"+id,List.class);
        requiredResponse.setUserList(userList);

        return requiredResponse;





    }

//    public RequiredResponse handleUserServiceDown(Integer id) {
//
//        RequiredResponse requiredResponse=new RequiredResponse();
//
//        //get the asset data
//        Asset response=assetRepository.findById(id).get();
//        requiredResponse.setAsset(response);
//
//        return requiredResponse;
//    }



    //call from user service(get the list of assets)
//    public List<Asset> getListOfAssets(int id) {
//
//        log.info("getListOfAssets method in AssetService (call from user service(get the list of assets)");
//        List<Asset> listofAsset=assetRepository.findByUserId(id);
//        return listofAsset;
//    }
}
