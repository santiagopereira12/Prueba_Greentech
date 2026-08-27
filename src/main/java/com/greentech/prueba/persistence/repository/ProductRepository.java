package com.greentech.prueba.persistence.repository;

import com.greentech.prueba.persistence.entity.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<ProductEntity, Integer> {
}
