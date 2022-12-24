package com.example.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date billingDate;

    @OneToMany(targetEntity=ProductItem.class,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIncludeProperties(value = {"id","productID","price","quantity","product"})
    private Collection<ProductItem> productItems;

    private Long customerID;

    @Transient
    private Customer customer;

}

