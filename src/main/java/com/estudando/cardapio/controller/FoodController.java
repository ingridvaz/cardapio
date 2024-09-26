package com.estudando.cardapio.controller;

import com.estudando.cardapio.model.Food;
import com.estudando.cardapio.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "+", allowedHeaders = "*")
    @GetMapping("/list")
    public List<Food> getAllFood(){
        return foodService.findAll();
    }

    @CrossOrigin(origins = "+", allowedHeaders = "*")
    @GetMapping("/list/{id}")
    public Optional<Food> findById(@PathVariable("id") Long id){
        return foodService.findById(id);
    }

    @CrossOrigin(origins = "+", allowedHeaders = "*")
    @PostMapping("/")
    public Food save (@RequestBody Food food){
        return foodService.save(food);
    }
}
