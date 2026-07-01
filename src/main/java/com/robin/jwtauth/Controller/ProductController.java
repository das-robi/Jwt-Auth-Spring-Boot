package com.robin.jwtauth.Controller;

import com.robin.jwtauth.Model.Product;
import com.robin.jwtauth.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> geAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/prodcut/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);

        if (product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(@RequestPart("product") Product product, @RequestPart(value = "imgFile", required = false) MultipartFile imgFile){

        try {
            Product product1 = productService.addProduct(product, imgFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (java.io.IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductIdByImage(@PathVariable int prodId){

        Product product = productService.getProductById(prodId);

        byte[] imgByte = product.getImgData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImgType()))
                .body(imgByte);
    }


    @PutMapping("/product/update")
    public ResponseEntity<String> updateProduct(@PathVariable int prodId, @RequestPart Product product, @RequestPart MultipartFile imgFile){

        Product product1 = null;


        try {
            product1 = productService.updateProduct(prodId, product, imgFile);
        } catch (IOException e) {
            return new ResponseEntity<>("Faild to update", HttpStatus.BAD_REQUEST);

        }


        if (product1 != null){
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Product Update Fail", HttpStatus.BAD_REQUEST);
        }

    }


    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){
        Product product = productService.getProductById(prodId);

        if (product != null){
            productService.deleteProduct(product);
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Product is not found", HttpStatus.NOT_FOUND);
        }

    }

//    @GetMapping("/product/search")
//    public ResponseEntity<List<Product>> getSearchProduct(@RequestParam String keyWord){
//
//        List<Product> searchProduct = productService.getSearchProduct(keyWord);
//
//        return new ResponseEntity<>(searchProduct, HttpStatus.OK);
//
//    }


}
