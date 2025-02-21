package com.expense.expense_tracker_app.mapper;

import com.expense.expense_tracker_app.dto.CategoryDto;
import com.expense.expense_tracker_app.entity.Category;

public class CategoryMapper {

    // Map CategoryDto to Category Entity
    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }

    // Map Category Entity to CategoryDto
    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
