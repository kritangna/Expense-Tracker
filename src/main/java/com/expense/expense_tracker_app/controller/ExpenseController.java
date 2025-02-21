package com.expense.expense_tracker_app.controller;


import com.expense.expense_tracker_app.dto.ExpenseDto;
import com.expense.expense_tracker_app.entity.Expense;
import com.expense.expense_tracker_app.mapper.ExpenseMapper;
import com.expense.expense_tracker_app.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource - Create Expense" +
                "Update Expense, Get Expense, Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    // inject the ExpenseServce using constructor based dependency injection
    private ExpenseService expenseService;

    // Build add expense REST API
    @Operation(
            summary = "Add Expense REST API",
            description = "ADD Expense REST API to save Expense into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> addExpense(@RequestBody ExpenseDto expenseDto) {

        ExpenseDto addedExpense = expenseService.addExpense(expenseDto);
        return new ResponseEntity<>(addedExpense, HttpStatus.CREATED);
    }

    // Build expense by id REST API
    @GetMapping("{id}")
    @Operation(
            summary = "GET Expense REST API",
            description = "GET Expense REST API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long id) {
        ExpenseDto expenseDto = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expenseDto, HttpStatus.OK);
    }

    // Build get all expenses REST API
    @Operation(
            summary = "GET all Expenses REST API",
            description = "GET all Expenses REST API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    // Build update expense REST API
    @PutMapping({"{id}"})
    @Operation(
            summary = "UPDATE Expense REST API",
            description = "UPDATE Expense REST API and save it to the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto updatedExpense = expenseService.updateExpense(id, expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    // Build delete expense REST API
    @Operation(
            summary = "DELETE Expense REST API",
            description = "DELETE Expense REST API and delete it from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Deleted expense");
    }
}
