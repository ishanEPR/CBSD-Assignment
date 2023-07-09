package com.example.assetservice.DTO;

import com.example.assetservice.model.Asset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

    private Asset asset;
    private List<User> userList;

}
