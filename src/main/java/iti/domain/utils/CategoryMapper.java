package iti.domain.utils;

import iti.domain.category.dtos.CategoryGetDto;
import iti.domain.category.dtos.CategoryPostDto;
import iti.entities.Category;

public class CategoryMapper {
    


    public static CategoryGetDto entityToGet( Category entity ) {
        CategoryGetDto getDto = new CategoryGetDto(entity.getId(), entity.getName());
        return getDto;
    }


    public static Category postToEntity( CategoryPostDto categoryPostDto ) {
        Category category = new Category(categoryPostDto.getName(), null);
        return category;
    }

}
