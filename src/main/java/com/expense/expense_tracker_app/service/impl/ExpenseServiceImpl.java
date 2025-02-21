package com.expense.expense_tracker_app.service.impl;

import com.expense.expense_tracker_app.dto.ExpenseDto;
import com.expense.expense_tracker_app.entity.Category;
import com.expense.expense_tracker_app.entity.Expense;
import com.expense.expense_tracker_app.exceptions.ResourceNotFoundException;
import com.expense.expense_tracker_app.mapper.ExpenseMapper;
import com.expense.expense_tracker_app.repository.CategoryRepository;
import com.expense.expense_tracker_app.repository.ExpenseRepository;
import com.expense.expense_tracker_app.service.CategoryService;
import com.expense.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    @Override
    public ExpenseDto addExpense(ExpenseDto expenseDto) {
        // Convert Expense dto to Expense Entity
        Expense expense = ExpenseMapper.maptoExpense(expenseDto);

        // save expense entity to db
        Expense savedExpense = expenseRepository.save(expense);

        // convert saved expense entity to expense dto
        return ExpenseMapper.mapExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {

        // get expense entity from the db
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));

        // convert expense entity to expense dto object and return
        return ExpenseMapper.mapExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {

        List<Expense> expenses = (List<Expense>) expenseRepository.findAll();
        return expenses.stream()
                .map((expense) -> ExpenseMapper.mapExpenseDto(expense))
                        .collect(Collectors.toList());

    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));

        // update the expense entity amount
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        // get the category id as well
        if (expenseDto.categoryDto() != null) {
            // get the category entity by id
            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }

        // save the updated expense
        Expense updatedExpense = expenseRepository.save(expense);

        // convert the expense entity to expense dto
        return ExpenseMapper.mapExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));

        expenseRepository.deleteById(id);
    }
}
