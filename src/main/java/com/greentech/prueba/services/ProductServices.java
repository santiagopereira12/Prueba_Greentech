package com.greentech.prueba.services;

import com.greentech.prueba.persistence.entity.ProductEntity;
import com.greentech.prueba.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAll(){
        return this.productRepository.findAll();
    }

    public ProductEntity saveProduct(ProductEntity product){
        return this.productRepository.save(product);
    }

    public ProductEntity getById(Integer idProduct){
        return this.productRepository.findById(idProduct).orElse(null);
    }

    public void deleteProduct(Integer idProduct){
        this.productRepository.deleteById(idProduct);
    }

    public boolean productExist(Integer idProduct){
        return this.productRepository.existsById(idProduct);
    }
}
