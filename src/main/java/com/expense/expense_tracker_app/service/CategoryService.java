package com.expense.expense_tracker_app.service;

import com.expense.expense_tracker_app.dto.CategoryDto;
import com.expense.expense_tracker_app.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategoryById(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}
