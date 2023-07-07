package com.Segmatek.OlaAbouelhadid.SupermarketAPI.service;

import com.Segmatek.OlaAbouelhadid.SupermarketAPI.dao.SupermarketRepo;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SupermarketServiceImpl implements SupermarketService {
    //inject the SupermarketRepo here
    private SupermarketRepo supermarketRepo;

    @Autowired
    public SupermarketServiceImpl(SupermarketRepo supermarketRepo) {
        this.supermarketRepo = supermarketRepo;
    }
    //define here all the functions that will be used in the controller
    @Override
    public List<Supermarket> listAll() {
        return null;
    }

    @Override
    public Supermarket createSupermarket(Supermarket supermarket) {
        return null;
    }

    @Override
    public Supermarket updateSupermarket(Supermarket supermarket) {
        return null;
    }

    @Override
    public void deleteSupermarket(int id) {

    }

    @Override
    public Supermarket getSupermarketById(int id) {
        return null;
    }

    @Override
    public Supermarket activateSupermarket(int id) {
        return null;
    }

    @Override
    public Supermarket deactivateSupermarket(int id) {
        return null;
    }

}
