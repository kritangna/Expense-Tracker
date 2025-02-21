package com.expense.expense_tracker_app.service.impl;

import com.expense.expense_tracker_app.dto.CategoryDto;
import com.expense.expense_tracker_app.entity.Category;
import com.expense.expense_tracker_app.exceptions.ResourceNotFoundException;
import com.expense.expense_tracker_app.mapper.CategoryMapper;
import com.expense.expense_tracker_app.repository.CategoryRepository;
import com.expense.expense_tracker_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        // Convert CategoryDto to Category Entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        // Save the category object into the database table - categories
        Category savedCategory = categoryRepository.save(category);

        // Convert saved category to categoryDto
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + id));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());

    }

    @Override
    public CategoryDto updateCategoryById(Long id, CategoryDto categoryDto) {
        // get category entity from DB table
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + id));

        // update the category entity and save it to the db table
        category.setName(categoryDto.name());
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + id));

        categoryRepository.delete(category);
    }
}
