package com.example.userservice.DTO;

import com.example.userservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredResponseAsset {

    private User user;
    private List<Asset> assetList;


}
