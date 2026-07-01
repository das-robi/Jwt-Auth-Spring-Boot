package com.robin.jwtauth.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String prodName;
    private String description;
    private BigDecimal price;
    private String brand;

    private String imgName;
    private String imgType;

    @Lob
    private byte[] imgData;


}
