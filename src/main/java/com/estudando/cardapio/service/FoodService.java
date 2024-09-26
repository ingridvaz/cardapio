package com.estudando.cardapio.service;

import com.estudando.cardapio.model.Food;
import com.estudando.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food save(Food food){
        return foodRepository.save(food);
    }
    public List<Food> findAll(){
        return foodRepository.findAll();
    }
    public Optional<Food> findById(Long id){
        return foodRepository.findById(id);
    }
    public void delete(Food food){
        foodRepository.delete(food);
    }
}
