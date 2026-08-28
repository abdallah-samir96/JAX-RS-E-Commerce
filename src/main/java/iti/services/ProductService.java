package iti.services;
import java.util.List;
import java.util.stream.Collectors;
import iti.daos.ProductDao;
import iti.domain.product.dtos.ProductGetDto;
import iti.domain.product.dtos.ProductPostDto;
import iti.domain.utils.ProductMapper;
import iti.entities.Product;


public class ProductService {
    
    private final ProductDao dao;

    public ProductService(){
        this.dao = new ProductDao();
    }
       
    public ProductGetDto findProduct(long id){
       var product =  dao.getProductById(id);
       if(product != null)
             return ProductMapper.entityToGet(product);

        return null;
    }
    public List<ProductGetDto> getAllProducts(){

        return dao.getAllProducts()
                .stream()
                .map(ProductMapper::entityToGet)
                .collect(Collectors.toList());
    }
    public void addProduct(ProductPostDto product){
        Product p = ProductMapper.postToEntity(product);
        dao.addProduct(p);
    }

    public void deleteProduct(long id){
        dao.deleteProduct(id);
    }

    public void deleteAllProducts(){
        dao.deleteAllProduct();
    }
    
}
