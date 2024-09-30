package com.estudando.cardapio.api.mapper;

import com.estudando.cardapio.api.request.FoodRequestDto;
import com.estudando.cardapio.api.response.FoodResponseDto;
import com.estudando.cardapio.domain.entity.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class FoodMapper {

    public static Food returnFoodPassFoodRequest(FoodRequestDto foodRequest){
        Food food = new Food();
        food.setTitle(foodRequest.getTitle());
        food.setImage(foodRequest.getImage());
        food.setPrice(foodRequest.getPrice());
        return food;

    }

    public static FoodResponseDto returnFoodResponsePassFood(Food food){

        FoodResponseDto responseDto = new FoodResponseDto();

        responseDto.setId(food.getId());
        responseDto.setTitle(food.getTitle());
        responseDto.setImage(food.getImage());
        responseDto.setPrice(food.getPrice());
        return responseDto;
    }


    public static List<FoodResponseDto> toFoodResponseList(List<Food> foods){
        List<FoodResponseDto> responses = new ArrayList<>();
        for (Food food : foods){
            responses.add(returnFoodResponsePassFood(food));
        }
        return responses;
    }
}
