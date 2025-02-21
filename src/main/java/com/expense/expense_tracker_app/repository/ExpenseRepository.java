package com.expense.expense_tracker_app.repository;

import com.expense.expense_tracker_app.entity.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    // Spring data jpa provides implementation for this interface
    // CRUD methods to perform database operations on Category entity
    // Spring data JPA provides transaction for all the CRUD methods
}
