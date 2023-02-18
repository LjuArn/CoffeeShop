package com.example.coffeeshop.web;


import com.example.coffeeshop.domain.binding.OrderAddBindingModel;
import com.example.coffeeshop.domain.serviceModel.OrderAddServiceModel;
import com.example.coffeeshop.service.OrderService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService,
                           ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addOrder(){
        return "order-add";
    }

   @ModelAttribute
   public OrderAddBindingModel orderAddBindingModel(){
        return new OrderAddBindingModel();
   }


    @PostMapping("/add")
    public String AddConfirm(@Valid OrderAddBindingModel orderAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }


        orderService.addOrder(modelMapper
                .map(orderAddBindingModel, OrderAddServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){
        orderService.ready(id);


        return "redirect:/";
    }
}
