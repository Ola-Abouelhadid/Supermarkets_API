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
        return supermarketRepo.findAll();
    }

    @Override
    public Supermarket saveSupermarket(Supermarket supermarket) {
        return supermarketRepo.save(supermarket);
    }

    @Override
    public void deleteSupermarket(int id) {
        supermarketRepo.deleteById(id);

    }

    @Override
    public Supermarket getSupermarketById(int id)
    {
        //check if the supermarket exists
        //if it exists, return it
        //if it doesn't exist, throw an exception
        if (supermarketRepo.findById(id).isPresent())
        {
            return supermarketRepo.findById(id).get();
        }
        else
        {
            throw new RuntimeException("Supermarket with id " + id + " doesn't exist");
        }


    }

    @Override
    public Supermarket activateSupermarket(int id) {

        if (supermarketRepo.findById(id).isPresent())
        {
            Supermarket supermarket = supermarketRepo.findById(id).get();
            if (supermarket.isActive())
            {
                throw new RuntimeException("Supermarket with id " + id + " is already active");
            }
            else
            {
                supermarket.setActive(true);
                return supermarketRepo.save(supermarket);
            }
        }
        else
        {
            throw new RuntimeException("Supermarket with id " + id + " doesn't exist");
        }
    }

    @Override
    public Supermarket deactivateSupermarket(int id) {
        if (supermarketRepo.findById(id).isPresent())
        {
            Supermarket supermarket = supermarketRepo.findById(id).get();
            if (!supermarket.isActive())
            {
                throw new RuntimeException("Supermarket with id " + id + " is already inactive");
            }
            else
            {
                supermarket.setActive(false);
                return supermarketRepo.save(supermarket);
            }
        }
        else
        {
            throw new RuntimeException("Supermarket with id " + id + " doesn't exist");
        }
    }

}
