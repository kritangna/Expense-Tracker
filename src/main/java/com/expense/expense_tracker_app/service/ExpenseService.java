package com.expense.expense_tracker_app.service;

import com.expense.expense_tracker_app.dto.ExpenseDto;
import com.expense.expense_tracker_app.entity.Expense;

import java.util.List;

public interface ExpenseService {

    ExpenseDto addExpense(ExpenseDto expenseDto);
    ExpenseDto getExpenseById(Long id);
    List<ExpenseDto> getAllExpenses();
    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);
    void deleteExpense(Long id);
}
