package com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupermarketDto {

//I will add all the fields here except the id and the image to test mapping
    @JsonProperty("arabicName")
    private String arabicName;

    @JsonProperty("englishName")
    private String englishName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("active")
    private String active;
}
