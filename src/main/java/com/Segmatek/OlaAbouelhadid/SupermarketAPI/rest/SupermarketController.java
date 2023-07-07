package com.Segmatek.OlaAbouelhadid.SupermarketAPI.rest;

import com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity.Supermarket;
import com.Segmatek.OlaAbouelhadid.SupermarketAPI.service.SupermarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//the base path for all the endpoints
@RequestMapping("/api")
public class SupermarketController {

    //inject the supermarket service
    private SupermarketService supermarketService;

    //inject the supermarket service using constructor injection
    public SupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    // will define here all the endpoints for the API
    // we will simply call the functions from the service layer

    // 1- List all supermarkets
    @GetMapping("/supermarkets")
    public List<Supermarket> listAll() {
        return supermarketService.listAll();
    }

    // 2- Add a new supermarket
    @PostMapping("/supermarkets")
    public Supermarket createSupermarket(@RequestBody Supermarket supermarket) {
        //this line will make sure that the id is set to 0
        //so that the save function will create a new supermarket instead of updating an existing one
        supermarket.setId(0);
        return supermarketService.saveSupermarket(supermarket);
    }
    // 3- Update a supermarket
    @PutMapping("/supermarkets/{id}")
    public Supermarket updateSupermarket(@PathVariable int id,@RequestBody Supermarket supermarket) {
        return supermarketService.updateSupermarket(id, supermarket);
    }

    // 4- Delete a supermarket
    @DeleteMapping("/supermarkets/{id}")
    public SupermarketService.CustomMessage deleteSupermarket(@PathVariable int id) {
        //check if the supermarket exists
        if (supermarketService.getSupermarketById(id) != null) {
            return supermarketService.deleteSupermarket(id);
        } else {
            throw new RuntimeException("Supermarket with id " + id + " doesn't exist");
        }
    }

    //5- Activate a supermarket
    @PutMapping("/supermarkets/activate/{id}")
    public Supermarket activateSupermarket(@PathVariable int id) {
        return supermarketService.activateSupermarket(id);
    }

    //6- Deactivate a supermarket
    @PutMapping("/supermarkets/deactivate/{id}")
    public Supermarket deactivateSupermarket(@PathVariable int id) {
        return supermarketService.deactivateSupermarket(id);
    }



}
