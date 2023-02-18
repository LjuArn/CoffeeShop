package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.entity.Order;
import com.example.coffeeshop.domain.serviceModel.OrderAddServiceModel;
import com.example.coffeeshop.domain.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderAddServiceModel orderAddServiceModel);

    List<OrderViewModel> findAllOrderByPriceDes();


    void ready(Long id);
}
