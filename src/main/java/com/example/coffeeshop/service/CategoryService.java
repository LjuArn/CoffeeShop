package com.example.coffeeshop.service;

import com.example.coffeeshop.domain.entity.Category;
import com.example.coffeeshop.domain.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoriNameEnum(CategoryNameEnum categoryNameEnum);
}
