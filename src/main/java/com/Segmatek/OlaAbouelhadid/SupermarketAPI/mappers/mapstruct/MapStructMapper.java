package com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.mapstruct;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.dtos.SupermarketDto;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(
        componentModel = "spring")
public interface MapStructMapper {
    //mapstruct will automatically generate the implementation of this method

    //this method is for mapping the entity supermarket to the dto
    SupermarketDto supermarketToSupermarketDto(
            Supermarket supermarket
    );

    //this method is for mapping the dto to the entity supermarket
    Supermarket supermarketDtoToSupermarket(
            SupermarketDto supermarketDto
    );
}
