package iti.domain.utils;

import iti.domain.product.dtos.ProductGetDto;
import iti.domain.product.dtos.ProductPostDto;
import iti.entities.Product;

public class ProductMapper {
    

    public static ProductGetDto entityToGet( Product entity ) {
        ProductGetDto getDto = new ProductGetDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getQuantity());
        return getDto;
    }

    public static Product postToEntity( ProductPostDto productPostDto ) {
        Product product = new Product(productPostDto.getName(), productPostDto.getPrice(), productPostDto.getQuantity());
        return product;
    }
}
