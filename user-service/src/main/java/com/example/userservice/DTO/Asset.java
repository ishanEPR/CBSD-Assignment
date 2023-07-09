package com.example.userservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Asset {

    @Id
    private int id;

    private String assettName;

    private String serialNumber;


    private Date addDate=new Date(System.currentTimeMillis());

    private String warrentyPeriod;

//    private int userId;

}
