package iti.services;

import java.util.List;
import java.util.stream.Collectors;

import iti.daos.CategoriesDao;
import iti.domain.category.dtos.CategoryGetDto;
import iti.domain.utils.CategoryMapper;

public class CategoryService {
    
    private CategoriesDao dao;

    public CategoryService(){
        this.dao = new CategoriesDao();
    }
       
    public CategoryGetDto findCategory(long id){
       var category =  dao.getCategoryById(id);
       if(category != null)
            return CategoryMapper.entityToGet(category);

        return null;
    }
    public List<CategoryGetDto> getAllCategories(){
        var categorydtos = dao.getAllCategories().stream().map(category ->{
            return CategoryMapper.entityToGet(category);
        }).collect(Collectors.toList());

        
        return categorydtos;
    }
    
}
