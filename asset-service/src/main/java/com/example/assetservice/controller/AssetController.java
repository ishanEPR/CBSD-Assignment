package com.example.assetservice.controller;

import com.example.assetservice.DTO.RequiredResponse;
import com.example.assetservice.model.Asset;
import com.example.assetservice.service.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asset")
@Slf4j
public class AssetController {

    private AssetService assetService;

    public AssetController(AssetService assetService)
    {
        this.assetService=assetService;
    }

    @PostMapping()
    public Asset saveAsset(@RequestBody Asset asset)
    {
        log.info("saveAsset method in AssetController(save the Asset Data)");
        return assetService.saveAsset(asset);
    }

    @GetMapping()
    public List<Asset> displayAssetData()
    {
        log.info("displayAssetData method in AssetController (display the all the list of assets)");
        return assetService.displayAssetData();
    }

    @GetMapping("{id}")
    public Optional<Asset> getAssetData(@PathVariable int id)
    {
        log.info("getAssetData method in AssetController (display the a asset data)");
        return assetService.getAssetData(id);
    }

    //call to microservice (user service)
    @GetMapping("/id/{id}")
    public RequiredResponse displayResponseData(@PathVariable Integer id)
    {
        log.info("displayResponseData method in AssetController (call the micro service user service");
        return assetService.displayResponseData(id);
    }


   // call from user service(get the list of assets)
//    @GetMapping("/listAsset/userId/{id}")
//    public List<Asset> getListOfAssets(@PathVariable int id)
//    {
//        log.info("getListOfAssets method in AssetController (call from user service(get the list of assets)");
//        return assetService.getListOfAssets(id);
//    }
}
