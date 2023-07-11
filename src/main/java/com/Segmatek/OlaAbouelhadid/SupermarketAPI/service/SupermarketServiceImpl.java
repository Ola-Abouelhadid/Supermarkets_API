package com.Segmatek.OlaAbouelhadid.SupermarketAPI.service;

import com.Segmatek.OlaAbouelhadid.SupermarketAPI.dao.SupermarketRepo;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.exception.SupermarketNotFoundException;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.dtos.SupermarketDto;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.mappers.mapstruct.MapStructMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupermarketServiceImpl implements SupermarketService {
    //inject the SupermarketRepo here
    private SupermarketRepo supermarketRepo;
    private MapStructMapper mapstructMapper;

    @Autowired
    public SupermarketServiceImpl(SupermarketRepo supermarketRepo, MapStructMapper mapstructMapper) {
        this.supermarketRepo = supermarketRepo;
        this.mapstructMapper = mapstructMapper;
    }
    //define here all the functions that will be used in the controller
    @Override
//    public List<Supermarket> listAll() {
//        return supermarketRepo.findAll();
//    }
    public ResponseEntity<List<SupermarketDto>> listAll() {
        //create an empty list of SupermarketDto
        List<SupermarketDto> supermarketDtoList = new ArrayList<>();
        List<Supermarket> supermarketList = supermarketRepo.findAll();

        //return only the active supermarkets
        //with java stream
        supermarketList.stream().filter(Supermarket::isActive).forEach(supermarket -> supermarketDtoList.add(mapstructMapper.supermarketToSupermarketDto(supermarket)));
//        for (Supermarket supermarket : supermarketRepo.findAll()) {
//
//            supermarketDtoList.add(mapstructMapper.supermarketToSupermarketDto(supermarket));
//        }
        //return the list of supermarketDto
        return new ResponseEntity<>(supermarketDtoList, HttpStatus.OK);
    }

    @Override
    public SupermarketDto saveSupermarket(SupermarketDto supermarket) {
        return mapstructMapper.supermarketToSupermarketDto(supermarketRepo.save(mapstructMapper.supermarketDtoToSupermarket(supermarket)));
    }

    @Override
    public SupermarketDto updateSupermarket(int id, SupermarketDto supermarket){
        if (supermarketRepo.findById(id).isPresent())
        {

            Supermarket existingSupermarket = supermarketRepo.findById(id).get();
            if (supermarket.getArabicName() != null)
                existingSupermarket.setArabicName(supermarket.getArabicName());
            if (supermarket.getEnglishName() != null)
                existingSupermarket.setEnglishName(supermarket.getEnglishName());
            if (supermarket.getAddress() != null)
                existingSupermarket.setAddress(supermarket.getAddress());
            if (supermarket.getImage() != null)
                existingSupermarket.setImage(supermarket.getImage());

            return mapstructMapper.supermarketToSupermarketDto(supermarketRepo.save(existingSupermarket));
        }
        else
        {
            throw new SupermarketNotFoundException("Supermarket with id " + id + " doesn't exist");
        }
    }

    @Override
    public CustomMessage deleteSupermarket(int id) {
        supermarketRepo.deleteById(id);
        return new CustomMessage("Supermarket with id " + id + " was deleted successfully");

    }

    @Override
    public SupermarketDto getSupermarketById(int id)
    {
        //check if the supermarket exists
        //if it exists, return it
        //if it doesn't exist, throw an exception
        if (supermarketRepo.findById(id).isPresent())
        {
            return mapstructMapper.supermarketToSupermarketDto(supermarketRepo.findById(id).get());
        }
        else
        {
            throw new SupermarketNotFoundException("Supermarket with id " + id + " doesn't exist");
        }


    }

    @Override
    public CustomMessage activateSupermarket(int id) {

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
                supermarketRepo.save(supermarket);
                return new CustomMessage("Supermarket with id " + id + " was activated successfully");
            }
        }
        else
        {
            throw new SupermarketNotFoundException("Supermarket with id " + id + " doesn't exist");
        }
    }

    @Override
    public CustomMessage deactivateSupermarket(int id) {
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
                supermarketRepo.save(supermarket);
                return new CustomMessage("Supermarket with id " + id + " was deactivated successfully");
            }
        }
        else
        {
            throw new SupermarketNotFoundException("Supermarket with id " + id + " doesn't exist");
        }
    }

}
