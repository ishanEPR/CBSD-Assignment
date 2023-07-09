package com.example.userservice.service;

import com.example.userservice.DTO.Asset;
import com.example.userservice.DTO.RequiredResponseAsset;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserService(UserRepository userRepository)
    {

        this.userRepository=userRepository;
    }
    public User saveUser(User user) {
        log.info("saveUser method in UserService(save the user Data)");
        return userRepository.save(user);
    }

    public List<User> displayUserData() {
        log.info("displayUserData method in UserService (display the all the list of users)");
        return userRepository.findAll();
    }

    public Optional<User> getUserData(int id) {
        log.info("getUserData method in UserService (display the a user data)");
        return userRepository.findById(id);
    }

    public List<User> findByAssetId(int id) {
        log.info("findByAssetId method in UserService (call from asset service(get the list of users)");

        List<User> listOfUser=userRepository.findByAssetId(id);
        return listOfUser;
    }


//    public RequiredResponseAsset getAssetsData(int id) {
//        RequiredResponseAsset requiredResponseAsset=new RequiredResponseAsset();
//
////        //get the user data
////        User user=userRepository.findById(id).get();
////        requiredResponseAsset.setUser(user);
////
////        //get list of assests
////        List<Asset> listOfAssst=restTemplate.getForObject("http://localhost:8081/asset/listAsset/userId/"+id,List.class);
////
////        requiredResponseAsset.setAssetList(listOfAssst);
////
////        return requiredResponseAsset;
////
////
////
////
////
////    }
}
