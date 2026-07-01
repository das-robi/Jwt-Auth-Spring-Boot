package com.robin.jwtauth.Service;

import com.robin.jwtauth.Model.Product;
import com.robin.jwtauth.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {

        return productRepo.findAll();

    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile imgFile) throws IOException {

        if (imgFile != null && !imgFile.isEmpty()){
            product.setImgName(imgFile.getOriginalFilename());
            product.setImgType(imgFile.getContentType());
            product.setImgData(imgFile.getBytes());
        }

        return productRepo.save(product);
    }

    public Product updateProduct(int prodId, Product product, MultipartFile imgFile) throws IOException {

        product.setImgName(imgFile.getOriginalFilename());
        product.setImgData(imgFile.getBytes());
        product.setImgType(imgFile.getContentType());

        return productRepo.save(product);

    }

    public void deleteProduct(Product product) {

        productRepo.delete(product);

    }

//    public List<Product> getSearchProduct(String keyWord) {
//        return productRepo.getSearchProduct(keyWord);
//    }


}
