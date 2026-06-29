package com.robin.jwtauth.Service;

import com.robin.jwtauth.Model.Product;
import com.robin.jwtauth.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {

        return productRepo.findAll();

    }

    public Product getProductById(@PathVariable int id) {

    }


//    public ResponseEntity<Product> searchProduct()

}
