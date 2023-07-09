package com.example.assetservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String telephone;

    private String address;

    private int assetId;
}
