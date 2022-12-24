package com.example.billingservice.feign;

import com.example.billingservice.entities.Customer;
import com.example.billingservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(path="/products")
    PagedModel<Product> pageProducts();

    @GetMapping(path="/products/{id}?projection=fullProduct")
    Product getProductById(@PathVariable Long id);

    @GetMapping("/products?projection=fullProduct")
    PagedModel<Product> findAll();
}
