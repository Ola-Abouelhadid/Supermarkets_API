package com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.mapstruct;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.dtos.SupermarketDto;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(
        componentModel = "spring")
public interface MapStructMapper {
    List<SupermarketDto> supermarketToSupermarketDto(
            List<Supermarket> supermarket
    );
}
