package com.Segmatek.OlaAbouelhadid.SupermarketAPI.service;

import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;

import java.util.List;

public interface SupermarketService {
    //define here all the functions that will be used in the controller

    //1- List supermarkets (read)
    List<Supermarket> listAll();

    //2- Add a new supermarket (create)
    //3- Update a supermarket (update)
    Supermarket saveSupermarket(Supermarket supermarket);


    //4- Delete a supermarket (delete)
    void deleteSupermarket(int id);

    //5- Get a supermarket by id
    Supermarket getSupermarketById(int id);

    //6- activate a supermarket
    Supermarket activateSupermarket(int id);

    //7- deactivate a supermarket
    Supermarket deactivateSupermarket(int id);
}
