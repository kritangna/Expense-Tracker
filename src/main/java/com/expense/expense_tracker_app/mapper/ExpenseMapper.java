package com.expense.expense_tracker_app.mapper;

import com.expense.expense_tracker_app.dto.CategoryDto;
import com.expense.expense_tracker_app.dto.ExpenseDto;
import com.expense.expense_tracker_app.entity.Category;
import com.expense.expense_tracker_app.entity.Expense;

public class ExpenseMapper {

    // Map Expense Entity to Expense Dto
    public static ExpenseDto mapExpenseDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }

    // Map Expense Dto to Expense Entity
    public static Expense maptoExpense(ExpenseDto expenseDto) {
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());

        Expense expense =  new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
        return expense;
    }
}
