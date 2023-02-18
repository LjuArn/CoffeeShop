package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.entity.Order;
import com.example.coffeeshop.domain.serviceModel.OrderAddServiceModel;
import com.example.coffeeshop.domain.view.OrderViewModel;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

   private final OrderRepository orderRepository;
   private final ModelMapper modelMapper;
   private final CurrentUser currentUser;
   private final UserService userService;
   private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ModelMapper modelMapper,
                            CurrentUser currentUser,
                            UserService userService,
                            CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public void addOrder(OrderAddServiceModel orderAddServiceModel) {

       Order order = modelMapper.map(orderAddServiceModel, Order.class);

       order.setEmployee(userService.findById(currentUser.getId()));
       order.setCategory(categoryService.findByCategoriNameEnum(orderAddServiceModel.getCategory()));

       orderRepository.save(order);

    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDes() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void ready(Long id) {
        orderRepository.deleteById(id);
    }


}
