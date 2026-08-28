package iti.services;

import java.util.List;
import java.util.stream.Collectors;

import iti.daos.CategoriesDao;
import iti.domain.category.dtos.CategoryGetDto;
import iti.domain.category.dtos.CategoryPostDto;
import iti.domain.utils.CategoryMapper;

public class CategoryService {
    
    private final CategoriesDao dao;

    public CategoryService(){
        this.dao = new CategoriesDao();
    }
       
    public CategoryGetDto findCategory(long id){
       var category =  dao.getCategoryById(id);
       return (category != null)? CategoryMapper.entityToGet(category): null;
    }
    public List<CategoryGetDto> getAllCategories(){

        return dao.getAllCategories()
                .stream()
                .map(CategoryMapper::entityToGet)
                .collect(Collectors.toList());
    }


    public void addCategory(CategoryPostDto categoryDto){
       var category =  CategoryMapper.postToEntity(categoryDto);
       dao.addCategory(category);
    }

    public void deleteCategory(long id){
        dao.deleteCategory(id);
    }

    public void deleteAllCategories(){
        dao.deleteAllCategories();
    }
    
}
