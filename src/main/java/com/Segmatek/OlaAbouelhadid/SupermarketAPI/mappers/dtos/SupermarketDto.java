package com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupermarketDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("arabicName")
    private String arabicName;

    @JsonProperty("englishName")
    private String englishName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("image")
    private String image;

    @JsonProperty("active")
    private String active;
}
