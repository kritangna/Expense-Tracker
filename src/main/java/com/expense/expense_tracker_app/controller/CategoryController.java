package com.expense.expense_tracker_app.controller;


import com.expense.expense_tracker_app.dto.CategoryDto;
import com.expense.expense_tracker_app.entity.Category;
import com.expense.expense_tracker_app.repository.CategoryRepository;
import com.expense.expense_tracker_app.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Category Resource",
        description = "CRUD REST APIs for Category Resource - Create Category" +
                "Update Category, Get Category, Delete Category"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private CategoryService categoryService;

    // Build create category REST API
    @Operation(
            summary = "CREATE Category REST API",
            description = "CREATE Category REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // Build Get category by id REST API
    @Operation(
            summary = "GET Category REST API",
            description = "GET Category REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getAllCategoryById(@PathVariable("id") Long id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);

        return ResponseEntity.ok(categoryDto);
    }

    // Build Get All Categories REST API
    @Operation(
            summary = "GET all Categories REST API",
            description = "GET all Categories REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    // Build update category REST API
    @Operation(
            summary = "UPDATE all Categories REST API",
            description = "UPDATE all Categories REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long id,
                                                      @RequestBody CategoryDto categoryDto) {

        CategoryDto updatedCategoryDto = categoryService.updateCategoryById(id, categoryDto);
        return ResponseEntity.ok(updatedCategoryDto);
    }

    @Operation(
            summary = "DELETE a Category REST API",
            description = "DELETE a Category REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted Category: " + id);
    }
}
