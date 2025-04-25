package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl){
        this.burgerDaoImpl=burgerDaoImpl;
    }

    @GetMapping("/")
    public List<Burger> getAll(){
        return this.burgerDaoImpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable("id") long id){
        return this.burgerDaoImpl.findById(id);
    }

    @PostMapping("/")
    public Burger save(@RequestBody Burger burger){
        Burger savedBurger = burgerDaoImpl.save(burger);
        return savedBurger;
    }

//    @PutMapping("/{id}")
//    public Burger update(@PathVariable long id, @RequestBody Burger burger){
//        Burger updatedBurger = this.burgerDaoImpl.findById(id);
//        return this.burgerDaoImpl.update(burger);
//    }

    @PutMapping
    public Burger update (@RequestBody Burger burger){
        return burgerDaoImpl.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable("id") long id){
        return burgerDaoImpl.remove(id);
    }

    @GetMapping("/{price}")
    public List<Burger> findByPrice(@PathVariable("price") Integer price){
        return burgerDaoImpl.findByPrice(price);
    }

    @GetMapping("/{breadType}")
    public List<Burger> findByBreadType(@PathVariable("breadType") BreadType breadType){
        return burgerDaoImpl.findByBreadType(breadType);
    }

    @GetMapping("/{content}")
    public List<Burger> findByContent(@PathVariable("content") String content){
        return burgerDaoImpl.findByContent(content);
    }

}
