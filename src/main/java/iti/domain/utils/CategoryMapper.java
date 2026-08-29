package iti.domain.utils;

import iti.domain.category.dtos.CategoryGetDto;
import iti.domain.category.dtos.CategoryPostDto;
import iti.entities.Category;

public class CategoryMapper {
    


    public static CategoryGetDto entityToGet( Category entity ) {
        return new CategoryGetDto(entity.getId(), entity.getName());
    }


    public static Category postToEntity( CategoryPostDto categoryPostDto ) {
        return new Category(categoryPostDto.getName(), null);
    }

}
