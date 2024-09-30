package com.estudando.cardapio.api.controller;

import com.estudando.cardapio.api.mapper.FoodMapper;
import com.estudando.cardapio.api.request.FoodRequestDto;
import com.estudando.cardapio.api.response.FoodResponseDto;
import com.estudando.cardapio.domain.entity.Food;
import com.estudando.cardapio.domain.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/list")
    public ResponseEntity<List<FoodResponseDto>> getAllFood(){
        List<Food> food = foodService.findAll();
        List<FoodResponseDto> response = FoodMapper.toFoodResponseList(food);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/listById/{id}")
    public ResponseEntity<FoodResponseDto> findById(@PathVariable("id") Long id){
        Optional<Food> byId = foodService.findById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(FoodMapper.returnFoodResponsePassFood(byId.get()));
    }

    @PostMapping("/")
    public ResponseEntity<FoodResponseDto> save (@RequestBody FoodRequestDto request){
        Food foodToSave = FoodMapper.returnFoodPassFoodRequest(request);
        Food foodSave = foodService.save(foodToSave);
        FoodResponseDto responseToSave = FoodMapper.returnFoodResponsePassFood(foodSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseToSave);
    }
}
