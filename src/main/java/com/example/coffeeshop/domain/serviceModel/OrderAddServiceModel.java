package com.example.coffeeshop.domain.serviceModel;

import com.example.coffeeshop.domain.entity.Category;
import com.example.coffeeshop.domain.entity.User;
import com.example.coffeeshop.domain.entity.enums.CategoryNameEnum;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddServiceModel {

    private Long id;
    private String description;
    private String name;
    private LocalDateTime orderTime;
    private BigDecimal price;
    private CategoryNameEnum category;
    private User employee;

    public OrderAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderAddServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public User getEmployee() {
        return employee;
    }

    public OrderAddServiceModel setEmployee(User employee) {
        this.employee = employee;
        return this;
    }
}
