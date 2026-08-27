package com.greentech.prueba.web.controller;

import com.greentech.prueba.persistence.entity.ProductEntity;
import com.greentech.prueba.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductController {
    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices){
        this.productServices = productServices;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAll(){
        return ResponseEntity.ok(this.productServices.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity product){
        if (product.getId() == null || !this.productServices.productExist(product.getId())){
            System.out.println("Producto Creado");
            return ResponseEntity.ok(this.productServices.saveProduct(product));
        }else {
            System.out.println("Producto ya existente");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<ProductEntity> getId(@PathVariable Integer idProduct){
        return ResponseEntity.ok(this.productServices.getById(idProduct));
    }

    @PutMapping
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity product){
        if (product.getId() != null && this.productServices.productExist(product.getId())){
            System.out.println("Elemento Actualizado");
            return ResponseEntity.ok(this.productServices.saveProduct(product));
        }else {
            System.out.println("Producto no existe");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable Integer idProduct){
        ProductEntity product = this.productServices.getById(idProduct);
        if (product != null && this.productServices.productExist(idProduct)){
            this.productServices.deleteProduct(idProduct);
            System.out.println();
            return ResponseEntity.ok(product);
        }else {
            System.out.println("El registro no existe");
            return ResponseEntity.badRequest().build();
        }
    }
}
