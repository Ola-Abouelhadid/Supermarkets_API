package com.Segmatek.OlaAbouelhadid.SupermarketAPI.dao;

import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupermarketRepo extends JpaRepository<Supermarket, Integer> {
    //no need to write code here
    //JpaRepository has all the methods we need
    //such as findAll(), findById(), save(), deleteById()
    //which will be used for the crud operations


}
