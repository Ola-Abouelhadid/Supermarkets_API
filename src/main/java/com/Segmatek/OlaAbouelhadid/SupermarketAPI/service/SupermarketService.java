package com.Segmatek.OlaAbouelhadid.SupermarketAPI.service;

import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.dtos.SupermarketDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupermarketService {
    record CustomMessage(String message) {}
    //define here all the functions that will be used in the controller

    //1- List supermarkets (read)
    ResponseEntity<List<SupermarketDto>> listAll();

    //2- Add a new supermarket (create)
    Supermarket saveSupermarket(Supermarket supermarket);

    //3- Update a supermarket (update)
    Supermarket updateSupermarket(int id, Supermarket supermarket);

    //4- Delete a supermarket (delete)
    CustomMessage deleteSupermarket(int id);

    //5- Get a supermarket by id
    Supermarket getSupermarketById(int id);

    //6- activate a supermarket
    CustomMessage activateSupermarket(int id);

    //7- deactivate a supermarket
    CustomMessage deactivateSupermarket(int id);
}
