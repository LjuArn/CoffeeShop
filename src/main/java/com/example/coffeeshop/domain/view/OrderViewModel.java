package com.example.coffeeshop.domain.view;

import com.example.coffeeshop.domain.entity.Category;
import com.example.coffeeshop.domain.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

    public OrderViewModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public OrderViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }
}
