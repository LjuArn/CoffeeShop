package com.example.coffeeshop.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDateTime orderTime;
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User employee;
}
//•	Has a Description
//o	The length of the description must be at least 5 (INCLUSIVE) characters
//o	The description is a long text field.

//•	Has a Name
//o	The length of the name must be between 3 and 20 characters (both numbers are INCLUSIVE).

//•	Has an Order time
//o	The date and time that cannot be in the future

//•	Has a Price
//o	The price must be a positive number

//•	Has a Category
//o	Has ONLY ONE category
//o	This is the relation with categories.

//•	Has a Employee (user)
//o	A user that adds this order to the Coffee Shop application
