package com.example.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private long productID;
    private double price;
    private double quantity;

    @Transient
    private Product product;

    @ManyToOne
    @JoinColumn(name = "productItem_id")
    @JsonIncludeProperties(value = {"id","billingDate","customerID","customer"})
    private Bill bill;
}
